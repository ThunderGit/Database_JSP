package ua.dnu.ivlev.child_cosmetic;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
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


@WebServlet("/AdminManufacturer")
public class AdminManufacturer extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	static private String url = "jdbc:mysql://localhost:3306/childcosmetic";
	static private String user = "root";
	static private String password = "";
	
    public AdminManufacturer() 
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
				request.getParameter("Firm_Name"),
				request.getParameter("Adress"),
				request.getParameter("Telephone"),
				request.getParameter("Website")
				};
		
		//Checkboxes
		String[] checks=new String[]{
				request.getParameter("chID"),
				request.getParameter("chFirm_Name"),
				request.getParameter("chAdress"),
				request.getParameter("chTelephone"),
				request.getParameter("chWebsite")
				};
		
		//Radio's
		String RAnd2=request.getParameter("RAnd2");
		String ROr2=request.getParameter("ROr2");
		
		//CRUD's
		String CREATE=request.getParameter("CREATE");
		String READ=request.getParameter("READ");
		String DELETE=request.getParameter("DELETE");
		
		//SQL
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url,user,password);
		PrintWriter out=response.getWriter();
		String sql="",AndOr="";
		if(RAnd2!=null)
		{
			AndOr=" and ";
		}
		else
		{
			AndOr=" or ";
		}
		if(CREATE!=null)//CREATE
		{
			sql="insert into manufacturer(id,firmname,adress,telephone,Website) values('"+
		Integer.parseInt(fields[0])+"','"+fields[1]+"','"+fields[2]+"','"+fields[3]+"','"+fields[4]+"')";
			
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
				sql="select * from manufacturer";
				if(checks[0]!=null ||checks[1]!=null||checks[2]!=null||checks[3]!=null||checks[4]!=null)
				{
					sql+=" where ";
					if(checks[0]!=null)//ID
					{
						sql+="id='"+Integer.parseInt(fields[0])+"'";
						if(checks[1]!=null)//FirmName
						{
							sql+=AndOr+"firmname='"+fields[1]+"'";
						}
						if(checks[2]!=null)//Adress
						{
							sql+=AndOr+"adress='"+fields[2]+"'";
						}
						if(checks[3]!=null)//Telephone
						{
							sql+=AndOr+"telephone='"+fields[3]+"'";
						}
						if(checks[4]!=null)//Website
						{
							sql+=AndOr+"Website='"+fields[4]+"'";
						}
					}
					else
					{
						if(checks[1]!=null)//FirmName
						{
							sql+="firmname='"+fields[1]+"'";
							if(checks[2]!=null)//Adress
							{
								sql+=AndOr+"adress='"+fields[2]+"'";
							}
							if(checks[3]!=null)//Telephone
							{
								sql+=AndOr+"telephone='"+fields[3]+"'";
							}
							if(checks[4]!=null)//Website
							{
								sql+=AndOr+"Website='"+fields[4]+"'";
							}
						}
						else
						{
							if(checks[2]!=null)//Adress
							{
								sql+="adress='"+fields[2]+"'";
								if(checks[3]!=null)//Telephone
								{
									sql+=AndOr+"telephone='"+fields[3]+"'";
								}
								if(checks[4]!=null)//Website
								{
									sql+=AndOr+"Website='"+fields[4]+"'";
								}
							}
							else
							{
								if(checks[3]!=null)//Telephone
								{
									sql+="telephone='"+fields[3]+"'";
									if(checks[4]!=null)//Website
									{
										sql+=AndOr+"Website='"+fields[4]+"'";
									}
								}
								else
								{
									if(checks[4]!=null)//Website
									{
										sql+="Website='"+fields[4]+"'";
									}
								}
								
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
						gotit+="\n ID: "+res.getString("ID")+
								"<br/> FirmName: " + res.getString("FirmName") + 
								"<br/> Adress: " + res.getString("Adress")+
								"<br/> Telephone: " + res.getString("Telephone")+
								"<br/> Web-site: " + res.getString("Website")+"<br/><br/>";
						
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
					if(checks[0]!=null ||checks[1]!=null||checks[2]!=null||checks[3]!=null||checks[4]!=null)
					{
						sql=" delete from manufacturer where ";
						if(checks[0]!=null)//ID
						{
							sql+="id='"+Integer.parseInt(fields[0])+"'";
							if(checks[1]!=null)//FirmName
							{
								sql+=AndOr+"firmname='"+fields[1]+"'";
							}
							if(checks[2]!=null)//Adress
							{
								sql+=AndOr+"adress='"+fields[2]+"'";
							}
							if(checks[3]!=null)//Telephone
							{
								sql+=AndOr+"telephone='"+fields[3]+"'";
							}
							if(checks[4]!=null)//Website
							{
								sql+=AndOr+"Website='"+fields[4]+"'";
							}
						}
						else
						{
							if(checks[1]!=null)//FirmName
							{
								sql+="firmname='"+fields[1]+"'";
								if(checks[2]!=null)//Adress
								{
									sql+=AndOr+"adress='"+fields[2]+"'";
								}
								if(checks[3]!=null)//Telephone
								{
									sql+=AndOr+"telephone='"+fields[3]+"'";
								}
								if(checks[4]!=null)//Website
								{
									sql+=AndOr+"Website='"+fields[4]+"'";
								}
							}
							else
							{
								if(checks[2]!=null)//Adress
								{
									sql+="adress='"+fields[2]+"'";
									if(checks[3]!=null)//Telephone
									{
										sql+=AndOr+"telephone='"+fields[3]+"'";
									}
									if(checks[4]!=null)//Website
									{
										sql+=AndOr+"Website='"+fields[4]+"'";
									}
								}
								else
								{
									if(checks[3]!=null)//Telephone
									{
										sql+="telephone='"+fields[3]+"'";
										if(checks[4]!=null)//Website
										{
											sql+=AndOr+"Website='"+fields[4]+"'";
										}
									}
									else
									{
										if(checks[4]!=null)//Website
										{
											sql+="Website='"+fields[4]+"'";
										}
									}
									
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
