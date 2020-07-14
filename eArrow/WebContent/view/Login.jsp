<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>eArrow</title>
<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<!--Custom styles-->
	<link rel="stylesheet" type="text/css" href="..//css/LoginStyle.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/footerStyle.css">
	<link rel="stylesheet" type="text/css" href="..//css/NavbareArrowStyle.css">
</head>

<body>

	<jsp:include page="NavbareArrow.jsp" />

	<div class="content">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Accedi</h3>
					<div class="d-flex justify-content-end icon">
						<span><i class="fab"><img src='..//image/eArrow.png'
								width="70" height="70"></i></span>

					</div>
				</div>
				<div class="card-body">
					<form>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="username">

						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control"
								placeholder="password">
						</div>
						<div class="row align-items-center remember">
							<input type="checkbox">Ricordami
						</div>
						<div class="form-group login-form">
							<input type="submit" value="Login"
								class="btn  login_btn">
						</div>
					</form>
				</div>
				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						Non hai un account?<a href="#">Registrati</a>
					</div>
					<!--  
					<div class="d-flex justify-content-center">
						<a href="#">Hai dimenticato la password?</a>
					</div> -->
				</div>
			</div>
		</div>
	</div>
	
	<div class="eArrow-footer">
			<jsp:include page="Footer.jsp"/>
	</div>
</body>
</html>