<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ProductList</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="..//css/ProductListStyleTest.css">
    <meta name ="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
    
<script>
    window.onresize = function resize()
	{
    	var body = $(".body-mar").css("width");
    	body = parseInt(body);
    	
    	var x = $(".img-product").css("width");
    	//var w =  parseInt(x);

    	$(".img-product").css("height" , x);
    	if(body < 860){
    		$(".single-product").css("grid-template-columns", "17% auto"); 
    		$(".single-product").css("grid-gap", "3%");
    	}
    	else if(body >= 860){
    		$(".single-product").css("grid-template-columns", "17% auto"); 
    		$(".single-product").css("grid-gap", "1%");
    	}
    	if(body < 744){ 
    		$(".single-product").css("grid-gap", "5%");
    	}
	}
	</script>
    
    
</head>
	<body>
	
	<div class="body-mar">
	
		<!-- Product -->
		<div class="product">
			
			
			<!-- inizio secondo prodotto -->
		    <div class="product-line">
			<div class="single-product">
			
				<div class="img-product">
					<img src="..//image/testImage.jpg" class="img-size" alt="non funzione">
				</div>
				
				<div class="spec-product">
				
				<div class="info-product">
					<p class="info-element">nome prodotto</p>
					<p class="info-element info-none">nome categoria</p>
					<p class="desc">breve descrizione</p>
					<p class="info-element info-none">prezzo:</p>
				</div>
				
				<div class="buy-product">
					<button type="button" class="btn btn-primary carrello">Aggiungi al carrello</button>
					<button type="button" class="btn btn-link info">scopri di pi� ></button>
				</div>
				
				</div>
				
			</div>
			</div>
			<!-- fine prodotto -->
		</div>
		
		</div>
	</body>
</html>