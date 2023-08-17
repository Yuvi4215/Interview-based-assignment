package com.Servlet.Assignment17;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Servlet.DAO.BlogPostDAO;
import com.Servlet.Model.BlogPost;

/* to create a blog
http://localhost:9999/Interview-Based-Assessment-Servlet-part1/blog/index*/

/* to view a blog
http://localhost:9999/Interview-Based-Assessment-Servlet-part1/blog/view*/

@WebServlet(urlPatterns = {"/blog/*"},loadOnStartup = 1)
public class UserServlet extends HttpServlet {
	
	    private static final long serialVersionUID = 1L;

	    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	doProcess(request, response);
	    	
	    }
	    
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	doProcess(request, response);
	    }

	    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	System.out.println(request.getPathInfo());
	    	if (request.getPathInfo()!=null  && request.getPathInfo().equalsIgnoreCase("/index")) {
	    		  RequestDispatcher dispatcher = request.getRequestDispatcher("../create.jsp");
	    			dispatcher.forward(request, response);
			}else if (request.getPathInfo()!=null && request.getPathInfo().equalsIgnoreCase("/view")) {
	    		 List<BlogPost> posts = BlogPostDAO.getAllBlogPosts(); 
	    	        System.out.println(posts);
	    	        request.setAttribute("posts", posts);
	    	        request.getRequestDispatcher("../view.jsp").forward(request, response);
			}
	    else if (request.getPathInfo()!=null && request.getPathInfo().equalsIgnoreCase("/created")) {
	    		String title = request.getParameter("title");
	            String description = request.getParameter("description");
	            String content = request.getParameter("content");
	            
	            BlogPost post = new BlogPost();
	            post.setId((int)(Math.random()*10000));
	            post.setTitle(title);
	            post.setDescription(description);
	            post.setContent(content);
	            
	            BlogPostDAO.createBlogPost(post); 
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/blog/view");
    			dispatcher.forward(request, response);
			
	    	}
	    }

}
