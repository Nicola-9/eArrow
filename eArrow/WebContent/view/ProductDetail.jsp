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
			
			switch(categoria){
				case "archi":
					categoria = "Archi";
					break;
				case "frecce":
					categoria = "Frecce e Componenti";
					break;
				case "accessori-arco":
					categoria = "Accessori Arco";
					break;
				case "accessori-arciere":
					categoria = "Accessori Arciere";
					break;
				case "paglioni":
					categoria = "Paglioni e Bersagli";
					break;
			}
			
			String tipologia = prodotto.getTipologia();
			
			boolean disponibile = prodotto.isDisponibilita();
			
			int quantita = prodotto.getQuantita();
			
			double prezzo = prodotto.getPrezzo();
			
			String prezzoS = String.format("%.2f", prezzo);
		%>

		<div class="content">
			<input type="hidden" class="hidden-code" name="codiceProdotto" value="<%=prodotto.getCodice() %>">
		
		<h5 class="doc-title-sm">DETTAGLI</h5>
		
		<div class="card-body">
		
		<!-- immagini prodotto, zona sinistra -->
		<div class = "left-area border-right">
		
			<aside class="clo-left" id="imageContainer">
				<div class="img-big-wrap">
	   				<a href="#"><img class="image" src="${pageContext.request.contextPath}<%=uriImage%>"></a>
				</div>
				
			</aside>
			
	</div>		
					
		<!-- informazioni prodotto, zona destra -->
		
	<div class = "right-area">
					
		<main class="main-class">
					
			<div class="content-body vertical-center">
			
				<div class="title2">
					<div class="titleHeader">
						<h1 class="title mar"><%=nome%></h1>
						
						<%
							if(prodotto.isDisponibilita()){
						%>
							<small class="label-rating text-success disponibility">Disponibile</small>
						<%	} else{ %>
							<small class="label-rating text-danger disponibility">Non disponibile</small>
						<%	} %>
					</div>
					<small class="label-rating category"> 
						<%=categoria %> - <%=tipologia %>
					</small>
				</div>
				
				<p class="mar description"><%=descrizione%></p>
				
				
				<div class="centro">
						
					<div class="priceInfo">
						<span>Prezzo:&nbsp&nbsp&nbsp</span><span class="price h5">&#8364 <%=prezzoS %></span>
					</div>
					
					<%
							if(prodotto.isDisponibilita()){
						%>
							<div class="disponibilityCenter">
								<span class="disponibilityCenter">Disponibilit&#224:&nbsp&nbsp&nbsp</span>
								<small class="label-rating text-success disponibilityCenter">Disponibile</small>
							</div>
						<%	} else{ %>
							<small class="label-rating text-danger disponibilityCenter">Non disponibile</small>
						<%	} %>
				
					<div class="quantity">
						<label class="titleSelect">Quantit&#224: &nbsp&nbsp&nbsp</label> 
						<select	class="custom-select quantitySelect" name="quantita">
						
						<%
							if(quantita == 0){
						%>
						
								<option value="0" selected>0</option>
								
						<%
							}
						%>
						
						<%
							for(int i = 1; i <= quantita; i++){
						
								if(i == 1){
						%>
									<option value="<%=i %>" selected><%=i %></option>
						<%
								} else{
						%>
									<option value="<%=i %>"><%=i %></option>
						<%
								}
							}
						%>
						
						</select>
					</div>

				</div>


			<div class="line-below mar">
				
						<%
							if(prodotto.isDisponibilita()){
						%>
							<button type ="submit" class="btn btn-primary addCart-btn">Aggiungi al Carrello</button>
							
						<%	} else{ %>
							<button type ="submit" class="btn btn-primary addCart-btn" disabled>Aggiungi al Carrello</button>
						<%	} %>
			</div> 
		</div>
		</main> 
		
	</div>
	
		</div> 
		
		
		<hr class="divider">
		
		
		<!-- prodotti consigliati -->
		
	<h5 class="doc-title-sm">Prodotti consigliati</h5>
	
	<div class="card card-body">
		
	<div class="row">
	
	<%
	ArrayList<ProdottoBean> prodottiConsigliati = new ArrayList<ProdottoBean>();
	prodottiConsigliati = (ArrayList<ProdottoBean>) ProdottoDAO.doRetrievebyRecommendedProducts(prodotto.getCategoria());
	
	int limit =  0;
	
	System.out.println(prodottiConsigliati.size());
	
	int size = prodottiConsigliati.size();
	
	for(int i=0; i < size; i++){
		if(prodottiConsigliati.get(i).getNome().equals(nome)){
			prodottiConsigliati.remove(i);
			--size;
			break;
		}
		if(prodottiConsigliati.get(i).getNome().equals("Smartriser Nero")){
			prodottiConsigliati.remove(i);
			--size;
		}
	}
	
	if(prodottiConsigliati.size() >= 4){
		limit = 4;
	} else{
		limit = prodottiConsigliati.size();
	}
	
	if(categoria.equals("Frecce e Componenti") || categoria.equals("Accessori Arco")){
		if(prodottiConsigliati.size() > 3)
			limit = 3;
		else
			limit = 2;
	}
	
	for(int j = 0; j < limit; j++){ 
		
		ImmagineBean imgCons = ImmagineDAO.doRetrieveImageByProductCode(prodottiConsigliati.get(j).getCodice());
	%>
		<div class="row-product-c">
			<figure class="itemside mb-2">
				<div class="aside" id="container-image-reccomended">
					<a href="${pageContext.request.contextPath}/ProductDetailServlet?codice=<%=prodottiConsigliati.get(j).getCodice() %>">
						<img src="${pageContext.request.contextPath}<%=imgCons.getUri()%>" class="img-sm img-responsive img-rec">
					</a>
				</div>
				<figcaption class="info align-self-center">
					<a href="${pageContext.request.contextPath}/ProductDetailServlet?codice=<%=prodottiConsigliati.get(j).getCodice() %>" class="title mt-2"><%=prodottiConsigliati.get(j).getNome()%></a>
					
					<%
						String price = String.format("%.2f", prodottiConsigliati.get(j).getPrezzo());
					%>
					<strong class="price2"><%=price%></strong>
				</figcaption>
			</figure>
		</div> 
	<%
	}
	%>
		
		
	</div> <!-- row.// -->
</div>
		
		<hr class="divider">
		
		</div>
		
		<div class="eArrow-footer">
			<jsp:include page="Footer.jsp"/>
		</div>
		
		<script src='${pageContext.request.contextPath}/javascript/ProductDetailJS.js'></script>
		
		<!-- Bootstrap Script -->	
		<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>	
		
	</body>
	
</html>