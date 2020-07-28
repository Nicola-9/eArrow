/**
 * Module for check fields of Check-out form
 */

let valid = false;
let nameField;
let panField;
let cvvField;
let checkForm;

let dataAnnoSelect;
let dataMeseSelect;
let cricSelect;

nameField = document.querySelector('#name');
panField = document.querySelector('#number');
cvvField = document.querySelector('#cvv');
checkForm = document.querySelector('#CheckForm');

dataAnnoSelect = document.querySelector('#selAnno');
dataMeseSelect = document.querySelector('#selMese');
circSelect = document.querySelector('#selC');

const validateForm = () => {
	
	let nameRegex = /^[A-Za-z]+[ ]*[A-Za-z]*/;//^[A-Z]{0,1}[a-z]{1,}$
	let panRegex = /(^[0-9]{4}\s[0-9]{4}\s[0-9]{4}\s[0-9]{4}$)/;
	let cvvRegex = /^[0-9]{3}$/;
	

	if(nameField.value == null || !nameRegex.test(nameField.value)){
		nameField.style.border = '1px solid #FF0000';
		document.querySelector('#errorName').innerHTML = "Campo nome deve iniziare con lettera maiuscola e non sono"
														+ " accettati caratteri speciali o numeri";
		document.querySelector('#errorName').style.visibility = 'visible';
		document.querySelector('#errorName').style.color = '#FF0000';
		}else
			if(panField.value == null || !panRegex.test(panField.value)){
				panField.style.border = '1px solid #FF0000';
				document.querySelector('#errorPan').innerHTML = "Campo Numero carta deve contenere esattamente 16 numeri"
																+ "presenti sul fronte della carta";
				document.querySelector('#errorPan').style.visibility = 'visible';
				document.querySelector('#errorPan').style.color = '#FF0000';
				} else 
					if(cvvField.value == null || !cvvRegex.test(cvvField.value)){
						cvvField.style.border = '1px solid #FF0000';
						document.querySelector('#errorCvv').innerHTML = "Campo CVV deve contenere esattamente 3 numeri presenti sul"
							 											+ "retro della carta";
						document.querySelector('#errorCvv').style.visibility = 'visible';
						document.querySelector('#errorCvv').style.color = '#FF0000';
						} else
							if(dataMeseSelect.value == "Mese"){
								dataMeseSelect.style.border = '1px solid #FF0000';
								document.querySelector('#errorData').innerHTML = "Selezionare il mese di scadenza della carta";
								document.querySelector('#errorData').style.visibility = 'visible';
								document.querySelector('#errorData').style.color = '#FF0000';
								} else
									if(dataAnnoSelect.value == "Anno"){
										dataAnnoSelect.style.border = '1px solid #FF0000';
										document.querySelector('#errorData').innerHTML = "Selezionare l'anno di scadenza della carta";
										document.querySelector('#errorData').style.visibility = 'visible';
										document.querySelector('#errorData').style.color = '#FF0000';
										} else
											if(circSelect.value == "Circuito"){
												dataMeseSelect.style.border = '1px solid #FF0000';
												document.querySelector('#errorData').innerHTML = "Selezionare il circuito della carta";
												document.querySelector('#errorData').style.visibility = 'visible';
												document.querySelector('#errorData').style.display = 'block';
												document.querySelector('#errorData').style.color = '#FF0000';
												} 
											else
												valid = true;
					
		
	if(!valid){
		event.preventDefault();
		
		document.addEventListener('keydown', () => {
			nameField.style.removeProperty('border');
			panField.style.removeProperty('border');
			cvvField.style.removeProperty('border');
			dataAnnoSelect.style.removeProperty('border');
			dataMeseSelect.style.removeProperty('border');
			circSelect.style.removeProperty('border');

			
			document.querySelector('#errorName').style.visibility = 'hidden';
			document.querySelector('#errorName').innerHTML = 'Errore';
			document.querySelector('#errorPan').style.visibility = 'hidden';
			document.querySelector('#errorPan').innerHTML = 'Errore';
			document.querySelector('#errorCvv').style.visibility = 'hidden';
			document.querySelector('#errorCvv').innerHTML = 'Errore';
			document.querySelector('#errorData').style.visibility = 'hidden';
			document.querySelector('#errorData').innerHTML = 'Errore';
		});
	}

};

document.addEventListener('DOMContentLoaded', () => {
	event.preventDefault();
	checkForm.onsubmit = validateForm;
});
