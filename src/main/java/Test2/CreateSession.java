package Test2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/create")
public class CreateSession extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		String user=req.getParameter("user");
		String pwd=req.getParameter("pwd");
		HttpSession session=req.getSession(true);
		session.setAttribute("user",user);
		session.setAttribute("pwd", pwd);
		out.println("<h2 align=center>Welcome, "+user);
		out.println("<br><br>");
		out.println("<form action=read>");
		out.println("<input type='Submit' value='Read'></form>");
		out.close();
	}
}
