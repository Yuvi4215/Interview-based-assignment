package com.Servlet.Assignment16;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//http://localhost:9999/Interview-Based-Assessment-Servlet/user

@WebServlet(urlPatterns = {"/user/*"},loadOnStartup = 1)
public class UserServlet extends HttpServlet {
	
	    private static final long serialVersionUID = 1L;

	    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	doProcess(request, response);
	    	
	    }
	    
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	doProcess(request, response);
	    }

	    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	 PrintWriter out = response.getWriter();
	    	 if (request.getPathInfo()!=null && request.getPathInfo().equalsIgnoreCase("/second") ) {
	    		    RequestDispatcher dispatcher = request.getRequestDispatcher("../second.jsp");
	    			dispatcher.forward(request, response);
			}
	    	if (request.getPathInfo()!=null && request.getPathInfo().equalsIgnoreCase("/first")) {
	    		 String userName = request.getParameter("name");
	    	        HttpSession session = request.getSession();
	    	        session.setAttribute("name", userName);
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("../first.jsp");
	    			dispatcher.forward(request, response);
			} else {
				out.println("<html><head><title>User</title></head><body>");
				out.println("<center>");
				out.println("<form action='./user/first' method='get'>");
	            out.println("<h2>Enter User Name</h2>");
	            out.println("<input type='text' name='name' />");
	            out.println("<input type='submit' value='Submit' >");
	            out.println("</form>");
	            out.println(" </center></body></html>");
			}
	    	 
	    	
	    	
	    	
	    }

}
