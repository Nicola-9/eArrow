/**
 * 
 */
const saveBtn = document.querySelector('.save-btn');
const modifyBtn = document.querySelector('.modify-btn');
const inputField = document.querySelectorAll('input');

let valid = false;
let modifiedPassword = false;
let jsonToSend;
let nameField;
let surnameField
let emailField;
let numTelField;
let passwordField;
let confirmPassField;
let cityField;
let viaField;
let civicoField;
let capField;
let formUrl;

nameField = document.querySelector('input.name');
surnameField = document.querySelector('input.surname');
emailField = document.querySelector('input.email');
numTelField = document.querySelector('input.tel');
passwordField = document.querySelector('input.pass');
confirmPassField = document.querySelector('input.confirmPass');
cityField = document.querySelector('input.citta');
viaField = document.querySelector('input.via');
civicoField = document.querySelector('input.civico');
capField = document.querySelector('input.cap');
formUrl = document.querySelector('#ajaxForm');

document.addEventListener('DOMContentLoaded', () => {
	const passField = document.querySelector('.pass');
		
	inputField.forEach((inp) => {
		inp.disabled = true;
	});
				
	saveBtn.style.display = "none";
				
	modifyBtn.addEventListener('click', () => {
		inputField.forEach((inp) => {
			inp.disabled = false;
			
			if(inp.name == "tipologia")
				inp.disabled = true;
		});
					
		modifyBtn.disabled = true;
					
		saveBtn.style.removeProperty('display');
		
		passField.type = "text";
	});
				
	saveBtn.addEventListener('click', () => {
		update();
	});
	
	
});

const update = () => {
	console.log("non invio");
	event.preventDefault();
	
	validateForm();
	
	if(valid){
		let id = document.querySelector('.idUser').value;
		let idAddress = document.querySelector('.idAddress').value;
		
		if(modifiedPassword){
			jsonToSend = {
					modifiedPass: true,
					id: id,
					idAddress: idAddress,
					name: nameField.value,
					surname: surnameField.value,
					email: emailField.value,
					tel: numTelField.value,
					password: passwordField.value,
					city: cityField.value,
					via: viaField.value,
					civico: civicoField.value,
					cap: capField.value
				};
		} else{
			jsonToSend = {
					modifiedPass: false,
					id: id,
					idAddress: idAddress,
					name: nameField.value,
					surname: surnameField.value,
					email: emailField.value,
					tel: numTelField.value,
					city: cityField.value,
					via: viaField.value,
					civico: civicoField.value,
					cap: capField.value
				};
		}
		
		
		var ajaxCall = new XMLHttpRequest();
		
		ajaxCall.onreadystatechange = () => {
			
			if (ajaxCall.readyState == XMLHttpRequest.DONE) {
				
				if (ajaxCall.status == 200) {
					let result = JSON.parse(ajaxCall.response);
					
					if(result[0]){
						let respObj = result[1];
						
						if(respObj.modifiedPass){
							nameField.value = respObj.name;
							surnameField.value = respObj.surname;
							emailField.value = respObj.email;
							numTelField.value = respObj.tel;
							passwordField.value = respObj.password;
							cityField.value = respObj.city;
							viaField.value = respObj.via;
							civicoField.value = respObj.civico;
							capField.value = respObj.cap;
						} else{
							nameField.value = respObj.name;
							surnameField.value = respObj.surname;
							emailField.value = respObj.email;
							numTelField.value = respObj.tel;
							cityField.value = respObj.city;
							viaField.value = respObj.via;
							civicoField.value = respObj.civico;
							capField.value = respObj.cap;
						}
						
						
						inputField.forEach((inp) => {
							inp.disabled = true;
						});
						
						saveBtn.style.display = "none";
						
						modifyBtn.disabled = false;
					}
		        }else 
		        	if (ajaxCall.status == 400) {
		        	
		        		// Bad request
		              
		        	}else{
		               alert('something else other than 200 was returned');
		           }
			}
		}
		
		let url = formUrl.action;
		
		ajaxCall.open('POST', url);
		ajaxCall.setRequestHeader("Content-Type", "application/json");
		ajaxCall.send(JSON.stringify(jsonToSend));
	}
}

const validateForm = () => {

	let nameSurnameRegex = /^[A-Z]{0,1}[a-z]{1,}$/;
	let emailRegex = /(^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$)/;
	let numTelRegex = /^[0-9]{10}$/;
	let passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/;
	let cityRouteRegex = /^[a-zA-Z]+(?:[\s-][a-zA-Z]+)*$/;
	let civicoRegex = /^[0-9]+\/{0,1}\s{0,1}[A-Z a-z]{0,1}$/;
	let capRegex = /^[0-9]{5}$/;
	
	if(nameField.value == null || !nameSurnameRegex.test(nameField.value)){
		nameField.style.border = '1px solid #FF0000';
		document.querySelector('#errorName').innerHTML = "Campo nome non può contenere caratteri speciali o numeri";
		document.querySelector('.errRowNameSurname').style.display = 'block';
		document.querySelector('.errNameHide').style.visibility = 'visible';
		document.querySelector('.nameSurnameRow').style.marginBottom = "0";
	} else
		if(surnameField.value == null || !nameSurnameRegex.test(surnameField.value)){
			surnameField.style.border = '1px solid #FF0000';
			document.querySelector('#errorSurname').innerHTML = "Campo cognome non può contenere caratteri speciali o numeri";
			document.querySelector('.errRowNameSurname').style.display = 'block';
			document.querySelector('.errSurnameHide').style.visibility = 'visible';
			document.querySelector('.nameSurnameRow').style.marginBottom = "0";
		} else
			if(emailField.value == null || !emailRegex.test(emailField.value)){
				emailField.style.border = '1px solid #FF0000';
				document.querySelector('#errorEmail').innerHTML = "Campo email non valido";
				document.querySelector('.errRowEmailTel').style.display = 'block';
				document.querySelector('.errEmailHide').style.visibility = 'visible';
				document.querySelector('.emailTelRow').style.marginBottom = "0";
			} else
				if(numTelField.value == null || !numTelRegex.test(numTelField.value)){
					numTelField.style.border = '1px solid #FF0000';
					document.querySelector('#errorTel').innerHTML = "Campo email non valido";
					document.querySelector('.errRowEmailTel').style.display = 'block';
					document.querySelector('.errTelHide').style.visibility = 'visible';
					document.querySelector('.emailTelRow').style.marginBottom = "0";
				} else
					 if(cityField.value == null || !cityRouteRegex.test(cityField.value)){
								cityField.style.border = '1px solid #FF0000';
								document.querySelector('#errorCity').innerHTML = "Campo città non valido";
								document.querySelector('.errRowCityVia').style.display = 'block';
								document.querySelector('.errCityHide').style.visibility = 'visible';
								document.querySelector('.cittaViaRow').style.marginBottom = "0";
							} else
								if(viaField.value == null || !cityRouteRegex.test(viaField.value)){
									viaField.style.border = '1px solid #FF0000';
									document.querySelector('#errorVia').innerHTML = "Campo via non valido";
									document.querySelector('.errRowCityVia').style.display = 'block';
									document.querySelector('.errViaHide').style.visibility = 'visible';
									document.querySelector('.cittaViaRow').style.marginBottom = "0";
								} else
									if(civicoField.value == null || !civicoRegex.test(civicoField.value)){
										civicoField.style.border = '1px solid #FF0000';
										document.querySelector('#errorCivico').innerHTML = "Campo civico non valido";
										document.querySelector('.errRowCivicoCap').style.display = 'block';
										document.querySelector('.errCivicoHide').style.visibility = 'visible';
										document.querySelector('.civicoCapRow').style.marginBottom = "0";
									} else
										if(capField.value == null || !capRegex.test(capField.value)){
											capField.style.border = '1px solid #FF0000';
											document.querySelector('#errorCap').innerHTML = "Campo civico non valido";
											document.querySelector('.errRowCivicoCap').style.display = 'block';
											document.querySelector('.errCapHide').style.visibility = 'visible';
											document.querySelector('.civicoCapRow').style.marginBottom = "0";
										} else{
											
											if(passwordField.value != null && passwordField.value.length != 0){
												if(!passwordRegex.test(passwordField.value)){
													passwordField.style.border = '1px solid #FF0000';
													document.querySelector('#errorPass').innerHTML = "Campo password deve contenere minimo 7 simboli alfabetici"
																									+ " ed un numero";
													document.querySelector('.errRowPassConfirmPass').style.display = 'block';
													document.querySelector('.errPassHide').style.visibility = 'visible';
													document.querySelector('.passConfPassRow').style.marginBottom = "0";
												} else
													if(confirmPassField.value == null || !(passwordField.value == confirmPassField.value)){
														confirmPassField.style.border = '1px solid #FF0000';
														document.querySelector('#errorConfirmPass').innerHTML = "Campo conferma password e password"
																												+ " non corrispondono";
														document.querySelector('.errRowPassConfirmPass').style.display = 'block';
														document.querySelector('.errConfPassHide').style.visibility = 'visible';
														document.querySelector('.passConfPassRow').style.marginBottom = "0";
													} else{
														valid = true;
														modifiedPassword = true;
													}
											} else{
												valid = true;
											}
										}
	
	if(!valid){
		event.preventDefault();
		
		document.addEventListener('keydown', () => {
			nameField.style.removeProperty('border');
			surnameField.style.removeProperty('border');
			emailField.style.removeProperty('border');
			numTelField.style.removeProperty('border');
			passwordField.style.removeProperty('border');
			confirmPassField.style.removeProperty('border');
			cityField.style.removeProperty('border');
			viaField.style.removeProperty('border');
			civicoField.style.removeProperty('border');
			capField.style.removeProperty('border');
			
			document.querySelector('.errRowNameSurname').style.display = 'none';
			document.querySelector('.nameSurnameRow').style.marginBottom = '1.5%';
			
			document.querySelector('.errRowEmailTel').style.display = 'none';
			document.querySelector('.emailTelRow').style.marginBottom = '1.5%';
			
			document.querySelector('.errRowPassConfirmPass').style.display = 'none';
			document.querySelector('.passConfPassRow').style.marginBottom = '1.5%';
			
			document.querySelector('.errRowCityVia').style.display = 'none';
			document.querySelector('.cityViaRow').style.marginBottom = '1.5%';
			
			document.querySelector('.errRowCivicoCap').style.display = 'none';
			document.querySelector('.civicoCapRow').style.marginBottom = '1.5%';
			
			document.querySelector('.errNameHide').style.visibility = 'hidden';
			document.querySelector('.errSurnameHide').style.visibility = 'hidden';
			document.querySelector('.errEmailHide').style.visibility = 'hidden';
			document.querySelector('.errTelHide').style.visibility = 'hidden';
			document.querySelector('.errPassHide').style.visibility = 'hidden';
			document.querySelector('.errConfPassHide').style.visibility = 'hidden';
			document.querySelector('.errCityHide').style.visibility = 'hidden';
			document.querySelector('.errViaHide').style.visibility = 'hidden';
			document.querySelector('.errCivicoHide').style.visibility = 'hidden';
			document.querySelector('.errCapHide').style.visibility = 'hidden';
		});
	}

};



