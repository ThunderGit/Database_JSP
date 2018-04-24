package ua.dnu.ivlev.child_cosmetic;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;



@WebServlet("/Log")
public class Log extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static private String url = "jdbc:mysql://localhost:3306/childcosmetic";
	static private String user = "root";
	static private String password = "";
   
    public Log() 
    {
        super();
    }
    

	protected String getMD5(String pass) throws NoSuchAlgorithmException
	{
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.reset();
		messageDigest.update(pass.getBytes(Charset.forName("UTF8")));
		byte[] resultByte = messageDigest.digest();
		String resultPass = new String(HexBin.encode(resultByte)).toLowerCase();
		
		return resultPass;
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
			
			String resultPass = getMD5(pass);

			String DBname=null,DBpass=null;
			
			String sql="select * from users where username=? and password=?";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,resultPass);
			ResultSet rs=ps.executeQuery();
			PrintWriter out=response.getWriter();
			while(rs.next())
			{
				DBname=rs.getString(2);
				DBpass=rs.getString("password");
			}
			//out.println(resultPass+","+DBname+","+DBpass);
			if(name.equals(DBname)&&resultPass.equals(DBpass))
			{
				if(name.equals("admin")&&resultPass.equals(getMD5("qwerty")))
				{
					RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");
					rd.include(request, response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("ChildCosmetic.jsp");
					rd.include(request, response);
				}
			}
			else
			{
				//response.sendRedirect("Log.jsp");
				RequestDispatcher rd=request.getRequestDispatcher("Log.jsp");
				rd.include(request, response);
			}
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
	}

}