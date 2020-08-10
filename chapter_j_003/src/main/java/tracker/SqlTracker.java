package tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection cn;
    private PreparedStatement pst;
    private ResultSet rs;
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

    private int executeUpdate(boolean closePst) {
        int result = -1;
        try {
            result = pst.executeUpdate();
            if (closePst) {
                pst.close();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }

    private void initiateTasksTableExists() throws SQLException {
        pst = cn.prepareStatement(" create table if not exists tasks ("
                + "id serial primary key,"
                + "name varchar(2000) unique not null)");
        executeUpdate(true);

    }

    @Override
    public void close() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (pst != null) {
            pst.close();
        }
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) throws SQLException {
        pst = cn.prepareStatement("insert into tasks (name) values (?)", Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, item.getName());
        if (executeUpdate(false) != -1) {
            rs = pst.getGeneratedKeys();
            if (rs.next()) {
                item.setId(rs.getString("id"));
            }
            rs.close();
            pst.close();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) throws SQLException {
        pst = cn.prepareStatement("update tasks set name = ? where id = ?");
        pst.setString(1, item.getName());
        pst.setInt(2, Integer.parseInt(id));
        int result = executeUpdate(true);
        return result == 1;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        pst = cn.prepareStatement("delete from tasks where id = ?");
        pst.setInt(1, Integer.parseInt(id));
        int result = executeUpdate(true);
        return result == 1;
    }

    private List<Item> executeQuery() {
        List<Item> result = new ArrayList<>();
        try {
            rs = pst.executeQuery();
            while (rs.next()) {
                result.add(new Item(Integer.toString(rs.getInt("id")), rs.getString("name")));
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<Item> findAll() throws SQLException {
        pst = cn.prepareStatement("select tasks.id, tasks.name from tasks");
        return executeQuery();
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        pst = cn.prepareStatement("select tasks.id, tasks.name from tasks where name = ?");
        pst.setString(1, key);
        return executeQuery();
    }

    @Override
    public Item findById(String id) throws SQLException {
        Item result = null;
        pst = cn.prepareStatement("select tasks.id, tasks.name from tasks where id = ?");
        pst.setInt(1, Integer.parseInt(id));
        List<Item> resultQuery = executeQuery();
        if (resultQuery.size() > 0) {
            result = new Item(resultQuery.get(0).getId(), resultQuery.get(0).getName());
        }
        return result;
    }
}