package Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/paraDemo" }, 
		initParams = { 
				@WebInitParam(name = "username", value = "Vamshi"), 
				@WebInitParam(name = "password", value = "Vade")
		})
public class ParaDemo extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		ServletConfig config=getServletConfig();
		String user=config.getInitParameter("username");
		String pwd=config.getInitParameter("password");	

		out.println("<h2 align=center>UserName : "+user+"</h2>");
		out.println("<h2 align=center>Password : "+pwd+"</h2>");
		out.close();

	}
}
