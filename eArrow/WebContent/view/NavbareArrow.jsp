
<header>
	<div class="earrow-container">

		<nav class="earrow-nav">
			<ul class="nav-earrow-list nav-earrow-list-mobile">

				<li class="nav-earrow-item">

					<div class="mobile-earrow-menu">
						<span class="line line-top"></span> <span class="line line-bottom"></span>
					</div>

				</li>

				<li class="nav-earrow-item"><a href="Homepage.jsp"
					class="nav-earrow-link nav-link-earrow"></a></li>

				<li class="nav-earrow-item"><a href="#"
					class="nav-earrow-link nav-earrow-link-bag"></a></li>
			</ul>

			<ul class="nav-earrow-list nav-earrow-list-larger">

				<li class="nav-earrow-item nav-earrow-item-hidden"><a
					href="Homepage.jsp" class="nav-earrow-link nav-link-earrow"></a></li>

				<li class="nav-earrow-item"><a href="../ProductsListServlet?category=Archi"
					class="nav-earrow-link">Archi</a></li>

				<li class="nav-earrow-item"><a href="Homepage.jsp"
					class="nav-earrow-link">Accessori Arco</a></li>

				<li class="nav-earrow-item"><a href="Homepage.jsp"
					class="nav-earrow-link">Accessori Arciere</a></li>

				<li class="nav-earrow-item"><a href="Homepage.jsp"
					class="nav-earrow-link">Frecce e Componenti</a></li>

				<li class="nav-earrow-item"><a href="Homepage.jsp"
					class="nav-earrow-link">Paglioni e Bersagli</a></li>

				<li class="nav-earrow-item search-item"><a href="#"
					class="nav-earrow-link nav-earrow-link-search" id="search"></a></li>

				<li class="nav-earrow-item"><a href="#"
					class="nav-earrow-link nav-earrow-link-account"></a></li>

				<li class="nav-earrow-item nav-earrow-item-hidden"><a href="#"
					class="nav-earrow-link nav-earrow-link-bag"></a></li>
			</ul>

			<div class="search-form">
				<form class="inputSearch">
					<input class="inputSearchInput" type="text" name=""
						placeholder="eArrow.it">
				</form>
			</div>

			<a class="close"> <i class="close-icon"></i>
			</a>
		</nav>

	</div>
</header>

<script src='..//javascript/NavbarJS.js'></script>

<script type="text/javascript">
		
			var searchView = function(){
                $('#search').click(function(){
                    $('.nav-earrow-link').addClass('hide-item');
                    $('.search-form').addClass('active');
                    $('.close').addClass('active');
                });
                
                $('.close').click(function(){
                    $('.nav-earrow-link').removeClass('hide-item');
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
            			
            			$('.search-form').removeClass('mobile').appendTo('.earrow-nav');
            			searchView();
            		}
            	});
            });
        </script>