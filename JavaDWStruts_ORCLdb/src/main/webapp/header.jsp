<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC
	"-//W3C//DTD HTML 4.01 transitional/EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta equiv-content="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Header</title>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>

<%
if(session.getAttribute("loggedUser") == null){
	response.sendRedirect("login.jsp");
}
%>

	<div class="topnav">
		<a href="welcomeAction">Home</a>
		<a href="addProduct.jsp">Add Product</a>
		<a href="logoutAction" style="float:right">Logout</a>
	</div>

</body>
</html>