<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList, model.bean.*, model.dao.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Carrello</title>
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">		
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ShoppingBagStyle.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footerStyle.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/NavbareArrowStyle.css">
	</head>

	<body>
	
	<jsp:include page="NavbareArrow.jsp"/>
	
	<%
		
 		ArrayList<ProdottoBean> products = (ArrayList<ProdottoBean>) request.getAttribute("productsCart");
		ProdottoBean product = (ProdottoBean) request.getAttribute("product");
		int quantity = (int) request.getAttribute("quantity");
		
		double totalPrice = 0;
	
		if(products != null){
	%>
	
	<div class="content">
	<div class="row">
		<aside class="col-lg-9">
			<div class="card">

				<div class="table-responsive">

					<table class="table table-borderless table-shopping-cart">
						<thead class="text-muted">
							<tr class="small text-uppercase">
								<th scope="col">Prodotti</th>
								<th scope="col" width="120">Quantità</th>
								<th class="price" scope="col" width="120">Prezzo</th>
							</tr>
						</thead>
						<tbody>
						
						<%
							for(ProdottoBean p : products){
								
								ImmagineBean image = ImmagineDAO.doRetrieveImageByProductCode(p.getCodice());
								
								String categoria = p.getCategoria();
								
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
								
								double prezzo = p.getPrezzo();
								
								String prezzoS = String.format("%.2f", prezzo);
								
								if(!p.getNome().equals(product.getNome())){
									
									totalPrice += prezzo;
						%>
							<tr>
								<td class="product">
									<figure class="itemside align-items-center">
										<div class="aside">
											<img src="${pageContext.request.contextPath}<%=image.getUri() %>"
												class="img-sm image">
										</div>
										<figcaption class="info">
											<a href="#" class="title mt-2 h5"><%=p.getNome() %></a>
											<p class="text-muted small">
												<%=categoria %><br><%=p.getTipologia() %>
											</p>
										</figcaption>
									</figure>
								</td>
								<td class="quantity">
									<div class="form-group">
										<select class="custom-select">		
								<%
										for(int i = 1; i <= p.getQuantita(); i++){
											
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
								</td>
								<td class="price">
									<div class="price-wrap">
										<span class="priceField">€ <%=prezzoS %></span>
										<small class="text-muted price-each">€ <%=prezzoS %></small>
									</div> <!-- price-wrap .// -->
								</td>
								<td class="text-right d-none d-md-block"> 
									<a href="" class="btn btn-light removeButton">Rimuovi</a></td>
							</tr>
							
						<%
							} else{
								
								prezzo *= quantity;
								
								totalPrice += prezzo;
								
								prezzoS = String.format("%.2f", prezzo);
						%>
							<tr>
								<td class="product">
									<figure class="itemside align-items-center">
										<div class="aside">
											<img src="${pageContext.request.contextPath}<%=image.getUri() %>"
												class="img-sm image">
										</div>
										<figcaption class="info">
											<a href="#" class="title mt-2 h5"><%=p.getNome() %></a>
											<p class="text-muted small">
												<%=categoria %><br><%=p.getTipologia() %>
											</p>
										</figcaption>
									</figure>
								</td>
								<td class="quantity">
									<div class="form-group">
										<select class="custom-select">		
								<%
										for(int i = 1; i <= p.getQuantita(); i++){
											
											if(i == quantity){
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
								</td>
								<td class="price">
									<div class="price-wrap">
										<span class="priceField">€ <%=prezzoS %></span>
										<small class="text-muted price-each">€ <%=prezzoS %></small>
									</div> <!-- price-wrap .// -->
								</td>
								<td class="text-right d-none d-md-block"> 
									<a href="" class="btn btn-light removeButton">Rimuovi</a></td>
							</tr>
						<%
							}
						}
		}
						%>
						</tbody>
					</table>

				</div>
				<!-- table-responsive.// -->
				<!-- card-body.// -->

			</div>
			<!-- card.// -->

		</aside>
		<!-- col.// -->
			<!-- card.// -->
			
			<%
				String totalPriceS = String.format("%.2f", totalPrice);
			%>
		<aside class="col-lg-3 acquistaForm">
			<div class="card">
				<div class="card-body">
					<dl class="dlist-align">
						<dt>Prezzo totale:</dt>
						<dd class="text-right totalPriceOrder">€ <%=totalPriceS %></dd>
					</dl>
					<dl class="dlist-align">
						<dt>Sconto:</dt>
						<dd class="text-right text-danger">- 0,00</dd>
					</dl>
					<dl class="dlist-align">
						<dt>Totale:</dt>
						<dd class="text-right text-dark b totalPriceOrderWithDiscount">
							<strong>€ <%=totalPriceS %></strong>
						</dd>
					</dl>
					<hr>
					<p class="text-center mb-3">
						<img src="${pageContext.request.contextPath}/image/pagamenti.png"
							height="26">
					</p>
					<a href="#" class="btn btn-primary btn-block"> Acquista ora </a> <a
						href="#" class="btn btn-light btn-block continueButton">Continua lo Shopping</a>
				</div>
				<!-- card-body.// -->
			</div>
			<!-- card.// -->

		</aside>
		<!-- col.// -->
	</div>
	
	</div>
	
	<div class="eArrow-footer">
		<jsp:include page="Footer.jsp"/>
	</div>
	
	<!-- Bootstrap Script -->	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>	
	
	<script src="${pageContext.request.contextPath}/javascript/ShoppingBagJS.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
    	if($(window).innerWidth() < 1262 && $(window).innerWidth() > 991){
           $('.continueButton').html('Continua<br/>lo Shopping');
    	}
    	
    	$(window).resize(function(){
    		if($(window).innerWidth() < 1262 && $(window).innerWidth() > 991){
    			$('.continueButton').html('Continua<br/>lo Shopping');
    		} else{
    			$('.continueButton').html('Continua lo Shopping');
    		}
    	});
	});
	</script>
	</body>
</html>