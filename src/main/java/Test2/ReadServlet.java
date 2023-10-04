package Test2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/read")
public class ReadServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		HttpSession session=req.getSession();
		String user=(String)session.getAttribute("uname");
		String pwd=(String)session.getAttribute("pwd");
		out.println("<h2 align=center>User Name : "+user+"</h2>");
		out.println("<h2 align=center>Password : "+pwd+"</h2>");
		out.close();	
	}
}
