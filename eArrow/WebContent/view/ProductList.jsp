<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ProductList</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="..//css/ProductListStyle.css">
    <meta name ="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
    
<script>
    window.onresize = function resize()
	{
    	var body = $("body").css("width");
    	body = parseInt(body);
    	
    	var x = $(".img-product").css("width");
    	var w =  parseInt(x);

    	$(".img-product").css("height" , x);
    	
    	if(body < 746){
    		$(".single-product").css("grid-template-columns", "auto auto");	
    	}
    	else if(body < 860){
    		$(".single-product").css("grid-template-columns", "17% 60% 17%"); 
    		$(".single-product").css("grid-gap", "3%");
    	}
    	else if(body >= 860){
    		$(".single-product").css("grid-template-columns", "17% auto 17%"); 
    		$(".single-product").css("grid-gap", "1%");
    	}
	}
	</script>
    
    
</head>
	<body>
		<!-- Product -->
		<div class="product">
			
			<!-- inizio primo prodotto -->
		    <div class="product-line">
			<div class="single-product">
			
				<div class="img-product">
					<img src="..//image/eArrow.png" class="img-size" alt="non funziona">
				</div>
				
				<div class="info-product">
					<p>nome prodotto</p>
					<p>nome categoria</p>
					<p>breve descrizione</p>
					<p>prezzo:</p>
				</div>
				
				<div class="buy-product">
					<button type="button" class="btn btn-primary carrello">Aggiungi al carrello</button>
					<button type="button" class="btn btn-link info">scopri di più ></button>
				</div>
				
			</div>
			</div>
			<!-- fine primo prodotto -->
			
			<!-- inizio secondo prodotto -->
		    <div class="product-line">
			<div class="single-product">
			
				<div class="img-product">
					<img src="..//image/testImage.jpg" class="img-size" alt="non funzione">
				</div>
				
				<div class="info-product">
				
					<p>nome prodotto</p>
					<p>nome categoria</p>
					<p>breve descrizione</p>
					<p>prezzo:</p>
				
				</div>
				
				<div class="buy-product">
					<button type="button" class="btn btn-primary">Aggiungi al carrello</button>
					<button type="button" class="btn btn-link">scopri di più ></button>
				</div>
				
			</div>
			</div>
			<!-- fine secondo prodotto -->
			
			<!-- inizio terzo prodotto -->
		    <div class="product-line">
			<div class="single-product">
			
				<div class="img-product">

					<img src="..//image/eArrow.png" class="img-size" alt="non funzione" width="200" height="200">
				
				</div>
				
				<div class="info-product">
				
					<p>nome prodotto</p>
					<p>nome categoria</p>
					<p>breve descrizione</p>
					<p>prezzo:</p>
				
				</div>
				
				<div class="buy-product">
					<button type="button" class="btn btn-primary">Aggiungi al carrello</button>
					<button type="button" class="btn btn-link">scopri di più ></button>
				</div>
				
			</div>
			</div>
			<!-- fine terzo prodotto -->
			
		</div>
	</body>
</html>