/**
 * 
 */
let quantitySelect = document.querySelector('.quantitySelect');
let priceElem = document.querySelector('.price');

let rowParent = document.querySelector('.row');

let removedChild = [];

let prezzo = priceElem.textContent;

prezzo = prezzo.substr(prezzo.indexOf(" ") + 1);

let price = parseFloat(prezzo.replace(',', '.'));

let addToShoppingButton = document.querySelector('.addCart-btn');

let productCode = document.querySelector('.hidden-code').value;
	
document.addEventListener('DOMContentLoaded', () =>{
	let productImage = document.querySelector('.image');
	
	quantitySelect.onchange = updatePrice;
	
	window.onresize = adjustReccomended;

	addToShoppingButton.addEventListener('click', () =>{
		document.location.href = './AddToShoppingBagServlet?codiceProdotto=' + productCode + "&quantity=" + quantitySelect.options[quantitySelect.selectedIndex].value;;
	});
});

const adjustReccomended = () =>{
	if(window.innerWidth <= 557){
		let j = 0;
		
		if(rowParent.children.length > 3){
			for(let i=3; i < rowParent.children.length && i >= 3; i++){
				removedChild[j] = rowParent.removeChild(rowParent.lastChild);
				
				j++;
			}	
		}
	}
	
	if(window.innerWidth > 557){
		if(removedChild.length > 0){
			for(let i=0; i < removedChild.length; i++){
				rowParent.append(removedChild[i]);
			}	
		}
	}
};

const updatePrice = () =>{
	let quantity = quantitySelect.options[quantitySelect.selectedIndex].value;
	
	quantity = +quantity;
	
	let priceNew = price * quantity;
	
	priceElem.textContent = '\u20AC ' + priceNew.toFixed(2).replace('.', ',');
};