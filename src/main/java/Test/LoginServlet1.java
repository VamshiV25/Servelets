package Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet1")
public class LoginServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		if(name.equals("admin")&&pwd.equals("admin"))
			out.println("<h2 align=center>Login Successfull,Welcome User</h2>");
		else
			out.println("<h2 align=center>Login Failed, Try Again..!</h2>");
		out.close();
	}
}
