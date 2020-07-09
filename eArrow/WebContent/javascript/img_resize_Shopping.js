/**
 * Funzione per il ridimensionamento delle immagini
 */
function resize()
 {  var body = $(".body-mar").css("width");
	body = parseInt(body);
	
	var x = $(".img-product").css("width");
	var w =  parseInt(x);

	$(".img-product").css("height" , x);
	
	if(body >= 890){
		$(".single-product").css("grid-template-columns", "17% 20% auto 20%"); 
		$(".img-product").css("max-width", "200px");
		$(".img-product").css("max-height", "200px");
		$(".single-product").css("grid-gap", "0");
	}
	
	else if(body >= 707 && body < 890){
		$(".single-product").css("grid-template-columns", "20% 20% auto 20%"); 
		$(".single-product").css("grid-gap", "3%");
		$(".img-product").css("max-width", "169px");
		$(".img-product").css("max-height", "169px");
	}
	
	else if(body < 707){
		$(".single-product").css("grid-template-columns", "35% auto"); 
		$(".single-product").css("grid-gap", "3%");
	}
 }