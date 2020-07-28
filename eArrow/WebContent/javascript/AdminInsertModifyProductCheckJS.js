/**
 * 
 */

let nameField = document.querySelector('input.name');
let tipologyField = document.querySelector('input.tipology');
let priceField = document.querySelector('input.price');
let quantityField = document.querySelector('input.quantity');
let descriptionField = document.querySelector('input.description');
let disponibility = document.querySelector('.dispSelect');

let saveBtn = document.querySelector('.save-btn');

let nameRegex = /^[a-zA-Z0-9-,_ ]+$/;
let tipologyRegex = /^[a-zA-Z0-9-,_ ]+$/;
let quantityRegex = /^[0-9]+$/;
let priceRegex = /^[0-9]*[.]{0,1}[0-9]+$/;
let descriptionRegex = /\s*([\s\S]*?)/;

let valid = false;

document.addEventListener('DOMContentLoaded', () =>{
	saveBtn.addEventListener('click', validateForm);
});

const validateForm = () =>{
	if(nameField.value == null || !nameRegex.test(nameField.value)){
		nameField.style.border = '1px solid #FF0000';
		document.querySelector('#errorName').innerHTML = "Campo nome non valido. Lunghezza massima consentita di 40 caratteri.";
		document.querySelector('.errRowNameCategory').style.display = 'block';
		document.querySelector('.errNameHide').style.visibility = 'visible';
		document.querySelector('.nameCategoryRow').classList.add('hidden');
	} else
		if(tipologyField.value == null || !tipologyRegex.test(tipologyField.value)){
			tipologyField.style.border = '1px solid #FF0000';
			document.querySelector('#errorTipology').innerHTML = "Campo tipologia non valido. Lunghezza massima consentita di 25 caratteri.";
			document.querySelector('.errRowTipologyPrice').style.display = 'block';
			document.querySelector('.errTipologyHide').style.visibility = 'visible';
			document.querySelector('.tipologyPriceRow').classList.add('hidden');
		} else
			if(priceField.value == null || !priceRegex.test(priceField.value)){
				priceField.style.border = '1px solid #FF0000';
				document.querySelector('#errorPrice').innerHTML = "Campo prezzo non valido. Consentiti solo numeri con al massimo un punto per cifre decimali";
				document.querySelector('.errRowTipologyPrice').style.display = 'block';
				document.querySelector('.errPriceHide').style.visibility = 'visible';
				document.querySelector('.errTipologyHide').style.visibility = 'hidden';
				document.querySelector('.tipologyPriceRow').classList.add('hidden');
			} else
				if(quantityField.value == null || !quantityRegex.test(quantityField.value) || quantityField.value == ""){
					quantityField.style.border = '1px solid #FF0000';
					document.querySelector('#errorQuantity').innerHTML = "Campo quantita' non valido. Consentiti solo numeri maggiori di 0 e non negativi.";
					document.querySelector('.errRowDisponibilityQuantity').style.display = 'block';
					document.querySelector('.errQuantityHide').style.visibility = 'visible';
					document.querySelector('.disponibilityQuantityRow').classList.add('hidden');
					
				} else
					if(disponibility.options[disponibility.selectedIndex].value == "true" && quantityField.value <= 0){
							quantityField.style.border = '1px solid #FF0000';
							document.querySelector('#errorQuantity').innerHTML = "Campo quantita' non valido. Prodotti disponibili non possono avere una quantità pari a 0.";
							document.querySelector('.errRowDisponibilityQuantity').style.display = 'block';
							document.querySelector('.errQuantityHide').style.visibility = 'visible';
							document.querySelector('.disponibilityQuantityRow').classList.add('hidden');
					} else
						if(descriptionField.value == null || !descriptionRegex.test(descriptionField.value)){
							descriptionField.style.border = '1px solid #FF0000';
							document.querySelector('#errorDescription').innerHTML = "Campo descrizione non valido. Lunghezza massima di 500 caratteri e minima di 10 caratteri.";
							document.querySelector('.errRowDescription').style.display = 'block';
							document.querySelector('.errDescriptionHide').style.visibility = 'visible';
							document.querySelector('.descriptionRow').classList.add('hidden');
						} else{
							valid = true;
						}
	
	if(!valid){
		event.preventDefault();
		
		document.addEventListener('keydown', () => {
			nameField.style.removeProperty('border');
			tipologyField.style.removeProperty('border');
			priceField.style.removeProperty('border');
			quantityField.style.removeProperty('border');
			descriptionField.style.removeProperty('border');
			
			document.querySelector('div.errRowNameCategory').style.removeProperty('display');
			document.querySelector('div.errRowTipologyPrice').style.removeProperty('display');
			document.querySelector('div.errRowDisponibilityQuantity').style.removeProperty('display');
			document.querySelector('div.errRowDescription').style.removeProperty('display');
			
			
			document.querySelector('.nameCategoryRow').classList.remove('hidden');
			document.querySelector('.tipologyPriceRow').classList.remove('hidden');
			document.querySelector('.disponibilityQuantityRow').classList.remove('hidden');
			document.querySelector('.descriptionRow').classList.remove('hidden');
			
			
			document.querySelector('.errNameHide').style.visibility = 'hidden !important';
			document.querySelector('.errTipologyHide').style.visibility = 'hidden !important';
			document.querySelector('.errPriceHide').style.visibility = 'hidden !important';
			document.querySelector('.errQuantityHide').style.visibility = 'hidden !important';
			document.querySelector('.errDescriptionHide').style.visibility = 'hidden !important';
		});
	}

};
