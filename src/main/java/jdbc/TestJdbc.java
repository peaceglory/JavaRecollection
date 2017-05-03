package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by mman on 03.02.17.
 */
public class TestJdbc {
    private static final Properties connProperties = new Properties();

    static {
        connProperties.setProperty("user", "root");
        connProperties.setProperty("password", "root");
        connProperties.setProperty("useSSL", "true");
        connProperties.setProperty("autoReconnect", "true");
        connProperties.setProperty("verifyServerCertificate", "false");
    }

    public static void main(String[] args) {
        Connection conn = null;

        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost/employees?user=root&password=root");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost/employees", "root", "root");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/employees", connProperties);

        } catch (SQLException sqle) {

        }
    }
}
