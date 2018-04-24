<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<html>
<head>
<title>Users</title>
<style>
td,tr,th
{
text-align:center;
border:5px solid gold;
}
table
{
border-color:gold;
background-color: white;
border-collapse: collapse;
border:5px solid gold;
}
label
{
border:2px solid gold;
width:100%;
}
a
{
color:black;
 text-decoration: none;
}
</style>
</head>
<body>
<h2 text-align="center">Product Data</h2>
<label><a href="/PSP_LAb3_Ivlev/ChildCosmetic.jsp">Return To Database View</a></label><br/><br/>

<%
	try 
	{
	 
	String url = "jdbc:mysql://localhost:3306/childcosmetic";
	String user = "root";
	String password = "";

	String QueryString = "select * from product_data";
	Class.forName("com.mysql.jdbc.Driver");

	Connection conn=DriverManager.getConnection(url,user,password);
	PreparedStatement ps=conn.prepareStatement(QueryString);

	ResultSet rs=ps.executeQuery();
	rs = ps.executeQuery(QueryString);
%>
	<table cellpadding="15" >
	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>ProductType</th>
	<th>ReleaseDate</th>
	<th>Term</th>
	<th>Firm</th>
	<th>Country</th>
	<th>Cost</th>
	</tr>

<%

	while (rs.next())
	{
%>
	<tr>
	<td><%=rs.getInt(1)%></td>
	<td><%=rs.getString(2)%></td>
	<td><%=rs.getString(3)%></td>
	<td><%=rs.getString(4)%></td>
	<td><%=rs.getString(5)%></td>
	<td><%=rs.getString(6)%></td>
	<td><%=rs.getString(7)%></td>
	<td><%=rs.getString(8)%></td>
	</tr>
<% 	} %>
<%
	} 
	catch (Exception ex) 
	{
%>
<font size="+3" color="red"></b>
<%
	out.println("Unable to connect to database.");
	}
%>
</font>
	</table>
</body>
</html>