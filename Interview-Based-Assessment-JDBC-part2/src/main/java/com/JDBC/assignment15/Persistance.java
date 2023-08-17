package com.JDBC.assignment15;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Persistance {
    public static List<Person> getPeople() throws SQLException {
        List<Person> people = new ArrayList<>();
        
        try (Connection connection = JdbcUtil.getConnection()) {
            String query = "SELECT * FROM people";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                people.add(new Person(id, name, age));
            }

            resultSet.close();
            preparedStatement.close();
        }
        
        return people;
    }
}
