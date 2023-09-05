package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private String url = "jdbc:mysql://localhost:3306/minisass";
    private String username = "root";
    private String password = "";
    public Statement connect() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
        return connection.createStatement();
    }
}