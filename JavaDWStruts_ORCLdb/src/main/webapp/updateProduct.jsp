<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Trasitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Update Product</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<div>
		<h2>Update Product</h2>
		<s:form action="updateAction" class="formTable">
			<s:textfield name="productId" input="Product ID" class="formTextField" readonly="true" />
			<s:textfield name="productName" input="Product Name" class="formTextField" />
			<s:textfield name="productCategory" input="Product Category" class="formTextField" />
			<s:textfield name="productPrice" input="Product Price" class="formTextField" />
			<s:submit value="Update Product" class="actionBtn" />
		</s:form>
	</div>

</body>
</html>