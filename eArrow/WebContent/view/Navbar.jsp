
        
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
						
						<li class="nav-item search-item">
							<a href="#" class="nav-link nav-link-search" id="search"></a>
						</li>
						
						<li class="nav-item">
							<a href="#" class="nav-link nav-link-account"></a>
						</li>
						
						<li class="nav-item nav-item-hidden">
							<a href="#" class="nav-link nav-link-bag"></a>
						</li>
					</ul>
					
					<div class="search-form">
                    	<form class="inputSearch">
                        	<input class="inputSearchInput" type="text" name="" placeholder="eArrow.it">
                    	</form>
                	</div>
                	
                	<a class="close">
                		<i class="close-icon"></i>
                	</a>
				</nav>
				
			</div>
		</header>
		
		<script src='..//javascript/NavbarJS.js'></script>
		
		<script type="text/javascript">
		
			var searchView = function(){
                $('#search').click(function(){
                    $('.nav-link').addClass('hide-item');
                    $('.search-form').addClass('active');
                    $('.close').addClass('active');
                });
                
                $('.close').click(function(){
                    $('.nav-link').removeClass('hide-item');
                    $('.search-form').removeClass('active');
                    $('.close').removeClass('active'); 
                });
            };
            
            $(document).ready(function(){
            	if($(window).innerWidth() > 998){
                   searchView();
            	} else
            		if($(window).innerWidth() <= 998){
						$('#search').unbind("click");
            			
            			$('#search').hide();
            			
            			$('.search-form input').addClass('mobile');
            			$('.search-form').addClass('mobile').appendTo('.search-item');
            		}
            	
            	$(window).resize(function(){
            		
            		if($(window).innerWidth() <= 998){
            			$('#search').unbind("click");
            			
            			$('#search').hide();
            			
            			$('.search-form input').addClass('mobile');
            			$('.search-form').addClass('mobile').appendTo('.search-item');
            		}
            		
            		if($(window).innerWidth() > 998){
            			$('#search').show();
            			
            			$('.search-form').removeClass('mobile').appendTo('.nav');
            			searchView();
            		}
            	});
            });
        </script>
