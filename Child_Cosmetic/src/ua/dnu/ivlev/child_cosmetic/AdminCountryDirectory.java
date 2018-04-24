package ua.dnu.ivlev.child_cosmetic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminCountryDirectory")
public class AdminCountryDirectory extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	static private String url = "jdbc:mysql://localhost:3306/childcosmetic";
	static private String user = "root";
	static private String password = "";
    public AdminCountryDirectory() 
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
		//table fields
		String[]fields=new String[]{
				request.getParameter("ID"),
				request.getParameter("Country_Name")
				};
		
		//Checkboxes
		String[] checks=new String[]{
				request.getParameter("chID"),
				request.getParameter("chCountry_Name")
				};
		
		//Radio's
		String RAnd1=request.getParameter("RAnd1");
		String ROr1=request.getParameter("ROr1");
		
		//CRUD's
		String CREATE=request.getParameter("CREATE");
		String READ=request.getParameter("READ");
		String DELETE=request.getParameter("DELETE");
		
		//SQL
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url,user,password);
		PrintWriter out=response.getWriter();
		String sql="",AndOr="";
		if(RAnd1!=null)
		{
			AndOr=" and ";
		}
		else
		{
			AndOr=" or ";
		}
		if(CREATE!=null)//CREATE
		{
			sql="insert into country_directory(id,countryname) values('"+Integer.parseInt(fields[0])+"','"+fields[1]+"')";
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
				sql="select * from country_directory";
				if(checks[0]!=null ||checks[1]!=null)
				{
					sql+=" where ";
					if(checks[0]!=null)//ID
					{
						sql+="id='"+Integer.parseInt(fields[0])+"'";
						if(checks[1]!=null)//CountryName
						{
							sql+=AndOr+"countryname='"+fields[1]+"'";
						}
					}
					else
					{
						if(checks[1]!=null)//CountryName
						{
							sql+="countryname='"+fields[1]+"'";
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
						gotit+="\n ID: "+res.getString("ID")+
								"<br/> Country Name: " + res.getString("CountryName")+"<br/><br/>";
						
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
					if(checks[0]!=null ||checks[1]!=null)
					{
						sql="delete from country_directory where ";
						if(checks[0]!=null)//ID
						{
							sql+="id='"+Integer.parseInt(fields[0])+"'";
							if(checks[1]!=null)//CountryName
							{
								sql+=AndOr+"countryname='"+fields[1]+"'";
							}
						}
						else
						{
							if(checks[1]!=null)//CountryName
							{
								sql="countryname='"+fields[1]+"'";
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
	}
}
