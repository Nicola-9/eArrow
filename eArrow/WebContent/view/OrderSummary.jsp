<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.bean.*, model.dao.*, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Riepilogo ordine</title>
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">		
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/OrderSummary.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footerStyle.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/NavbareArrowStyle.css">
	</head>

	
	<body>
	
	<jsp:include page="NavbareArrow.jsp"/>
	
	<% 
	ProdottoBean carrello = (ProdottoBean) request.getAttribute("carrello");
	ImmagineBean img = (ImmagineBean) request.getAttribute("img");
	%>
	
	<div class="content">

			<div class="ordinamento">
				<label class="titleSelect">Riepilogo ordine</label> 
			</div>

	<div class="card-body">
		<div class="row">
			<aside class="col-md-3" id="imageContainer">
				<a href="#" class="img-wrap img-fluid"><img class="image" src="${pageContext.request.contextPath}<%=img.getUri()%>"></a>
			</aside>
			<!-- col.// -->
			<article class="col-md-6">
				<a href="#" class="title mt-2 h5"><%=carrello.getNome()%></a>
				
				<!-- rating-wrap.// -->
				<p class="description"><%=carrello.getDescrizione()%></p>

			</article>
			<!-- col.// -->
			<aside class="col-md-3 order">
			<div class="cent">
				<div class="price-wrap mt-2">
					<span class="price h5">&#8364 <%=carrello.getPrezzo()%></span>
				</div>
				<!-- info-price-detail // -->

				
				<p class="buttonAdd">
					<p class="quantity">Quantita: <%=carrello.getQuantita()%></p>
				</p>
			</div>
			</aside>
			<!-- col.// -->
		</div>
		<!-- row.// -->
	</div>
		
		<div class="tot-prezzo">
			<label class="titleSelect">Totale ordine: <strong>&#8364 $$$$$$$</strong> </label> 
		</div>
		
		<div class="bottone-cont">
			<a href="#" class="btn btn-primary "> Continua lo Shopping</a> 
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