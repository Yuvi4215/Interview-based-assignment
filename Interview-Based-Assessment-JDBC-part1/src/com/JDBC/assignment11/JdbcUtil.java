package com.JDBC.assignment11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/yuvi";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "4215";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load MySQL JDBC driver.");
            e.printStackTrace();
        }

        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}
