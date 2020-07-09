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
			
				<div class="img-product img-thumbnail">
					<img src="..//image/riser-test.jpg" class="img-size" alt="non funzione">
				</div>
				
				<div class="spec-product">
				
				<div class="info-product">
					<p class="info-element-nome"><strong>KINETIC RISER A1 FORGED STYLIZED 2020</strong></p>
					<p class="info-element-categoria">Riser</p>
					<p class="desc">Riser Kinetic A1 Forged Stylized, lunghezza 25'', 
						peso 1290 grammi con produzione da alluminio forgiato e fresatura di ottima qualità. 
						Colori Anodizzati molto belli e resistenti. L'unico colore verniciato è il Bianco. 
						Attacco flettenti Standard ILF.</p>
				</div>
				
				<div class="buy-product">
					<p class="price"><strong>25 $</strong></p>
					<button type="button" class="btn btn-primary carrello">Aggiungi al carrello</button>
					<button type="button" class="btn btn-link info">scopri di più ></button>
				</div>
				
				</div>
				
			</div>
			</div>
			<!-- fine prodotto -->
		</div>
		
		</div>
	</body>
</html>