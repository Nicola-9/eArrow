<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Il tuo profilo</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">		
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footerStyle.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ProfileStyle.css">	
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/NavbareArrowStyle.css">	
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	</head>
	
	<body>
	
		<jsp:include page="NavbareArrow.jsp"/>
	
		<div class="content">
			<h5 class="doc-title-sm">IL TUO PROFILO</h5>
			<div class="card">
				<div class="card-body">
					<form>
					
						<div class="intestation">
							<h5 class="headerInformation d-inline-block">INFORMAZIONI PERSONALI</h5>
							<button type="button" class="btn btn-primary modify-btn"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>Modifica</button>
						</div>
						<div class="form-row">
							<div class="col form-group">
								<label>Nome</label> <input type="text" class="form-control"
									value="John">
							</div>
							<!-- form-group end.// -->
							<div class="col form-group">
								<label>Cognome</label> <input type="text" class="form-control"
									value="Surname">
							</div>
							<!-- form-group end.// -->
						</div>
						<!-- form-row.// -->
		
						<div class="form-row email-row">
							<div class="col form-group">
								<label>Email</label> <input type="email" class="form-control"
									value="boh@gmail.com">
							</div>
							
							<div class="col form-group">
								<label>Telefono</label> <input type="text" class="form-control"
									value="3914599336">
							</div>
							<!-- form-group end.// -->
						</div>
						
						<div class="form-row tel-row">
							<div class="col form-group">
								<label>Password</label> <input type="password" class="form-control pass"
									value="Prova">
							</div>
							<!-- form-group end.// -->
						</div>
						
						<h5 class="headerInformation addressHeader">INDIRIZZO</h5>
						
						<div class="form-row">
							<div class="col form-group">
								<label>Città</label> <input type="text" class="form-control"
									value="Trecchina">
							</div>
							<!-- form-group end.// -->
							<div class="col form-group">
								<label>Via</label> <input type="text" class="form-control"
									value="Maurino">
							</div>
							<!-- form-group end.// -->
						</div>
						
						<div class="form-row">
							<div class="col form-group">
								<label>Civico</label> <input type="text" class="form-control"
									value="43/A">
							</div>
							<!-- form-group end.// -->
							<div class="col form-group">
								<label>CAP</label> <input type="text" class="form-control"
									value="85049">
							</div>
							<!-- form-group end.// -->
						</div>
						
						<div class="form-row">
							<div class="col form-group">
								<label>Tipologia indirizzo</label> <input type="text" class="form-control typeAddress"
									value="Fatturazione e Spedizione">
							</div>
							<!-- form-group end.// -->
						</div>
						
		
						<button class="btn btn-primary btn-block save-btn">Salva le modifiche</button>
					</form>
				</div>
				<!-- card-body.// -->
			</div>
			<!-- card .// -->
		</div>
		
		<div class="eArrow-footer">
			<jsp:include page="Footer.jsp"/>
		</div>
		
		<!-- Bootstrap Script -->	
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>	
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/ProfileJS.js"></script>
	</body>
</html>