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

    private void initiateTasksTableExists() {
        try (
                PreparedStatement pst  = cn.prepareStatement(" create table if not exists tasks ("
                        + "id serial primary key,"
                        + "name varchar(2000) unique not null)")
        ) {
            pst.executeUpdate();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement pst = cn.prepareStatement("insert into tasks (name) values (?)", Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, item.getName());
            pst.executeUpdate();
            try (ResultSet rs = pst.getGeneratedKeys()) {
                if (rs.next()) {
                    item.setId(rs.getString("id"));
                }
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result;
        try (PreparedStatement pst = cn.prepareStatement("update tasks set name = ? where id = ?")) {
            pst.setString(1, item.getName());
            pst.setInt(2, Integer.parseInt(id));
            result = pst.executeUpdate() == 1;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result;
        try (PreparedStatement pst = cn.prepareStatement("delete from tasks where id = ?")) {
            pst.setInt(1, Integer.parseInt(id));
            result = pst.executeUpdate() == 1;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement pst = cn.prepareStatement("select tasks.id, tasks.name from tasks")) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    result.add(new Item(Integer.toString(rs.getInt("id")), rs.getString("name")));
                }
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement pst = cn.prepareStatement("select tasks.id, tasks.name from tasks where name = ?")) {
            pst.setString(1, key);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    result.add(new Item(Integer.toString(rs.getInt("id")), rs.getString("name")));
                }
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        Item result = null;
        try (PreparedStatement pst = cn.prepareStatement("select tasks.id, tasks.name from tasks where id = ?")) {
            pst.setInt(1, Integer.parseInt(id));
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    result = new Item(Integer.toString(rs.getInt("id")), rs.getString("name"));
                }
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return result;
    }
}