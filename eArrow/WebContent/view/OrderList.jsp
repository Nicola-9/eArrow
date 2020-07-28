<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*, model.bean.*, model.dao.*, util.*"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Storico Ordini</title>
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">		
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/OrderList.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footerStyle.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/NavbareArrowStyle.css">
	</head>

	
	<body>
	
	<jsp:include page="NavbareArrow.jsp"/>
	
	<div class="content">

	<h5 class="doc-title-sm">STORICO ORDINI</h5>
			
	<%
	ArrayList<StoricoOrdiniBean> listaOrdini = StoricoOrdiniDAO.doRetrieveAll();
	
		int totProdotti = 0;
		
		for(int i = 0; i < listaOrdini.size(); i++) {
			
			int idOrdine = listaOrdini.get(i).getIdOrdine();
			
			OrdineBean ordine = (OrdineBean) OrdinaDAO.doRetrievebyUserId(idOrdine);		
			PagamentoBean pagamento = (PagamentoBean) PagamentoDAO.doRetrievebyUserId(idOrdine);		
	
			double price = pagamento.getImporto();
			

			UtenteBean utente = UtenteDao.doRetrievebyId(ordine.getIdUtente());
			
			Date data = ordine.getData();
			
			HashMap<Integer, Integer> ordineHash = ComposizioneOrdineDAO.doRetrieveIdbyUserOrderId(listaOrdini.get(i).getIdOrdine());
	%>

	<div class="card-body">
		<div class="row">
		
		<aside class="col-md-3" id="imageContainer">
			<a class="img-wrap img-fluid text-none">
				<label class="titleSelect"><strong><%=utente.getNome()%> <%=utente.getCognome()%></strong> </label> <br>
				
				<label class="titleSelect"><%=utente.getEmail()%></label> <br>
				
				<label class="titleSelect">tel. : <%=utente.getTelefono()%></label> <br>
				
				<label class="titleSelect">id ordine: <%=listaOrdini.get(i).getIdOrdine()%></label>
			</a>
		</aside>
			
			<article class="col-md-6 row">
			

		
			<%
				
				for(HashMap.Entry<Integer, Integer> pair : ordineHash.entrySet()){
				
					
					totProdotti += pair.getValue();

				  ProdottoBean prod = ProdottoDAO.doRetrievebyCodeOrdered(pair.getKey());
				%>
		<div class="row-product-c">
			<figure class="itemside mb-2">
				<figcaption class="info align-self-center">
					<a href="${pageContext.request.contextPath}/ProductDetailServlet?codice=<%=prod.getCodice()%>" class="mt-2"><%=prod.getNome() %></a><br>
					<label class="titleSe">Codice del prodotto: <%=prod.getCodice()%></label>
					<strong class="price2">&#8364 <%=prod.getPrezzo()%></strong>
				</figcaption>
			</figure>
		</div> 
	<%
		}	
	%>
		

			</article>
			<!-- col.// -->
			<aside class="col-md-3 order">
			<div class="cent">
			
		<div class="tot-prezzo">
			<label class="titleSelect">Data acquisto: <strong><%=data.toString()%></strong> </label> <br>
		</div>
			
		<div class="tot-prezzo">
			<label class="titleSelect">Totale prodotti acquistati: <strong> <%=totProdotti %></strong> </label> <br>
		</div>
		
		<%
			String str = String.format("%.2f", price);
 		%>
				
		<div class="tot-prezzo">
			<label class="titleSelect">Totale ordine: <strong>&#8364 <%=str %></strong> </label> <br>
		</div>
			</div>
			</aside>
		</div>
	</div>
	
		<%
		} 
	%>

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