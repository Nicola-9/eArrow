<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrello</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta name ="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="..//css/ShoppingStyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
    
    <script src="..//javascript/img_resize_Shopping.js"></script>
    
</head>
<body>

<div class="body-mar">
	
	<div id ="product-specific">
			<div class="text-left"><p class="cen">Carrello</p></div>
			<div class="text-right"><p>prezzo</p></div>
	</div>

	<!-- Product -->
		<div id="products">
			
			<!-- inizio primo prodotto -->
		   <div class="product-line">
			<div class="single-product">
			
			
			<!-- immagine prodotto -->
				<div class="img-product">
					<img src="..//image/testImage.jpg" class="img-size" alt="non funzione">
				</div>
				
				<!-- informazione prodotto -->
				<div class="info-product">
					<p class="info-element">nome prodotto</p>
					<p class="info-element cate-none">nome categoria</p>
					<button type="button" class="btn btn-link info">scopri di più ></button>
				</div>
				
				<!-- Quantità prodotto / rimuovi prodotto-->
				<div class="quantity-product">
				<label>Seleziona quantità</label>
						<div class="form-group">
					      <select class="form-control" id="sel1">
							      <option value="1">1</option>
							      <option value="2">2</option>
							      <option value="3">3</option>
							      <option value="4">4</option>
							      <option value="5">5</option>
							      <option value="6">6</option>
							      <option value="7">7</option>
							      <option value="8">8</option>
							      <option value="9">9</option>
							      <option value="10">10</option>
							      <option value="+">+</option>
							    </select>
							    
							    <button type="button" class="btn btn-secondary">Rimuovi</button>
							    
							  </div>
				</div>
				
				<!-- Nuero di prodotto -->
				<div class="price">
					<p>$$$</p>
						</div>
					</div>
				</div>
				
			</div>
			</div>
			<!-- fine prodotto -->
			
	<script>window.onload = function(){resize();}</script>
	<script>window.onresize = function(){resize();}</script>
</body>
</html>