<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- footer -->
<footer>
	<div class="footer"> 

		<div class="footer-line">
			<div class="footer-content">

				<div id="information">
					<label for="exampleFormControlInput1">
						<dt>PER CONOSCERCI MEGLIO</dt>
					</label>

					<p class="left-information">
						eArrow è un sito web e-commerce di arcieria.
						eArrow possiede in magazzino i prodotti dei più grandi marchi e punta ad essere il tuo 
						negozio di fiducia.
						Questo e-commerce è stato sviluppato mediante un progetto universitario relativo all'esame 
						di Tecnologie Software per il Web.
					</p>
					

					<a href="#" class="fa fa-facebook"></a> <a href="#"
						class="fa fa-twitter"></a> <a href="#" class="fa fa-linkedin"></a>
					<a href="#" class="fa fa-instagram"></a>
				</div>

				<div id="contacts">
					<label for="exampleFormControlInput1"><dt>INFO SU eArrow.it</dt></label>
					<ul>
						<li>Semplice da usare</li>
						<li>Sicuro</li>
						<li>Le migliori marche</li>
					</ul>
				</div>

				<div id="contact-us">

					<form>
						<div class="form-group">
							<label for="exampleFormControlInput1"><dt>HAI BISOGNO D'AIUTO?</dt></label> <input type="email" class="form-control"
								id="exampleFormControlInput1" placeholder="nome@esempio.com">
						</div>

						<div class="form-group">
							<textarea class="form-control" id="exampleFormControlTextarea1"
								rows="3" placeholder="Scrivi il tuo messaggio"></textarea>
						</div>
					</form>

				</div>

			</div>
		</div>


		<div class="footer-celebration">
			<p>© 2020 Design by Labanca Nicola & Bruno Biagio</p>
			<p id="logo">
				<img src='${pageContext.request.contextPath}/image/eArrow.png' width="50" height="50">
			</p>
		</div>


	</div>
</footer>