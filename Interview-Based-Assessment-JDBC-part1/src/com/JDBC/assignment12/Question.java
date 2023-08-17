package com.JDBC.assignment12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/yuvi";
        String username = "root";
        String password = "4215";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load MySQL JDBC driver.");
            e.printStackTrace();
            return;
        }

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connected to the database.");

            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                System.out.println("\n\nChoose an operation:");
                System.out.println("1. Add record");
                System.out.println("2. View records");
                System.out.println("3. Update record");
                System.out.println("4. Delete record");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addRecord(connection, scanner);
                        break;
                    case 2:
                        viewRecords(connection);
                        break;
                    case 3:
                        updateRecord(connection, scanner);
                        break;
                    case 4:
                        deleteRecord(connection, scanner);
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Database connection error.");
            e.printStackTrace();
        }
    }

    private static void addRecord(Connection connection, Scanner scanner) throws SQLException {
    	System.out.print("Enter ID: ");
    	int id = scanner.nextInt();
    	System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        String query = "INSERT INTO people (id, name, age) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, age);
        preparedStatement.executeUpdate();

        System.out.println("Record added successfully.");
        preparedStatement.close();
    }

    private static void viewRecords(Connection connection) throws SQLException {
        String query = "SELECT * FROM people";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
        }

        resultSet.close();
        preparedStatement.close();
    }

    private static void updateRecord(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter ID of the record to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new age: ");
        int newAge = scanner.nextInt();

        String query = "UPDATE people SET name = ?, age = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newName);
        preparedStatement.setInt(2, newAge);
        preparedStatement.setInt(3, id);
        int rowsUpdated = preparedStatement.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("Record with ID " + id + " not found.");
        }

        preparedStatement.close();
    }

    private static void deleteRecord(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter ID of the record to delete: ");
        int id = scanner.nextInt();

        String query = "DELETE FROM people WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        int rowsDeleted = preparedStatement.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("Record with ID " + id + " not found.");
        }

        preparedStatement.close();
    }
}

