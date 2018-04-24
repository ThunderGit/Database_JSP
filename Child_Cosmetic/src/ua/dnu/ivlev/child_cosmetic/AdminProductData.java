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

@WebServlet("/AdminProductData")
public class AdminProductData extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	static private String url = "jdbc:mysql://localhost:3306/childcosmetic";
	static private String user = "root";
	static private String password = "";
    public AdminProductData() 
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
				request.getParameter("Name"),
				request.getParameter("Product_Type"),
				request.getParameter("Release_Date"),
				request.getParameter("Term"),
				request.getParameter("Firm"),
				request.getParameter("Country"),
				request.getParameter("Cost")
				};
		
		//Checkboxes
		String[] checks=new String[]{
				request.getParameter("chID"),
				request.getParameter("chName"),
				request.getParameter("chProduct_Type"),
				request.getParameter("chRelease_Date"),
				request.getParameter("chTerm"),
				request.getParameter("chFirm"),
				request.getParameter("chCountry"),
				request.getParameter("chCost")
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
			sql="insert into product_data(id,name,producttype,releasedate,term,firm,country,cost) values('"+
		Integer.parseInt(fields[0])+"','"+fields[1]+"','"+fields[2]+"','"+fields[3]+"','"+fields[4]+"','"+fields[5]+
		"','"+fields[6]+"','"+fields[7]+"')";
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
				sql="select * from product_data";
				if(checks[0]!=null ||checks[1]!=null||checks[2]!=null||checks[3]!=null||checks[4]!=null||
						checks[5]!=null||checks[6]!=null||checks[7]!=null)
				{
					sql+=" where ";
					if(checks[0]!=null)//ID
					{
						sql+="id='"+Integer.parseInt(fields[0])+"'";
						{
							if(checks[1]!=null)//Name
							{
								sql+=AndOr+"name='"+fields[1]+"'";
							}
							if(checks[2]!=null)//Product_Type
							{
								sql+=AndOr+"producttype='"+fields[2]+"'";
							}
							if(checks[3]!=null)//Release_Date
							{
							    sql+=AndOr+"releasedate='"+fields[3]+"'";
							}
							if(checks[4]!=null)//Term
							{
								sql+=AndOr+"term='"+fields[4]+"'";
							}	
							if(checks[5]!=null)//Firm
							{
								sql+=AndOr+"firm='"+fields[5]+"'";
							}	
							if(checks[6]!=null)//Country
							{
								sql+=AndOr+"country='"+fields[6]+"'";
							}
							if(checks[7]!=null)
							{
								sql+=AndOr+"cost='"+fields[7]+"'";
							}
						}
					}
					else
					{
						if(checks[1]!=null)//Name
						{
							sql+="name='"+fields[1]+"'";
							if(checks[2]!=null)//Product_Type
							{
								sql+=AndOr+"producttype='"+fields[2]+"'";
							}
							if(checks[3]!=null)//Release_Date
							{
							    sql+=AndOr+"releasedate='"+fields[3]+"'";
							}
							if(checks[4]!=null)//Term
							{
								sql+=AndOr+"term='"+fields[4]+"'";
							}	
							if(checks[5]!=null)//Firm
							{
								sql+=AndOr+"firm='"+fields[5]+"'";
							}	
							if(checks[6]!=null)//Country
							{
								sql+=AndOr+"country='"+fields[6]+"'";
							}
							if(checks[7]!=null)
							{
								sql+=AndOr+"cost='"+fields[7]+"'";
							}
						}
						else
						{
							if(checks[2]!=null)//Product_Type
							{
								sql+="producttype='"+fields[2]+"'";
								if(checks[3]!=null)//Release_Date
								{
								    sql+=AndOr+"releasedate='"+fields[3]+"'";
								}
								if(checks[4]!=null)//Term
								{
									sql+=AndOr+"term='"+fields[4]+"'";
								}	
								if(checks[5]!=null)//Firm
								{
									sql+=AndOr+"firm='"+fields[5]+"'";
								}	
								if(checks[6]!=null)//Country
								{
									sql+=AndOr+"country='"+fields[6]+"'";
								}
								if(checks[7]!=null)
								{
									sql+=AndOr+"cost='"+fields[7]+"'";
								}
							}
							else
							{
								if(checks[3]!=null)//Release_Date
								{
								    sql+="releasedate='"+fields[3]+"'";
									if(checks[4]!=null)//Term
									{
										sql+=AndOr+"term='"+fields[4]+"'";
									}	
									if(checks[5]!=null)//Firm
									{
										sql+=AndOr+"firm='"+fields[5]+"'";
									}	
									if(checks[6]!=null)//Country
									{
										sql+=AndOr+"country='"+fields[6]+"'";
									}
									if(checks[7]!=null)
									{
										sql+=AndOr+"cost='"+fields[7]+"'";
									}
								}
								else
								{
									if(checks[4]!=null)//Term
									{
										sql+="term='"+fields[4]+"'";
										if(checks[5]!=null)//Firm
										{
											sql+=AndOr+"firm='"+fields[5]+"'";
										}	
										if(checks[6]!=null)//Country
										{
											sql+=AndOr+"country='"+fields[6]+"'";
										}
										if(checks[7]!=null)
										{
											sql+=AndOr+"cost='"+fields[7]+"'";
										}
									}	
									else
									{
										if(checks[5]!=null)//Firm
										{
											sql+="firm='"+fields[5]+"'";
											if(checks[6]!=null)//Country
											{
												sql+=AndOr+"country='"+fields[6]+"'";
											}
											if(checks[7]!=null)
											{
												sql+=AndOr+"cost='"+fields[7]+"'";
											}

										}	
										else
										{
											if(checks[6]!=null)//Country
											{
												sql+="country='"+fields[6]+"'";
												if(checks[7]!=null)
												{
													sql+=AndOr+"cost='"+fields[7]+"'";
												}
											}
											else
											{
												if(checks[7]!=null)
												{
													sql+="cost='"+fields[7]+"'";
												}
											}
										}
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
								"<br/> Name: " + res.getString("Name") + 
								"<br/> Product Type: " + res.getString("ProductType")+
								"<br/> Release Date: " + res.getString("ReleaseDate")+
								"<br/> Term: " + res.getString("Term")+
								"<br/> Firm: " + res.getString("Firm")+
								"<br/> Country: " + res.getString("Country")+
								"<br/> Cost: " + res.getString("Cost")+"<br/><br/>";
						
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
					if(checks[0]!=null ||checks[1]!=null||checks[2]!=null||checks[3]!=null||checks[4]!=null||
							checks[5]!=null||checks[6]!=null||checks[7]!=null)
					{
						sql+=" delete from product_data where ";
						if(checks[0]!=null)//ID
						{
							sql+="id='"+Integer.parseInt(fields[0])+"'";
							{
								if(checks[1]!=null)//Name
								{
									sql+=AndOr+"name='"+fields[1]+"'";
								}
								if(checks[2]!=null)//Product_Type
								{
									sql+=AndOr+"producttype='"+fields[2]+"'";
								}
								if(checks[3]!=null)//Release_Date
								{
								    sql+=AndOr+"releasedate='"+fields[3]+"'";
								}
								if(checks[4]!=null)//Term
								{
									sql+=AndOr+"term='"+fields[4]+"'";
								}	
								if(checks[5]!=null)//Firm
								{
									sql+=AndOr+"firm='"+fields[5]+"'";
								}	
								if(checks[6]!=null)//Country
								{
									sql+=AndOr+"country='"+fields[6]+"'";
								}
								if(checks[7]!=null)
								{
									sql+=AndOr+"cost='"+fields[7]+"'";
								}
							}
						}
						else
						{
							if(checks[1]!=null)//Name
							{
								sql+="name='"+fields[1]+"'";
								if(checks[2]!=null)//Product_Type
								{
									sql+=AndOr+"producttype='"+fields[2]+"'";
								}
								if(checks[3]!=null)//Release_Date
								{
								    sql+=AndOr+"releasedate='"+fields[3]+"'";
								}
								if(checks[4]!=null)//Term
								{
									sql+=AndOr+"term='"+fields[4]+"'";
								}	
								if(checks[5]!=null)//Firm
								{
									sql+=AndOr+"firm='"+fields[5]+"'";
								}	
								if(checks[6]!=null)//Country
								{
									sql+=AndOr+"country='"+fields[6]+"'";
								}
								if(checks[7]!=null)
								{
									sql+=AndOr+"cost='"+fields[7]+"'";
								}
							}
							else
							{
								if(checks[2]!=null)//Product_Type
								{
									sql+="producttype='"+fields[2]+"'";
									if(checks[3]!=null)//Release_Date
									{
									    sql+=AndOr+"releasedate='"+fields[3]+"'";
									}
									if(checks[4]!=null)//Term
									{
										sql+=AndOr+"term='"+fields[4]+"'";
									}	
									if(checks[5]!=null)//Firm
									{
										sql+=AndOr+"firm='"+fields[5]+"'";
									}	
									if(checks[6]!=null)//Country
									{
										sql+=AndOr+"country='"+fields[6]+"'";
									}
									if(checks[7]!=null)
									{
										sql+=AndOr+"cost='"+fields[7]+"'";
									}
								}
								else
								{
									if(checks[3]!=null)//Release_Date
									{
									    sql+="releasedate='"+fields[3]+"'";
										if(checks[4]!=null)//Term
										{
											sql+=AndOr+"term='"+fields[4]+"'";
										}	
										if(checks[5]!=null)//Firm
										{
											sql+=AndOr+"firm='"+fields[5]+"'";
										}	
										if(checks[6]!=null)//Country
										{
											sql+=AndOr+"country='"+fields[6]+"'";
										}
										if(checks[7]!=null)
										{
											sql+=AndOr+"cost='"+fields[7]+"'";
										}
									}
									else
									{
										if(checks[4]!=null)//Term
										{
											sql+="term='"+fields[4]+"'";
											if(checks[5]!=null)//Firm
											{
												sql+=AndOr+"firm='"+fields[5]+"'";
											}	
											if(checks[6]!=null)//Country
											{
												sql+=AndOr+"country='"+fields[6]+"'";
											}
											if(checks[7]!=null)
											{
												sql+=AndOr+"cost='"+fields[7]+"'";
											}
										}	
										else
										{
											if(checks[5]!=null)//Firm
											{
												sql+="firm='"+fields[5]+"'";
												if(checks[6]!=null)//Country
												{
													sql+=AndOr+"country='"+fields[6]+"'";
												}
												if(checks[7]!=null)
												{
													sql+=AndOr+"cost='"+fields[7]+"'";
												}

											}	
											else
											{
												if(checks[6]!=null)//Country
												{
													sql+="country='"+fields[6]+"'";
													if(checks[7]!=null)
													{
														sql+=AndOr+"cost='"+fields[7]+"'";
													}
												}
												else
												{
													if(checks[7]!=null)
													{
														sql+="cost='"+fields[7]+"'";
													}
												}
											}
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
