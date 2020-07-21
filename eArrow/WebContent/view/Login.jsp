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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/LoginStyle.css">
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
					<h3>Accedi</h3>
					<div class="d-flex justify-content-end icon">
						<span><i class="fab"><img src='${pageContext.request.contextPath}/image/eArrow.png' width="70" height="70"></i></span>
					</div>
				</div>
				
				<div class="card-body">
				
					<div id="errorLog">
						<p id="textError"></p>
					</div>
				
					<form id="logForm" action="${pageContext.request.contextPath}/LoginServlet" method="POST">
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							
							<input type="text" class="form-control" placeholder="username" id="Email" name="Email">
						</div>
						
						<div class="error">
							<small id="errorEmail" class="form-text text-danger">We'll never share your email..</small>
						</div>
						
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							
							<input type="password" class="form-control" placeholder="password" id="Password" name="Password">
						</div>
						
						<div class="error">
							<small id="errorPass" class="form-text text-danger">We'll never share your password..</small>
						</div>
						
						<div class="row align-items-center remember">
							<input type="checkbox">Ricordami
						</div>
						
						<div class="form-group login-form">
							<input type="submit" value="Login" class="btn login_btn">
						</div>
						
					</form>
				</div>
				
				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						Non hai un account?
						<a class="registration-link" href="${pageContext.request.contextPath}/view/SignUp.jsp">Registrati</a>
					</div>
				
				</div>
			</div>
		</div>
	</div>
	
	<div class="eArrow-footer">
			<jsp:include page="Footer.jsp"/>
	</div>
	
	<script>
		
		function alertInsuccesso(input){
			$("#textError").text(input);
			//$(".card").animate({height: "470px"}, 400 );
			$(".card-body").css("margin-top", "5%");
			$("#errorLog").css("margin-top", "5%");
			$("#errorLog").slideDown();
			}
			
		
		
		$( document ).ready(function() {
		   
		
		<% if(request.getAttribute("emailErrata")!=null) { %>
		alertInsuccesso("E-mail errata!");
		<% } %>
		
		
		<% if(request.getAttribute("passwordErrata")!=null) { %>
		alertInsuccesso("Password errata!");
		<% } %>
		
		<% if(request.getAttribute("utenteNonDb")!=null) { %>
		alertInsuccesso("Utente non registrato!");
		<% } %>
		});
	</script>
	
	<script src="${pageContext.request.contextPath}/javascript/LoginCheck.js"></script>

	<!-- Bootstrap Script -->
		<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>	
</body>
</html>