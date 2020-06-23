/**
 * Funzione per il ridimensionamento delle immagini
 */
function resize()
 {  var body = $(".body-mar").css("width");
	body = parseInt(body);
	
	var x = $(".img-product").css("width");
	var w =  parseInt(x);

	$(".img-product").css("height" , x);
	
	if(body >= 873){
		$(".single-product").css("grid-template-columns", "17% auto 17%"); 
		$(".img-product").css("max-width", "200px");
		$(".img-product").css("max-height", "200px");
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
	
	if(body >= 659 && body < 718){
		$(".single-product").css("grid-template-columns", "22% auto 22%"); 
	}
	else if(body >= 465 && body < 659){
		$(".single-product").css("grid-template-columns", "27% auto");
		$(".img-product").css("max-width", "169px");
	}
	else if(body < 465){
		$(".single-product").css("grid-template-columns", "auto"); 
	}
 }