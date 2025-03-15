package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private String URL = "jdbc:mysql://localhost:3306/bookstoredb";
    private String USERNAME = "root";
    private String PASSWORD = "YourPassWord";
    private String dbDriver = "com.mysql.cj.jdbc.Driver";

    public Connection createConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Connected to the database");

        } catch (SQLException e) {
            throw new RuntimeException( "Failed to connect to the database: " + e.getMessage());
        }
        return connection;


    }
}
