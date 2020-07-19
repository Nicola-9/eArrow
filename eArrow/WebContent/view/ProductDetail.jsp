<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.bean.*, model.dao.*, java.util.ArrayList"%>
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
				
				<%
					ArrayList<ImmagineBean> imgs = new ArrayList<ImmagineBean>();
					imgs = (ArrayList<ImmagineBean>) ImmagineDAO.doRetrieveImagesByCode(prodotto.getCodice());
					%>
					
					<% if(imgs.size() == 1 || imgs == null){%>
						<div class="img-small-wrap" style="display: none">
					<% }
					else{%>
				<div class="img-small-wrap" style="display: flex">
				<% 
					
				for(int n = 0; n < 3; n++){
					System.out.println(imgs.toString());
				%>
				
	 				<div  class="item-small"><a href="#"> <img class="image" src="${pageContext.request.contextPath}<%=imgs.get(n).getUri()%>"> </a> </div>
	 				
	 				<%}} %>
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
	
	<%
	ArrayList<ProdottoBean> prodottiConsigliati = new ArrayList<ProdottoBean>();
	prodottiConsigliati = (ArrayList<ProdottoBean>) ProdottoDAO.doRetrievebyRecommendedProducts(prodotto.getCategoria());
	
	int j =  0;
	int cod = 0;
	
	for(int i = 1; i < 5; i++){ 
		
		cod = prodottiConsigliati.get(j).getCodice();
		
		if(cod == prodotto.getCodice()){
			j++;
			if(i == prodottiConsigliati.size()){
				break;
			}
			else{
			cod = prodottiConsigliati.get(j).getCodice();
			}
		}
		
		ImmagineBean imgCons = ImmagineDAO.doRetrieveImageByProductCode(cod);
	%>
		<div class="row-product-c">
			<figure class="itemside mb-2">
				<div class="aside"><a href="#"></a><img src="${pageContext.request.contextPath}<%=imgCons.getUri()%>" class="border img-sm"></a></div>
				<figcaption class="info align-self-center">
					<a href="#" class="title"><%=prodottiConsigliati.get(i).getNome()%></a>
					<strong class="price2"><%=prodottiConsigliati.get(i).getPrezzo()%></strong>
				</figcaption>
			</figure>
		</div> 
		<%
		j++;
	
	}%>
		
		
	</div> <!-- row.// -->
</div>
		
		<hr class="divider">
		
		<div class="eArrow-footer">
			<jsp:include page="Footer.jsp"/>
		</div>
	</body>
	
</html>