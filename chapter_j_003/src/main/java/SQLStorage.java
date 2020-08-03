import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

import static java.lang.System.*;

public class SQLStorage {
    private static Logger log = LoggerFactory.getLogger(SQLStorage.class);

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/tracker";
        String userName = "postgres";
        String password = "112233";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                out.printf("%s %s%n", rs.getString("name"), rs.getString("password"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
