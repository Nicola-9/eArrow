/**
 * Module for check fields of SignUp form
 */

let valid = false;

const validateForm = () => {
	let nameField;
	let surnameField
	let emailField;
	let numTelField;
	let addressField;
	let passwordField;
	let confirmPassField;
	let registrationForm;
	
	nameField = document.querySelector('#name');
	surnameField = document.querySelector('#surname');
	emailField = document.querySelector('#email');
	numTelField = document.querySelector('#numTel');
	addressField = document.querySelector('#address');
	passwordField = document.querySelector('#password');
	confirmPassField = document.querySelector('#confirmPass');
	registrationForm = document.querySelector('#registrationForm');
	
	let nameSurnameRegex = /^[A-Z]{0,1}[a-z]{1,}$/;
	let emailRegex = /(^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$)/;
	let numTelRegex = /^[0-9]{10}$/;
	let addressRegex = /[A-Z]{0,1}[a-z]+[0-9 \, \', / A-Z a-z]*/;
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
																			+ " massima è 10";
					document.querySelector('#errorNumTel').style.visibility = 'visible';
					document.querySelector('#errorNumTel').style.color = '#FF0000';
				} else
					if(addressField.value == null || !addressRegex.test(addressField.value)){
						addressField.style.border = '1px solid #FF0000';
						document.querySelector('#errorAddress').innerHTML = "Campo indirizzo deve essere nella forma"
																			+ "Via strada 53";
						
						document.querySelector('#errorAddress').style.visibility = 'visible';
						document.querySelector('#errorAddress').style.color = '#FF0000';
					} else
						if(passwordField.value == null || !passwordRegex.test(passwordField.value)){
							passwordField.style.border = '1px solid #FF0000';
							document.querySelector('#errorPass').innerHTML = "Campo password deve contenere minimo 7 simboli alfabetici"
																				+ " ed un numero";
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
			addressField.style.removeProperty('border');
			passwordField.style.removeProperty('border');
			confirmPassField.style.removeProperty('border');
			
			document.querySelector('#errorNameSurname').style.visibility = 'hidden';
			document.querySelector('#errorNameSurname').innerHTML = 'Errore';
			document.querySelector('#errorEmail').style.visibility = 'hidden';
			document.querySelector('#errorEmail').innerHTML = 'Errore';
			document.querySelector('#errorNumTel').style.visibility = 'hidden';
			document.querySelector('#errorNumTel').innerHTML = 'Errore';
			document.querySelector('#errorAddress').style.visibility = 'hidden';
			document.querySelector('#errorAddress').innerHTML = 'Errore';
			document.querySelector('#errorPass').style.visibility = 'hidden';
			document.querySelector('#errorPass').innerHTML = 'Errore';
			document.querySelector('#errorConfirmPass').style.visibility = 'hidden';
			document.querySelector('#errorConfirmPass').innerHTML = 'Errore';
		});
	}

};

document.addEventListener('DOMContentLoaded', () => {
	registrationForm.onsubmit = validateForm;
});