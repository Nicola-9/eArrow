<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Prodotti</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">		
		
		<link rel="stylesheet" type="text/css" href="..//css/footerStyle.css">
		<link rel="stylesheet" type="text/css" href="..//css/ProductListResponsive.css">
		<link rel="stylesheet" type="text/css" href="..//css/NavbareArrowStyle.css">	
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

	<body>
	
	<jsp:include page="NavbareArrow.jsp"/>
	
	<div class="content"> 
	
	<div class="ordinamento">
			<label class="titleSelect">Ordina per: &nbsp&nbsp&nbsp</label>
			<select class="custom-select">
  				<option selected>Nome</option>
  				<option value="1">Prezzo crescente</option>
  				<option value="2">Prezzo decrescente</option>
			</select>
	</div>

	<div class="card-body">
		<div class="row">
			<aside class="col-md-3" id="imageContainer">
				<a href="#" class="img-wrap img-fluid"><img class="image" src="..//image/riser-test.jpg"></a>
			</aside>
			<!-- col.// -->
			<article class="col-md-6">
				<a href="#" class="title mt-2 h5">
					KINETIC RISER A1 FORGED STYLIZED 2020
				</a>
				
				<div class="rating-wrap mb-3">
					<small class="label-rating text-success category"> 
						Riser
					</small>
				</div>
				<!-- rating-wrap.// -->
				<p class="description">
					Riser Kinetic A1 Forged Stylized, lunghezza 25'', 
					peso 1290 grammi con produzione da alluminio forgiato e fresatura di ottima qualità. 
					Colori Anodizzati molto belli e resistenti. L'unico colore verniciato è il Bianco. 
					Attacco flettenti Standard ILF.
				</p>

			</article>
			<!-- col.// -->
			<aside class="col-md-3 order">
				<div class="price-wrap mt-2">
					<span class="price h5"> $56 </span>
				</div>
				<!-- info-price-detail // -->

				<p class="small text-success">Free shipping</p>
				<br>
				<p class="buttonAdd">
					<a href="#" class="btn btn-primary">Aggiungi al carrello</a> 
				</p>
				<br> <a href="#" class="small link">
					Scopri di più ></a>
			</aside>
			<!-- col.// -->
		</div>
		<!-- row.// -->
	</div>
	
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