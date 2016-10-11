package com.seed;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	TODO:1 Make DisplayCartDetailsServlet as a HttpServlet
@WebServlet("/displayDetails")
public class DisplayCartDetailsServlet extends HttpServlet{

//	TODO:2 	Provide call-back method (called by web container) for HTTP request made using HTTP GET method
//	TODO:3	This method should read products selected by web-client from bookCatelogue.html and 
//					display them in tabular format as html response to the web client.	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String bookName[] = request.getParameterValues("bookName");
		String shopMore = request.getParameter("continue");
		String checkOut = request.getParameter("checkout");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<table border='1'>");
		
		out.println("<tr>");
    	out.println("<td>Book Name</td>");
    	out.println("</tr>");
    	
		if (bookName != null) {
		    for (String name : bookName) {
		    	out.println("<tr>");
		    	out.println("<td>"+name +"</td>");
		    	out.println("</tr>");
		    }
		}

		out.println("</table>");
		out.println("<p>Shop More:"+shopMore+"</p>");
		out.println("<p>Checkout:"+checkOut+"</p>");
		out.println("</body></html>");
		
	}
	
	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//super.doPost(req, resp);
			this.doGet(request, response);
			PrintWriter out = response.getWriter();
			out.println("finish");
		/*String bookName[] = request.getParameterValues("bookName");
		String shopMore = request.getParameter("continue");
		String checkOut = request.getParameter("checkout");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<table border='1'>");
		
		out.println("<tr>");
    	out.println("<td>Book Name</td>");
    	out.println("</tr>");
    	
		if (bookName != null) {
		    for (String name : bookName) {
		    	out.println("<tr>");
		    	out.println("<td>"+name +"</td>");
		    	out.println("</tr>");
		    }
		}

		out.println("</table>");
		out.println("<p>Shop More:"+shopMore+"</p>");
		out.println("<p>Checkout:"+checkOut+"</p>");
		out.println("finish");
		out.println("</body></html>");*/
		}
	
}









