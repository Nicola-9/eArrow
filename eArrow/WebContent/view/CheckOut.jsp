<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.bean.*, model.dao.*, java.util.ArrayList"%>
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
	
	<% 
		CartaDiCreditoBean carta = (CartaDiCreditoBean) request.getAttribute("cartaAssociata");
		UtenteBean utente = (UtenteBean) request.getAttribute("user");
	%>

	<%if(carta != null){ %>			
		<p id="nameText" class="hid"><%=utente.getNome()%></p>
		<p id="panText" class="hid"><%=carta.getCodicePAN()%></p>			
	<%}%>
	
	<div class="content">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
			
			<form id="CheckForm" action="${pageContext.request.contextPath}/CheckOutServlet?formRequest=true" method="POST">
				<div class="card-header">
					
					<h3>Check-out</h3>
					
					<div class="d-flex justify-content-end icon">
						<span><i class="fab"><img src='${pageContext.request.contextPath}/image/eArrow.png' width="70" height="70"></i></span>
					</div>
					</div>
				
				<div class="card-body">
					
					
						<div class="input-group form-group">
							
							<input type="text" class="form-control" placeholder="Nome del titolare della carta" id="name" name="name">

						</div>
						
						<div class="error">
							<small id="errorName" class="form-text text-danger">We'll never share your name..</small>
						</div>
						

						<div class="input-group form-group">
							<input type="text" class="form-control" placeholder="Numero della carta" id="number" name="number">
								<span class="input-group-text">
									<i class="fab fa-cc-visa"></i> &nbsp; <i class="fab fa-cc-amex"></i> &nbsp; 
									<i class="fab fa-cc-mastercard"></i> 
								</span>
							</div>
							
							<div class="error">
								<small id="errorPan" class="form-text text-danger">We'll never share your PAN..</small>
							</div>
						</div>
						
						<div class="row">
						    <div class="col-md flex-grow-0">
						        <div class="form-group">
						            <label><span class="hidden-xs">Scadenza</span> </label>
						        	<div class="form-inline wh">
						        		<select id="selMese" class="form-control custom-select" style="width:100px">
										  <option>Mese</option>
										  <option>01</option>
										  <option>02</option>
										  <option>03</option>
										  <option>04</option>
										  <option>05</option>
										  <option>06</option>
										  <option>07</option>
										  <option>08</option>
										  <option>09</option>
										  <option>10</option>
										  <option>11</option>
										  <option>12</option>
										</select>
							            <span class="primoSpan"> / </span>
							            <select id="selAnno" class="form-control custom-select" style="width:100px">
										  <option>Anno</option>
										  <option>2020</option>
										  <option>2021</option>
										  <option>2022</option>
										  <option>2023</option>
										  <option>2024</option>
										  <option>2025</option>
										  <option>2026</option>
										  <option>2027</option>
										  <option>2028</option>
										  <option>2029</option>
										  <option>2030</option>
										  <option>2031</option>
										  <option>2032</option>
										  <option>2033</option>
										  <option>2034</option>
										  <option>2036</option>
										  <option>2037</option>
										  <option>2038</option>
										  <option>2039</option>
										  <option>2040</option>
										</select>
										<span class="secondoSpan"> </span>
										<select id="selC" class="form-control custom-select" name="circuito" style="width:100px">
										  <option>Circuito</option>
										  <option>Visa</option>
										  <option>Mastercard</option>
										  <option>Diners Club</option>
										</select>
						        	</div>
						        </div>
						    </div>
			</div>
			
						<div class="error errorD">
							<small id="errorData" class="form-text text-danger">We'll never share your DATA..</small>
						</div>
			
						<div class="input-group form-group marg">
							<input type="text" class="form-control" placeholder="CVV" id="cvv" name="cvv">
						</div>
						
						<div class="error errorC">
							<small id="errorCvv" class="form-text text-danger">We'll never share your CVV..</small>
						</div>
						
						<div class="form-group check-form">
							<input type="submit" value="Conferma" class="btn btn-primary">
						</div>
						</form>
				</div>
			</div>
		</div>

	
	<div class="eArrow-footer">
			<jsp:include page="Footer.jsp"/>
	</div>
	
	
	<!-- Validazione -->
		<script src="${pageContext.request.contextPath}/javascript/CheckOutCheck.js"></script>
	
	<!-- Bootstrap Script -->
		<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
		
		<script>
		$(document).ready(function(){
		document.getElementById('number').addEventListener('input', function (e) {
			  var target = e.target, position = target.selectionEnd, length = target.value.length;
			  
			  target.value = target.value.replace(/[^\dA-Z]/g, '').replace(/(.{4})/g, '$1 ').trim();
			  target.selectionEnd = position += ((target.value.charAt(position - 1) === ' ' && target.value.charAt(length - 1) === ' ' && length !== target.value.length) ? 1 : 0);
			});
		});

		$(document).ready(function() {
			<% if(carta != null) {%>
			document.querySelector('#name').value = document.getElementById('nameText').textContent;
			
			var target = document.getElementById('panText').textContent;
			
			var t = target.replace(/[^\dA-Z]/g, '').replace(/(.{4})/g, '$1 ').trim();
			
			document.querySelector('#number').value = t;
			<% } %>
		});

		</script>	
		
		
</body>
</html>