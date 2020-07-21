/**
 * 
 */
let quantitySelect = document.querySelector('.quantitySelect');
let priceElem = document.querySelector('.price');

let prezzo = priceElem.textContent;

prezzo = prezzo.substr(prezzo.indexOf(" ") + 1);

let price = parseFloat(prezzo.replace(',', '.'));
	
document.addEventListener('DOMContentLoaded', () =>{
	let productImage = document.querySelector('.image');
	
	quantitySelect.onchange = updatePrice;
});

const updatePrice = () =>{
	let quantity = quantitySelect.options[quantitySelect.selectedIndex].value;
	
	quantity = +quantity;
	
	let priceNew = price * quantity;
	
	priceElem.textContent = '\u20AC ' + priceNew.toFixed(2).replace('.', ',');
};