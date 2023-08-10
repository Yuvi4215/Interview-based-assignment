package in.ineuron.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.DTO.Products;
import in.ineuron.Service.IProductsService;
import in.ineuron.ServiceFactory.ProductsServiceFactory;
import in.ineuron.Util.HibernateUtil;


@WebServlet(urlPatterns = {"/controller/*"},loadOnStartup = 1)
public class ControllerServlet extends HttpServlet {
	static {
		HibernateUtil.startup();
	}
	  
	 
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		IProductsService productsService = ProductsServiceFactory.getProductsService();
		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path Info :: " + request.getPathInfo() + "\n");
		String uri = request.getPathInfo();

		switch (uri) {
		
		case "/addform": {
			Products product = new Products();
			product.setpName(request.getParameter("pName"));
			product.setpQty(Integer.parseInt(request.getParameter("pQty")));
			product.setpRate(Integer.parseInt(request.getParameter("pRate")));
			String msg = productsService.addProduct(product);
			request.setAttribute("status", msg);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("../addformresult.jsp");
			dispatcher.forward(request, response);
			break;
		}
		
		case "/searchform": {
			Products product = productsService.searchProduct(Integer.parseInt(request.getParameter("serialNo")));
			request.setAttribute("product", product);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("../searchResult.jsp");
			dispatcher.forward(request, response);
			break;
		}
		
		case "/deleteform": {
			String msg = productsService.deleteProduct(Integer.parseInt(request.getParameter("serialNo")));
			request.setAttribute("status", msg);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("../deleteformResult.jsp");
			dispatcher.forward(request, response);
			break;
		}
		
		case "/updateform": {
			PrintWriter out = response.getWriter();
			Products product = productsService.searchProduct(Integer.parseInt(request.getParameter("serialNo")));
			if (product != null) {
				out.println("<body>");
				out.println("<center><br/><br/><br/><form method= 'post' action='./controller/updated'><table>");
				out.println("<tr><td>Product ID :: </td>");
				out.println(
						"<td><input type='text' value='" + product.getSerialNo() + "' name='serialNo' disabled/></tr>");
				out.println("<input type='hidden' name='serialNo' value='" + product.getSerialNo() + "'/>");

				out.println("<tr><td>Product NAME :: </td>");
				out.println("<td><input type='text' value='" + product.getpName() + "' name='pName' required/></tr>");

				out.println("<tr><td>Product RATE :: </td>");
				out.println("<td><input type='text' value='" + product.getpRate() + "' name='pRate' required/></tr>");

				out.println("<tr><td>Product QUANTITY :: </td>");
				out.println("<td><input type='text' value='" + product.getpQty() + "' name='pQty' required/></tr>");

				out.println("<tr><td></td>");
				out.println("<td><input type='submit' value='Submit' ></tr>");
				out.println("");
				out.println("</table></form></center>");
				out.println("</body>");
			} else {
				out.println("<br/><br/><br/><h1 style='color:red; text-align:center;'>NO RECORD FOUND TO UPDATE</h1>");
				out.println("<center><a href='../updateForm.html'>Home Page</a></center>");
			}
			break;
		}
		
		case "/controller/updated": {
			Products update = new Products();
			update.setSerialNo(Integer.parseInt(request.getParameter("serialNo")));
			update.setpName(request.getParameter("pName"));
			update.setpRate(Integer.parseInt(request.getParameter("pRate")));
			update.setpQty(Integer.parseInt(request.getParameter("pQty")));
			String msg = productsService.updateProduct(update);
			request.setAttribute("status", msg);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("../../updateResult.jsp");
			dispatcher.forward(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + uri);
		}

		
	}
}