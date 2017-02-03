package sources.jdbc;

import java.sql.*;
import java.util.Properties;

/**
 * Created by mman on 03.02.17.
 */
public class ReleaseResourcesTest {
    private static final Properties connProperties = new Properties();

    static {
        connProperties.setProperty("user", "root");
        connProperties.setProperty("password", "root");
        connProperties.setProperty("useSSL", "true");
        connProperties.setProperty("autoReconnect", "true");
        connProperties.setProperty("verifyServerCertificate", "false");
    }

    public static void main(String[] args) {
        /*
         * conn.close() closes stmt and rs also; stmt.close() closes rs also; rs.close() closes only itself.
         */
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/employees", connProperties);
             Statement stmt = conn.createStatement() // practically this is not needed here.
            ) {
            ResultSet rs = stmt.executeQuery("select * from employees limit 10");
            while (rs.next()) {
                String name = rs.getString("first_name");
                System.out.println("name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
