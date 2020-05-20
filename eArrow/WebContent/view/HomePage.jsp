<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>eArrow</title>
		
		<link rel="stylesheet" type="text/css" href="..//css/HomePageStyle.css">
	</head>
	
	<body>
	
		<div class="home">
			
			<jsp:include page="navbar.jsp" />
		
			<div class="body">
				<jsp:include page="Body.jsp" />
			</div>
		
			<div class="footer">
				<jsp:include page="footer.jsp" />
			</div>
		
		</div>
	
	</body>
</html>