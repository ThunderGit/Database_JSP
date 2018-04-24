<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ChildCosmetic</title>
<style>
body {font-family: Arial;}

/* Style the tab */
.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
    font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
    background-color: #ccc;
}
/* Change background color of buttons on hover */
.tab .logout:hover {
    background-color: #aaa;
}

/* Create an active/current tablink class */
.tab .logout.active {
    background-color: #bbb;
}
/* Style the tab content */
.tabcontent {
    display: none;
    padding: 6px 12px;
    border: 1px solid #ccc;
    border-top: none;
}
</style>
</head>
<body>
<h3>View any table of Database by clicking any of buttons</h3>
<div class="tab">
<form method="post" action="/PSP_LAb3_Ivlev/CountryDirectory.jsp">
  <button class="tablinks">Country Directory</button></form>
  
<form method="post" action="/PSP_LAb3_Ivlev/Manufacturer.jsp">
  <button class="tablinks">Manufacturer</button></form>
  
<form method="post" action="/PSP_LAb3_Ivlev/ProductData.jsp">
  <button class="tablinks">Product Data</button></form>
  
<form method="post" action="/PSP_LAb3_Ivlev/Users.jsp">
  <button class="tablinks">Users</button></form>
</div>

<br/><br/>
<div class="tab">
 <form method="post" action="/PSP_LAb3_Ivlev/Log.jsp"><button class="tablogout">Log Out</button></form>
</div>
</body>
</html>