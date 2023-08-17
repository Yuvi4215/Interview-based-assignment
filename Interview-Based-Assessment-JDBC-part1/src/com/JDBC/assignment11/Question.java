package com.JDBC.assignment11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Question {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;
		
		 try{
			 connection = JdbcUtil.getConnection();
	            System.out.println("Connected to the database.");

	            String query = "SELECT * FROM people";
	            preparedStmt = connection.prepareStatement(query);

	            resultSet = preparedStmt.executeQuery();

	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String name = resultSet.getString("name");
	                int age = resultSet.getInt("age");
	                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
	            }

	            resultSet.close();
	            preparedStmt.close();

	        } catch (SQLException e) {
	            System.err.println("Database connection error.");
	            e.printStackTrace();
	        }

	}
}
