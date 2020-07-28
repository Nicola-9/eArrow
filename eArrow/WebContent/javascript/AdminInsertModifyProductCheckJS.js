/**
 * 
 */

let nameField = document.querySelector('.name');
let tipologyField = document.querySelector('.tipology');
let priceField = document.querySelector('.price');
let quantityField = document.querySelector('.quantity');
let descriptionField = document.querySelector('.decsription');

let saveBtn = document.querySelector('.save-btn');

let nameRegex = /^[a-zA-Z0-9-,_ ]+$/;
let tipologyRegex = /^[a-zA-Z0-9-,_ ]+$/;
let quantityRegex = /^[0-9]{1}$/;
let priceRegex = /^[0-9]*[.]{0,1}[0-9]+$/;
let descriptionRegex = /^[a-zA-Z0-9-,_ ]{10, 500}$/;

let valid = false;

document.addEventListener('DOMContentLoaded', () =>{
	saveBtn.addEventListener('click', validateForm);
});

const validateForm = () =>{
	console.log
	if(nameField.value == null || !nameRegex.test(nameField.value)){
		nameField.style.border = '1px solid #FF0000';
		document.querySelector('#errorName').innerHTML = "Campo nome non valido. Lunghezza massima consentita di 40 caratteri.";
		document.querySelector('.errRowNameCategory').style.display = 'block';
		document.querySelector('.errNameHide').style.visibility = 'visible';
	} else
		if(tipologyField.value == null || !tipologyRegex.test(tipologyField.value)){
			tipologyField.style.border = '1px solid #FF0000';
			document.querySelector('#errorTipology').innerHTML = "Campo tipologia non valido. Lunghezza massima consentita di 25 caratteri.";
			document.querySelector('.errRowTipologyPrice').style.display = 'block';
			document.querySelector('.errTipologyHide').style.visibility = 'visible';
		} else
			if(priceField.value == null || !priceRegex.test(priceField.value)){
				priceField.style.border = '1px solid #FF0000';
				document.querySelector('#errorPrice').innerHTML = "Campo prezzo non valido. Consentiti solo numeri con al massimo un punto per cifre decimali";
				document.querySelector('.errRowTipologyPrice').style.display = 'block';
				document.querySelector('.errPriceHide').style.visibility = 'visible';
			} else
				if(quantityField.value == null || !quantityRegex.test(quantityField.value)){
					quantityField.style.border = '1px solid #FF0000';
					document.querySelector('#errorQuantity').innerHTML = "Campo quantita' non valido. Consentiti solo numeri non minori non negativi.";
					document.querySelector('.errRowDisponibilityQuantity').style.display = 'block';
					document.querySelector('.errQuantityHide').style.visibility = 'visible';
				} else
					if(descriptionField.value == null || !descriptionRegex.test(descriptionField.value)){
						descriptionField.style.border = '1px solid #FF0000';
						document.querySelector('#errorDescription').innerHTML = "Campo descrizione non valido. Lunghezza massima di 500 caratteri e minima di 10 caratteri.";
						document.querySelector('.errRowDescription').style.display = 'block';
						document.querySelector('.errDescriptionHide').style.visibility = 'visible';
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
			
			document.querySelector('.errRowNameCategory').style.display = 'none !important';
			document.querySelector('.errRowTipologyPrice').style.display = 'none !important';
			document.querySelector('.errRowDisponibilityQuantity').style.display = 'none !important';
			document.querySelector('.errRowDescription').style.display = 'none !important';
			
			
			document.querySelector('.errNameHide').style.visibility = 'hidden !important';
			document.querySelector('.errTipologyHide').style.visibility = 'hidden !important';
			document.querySelector('.errPriceHide').style.visibility = 'hidden !important';
			document.querySelector('.errQuantityHide').style.visibility = 'hidden !important';
			document.querySelector('.errDescriptionHide').style.visibility = 'hidden !important';
		});
	}

};
