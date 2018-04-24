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

/**
 * Servlet implementation class AdminUsers
 */
@WebServlet("/AdminUsers")
public class AdminUsers extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static private String url = "jdbc:mysql://localhost:3306/childcosmetic";
	static private String user = "root";
	static private String password = "";
    public AdminUsers()
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
		//table fields
		String[]fields=new String[]{
				request.getParameter("ID"),
				request.getParameter("Username"),
				getMD5(request.getParameter("Password"))
				};
		
		//Checkboxes
		String[] checks=new String[]{
				request.getParameter("chID"),
				request.getParameter("chUsername"),
				request.getParameter("chPassword")
				};
		
		//Radio's
		String RAnd4=request.getParameter("RAnd4");
		String ROr4=request.getParameter("ROr4");
		
		//CRUD's
		String CREATE=request.getParameter("CREATE");
		String READ=request.getParameter("READ");
		String DELETE=request.getParameter("DELETE");
		
		//SQL
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url,user,password);
		PrintWriter out=response.getWriter();
		String sql="",AndOr="";
		//int ID=Integer.parseInt(fields[0]);
		if(RAnd4!=null)
		{
			AndOr=" and ";
		}
		else
		{
			AndOr=" or ";
		}
		if(CREATE!=null)//CREATE
		{
			sql="insert into users(id,username,password) values('"+Integer.parseInt(fields[0])+"','"+fields[1]+"',MD5('"+fields[2]+"'))";
			if(!sql.equals(""))
			{
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.executeUpdate();
				out.println("Successful!!!");
			}
			else
			{
				out.println("Error!");
			}
		}
		else
		{
			if(READ!=null)//READ
			{
				sql="select * from users";
				if(checks[0]!=null ||checks[1]!=null||checks[2]!=null)
				{
					sql+=" where ";
					if(checks[0]!=null)//ID
					{
						sql+="id='"+Integer.parseInt(fields[0])+"'";
						if(checks[1]!=null)//Username
						{
							sql+=AndOr+"username='"+fields[1]+"'";
							  
						}
						if(checks[2]!=null)//password
						{	
							sql+=AndOr+"password='"+fields[2]+"'";
						}
					}
					else
					{
						if (checks[1] != null) //Username
						{
							sql += "username='" + fields[1] + "'";
							if (checks[2] != null) //Password
							{
								sql += AndOr + "password='" + fields[2] + "'";
							}
						}
						else
						{
							if (checks[2] != null) //Password
							{
								sql += "password='" + fields[2] + "'";
							}
						}
					}
				}
				if(!sql.equals(""))
				{
					PreparedStatement ps=conn.prepareStatement(sql);
					ResultSet res=ps.executeQuery();
					String gotit="";
					while (res.next()) 
					{
						gotit+="\n ID: "+res.getString("ID")+"<br/> Username: " + res.getString("username") + "<br/> password: " + res.getString("password")+"<br/><br/>";
						
					}
					out.print(gotit);
				}
				else
				{
					out.println("Error!");
				}
			}
			else
			{
				if(DELETE!=null)//DELETE
				{
					if(checks[0]!=null ||checks[1]!=null||checks[2]!=null)
					{
						sql+=" delete from users where ";
						if(checks[0]!=null)//ID
						{
							sql+="id='"+Integer.parseInt(fields[0])+"'";
							if(checks[1]!=null)//Username
							{
								sql+=AndOr+"username='"+fields[1]+"'";
								  
							}
							if(checks[2]!=null)//password
							{	
								sql+=AndOr+"password='"+fields[2]+"'";
							}
						}
						else
						{
							if (checks[1] != null) //Username
							{
								sql += "username='" + fields[1] + "'";
								if (checks[2] != null) //Password
								{
									sql += AndOr + "password='" + fields[2] + "'";
								}
							}
							else
							{
								if (checks[2] != null) //Password
								{
									sql += "password='" + fields[2] + "'";
								}
							}
						}
					}
					if(!sql.equals(""))
					{
						PreparedStatement ps=conn.prepareStatement(sql);
						ps.executeUpdate();
						out.println("Successful!!!");
					}
					else
					{
						out.println("Error!");
					}
				}
			}
		}
		if(!sql.equals(""))
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.executeQuery();
			out.println("Successful!!!");
		}
		else
		{
			out.println("Error!");
		}
		RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");
		rd.include(request, response);
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