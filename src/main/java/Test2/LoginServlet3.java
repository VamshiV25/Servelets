package Test2;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;

@WebServlet("/login3")
public class LoginServlet3 extends HttpServlet {
	Connection con=null;
	PreparedStatement pstmt=null;
	String sql="Select*from Users where uname=? and pwd=?";
	ResultSet rs=null;
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ServletConfig config=getServletConfig();
		
		String driver=config.getInitParameter("driver");
		String url=config.getInitParameter("url");	
		String dbuser=config.getInitParameter("dbuser");
		String dbpass=config.getInitParameter("dbpass");	
		
		String name=req.getParameter("uname");
		String pwd=req.getParameter("pwd");	
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection
					(url,dbuser,dbpass);
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				out.println("<h2 align=center>");
				out.println("Login Successfull,Welcome User</h2>");
			}
			else {
				out.println("<h2 align=center>");
				out.println("Login Failed,Try Again</h2>");
			}
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
		}
}
