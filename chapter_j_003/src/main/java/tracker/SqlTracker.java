package tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class SqlTracker implements Store {
    private Connection cn;
    private static Logger log = LoggerFactory.getLogger(SqlTracker.class);

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            initiateTasksTableExists();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private int executeUpdate(PreparedStatement st) {
        int result = -1;
        try {
            result = st.executeUpdate();
            st.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }

    private void initiateTasksTableExists() throws SQLException {
        executeUpdate(
                cn.prepareStatement("create table if not exists tasks ("
                        + "id varchar(2000) primary key unique not null,"
                        + "name varchar(2000) unique not null)")
        );
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) throws SQLException {
        item.setId(this.generateId());
        PreparedStatement pst = cn.prepareStatement("insert into tasks (id, name) values (? , ?)");
        pst.setString(1, item.getId());
        pst.setString(2, item.getName());
        executeUpdate(pst);
        return item;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    @Override
    public boolean replace(String id, Item item) throws SQLException {
        PreparedStatement pst = cn.prepareStatement("update tasks set name = ? where id = ?");
        pst.setString(1, item.getName());
        pst.setString(2, id);
        int result = executeUpdate(pst);
        return result == 1;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        PreparedStatement pst = cn.prepareStatement("delete from tasks where id = ?");
        pst.setString(1, id);
        int result = executeUpdate(pst);
        return result == 1;
    }

    private List<Item> executeQuery(PreparedStatement st) {
        List<Item> result = new ArrayList<>();
        ResultSet rs;
        try {
            rs = st.executeQuery();
            while (rs.next()) {
                result.add(new Item(rs.getString("id"), rs.getString("name")));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<Item> findAll() throws SQLException {
        PreparedStatement pst = cn.prepareStatement("select tasks.id, tasks.name from tasks");
        return executeQuery(pst);
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        PreparedStatement pst = cn.prepareStatement("select tasks.id, tasks.name from tasks where name = ?");
        pst.setString(1, key);
        return executeQuery(pst);
    }

    @Override
    public Item findById(String id) throws SQLException {
        Item result = null;
        PreparedStatement pst = cn.prepareStatement("select tasks.id, tasks.name from tasks where id = ?");
        pst.setString(1, id);
        List<Item> resultQuery = executeQuery(pst);
        if (resultQuery.size() > 0) {
            result = new Item(resultQuery.get(0).getId(), resultQuery.get(0).getName());
        }
        return result;
    }
}