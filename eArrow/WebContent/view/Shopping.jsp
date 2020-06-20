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
		<div id="products">
			
			<!-- inizio primo prodotto -->
		    <div class="product-line">
			<div class="single-product">
			
				<div class="img-product">
					<img src="..//image/testImage.jpg" class="img-size" alt="non funzione">
				</div>
				
				<div class="info-product">
					<p>nome prodotto</p>
					<p>breve descrizione</p>
			
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
							  </div>
						</div>
					</div>
				
				<div class="price">
					<p>prezzo</p>
					<p>n euri</p>
				</div>
				
			</div>
			</div>
			<!-- fine primo prodotto -->
			</div>
</body>
</html>