<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList, model.bean.*, model.dao.*"%>

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
		
		<%
			Object userObj = request.getAttribute("userProfile");
			Object userAddressObj = request.getAttribute("userAddress");
			
			UtenteBean user = null;
			IndirizzoBean address = null;
			
			if(userObj != null && userAddressObj != null){
				user = (UtenteBean) userObj;
				address = (IndirizzoBean) userAddressObj;
			
		%>
	
		<div class="content">
			<h5 class="doc-title-sm">IL TUO PROFILO</h5>
			<div class="card">
				<div class="card-body">
					<form id="ajaxForm" action="${pageContext.request.contextPath}/ProfileAJAX?userNew">
						<input type="hidden" class="idUser" name="idUser" value="<%=user.getId()%>">
						<input type="hidden" class="idAddress" name="idAddress" value="<%=user.getIndirizzo()%>">
						
						<div class="intestation">
							<h5 class="headerInformation d-inline-block">INFORMAZIONI PERSONALI</h5>
							<button type="button" class="btn btn-primary modify-btn"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>Modifica</button>
						</div>
						<div class="form-row nameSurnameRow">
							<div class="col form-group">
								<label>Nome</label> <input type="text" class="form-control name"
									value="<%=user.getNome()%>">
							</div>
							<!-- form-group end.// -->
							<div class="col form-group">
								<label>Cognome</label> <input type="text" class="form-control surname"
									value="<%=user.getCognome()%>">
							</div>
							<!-- form-group end.// -->
						</div>
						<!-- form-row.// -->
						<div class="errRow errRowNameSurname">
							<span class="error errNameHide">
									<small id="errorName" class="form-text text-danger">We'll never share your email..</small>
							</span>
							<span class="error error-second errSurnameHide">
									<small id="errorSurname" class="form-text text-danger">We'll never share your email..</small>
							</span>
						</div>
		
						<div class="form-row emailTelRow">
							<div class="col form-group">
								<label>Email</label> <input type="email" class="form-control email"
									value="<%=user.getEmail()%>">
							</div>
							
							<div class="col form-group">
								<label>Telefono</label> <input type="text" class="form-control tel"
									value="<%=user.getTelefono()%>">
							</div>
							<!-- form-group end.// -->
						</div>
						
						<div class="errRow errRowEmailTel">
							<span class="error errEmailHide">
									<small id="errorEmail" class="form-text text-danger">We'll never share your email..</small>
							</span>
							<span class="error error-second errTelHide">
									<small id="errorTel" class="form-text text-danger">We'll never share your email..</small>
							</span>
						</div>
						
						<div class="form-row passConfPassRow">
							<div class="col form-group">
								<label class="modifyPassLab">Modifica Password</label> <input type="password" class="form-control pass"
									value="">
							</div>
							<!-- form-group end.// -->
							<div class="col form-group">
								<label>Conferma Modifica Password</label> <input type="confirmPass" class="form-control confirmPass"
									value="">
							</div>
							<!-- form-group end.// -->
						</div>
						
						<div class="errRow errRowPassConfirmPass">
							<span class="error errPassHide">
									<small id="errorPass" class="form-text text-danger">We'll never share your email..</small>
							</span>
							<span class="error error-second errConfPassHide">
									<small id="errorConfirmPass" class="form-text text-danger">We'll never share your email..</small>
							</span>
						</div>
						
						<h5 class="headerInformation addressHeader">INDIRIZZO</h5>
						
						<div class="form-row cittaViaRow">
							<div class="col form-group">
								<label>Città</label> <input type="text" class="form-control citta"
									value="<%=address.getCitta()%>">
							</div>
							<!-- form-group end.// -->
							<div class="col form-group">
								<label>Via</label> <input type="text" class="form-control via"
									value="<%=address.getVia()%>">
							</div>
							<!-- form-group end.// -->
						</div>
						
						<div class="errRow errRowCityVia">
							<span class="error errCityHide">
									<small id="errorCity" class="form-text text-danger">We'll never share your email..</small>
							</span>
							<span class="error error-second errViaHide">
									<small id="errorVia" class="form-text text-danger">We'll never share your email..</small>
							</span>
						</div>
						
						<div class="form-row civicoCapRow">
							<div class="col form-group">
								<label>Civico</label> <input type="text" class="form-control civico"
									value="<%=address.getCivico()%>">
							</div>
							<!-- form-group end.// -->
							<div class="col form-group">
								<label>CAP</label> <input type="text" class="form-control cap"
									value="<%=address.getCap()%>">
							</div>
							<!-- form-group end.// -->
						</div>
						
						<div class="errRow errRowCivicoCap">
							<span class="error errCivicoHide">
									<small id="errorCivico" class="form-text text-danger">We'll never share your email..</small>
							</span>
							<span class="error error-second errCapHide">
									<small id="errorCap" class="form-text text-danger">We'll never share your email..</small>
							</span>
						</div>
						
						<div class="form-row tipologiaRow">
							<div class="col form-group">
								<label>Tipologia indirizzo</label> <input type="text" name="tipologia" class="form-control typeAddress"
									value="<%=address.getTipologia()%>">
							</div>
							<!-- form-group end.// -->
						</div>
						
						<div class="errRow errRowTipologia">
							<span class="error">
									<small id="errorTipologia" class="form-text text-danger">We'll never share your email..</small>
							</span>
						</div>		
		
						<button type ="submit" class="btn btn-primary btn-block save-btn">Salva le modifiche</button>
					</form>
				</div>
				<!-- card-body.// -->
			</div>
			<!-- card .// -->
		</div>
		
		<%
			}
		%>
			
			
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