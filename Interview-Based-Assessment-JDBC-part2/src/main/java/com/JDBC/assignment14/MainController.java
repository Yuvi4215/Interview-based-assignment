package com.JDBC.assignment14;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:9999/Interview-Based-Assessment-JDBC-part2/

@WebServlet(urlPatterns = {"/assignment4/*"})
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String userName = request.getParameter("name");

	        out.println("<html><head><title>Welcome Page</title></head><body>");
	        out.println("<h2>Welcome, " + userName + "!</h2>");
	        out.println("</body></html>");
	    }
}
