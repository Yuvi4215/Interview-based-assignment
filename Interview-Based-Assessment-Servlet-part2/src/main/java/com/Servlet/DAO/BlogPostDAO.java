package com.Servlet.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Servlet.Model.BlogPost;
import com.Servlet.Util.JdbcUtil;

public class BlogPostDAO {

	    public static void createBlogPost(BlogPost post) {
	        try {
	            Connection conn = JdbcUtil.getConnection();
	            String sql = "INSERT INTO blog (id, title, description, content) VALUES (?, ?, ?, ?)";
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setInt(1, post.getId());
	            statement.setString(2, post.getTitle());
	            statement.setString(3, post.getDescription());
	            statement.setString(4, post.getContent());
	            statement.executeUpdate();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public static List<BlogPost> getAllBlogPosts() {
	        List<BlogPost> posts = new ArrayList<>();
	        try {
	        	 Connection conn = JdbcUtil.getConnection();
	            String sql = "SELECT * FROM blog";
	            Statement statement = conn.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql);
	            while (resultSet.next()) {
	                BlogPost post = new BlogPost();
	                post.setId(resultSet.getInt("id"));
	                post.setTitle(resultSet.getString("title"));
	                post.setDescription(resultSet.getString("description"));
	                post.setContent(resultSet.getString("content"));
	                posts.add(post);
	            }
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return posts;
	    }
}
