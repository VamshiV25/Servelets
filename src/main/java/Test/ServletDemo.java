package Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletDemo")
public class ServletDemo extends HttpServlet {	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<h2 align=center>Welcome to Servlet</h1>");
		out.println("<h2 align=center>Current Date and Time : "+new java.util.Date()+"</h2>");
		out.close();
	}
}
