<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*, model.bean.*, model.dao.*, util.*"%>
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
	
	ShoppingCart productsS = (ShoppingCart) request.getSession().getAttribute("mapOrderProduct");
	System.out.println("va va va va va va va av"+ productsS.toString());
	
			HashMap<ProdottoBean, Integer> products = productsS.getProductsList();
			
	 		double totalPrice = 0;
		
			if(products != null){
	%>
	
	<div class="content">

			<div class="ordinamento">
				
			</div>
			
			<h5 class="doc-title-sm">RIEPILOGO ORDINE</h5>
			
			<%
						
			for(HashMap.Entry<ProdottoBean, Integer> pair : products.entrySet()){
								
				ProdottoBean p = (ProdottoBean) pair.getKey();
								
				ImmagineBean image = ImmagineDAO.doRetrieveImageByProductCode(p.getCodice());
								
				String categoria = p.getCategoria();

								
					double prezzo = p.getPrezzo();
								
					String prezzoS = String.format("%.2f", prezzo);
								
					prezzo *= pair.getValue();
								
					totalPrice += prezzo;
								
					String prezzoTotal = String.format("%.2f", prezzo);
						%>

	<div class="card-body">
		<div class="row">
			<aside class="col-md-3" id="imageContainer">
				<a href="#" class="img-wrap img-fluid"><img class="image" src="${pageContext.request.contextPath}<%=image.getUri()%>"></a>
			</aside>
			<!-- col.// -->
			<article class="col-md-6">
				<a href="#" class="title mt-2 h5"><%=p.getNome()%></a>
				
				<!-- rating-wrap.// -->
				<p class="description"><%=p.getDescrizione()%></p>

			</article>
			<!-- col.// -->
			<aside class="col-md-3 order">
			<div class="cent">
				<div class="price-wrap mt-2">
					<span class="price h5">&#8364 <%=p.getPrezzo()%></span>
				</div>
				<!-- info-price-detail // -->

				
				<p class="buttonAdd">
					<p class="quantity">Quantita: <%=pair.getValue()%></p>
					<p class="quantity">Totale prodotto: <%=prezzo%> &#8364</p>
				</p>
			</div>
			</aside>
			<!-- col.// -->
		</div>
		<!-- row.// -->
	</div>
	
	<%
		} } 
	%>
		
		<div class="tot-prezzo">
			<label class="titleSelect">Totale ordine: <strong>&#8364 <%=totalPrice %></strong> </label> 
		</div>

		<div class="bottone-cont">
			<a href="${pageContext.request.contextPath}/HomePageServlet" class="btn btn-primary "> Continua lo Shopping</a> 
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