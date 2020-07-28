/**
 * Module for check fields of SignUp form
 */

let valid = false;

const validateForm = () => {
	let nameField;
	let surnameField
	let emailField;
	let numTelField;
	let cityField;
	let viaField;
	let civicoField;
	let capField;
	let passwordField;
	let confirmPassField;
	let registrationForm;
	
	nameField = document.querySelector('#name');
	surnameField = document.querySelector('#surname');
	emailField = document.querySelector('#email');
	numTelField = document.querySelector('#numTel');
	cityField = document.querySelector('#city');
	viaField = document.querySelector('#via');
	civicoField = document.querySelector('#civico');
	capField = document.querySelector('#cap');
	passwordField = document.querySelector('#password');
	confirmPassField = document.querySelector('#confirmPass');
	registrationForm = document.querySelector('#registrationForm');
	
	let nameSurnameRegex = /^[A-Z]{0,1}[a-z]{1,}$/;
	let emailRegex = /(^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$)/;
	let numTelRegex = /^[0-9]{10}$/;
	let cityRouteRegex = /^[a-zA-Z]+(?:[\s-][a-zA-Z]+)*$/;
	let civicoRegex = /^[0-9]+\/{0,1}\s{0,1}[A-Z a-z]{0,1}$/;
	let capRegex = /^[0-9]{5}$/;
	let passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
	let confirmPassRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
	
	if(nameField.value == null || !nameSurnameRegex.test(nameField.value)){
		nameField.style.border = '1px solid #FF0000';
		document.querySelector('#errorNameSurname').innerHTML = "Campo nome deve iniziare con lettera maiuscola e non sono"
																+ " accettati caratteri speciali o numeri";
		document.querySelector('#errorNameSurname').style.visibility = 'visible';
		document.querySelector('#errorNameSurname').style.color = '#FF0000';
	} else
		if(surnameField.value == null || !nameSurnameRegex.test(surnameField.value)){
			surnameField.style.border = '1px solid #FF0000';
			document.querySelector('#errorNameSurname').innerHTML = "Campo cognome deve iniziare con lettera maiuscola e non sono"
																	+ " accettati caratteri speciali o numeri";
			document.querySelector('#errorNameSurname').style.visibility = 'visible';
			document.querySelector('#errorNameSurname').style.color = '#FF0000';
		} else
			if(emailField.value == null || !emailRegex.test(emailField.value)){
				emailField.style.border = '1px solid #FF0000';
				document.querySelector('#errorEmail').innerHTML = "Campo email deve essere della forma"
																+ "  email@example.com";
				document.querySelector('#errorEmail').style.visibility = 'visible';
				document.querySelector('#errorEmail').style.color = '#FF0000';
			}else
				if(numTelField.value == null || !numTelRegex.test(numTelField.value)){
					numTelField.style.border = '1px solid #FF0000';
					document.querySelector('#errorNumTel').innerHTML = "Campo telefono deve contenere solo numeri e la lunghezza"
																			+ " consentita è esattamente 10";
					document.querySelector('#errorNumTel').style.visibility = 'visible';
					document.querySelector('#errorNumTel').style.color = '#FF0000';
				} else
					if(cityField.value == null || !cityRouteRegex.test(cityField.value)){
						cityField.style.border = '1px solid #FF0000';
						document.querySelector('#errorCity').innerHTML = "Campo citta' non valido";
						
						document.querySelector('.errCityHide').style.visibility = 'visible';
						document.querySelector('#errorCity').style.color = '#FF0000';
					} else
						if(viaField.value == null || !cityRouteRegex.test(viaField.value)){
							viaField.style.border = '1px solid #FF0000';
							document.querySelector('#errorVia').innerHTML = "Campo via non valido";
							
							document.querySelector('.errViaHide').style.visibility = 'visible';
							document.querySelector('#errorVia').style.color = '#FF0000';
						}else
							if(civicoField.value == null || !civicoRegex.test(civicoField.value)){
								civicoField.style.border = '1px solid #FF0000';
								document.querySelector('#errorCivico').innerHTML = "Campo civico non valido";
								
								document.querySelector('.errCivicoHide').style.visibility = 'visible';
								document.querySelector('#errorCivico').style.color = '#FF0000';
							} else
								if(capField.value == null || !capRegex.test(capField.value)){
									capField.style.border = '1px solid #FF0000';
									document.querySelector('#errorCap').innerHTML = "Campo CAP non valido";
									
									document.querySelector('.errCapHide').style.visibility = 'visible';
									document.querySelector('#errorCap').style.color = '#FF0000';
								} else
									if(passwordField.value == null || !passwordRegex.test(passwordField.value)){
										passwordField.style.border = '1px solid #FF0000';
										document.querySelector('#errorPass').innerHTML = "Campo password deve contenere minimo 7 caratteri con "
																							+ "almeno un numero";
										document.querySelector('#errorPass').style.visibility = 'visible';
										document.querySelector('#errorPass').style.color = '#FF0000';
									} else
										if(confirmPassField.value == null || !confirmPassRegex.test(confirmPassField.value)){
											confirmPassField.style.border = '1px solid #FF0000';
											document.querySelector('#errorConfirmPass').innerHTML = "Campo conferma password deve corrispondere al"
																									+ " campo password";
											document.querySelector('#errorConfirmPass').style.visibility = 'visible';
											document.querySelector('#errorConfirmPass').style.color = '#FF0000';
										} else{
											valid = true;
										}
		
	if(!valid){
		event.preventDefault();
		
		document.addEventListener('keydown', () => {
			nameField.style.removeProperty('border');
			surnameField.style.removeProperty('border');
			emailField.style.removeProperty('border');
			numTelField.style.removeProperty('border');
			cityField.style.removeProperty('border');
			viaField.style.removeProperty('border');
			civicoField.style.removeProperty('border');
			capField.style.removeProperty('border');
			passwordField.style.removeProperty('border');
			confirmPassField.style.removeProperty('border');
			
			document.querySelector('#errorNameSurname').style.visibility = 'hidden';
			document.querySelector('#errorNameSurname').innerHTML = 'Errore';
			document.querySelector('#errorEmail').style.visibility = 'hidden';
			document.querySelector('#errorEmail').innerHTML = 'Errore';
			document.querySelector('#errorNumTel').style.visibility = 'hidden';
			document.querySelector('#errorNumTel').innerHTML = 'Errore';
			document.querySelector('.errCityHide').style.visibility = 'hidden';
			document.querySelector('#errorCity').innerHTML = 'Errore';
			document.querySelector('.errViaHide').style.visibility = 'hidden';
			document.querySelector('#errorVia').innerHTML = 'Errore';
			document.querySelector('.errCivicoHide').style.visibility = 'hidden';
			document.querySelector('#errorCivico').innerHTML = 'Errore';
			document.querySelector('.errCapHide').style.visibility = 'hidden';
			document.querySelector('#errorCap').innerHTML = 'Errore';
			document.querySelector('#errorPass').style.visibility = 'hidden';
			document.querySelector('#errorPass').innerHTML = 'Errore';
			document.querySelector('#errorConfirmPass').style.visibility = 'hidden';
			document.querySelector('#errorConfirmPass').innerHTML = 'Errore';
		});
	}

};

document.addEventListener('DOMContentLoaded', () => {
	event.preventDefault();
	
	registrationForm.onsubmit = validateForm;
});