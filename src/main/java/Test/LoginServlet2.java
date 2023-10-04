package Test;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet2")
public class LoginServlet2 extends HttpServlet {	
	/*---Dynamic Login Validation---*/
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement pstmt=null;
	String sql="Select*from users where uname=? and pwd=?";
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection
					("jdbc:mysql://localhost/login","root","2059");
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name=req.getParameter("uname");
		String pwd=req.getParameter("pwd");	
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				out.println("<h2 align=center>Login Successfull,Welcome User</h2>");
			}
			else {
				out.println("<h2 align=center>Login Failed,Try Again</h2>");
			}
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
		out.close();
	}
}
