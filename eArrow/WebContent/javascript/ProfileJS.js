/**
 * 
 */

document.addEventListener('DOMContentLoaded', () => {
	const modifyBtn = document.querySelector('.modify-btn');
	const saveBtn = document.querySelector('.save-btn');
	const inputField = document.querySelectorAll('input');
	const passField = document.querySelector('.pass');
		
	inputField.forEach((inp) => {
		inp.disabled = true;
	});
				
	saveBtn.style.display = "none";
				
	modifyBtn.addEventListener('click', () => {
		inputField.forEach((inp) => {
			inp.disabled = false;
		});
					
		modifyBtn.disabled = true;
					
		saveBtn.style.removeProperty('display');
		
		passField.type = "text";
	});
				
	saveBtn.addEventListener('click', () => {
					
	});
});