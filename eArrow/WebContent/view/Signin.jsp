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
	<link rel="stylesheet" type="text/css" href="..//css/SigninStyle.css">
</head>

<body>
<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Crea account</h3>
				<div class="d-flex justify-content-end icon">
					<span><i class="fab"><img src = '..//image/eArrow.png' width="70" height="70"></i></span>
					
				</div>
			</div>
			<div class="card-body">
				<form>
					
					<h5>Il tuo nome</h5>
				
					<div class="input-group form-group">
						<input type="text" class="form-control" placeholder="username">
					</div>
					
					<h5>E-mail</h5>
					<div class="input-group form-group">
						<input type="text" class="form-control" placeholder="E-mail">
					</div>
					
					<h5>Password</h5>
					<div class="input-group form-group">
						<input type="password" class="form-control" placeholder="password">
					</div>
					
					<div class="form-group subm">
						<input type="submit" value="Crea il tuo account" class="btn btn-block Signin_btn">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>