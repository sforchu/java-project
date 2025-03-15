package data;

import java.sql.*;

public class DatabaseConnection {
    private final String URL = "jdbc:mysql://127.0.0.1:3306/devprodbatm";
    private final String USERNAME = "DevUser";
    private final String PASSWORD = "YourPassWord";

    public Connection createConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException( "Failed to connect to the database: " + e.getMessage());
        }
        return connection;


    }


}
