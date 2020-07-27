<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList, model.bean.*, model.dao.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0">
	
		<title>eArrow</title>
		
		<!-- Bootstrap CSS -->	
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/NavbareArrowStyle.css">
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/HomePageStyle.css">
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/footerStyle.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
	</head>
	
	<body>
		
		<jsp:include page="NavbareArrow.jsp"/>

	<div id="carouselExampleIndicators" class="carousel slide h-100"
		data-ride="carousel">
		<ol class="carousel-indicators">
		
		<%
			Object evidenzaObj = request.getAttribute("evidenzaList");
			ArrayList<EvidenzaBean> evidenza = (ArrayList<EvidenzaBean>) evidenzaObj;
		
			int j = 0;
		
			for(EvidenzaBean e : evidenza){
				if(j == 0){
		%>
			<li data-target="#carouselExampleIndicators" data-slide-to="<%=j %>"
				class="active"></li>
				
		<%
					j++;
				} else{
		%>
			<li data-target="#carouselExampleIndicators" data-slide-to="<%=j %>"></li>
		<%
					j++;
				}
			}
		%>
		</ol>
		<div class="carousel-inner">
		
		<% 
			int i = 0;
			
			for(EvidenzaBean e : evidenza){
				
				String uriImage = ImmagineDAO.doRetrieveImageDiscountByProductCode(e.getCodiceProdotto()).getUri();
				
				String name = ProdottoDAO.doRetrievebyKey(e.getCodiceProdotto()).getNome();
				String descrizione = ProdottoDAO.doRetrievebyKey(e.getCodiceProdotto()).getDescrizione();
				
				if(i == 0){
				
		%>
			<div class="carousel-item h-100 active">
				<a class="textResp" href="${pageContext.request.contextPath}/ProductDetailServlet?codice=4">
					<div class="responseText">
						
						<p class="productDescription"><strong class="title"><%=name %></strong><br><%=descrizione %></p>
					</div>
					<img class="d-block w-100 h-100 imageSlider" src="${pageContext.request.contextPath}<%=uriImage %>" alt="Offerta">
				</a>
				<div class="carousel-caption d-none d-md-block">
					<h5 class="productName"><%=name %></h5>
					<p class="productDescription"><%=descrizione %></p>
				</div>
			</div>
			
		<%
				i++;
		
				} else {
					System.out.println(e.getCodiceProdotto());
					if(e.getCodiceProdotto() == 6){
		%>
					
			<div class="carousel-item h-100">
				<a class="textResp" href="${pageContext.request.contextPath}/ProductDetailServlet?codice=6">
					<div class="responseText" style="display: none">
						
						<p class="productDescription"><strong class="title"><%=name %></strong><br><%=descrizione %></p>
					</div>
					<img class="d-block w-100 h-100 imageSlider" src="${pageContext.request.contextPath}<%=uriImage%>" alt="Offerta">
				</a>
				<div class="carousel-caption d-none d-md-block">
					<h5 class="productName"><%=name %></h5>
					<p class="productDescription"><%=descrizione %></p>
				</div>
			</div>
		
		<%
			
				} else
					if(e.getCodiceProdotto() == 7){
						
						System.out.println("ci sono");
		%>
			
			<div class="carousel-item h-100">
				<a class="textResp" href="${pageContext.request.contextPath}/ProductDetailServlet?codice=7">
					<div class="responseText">
						
						<p class="productDescription"><strong class="title"><%=name %></strong><br><%=descrizione %></p>
					</div>
					<img class="d-block w-100 h-100 imageSlider" src="${pageContext.request.contextPath}<%=uriImage %>" alt="Offerta">
				</a>
				<div class="carousel-caption d-none d-md-block">
					<h5 class="productName"><%=name %></h5>
					<p class="productDescription"><%=descrizione %></p>
				</div>
			</div>
			
		<%
				}
					i++;
				}
			}
		%>
		
		
		</div>
		
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
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