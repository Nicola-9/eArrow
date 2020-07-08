<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0">
	
		<title>eArrow</title>
		
		<link rel="stylesheet" href="..//css/NavStyleTest.css">
		<link rel="stylesheet" href="..//css/ProductPageStyle.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	<div class="navbar">
		<jsp:include page="Navbar.jsp"/>
	</div>
		
	<div class="slider">
		<jsp:include page="ProductList.jsp"/>	
	</div>

</body>
</html>