/**
 * Module for check fields of Login form
 */
let valid = false;

const validateForm = () => {
	let emailField;
	let passwordField;

	
	
	emailField = document.querySelector('#Email');
	passwordField = document.querySelector('#Password');
	
	
	
	let emailRegex = /(^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$)/;
	let passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
	

	if(emailField.value == null || !emailRegex.test(emailField.value)){
		emailField.style.border = '1px solid #FF0000';
		document.querySelector('#errorEmail').innerHTML = "Campo email deve essere della forma"
																+ "  email@example.com";
		document.querySelector('#errorEmail').style.visibility = 'visible';
		document.querySelector('#errorEmail').style.color = '#FF0000';
		}else
			if(passwordField.value == null || !passwordRegex.test(passwordField.value)){
				passwordField.style.border = '1px solid #FF0000';
				document.querySelector('#errorPass').innerHTML = "Campo password deve contenere minimo 7 simboli alfabetici"
																							+ " ed un numero";
				document.querySelector('#errorPass').style.visibility = 'visible';
				document.querySelector('#errorPass').style.color = '#FF0000';
				} else{
					valid = true;
					}
		
	if(!valid){
		event.preventDefault();
		
		document.addEventListener('keydown', () => {
			emailField.style.removeProperty('border');
			passwordField.style.removeProperty('border');
			
			
			
			document.querySelector('#errorEmail').style.visibility = 'hidden';
			document.querySelector('#errorEmail').innerHTML = 'Errore';
			document.querySelector('#errorPass').style.visibility = 'hidden';
			document.querySelector('#errorPass').innerHTML = 'Errore';
		});
	}

};

document.addEventListener('DOMContentLoaded', () => {
	event.preventDefault();
	
	registrationForm.onsubmit = validateForm;
});