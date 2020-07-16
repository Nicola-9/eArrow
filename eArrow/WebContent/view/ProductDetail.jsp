<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.bean.*, model.dao.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dettagli prodotto</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footerStyle.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ProductDetailStyle.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/NavbareArrowStyle.css">	
	</head>

	<body>
	
	<jsp:include page="NavbareArrow.jsp"/>
	
		<%
		ProdottoBean prodotto = (ProdottoBean) request.getAttribute("prodotto");
		
			
			ImmagineBean immagine = new ImmagineBean();
			immagine = ImmagineDAO.doRetrieveImageByProductCode(prodotto.getCodice());
			
			String uriImage = immagine.getUri();
			
			String nome = prodotto.getNome();
			
			String descrizione = prodotto.getDescrizione();
			
			String categoria = prodotto.getCategoria();
			
			String tipologia = prodotto.getTipologia();
			
			boolean disponibile = prodotto.isDisponibilita();
			
			int quantita = prodotto.getQuantita();
			
			double prezzo = prodotto.getPrezzo();
			
			String prezzoS = Double.toString(prezzo);
		%>

		<div class="card-body">
		
		<!-- immagini prodotto, zona sinistra -->
		<div class = "left-area border-right">
		
			<aside class="clo-left" id="imageContainer">
				<div class="img-big-wrap">
	   				<a href="#"><img class="image" src="${pageContext.request.contextPath}<%=uriImage%>"></a>
				</div>
				
				<div class="img-small-wrap">
	 				<a href="#" class="item-small"> <img class="image" src="${pageContext.request.contextPath}/image/productImage/hoyt-gran-prix.jpg"></a>
	 				<a href="#" class="item-small"> <img class="image" src="${pageContext.request.contextPath}/image/productImage/smartriser-nero.jpg"></a>
	 				<a href="#" class="item-small"> <img class="image" src="${pageContext.request.contextPath}/image/productImage/smartriser-nero.jpg"></a>
	 				<a href="#" class="item-small"> <img class="image" src="${pageContext.request.contextPath}/image/productImage/smartriser-nero.jpg"></a>
				</div>
			</aside>
			
	</div>		
					
		<!-- informazioni prodotto, zona destra -->
		
	<div class = "right-area">
					
		<main class="main-class">
					
			<div class="content-body vertical-center">
			
				<div class="title2">
					<h1 class="title mar"><%=nome%></h1>
				</div>
				
				<p class="mar"><%=descrizione%></p>
				
				
				<div class="centro">
				
			
				<div class="sinistra">
					<p><%=categoria%></p>
					<p class ="space"><%=tipologia%></p>
					<p class ="space">Quantità: <%=quantita%></p>
				</div>
				
				<div class="destra">
				
				<span class="price h4">€ <%=prezzoS%></span> 
				
				<%
					if(prodotto.isDisponibilita()){
				%>
				
					<p class="small text-success">Disponibile</p>
					
				<% } else { %>
				
					<p class="small text-danger">Non disponibile</p>
					
				<% } %>
				
				<div class="selez-quant">
				
					<p>Seleziona quantità</p>
					
					<select class="form-control form-width" id="sel1">
	        				<option>1</option>
	        				<option>2</option>
	        				<option>3</option>
	        				<option>4</option>
	      				</select>
				
				</div>
</div>

</div>


			<div class="line-below mar">
		
	  		<span class="line-but"><a href="#" class="btn btn-primary">Aggiungi al carrello</a></span>
	  		
			</div> 
		</div>
		</main> 
		
	</div>
	
		</div> 
		
		
		<hr class="divider">
		
		
		<!-- prodotti consigliati -->
		
		<div class="card card-body">
	<div class="row">
		<div class="row-product-c">
			<figure class="itemside mb-2">
				<div class="aside"><img src="image/riser-test.jpg" class="border img-sm"></div>
				<figcaption class="info align-self-center">
					<a href="#" class="title">Camera GoPro 4</a>
					<strong class="price2">$241.99</strong>
				</figcaption>
			</figure>
		</div> <!-- col.// -->

		<div class="row-product-c">
			<figure class="itemside mb-2">
				<div class="aside"><img src="image/smart_blue.jpg" class="border img-sm"></div>
				<figcaption class="info align-self-center">
					<a href="#" class="title">Headset logitec</a>
					<strong class="price2">$45.50</strong>
				</figcaption>
			</figure>
		</div> <!-- col.// -->

		<div class="row-product-c">
			<figure class="itemside mb-2">
				<div class="aside"><img src="image/riser-test.jpg" class="border img-sm"></div>
				<figcaption class="info align-self-center">
					<a href="#" class="title">Some product name</a>
					<strong class="price2">$54.99</strong>
				</figcaption>
			</figure>
		</div> <!-- col.// -->

		<div class="row-product-c" id ="consiglio-4">
			<figure class="itemside mb-2">
				<div class="aside"><img src="image/smart_blue.jpg" class="border img-sm"></div>
				<figcaption class="info align-self-center">
					<a href="#" class="title">Name of item goes here </a>
					<strong class="price2">$241.99</strong>
				</figcaption>
			</figure>
		</div> <!-- col.// -->
	</div> <!-- row.// -->
</div>
		
		<hr class="divider">
		
		<div class="eArrow-footer">
			<jsp:include page="footer.jsp"/>
		</div>
	</body>
	
</html>