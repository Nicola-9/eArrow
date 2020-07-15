<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign in</title>
<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<!--Custom styles-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/SignUpStyle.css">
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
				<h3>Registrazione</h3>
				<div class="d-flex justify-content-end icon">
					<span><i class="fab"><img src = '..//image/eArrow.png' width="70" height="70"></i></span>
					
				</div>
			</div>
			<div class="card-body">
				<form>
				
					<div class="input-group form-group">
						<input type="text" class="form-control name" placeholder="Nome">
						<input type="text" class="form-control surname" placeholder="Cognome">
					</div>
				
					<div class="input-group form-group">
						<input type="text" class="form-control" placeholder="Indirizzo e-mail">
					</div>
				
					<div class="input-group form-group">
						<input type="text" class="form-control" placeholder="Numero di telefono">
					</div>
					
					<div class="input-group form-group">
						<input type="text" class="form-control" placeholder="Indirizzo">
					</div>
					
					<div class="input-group form-group">
						<input type="password" class="form-control" placeholder="Password">
					</div>
					
					<div class="input-group form-group">
						<input type="password" class="form-control" placeholder="Conferma Password">
					</div>
					
					<div class="form-group subm">
						<input type="submit" value="Registrati ora" class="btn btn-block Signin_btn">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<div class="eArrow-footer">
			<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>