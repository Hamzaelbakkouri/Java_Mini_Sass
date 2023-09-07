package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private static String url = "jdbc:mysql://localhost:3306/minisass";
    private static String username = "root";
    private static String password = "";

    public static Connection Connect() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
        return connection;
    }
}