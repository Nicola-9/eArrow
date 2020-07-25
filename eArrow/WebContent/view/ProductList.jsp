<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@page import="java.util.ArrayList, model.bean.*, model.dao.*"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<%  
			Object categoryObj = request.getAttribute("category");
			String category = (String) categoryObj;
			
			String categoryParam = "";
			
			switch(category){
				case "Archi":
					categoryParam = "Archi";
					break;
				case "Frecce e Componenti":
					categoryParam = "Frecce";
					break;
				case "Accessori Arco":
					categoryParam = "accessori-arco";
					break;
				case "Accessori Arciere":
					categoryParam = "accessori-arciere";
					break;
				case "Paglioni e Bersagli":
					categoryParam = "paglioni";
					break;
			}
		%>
			<title>eArrow - <%=category %></title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">		
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footerStyle.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ProductListStyle.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/NavbareArrowStyle.css">	
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

	<body>
	
	<jsp:include page="NavbareArrow.jsp"/>
	
	<div class="content">
	
	<%
		Object ordinamentoObj = request.getAttribute("ordinamento");
		String ordinamento = (String) ordinamentoObj;
	%>
	

		<form class="orderForm" action="./ProductsListServlet">
			<input type="hidden" name="category" value="<%=categoryParam%>">
			<div class="ordinamento">
				<label class="titleSelect">Ordina per: &nbsp&nbsp&nbsp</label> 
				<select	class="custom-select" name="ordinamento" onchange="this.form.submit()">
				
				<%
					if( ordinamento != null ) {
						if( ordinamento.equals("nome") ) {
				%>
					<option value="nome" selected>Nome</option>
					<option value="prezzoC">Prezzo crescente</option>
					<option value="prezzoD">Prezzo decrescente</option>
					
				<%
						} else
							if(ordinamento.equals("prezzoC")){
				%>
					<option value="nome">Nome</option>
					<option value="prezzoC" selected>Prezzo crescente</option>
					<option value="prezzoD">Prezzo decrescente</option>
				<%
						} else
							if(ordinamento.equals("prezzoD")){
				%>
					<option value="nome">Nome</option>
					<option value="prezzoC">Prezzo crescente</option>
					<option value="prezzoD" selected>Prezzo decrescente</option>
				<%
							}
					} else{
				%>
					<option value="nome" selected>Nome</option>
					<option value="prezzoC">Prezzo crescente</option>
					<option value="prezzoD">Prezzo decrescente</option>
				<% 
					}
				%>
				</select>
			</div>
		</form>

		<%	
		ArrayList<ProdottoBean> products = (ArrayList<ProdottoBean>) request.getAttribute("prodottiList");
		
		for(ProdottoBean p : products){
			double price = p.getPrezzo();
			
			String priceD = String.format("%.2f", price);
			
			ImmagineBean image = ImmagineDAO.doRetrieveImageByProductCode(p.getCodice());
			
			String uriImage = image.getUri();
			
			String categoria = p.getCategoria().substring(0, 1).toUpperCase() + p.getCategoria().substring(1);
	%>
	<div class="card-body">
		<div class="row">
			<aside class="col-md-3" id="imageContainer">
				<a href="${pageContext.request.contextPath}/ProductDetailServlet?codice=<%=p.getCodice()%>" class="img-wrap img-fluid"><img class="image" src="${pageContext.request.contextPath}<%=uriImage%>"></a>
			</aside>
			<!-- col.// -->
			<article class="col-md-6">
				<a href="${pageContext.request.contextPath}/ProductDetailServlet?codice=<%=p.getCodice()%>" class="title mt-2 h5">
					<%=p.getNome() %>
				</a>
				
				<div class="rating-wrap mb-3">
					<small class="label-rating text-success category"> 
						<%=categoria %> - <%=p.getTipologia() %>
					</small>
				</div>
				<!-- rating-wrap.// -->
				<p class="description">
					<%=p.getDescrizione() %>
				</p>

			</article>
			<!-- col.// -->
			<aside class="col-md-3 order">
				<div class="price-wrap mt-2">
					<span class="price h5">€ <%=priceD %> </span>
				</div>
				<!-- info-price-detail // -->

				<%
					if(p.isDisponibilita()){
				%>
				
					<p class="small text-success">Disponibile</p>
					
				<% } else { %>
				
					<p class="small text-danger">Non disponibile</p>
					
				<% } %>
				
				<p class="buttonAdd">
					<p class="quantity">In stock: <%=p.getQuantita()%></p>
					<a href="${pageContext.request.contextPath}/AddToShoppingBagServlet?codiceProdotto=<%=p.getCodice()%>&quantity=1" class="btn btn-primary">Aggiungi al carrello</a> 
				</p>
				<a href="${pageContext.request.contextPath}/ProductDetailServlet?codice=<%=p.getCodice()%>" class="small link">
					Scopri di più >
				</a>
			</aside>
			<!-- col.// -->
		</div>
		<!-- row.// -->
	</div>
	
	<% 	
		}	
	%>
	
	</div>
	
	<div class="eArrow-footer">
		<jsp:include page="Footer.jsp"/>
	</div>
	
	<!-- Bootstrap Script -->	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>	
	
	<script type="text/javascript">
	$(document).ready(function(){
    	if($(window).innerWidth() < 837 && $(window).innerWidth() > 767){
           $('a.btn.btn-primary').html('Aggiungi<br/>al carrello');
    	}
    	
    	$(window).resize(function(){
    		if($(window).innerWidth() < 837 && $(window).innerWidth() > 767){
    			$('a.btn.btn-primary').html('Aggiungi<br/>al carrello');
    		} else{
    			$('a.btn.btn-primary').html('Aggiungi al carrello');
    		}
    	});
	});
	</script>
</body>
</html>