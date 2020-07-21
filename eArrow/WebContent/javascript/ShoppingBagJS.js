/**
 * 
 */

let quantitySelect = document.querySelectorAll('.custom-select');
let priceTotal = document.querySelectorAll('.priceField');
let priceEach = document.querySelectorAll('.price-each');
let totalPriceOrder = document.querySelector('.totalPriceOrder');
let totalPriceOrderWithDiscount = document.querySelector('.totalPriceOrderWithDiscount');

document.addEventListener('DOMContentLoaded', () =>{
	
	for(let i=0; i < quantitySelect.length; i++){
		quantitySelect[i].onchange = function(){
			let quantity = quantitySelect[i].options[quantitySelect[i].selectedIndex].value;
			let prezzoOgnuno = priceEach[i].textContent;
			prezzoOgnuno = prezzoOgnuno.substr(prezzoOgnuno.indexOf(" ") + 1);

			let priceElem = parseFloat(prezzoOgnuno.replace(',', '.'));
			
			quantity = +quantity;
			
			let priceNew = priceElem * quantity;
			
			console.log(priceNew);
			
			priceTotal[i].textContent = '\u20AC ' + priceNew.toFixed(2).replace('.', ',');
			
			updateTotal();
		};
	}
});

const updateTotal = () =>{
	let total = 0;
	
	for(let i=0; i < priceTotal.length; i++){
		let priceString = priceTotal[i].textContent.substr(priceTotal[i].textContent.indexOf(" ") + 1);
		
		let price = parseFloat(priceString.replace(',', '.'));
		
		total += price;
	}
	
	totalPriceOrder.textContent = '\u20AC ' + total.toFixed(2).replace('.', ',');
	totalPriceOrderWithDiscount.textContent = '\u20AC ' + total.toFixed(2).replace('.', ',');
}