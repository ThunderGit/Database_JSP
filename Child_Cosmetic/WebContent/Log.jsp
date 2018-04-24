<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In</title>
</head>
<body>
<div align="center">
<form action="Log" method="post">
	<label>Username</label>
	<input type="text" name="login" placeholder="Set Login"><br/>
	<label>Password</label>
	<input type="password" name="pass" placeholder="Set Password"><br/>
	<input type="submit"  value="Submit"></input>
</form>
<br/>
<label>Not Registered Yet? <a href="/PSP_LAb3_Ivlev/Reg.jsp"> Sign Up Here</a>!</label>
</div>
</body>
</html>