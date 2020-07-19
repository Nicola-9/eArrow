<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>check-out</title>
<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<!--Custom styles-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/checkOutStyle.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/footerStyle.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/NavbareArrowStyle.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>

	<jsp:include page="NavbareArrow.jsp" />
	
	<div class="content">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					
					<h3>Check-out</h3>
					
					<div class="d-flex justify-content-end icon">
						<span><i class="fab"><img src='${pageContext.request.contextPath}/image/eArrow.png' width="70" height="70"></i></span>
					</div>
					</div>
				
				<div class="card-body">
					<form id="logForm" action="${pageContext.request.contextPath}/?" method="POST">
					
						<div class="input-group form-group">
							<input type="text" class="form-control" placeholder="Nome della carta" id="name" name="name">
						</div>
						

						<div class="input-group form-group">
							<input type="text" class="form-control" placeholder="Nuomero della carta" id="number" name="number">
							<div class="input-group-append">
								<span class="input-group-text">
									<i class="fab fa-cc-visa"></i> &nbsp; <i class="fab fa-cc-amex"></i> &nbsp; 
									<i class="fab fa-cc-mastercard"></i> 
								</span>
							</div>
						</div>
						
						
						<div class="row align-items-center remember">
							<input type="checkbox">Ricordami
						</div>
						
						<div class="form-group login-form">
							<input type="submit" value="Login" class="btn login_btn">
						</div>
						
					</form>
				</div>
			</div>
		</div>
	</div>

	
	<div class="eArrow-footer">
			<jsp:include page="Footer.jsp"/>
	</div>
	
	
	<!-- Bootstrap Script -->
		<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>	
</body>
</html>