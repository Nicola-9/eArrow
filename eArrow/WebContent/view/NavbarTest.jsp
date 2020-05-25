
        
		<header>
			<div class="container">
				
				<nav class="nav">
					<ul class="nav-list nav-list-mobile">
						
						<li class="nav-item">
						
							<div class="mobile-menu">
								<span class="line line-top"></span>
								<span class="line line-bottom"></span>
							</div>
						
						</li>
						
						<li class="nav-item">
							<a href="Homepage.jsp" class="nav-link nav-link-apple"></a>
						</li>
						
						<li class="nav-item">
							<a href="#" class="nav-link nav-link-bag"></a>
						</li>
					</ul>
					
					<ul class="nav-list nav-list-larger">
						
						<li class="nav-item nav-item-hidden">
							<a href="Homepage.jsp" class="nav-link nav-link-apple"></a>
						</li>
						
						<li class="nav-item">
							<a href="Homepage.jsp" class="nav-link">Archi</a>
						</li>

						<li class="nav-item">
							<a href="Homepage.jsp" class="nav-link">Accessori Arco</a>
						</li>
						
						<li class="nav-item">
							<a href="Homepage.jsp" class="nav-link">Accessori Arciere</a>
						</li>
						
						<li class="nav-item">
							<a href="Homepage.jsp" class="nav-link">Frecce e Componenti</a>
						</li>
						
						<li class="nav-item">
							<a href="Homepage.jsp" class="nav-link">Paglioni e Bersagli</a>
						</li>
						
						<li class="nav-item">
							<a href="#" class="nav-link-search" id="search"></a>
						</li>
						
						<li class="nav-item">
							<a href="#" class="nav-link-account"></a>
						</li>
						
						<li class="nav-item">
							<a href="#" class="nav-link-bag"></a>
						</li>
					</ul>
					
					<div class="search-form">
                    	<form>
                        	<input type="text" name="" placeholder="eArrow.it">
                    	</form>
                	</div>
                	
                	<a class="close">
                		<span class="close-line-top"></span>
						<span class="close-line-bottom"></span>
                	</a>
				</nav>
				
			</div>
		</header>
		
		<script src='..//javascript/NavbarJS.js'></script>
		
		<script type="text/javascript">
            $(document).ready(function(){
                $('#search').click(function(){
                    $('.nav-item').addClass('hide-item')
                    $('.search-form').addClass('active')
                    $('.close').addClass('active')
                    $('#search').hide()
                })
                $('.close').click(function(){
                    $('.nav-item').removeClass('hide-item')
                    $('.search-form').removeClass('active')
                    $('.close').removeClass('active')
                    $('#search').show()
                })
            })
        </script>
