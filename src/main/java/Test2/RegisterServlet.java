package Test2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into values(?,?)";
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String name=req.getParameter("user");
		String pwd=req.getParameter("pwd");	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection
					("jdbc:mysql://localhost/login","root","2059");
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			int rows=pstmt.executeUpdate();
			if(rows>0) {
				out.println("<h2 align=center>");
				out.println("Registration Completed...</h2>");
				out.println("<br><br>");
				out.println("<h3 align=center><a href=index.html>");
				out.println("Login Now...</a></h3>");
			}
		}
		catch(Exception exp) {
			exp.printStackTrace();
		}
	}

}
