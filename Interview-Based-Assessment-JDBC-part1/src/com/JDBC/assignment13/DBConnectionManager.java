package com.JDBC.assignment13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/yuvi";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "4215";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load PostgreSQL JDBC driver.");
            e.printStackTrace();
        }

        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}
