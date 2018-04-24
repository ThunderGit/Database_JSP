package ua.dnu.ivlev.child_cosmetic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Reg")
public class Reg extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static private String url = "jdbc:mysql://localhost:3306/childcosmetic";
	static private String user = "root";
	static private String password = "";
   
    public Reg() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			String name=request.getParameter("login");
			String pass=request.getParameter("pass");
			String sql="insert into users(username,password) values('"+name+"',MD5('"+pass+"'))";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			PrintWriter out=response.getWriter();
			out.println("New user has been successfully registrated!");
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}