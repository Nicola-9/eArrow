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
	var body = $(".body-mar").css("width");
	body = parseInt(body);
	
	var x = $(".img-product").css("width");
	var w =  parseInt(x);

	$(".img-product").css("height" , x);
	
	if(body >= 873){
		$(".single-product").css("grid-template-columns", "17% auto 17%"); 
		$(".img-product").css("max-width", "200px");
	}
	else if(body < 873){
		$(".single-product").css("grid-template-columns", "22% auto 22%"); 
		$(".img-product").css("max-width", "169px");
	}
	
	if(body >= 718 && body < 873){
		$(".single-product").css("grid-gap", "1%");
	}
	else if(body < 718){
		$(".single-product").css("grid-gap", "3%");
	}
	
	if(body >= 676 && body < 718){
		$(".single-product").css("grid-template-columns", "22% auto 22%"); 
	}
	else if(body < 676){
		$(".single-product").css("grid-template-columns", "27% auto"); 
		$(".img-product").css("max-width", "169px"); 
	}
	if(body >= 482 && body < 676){
		$(".single-product").css("grid-template-columns", "27% auto"); 
	}
	else if(body < 482){
		$(".single-product").css("grid-template-columns", "auto"); 
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
				
				<div class="info-product">
					<p class="info-element">nome prodotto</p>
					<p class="info-element cate-none">nome categoria</p>
					<p class="desc">breve descrizione</p>
					<p class="info-element prez-none">prezzo:</p>
				</div>
				
				<div class="buy-product">
					<button type="button" class="btn btn-primary carrello">Aggiungi al carrello</button>
					<button type="button" class="btn btn-link info">scopri di pi� ></button>
				</div>
				
			</div>
			</div>
			<!-- fine prodotto -->
		</div>
		
		<!-- Product -->
		<div class="product">
			
			
			<!-- inizio secondo prodotto -->
		    <div class="product-line">
			<div class="single-product">
			
				<div class="img-product">
					<img src="..//image/testImage.jpg" class="img-size" alt="non funzione">
				</div>
				
				<div class="info-product">
					<p class="info-element">nome prodotto</p>
					<p class="info-element cate-none">nome categoria</p>
					<p class="desc">breve descrizione</p>
					<p class="info-element prez-none">prezzo:</p>
				</div>
				
				<div class="buy-product">
					<button type="button" class="btn btn-primary carrello">Aggiungi al carrello</button>
					<button type="button" class="btn btn-link info">scopri di pi� ></button>
				</div>
				
			</div>
			</div>
			<!-- fine prodotto -->
		</div>
		
		<!-- Product -->
		<div class="product">
			
			
			<!-- inizio secondo prodotto -->
		    <div class="product-line">
			<div class="single-product">
			
				<div class="img-product">
					<img src="..//image/testImage.jpg" class="img-size" alt="non funzione">
				</div>
				
				<div class="info-product">
					<p class="info-element">nome prodotto</p>
					<p class="info-element cate-none">nome categoria</p>
					<p class="desc">breve descrizione</p>
					<p class="info-element prez-none">prezzo:</p>
				</div>
				
				<div class="buy-product">
					<button type="button" class="btn btn-primary carrello">Aggiungi al carrello</button>
					<button type="button" class="btn btn-link info">scopri di pi� ></button>
				</div>
				
			</div>
			</div>
			<!-- fine prodotto -->
		</div>
		
		<!-- Product -->
		<div class="product">
			
			
			<!-- inizio secondo prodotto -->
		    <div class="product-line">
			<div class="single-product">
			
				<div class="img-product">
					<img src="..//image/testImage.jpg" class="img-size" alt="non funzione">
				</div>
				
				<div class="info-product">
					<p class="info-element">nome prodotto</p>
					<p class="info-element cate-none">nome categoria</p>
					<p class="desc">breve descrizione</p>
					<p class="info-element prez-none">prezzo:</p>
				</div>
				
				<div class="buy-product">
					<button type="button" class="btn btn-primary carrello">Aggiungi al carrello</button>
					<button type="button" class="btn btn-link info">scopri di pi� ></button>
				</div>
				
			</div>
			</div>
			<!-- fine prodotto -->
		</div>
		
		<!-- Product -->
		<div class="product">
			
			
			<!-- inizio secondo prodotto -->
		    <div class="product-line">
			<div class="single-product">
			
				<div class="img-product">
					<img src="..//image/testImage.jpg" class="img-size" alt="non funzione">
				</div>
				
				<div class="info-product">
					<p class="info-element">nome prodotto</p>
					<p class="info-element cate-none">nome categoria</p>
					<p class="desc">breve descrizione</p>
					<p class="info-element prez-none">prezzo:</p>
				</div>
				
				<div class="buy-product">
					<button type="button" class="btn btn-primary carrello">Aggiungi al carrello</button>
					<button type="button" class="btn btn-link info">scopri di pi� ></button>
				</div>
				
			</div>
			</div>
			<!-- fine prodotto -->
		</div>
		
		<!-- Product -->
		<div class="product">
			
			
			<!-- inizio secondo prodotto -->
		    <div class="product-line">
			<div class="single-product">
			
				<div class="img-product">
					<img src="..//image/testImage.jpg" class="img-size" alt="non funzione">
				</div>
				
				<div class="info-product">
					<p class="info-element">nome prodotto</p>
					<p class="info-element cate-none">nome categoria</p>
					<p class="desc">breve descrizione</p>
					<p class="info-element prez-none">prezzo:</p>
				</div>
				
				<div class="buy-product">
					<button type="button" class="btn btn-primary carrello">Aggiungi al carrello</button>
					<button type="button" class="btn btn-link info">scopri di pi� ></button>
				</div>
				
			</div>
			</div>
			<!-- fine prodotto -->
		</div>
		�
		<!-- Product -->
		<div class="product">
			
			
			<!-- inizio secondo prodotto -->
		    <div class="product-line">
			<div class="single-product">
			
				<div class="img-product">
					<img src="..//image/testImage.jpg" class="img-size" alt="non funzione">
				</div>
				
				<div class="info-product">
					<p class="info-element">nome prodotto</p>
					<p class="info-element cate-none">nome categoria</p>
					<p class="desc">breve descrizione</p>
					<p class="info-element prez-none">prezzo:</p>
				</div>
				
				<div class="buy-product">
					<button type="button" class="btn btn-primary carrello">Aggiungi al carrello</button>
					<button type="button" class="btn btn-link info">scopri di pi� ></button>
				</div>
				
			</div>
			</div>
			<!-- fine prodotto -->
		</div>
		
	</div>
	</body>
</html>