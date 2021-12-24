<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Trasitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	
	<div align="center">
		<h2>Welcome</h2>
		<a href="addProduct.jsp">
			<button class="actionBtn">Add New Product</button>
		</a>
	</div>
	
	<table width="750" class="productTable" align="center">
		<thead>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Category</th>
				<th>Product Price</th>
				<th colspan="2">Actions</th>
			</tr>
		</thead>
		
		<s:iterator value="products" var="product">
			<tr>
				<td>
					<s:property value="#product.productId"/>
				</td>
				<td>
					<s:property value="#product.productName"/>
				</td>
				<td>
					<s:property value="#product.productCategory"/>
				</td>
				<td>
					<s:property value="#product.productPrice"/>
				</td>
				<td>UPDATE</td>
				<td>DELETE</td>
			</tr>
		</s:iterator>
	</table>

</body>
</html>