package com.JDBC.assignment13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question {
	 public static void main(String[] args) {
	        String filePath = "src\\com\\JDBC\\assignment13\\Document.txt"; // Replace with the path to your input data file

	        try (Connection connection = DBConnectionManager.getConnection()) {
	            System.out.println("Connected to the database.");

	            String insertQuery = "INSERT INTO people (column1, column2) VALUES (?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

	            BufferedReader reader = new BufferedReader(new FileReader(filePath));
	            String line;

	            while ((line = reader.readLine()) != null) {
	                String[] data = line.split(",");
	                preparedStatement.setString(1, data[0]); // Replace with the correct column index
	                preparedStatement.setString(2, data[1]); // Replace with the correct column index
	                preparedStatement.addBatch();
	            }

	            int[] batchResult = preparedStatement.executeBatch();

	            System.out.println("Batch update completed. Rows affected: " + batchResult.length);

	            reader.close();
	            preparedStatement.close();

	        } catch (IOException | SQLException e) {
	            System.err.println("An error occurred.");
	            e.printStackTrace();
	        }
}
}
