package com.shopkeeper.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private final String URL = "jdbc:mysql://localhost:3306/shopkeeperdb";
    private final String USERNAME = "root";
    private final String PASSWORD = "YourPassWord";

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
