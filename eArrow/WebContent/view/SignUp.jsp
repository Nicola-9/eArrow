<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registrazione</title>
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
							<span><i class="fab"><img src = '${pageContext.request.contextPath}/image/eArrow.png' width="70" height="70"></i></span>
							
						</div>
					</div>
					<div class="card-body">
						<form id="registrationForm" method="POST" action="${pageContext.request.contextPath}/SignUpServlet">
						
							<div class="input-group form-group">
								<input name="name" type="text" class="form-control name" id="name" placeholder="Nome">
								<input name="surname" type="text" class="form-control surname" id="surname" placeholder="Cognome">
							</div>
							
							<div class="error">
								<small id="errorNameSurname" class="form-text text-danger">We'll never share your email..</small>
							</div>
						
							<div class="input-group form-group">
								<input name="email" type="text" class="form-control" id="email" placeholder="Indirizzo e-mail">
							</div>
							
							<div class="error">
								<small id="errorEmail" class="form-text text-danger">We'll never share your email..</small>
							</div>
						
							<div class="input-group form-group">
								<input name="numTel" type="text" class="form-control" id="numTel" placeholder="Numero di telefono">
							</div>
							
							<div class="error">
								<small id="errorNumTel" class="form-text text-danger">We'll never share your email..</small>
							</div>
							
							<div class="input-group form-group">
								<input name="city" type="text" class="form-control city" id="city" placeholder="Città">
								<input name="via" type="text" class="form-control via" id="via" placeholder="Via">
							</div>
							
							<div class="errCityVia">
								<span class="errCityHide">
										<small id="errorCity" class="form-text text-danger">We'll never share your email..</small>
								</span>
								<span class="error error-second errViaHide">
										<small id="errorVia" class="form-text text-danger">We'll never share your email..</small>
								</span>
							</div>
							
							<div class="input-group form-group">
								<input name="civico" type="text" class="form-control civico" id="civico" placeholder="Civico">
								<input name="cap" type="text" class="form-control cap" id="cap" placeholder="CAP">
							</div>
							
							<div class="errCivicoCap">
								<span class="errCivicoHide">
										<small id="errorCivico" class="form-text text-danger">We'll never share your email..</small>
								</span>
								<span class="error error-second errCapHide">
										<small id="errorCap" class="form-text text-danger">We'll never share your email..</small>
								</span>
							</div>
							
							<div class="input-group form-group">
								<input name="password" type="password" class="form-control" id="password" placeholder="Password">
							</div>
							
							<div class="error">
								<small id="errorPass" class="form-text text-danger">We'll never share your email..</small>
							</div>
							
							<div class="input-group form-group">
								<input name="confirmPass" type="password" class="form-control" id="confirmPass" placeholder="Conferma Password">
							</div>
							
							<div class="error">
								<small id="errorConfirmPass" class="form-text text-danger">We'll never share your email..</small>
							</div>
							
							<div class="form-group subm">
								<input type="submit" value="Registrati ora" id="submitBtn" class="btn btn-block Signin_btn">
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<div class="eArrow-footer">
			<jsp:include page="Footer.jsp"/>
		</div>
		
		<script src="${pageContext.request.contextPath}/javascript/SignUpCheck.js"></script>
		
		<!-- Bootstrap Script -->
		<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>	
	
	</body>
</html>