package com.JDBC.assignment15;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:9999/Interview-Based-Assessment-JDBC-part2/assignment5
@WebServlet(urlPatterns = {"/assignment5"},loadOnStartup = 1)
public class MainController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static {
		JdbcUtil.startup();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        try {
	            List<Person> people = Persistance.getPeople();
	            
	            out.println("<html><head><title>People Table</title></head><body>");
	            out.println("<h2>People Table</h2>");
	            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Age</th></tr>");
	            
	            for (Person person : people) {
	                out.println("<tr><td>" + person.getId() + "</td><td>" + person.getName() + "</td><td>" + person.getAge() + "</td></tr>");
	            }
	            
	            out.println("</table></body></html>");
	        } catch (SQLException e) {
	            out.println("Error: Unable to retrieve data from the database.");
	            e.printStackTrace(out);
	        }
	}
}
