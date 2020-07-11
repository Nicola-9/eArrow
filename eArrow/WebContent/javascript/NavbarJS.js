/**
 * 
 */

const selectElement = (element) => document.querySelector(element);

selectElement('.mobile-earrow-menu').addEventListener("click", () => {
	selectElement('header').classList.toggle('active');
});




