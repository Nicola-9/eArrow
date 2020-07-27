<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@page import="util.*, model.bean.*"%>

<header>
	<div class="earrow-container">

		<nav class="earrow-nav">
			<ul class="nav-earrow-list nav-earrow-list-mobile">

				<li class="nav-earrow-item">

					<div class="mobile-earrow-menu">
						<span class="line line-top"></span> <span class="line line-bottom"></span>
					</div>

				</li>

				<li class="nav-earrow-item"><a href="${pageContext.request.contextPath}/HomePageServlet"
					class="nav-earrow-link nav-link-earrow"></a></li>

				<li class="nav-earrow-item"><a href="#"
					class="nav-earrow-link nav-earrow-link-bag"></a></li>
			</ul>

			<ul class="nav-earrow-list nav-earrow-list-larger">

				<li class="nav-earrow-item nav-earrow-item-hidden"><a
					href="${pageContext.request.contextPath}/HomePageServlet" class="nav-earrow-link nav-link-earrow"></a></li>

				<li class="nav-earrow-item"><a href="${pageContext.request.contextPath}/ProductsListServlet?category=Archi"
					class="nav-earrow-link">Archi</a></li>

				<li class="nav-earrow-item"><a href="${pageContext.request.contextPath}/ProductsListServlet?category=AccessoriArco"
					class="nav-earrow-link">Accessori Arco</a></li>

				<li class="nav-earrow-item"><a href="${pageContext.request.contextPath}/ProductsListServlet?category=AccessoriArciere"
					class="nav-earrow-link">Accessori Arciere</a></li>

				<li class="nav-earrow-item"><a href="${pageContext.request.contextPath}/ProductsListServlet?category=Frecce"
					class="nav-earrow-link">Frecce e Componenti</a></li>

				<li class="nav-earrow-item"><a href="${pageContext.request.contextPath}/ProductsListServlet?category=Paglioni"
					class="nav-earrow-link">Paglioni e Bersagli</a></li>

				<li class="nav-earrow-item search-item"><a href="#"
					class="nav-earrow-link nav-earrow-link-search" id="search"></a></li>

				<% 
					UtenteBean user = (UtenteBean) request.getSession().getAttribute("user"); 
					
					System.out.println(user);
					
					if(user == null){
				%>
				
				<li class="nav-earrow-item">
					<div class="dropdown">
						<a href="#" class="nav-earrow-link nav-earrow-link-account dropdown" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
					
						<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<div class="arrow-up"></div>
							<div class="dropdown-item">
								<p class="title-drop">Già registrato?</p>
								<a class="btn btn-primary btn-drop btn-drop-signIn" href="${pageContext.request.contextPath}/LoginServlet?launch=true">Accedi</a> 
							</div> 
							<div class="dropdown-divider"></div>
							<div class="dropdown-item">
								<p class="title-drop">Non ancora registrato?</p>
								<a class="btn btn-primary btn-drop btn-drop-signUp" href="${pageContext.request.contextPath}/SignUpServlet?launch=true">Registrati ora</a> 
							</div> 
						</div>
					</div>
				</li>
					
				<% 
					} else {
						request.setAttribute("update", false);
						
						String role = (String) request.getSession().getAttribute("role");
						
						if(role.equals("utente")){
				%>
				
				<li class="nav-earrow-item">
					<div class="dropdown">
						<a href="#"
							class="nav-earrow-link nav-earrow-link-account dropdown" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
						
						<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<div class="arrow-up"></div>
							<div class="dropdown-item">
								<p class="title-drop title-drop-signedin">Ciao, <%=user.getNome() %></p>
								<a class="btn btn-primary btn-drop btn-drop-visualizeProfile" href="${pageContext.request.contextPath}/ProfileServlet">Visualizza profilo</a> 
							</div> 
							<div class="dropdown-divider"></div>
							<div class="dropdown-item">
								<a class="btn btn-drop btn-drop-logout" href="${pageContext.request.contextPath}/LogoutServlet">Logout</a> 
							</div> 
						</div>
					</div>	
				</li>
					
				<% 
					} else{
				%>
				
				<li class="nav-earrow-item">
					<div class="dropdown">
						<a href="#"
							class="nav-earrow-link nav-earrow-link-account dropdown" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
						
						<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<div class="arrow-up"></div>
							<div class="dropdown-item">
								<p class="title-drop title-drop-signedin">Ciao, Amministratore</p>
								<a class="btn btn-primary btn-drop btn-drop-visualizeProfile" href="${pageContext.request.contextPath}/AdminProfileServlet">Gestisci eArrow</a> 
							</div> 
							<div class="dropdown-divider"></div>
							<div class="dropdown-item">
								<a class="btn btn-drop btn-drop-logout" href="${pageContext.request.contextPath}/LogoutServlet">Logout</a> 
							</div> 
						</div>
					</div>	
				</li>
				
				<%
					}
				}
				%>

				<li class="nav-earrow-item nav-earrow-item-hidden">
					<a href="${pageContext.request.contextPath}/ShoppingBagServlet" class="nav-earrow-link nav-earrow-link-bag"></a>
				</li>
			</ul>

			<div class="search-form">
				<form class="inputSearch" action="./SearchServlet" onsubmit="this.form.submit()">
					<input class="inputSearchInput" type="text" name="suggestion"
						placeholder="eArrow.it" list="dbSearch">
						<datalist id="dbSearch">
						  
						</datalist>
				</form>
			</div>

			<a class="close"> <i class="close-icon"></i>
			</a>
		</nav>

	</div>
</header>


<script src='${pageContext.request.contextPath}/javascript/NavbarJS.js'></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" type="text/javascript"></script> 


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
            	var user = <%=user%>;
            	
            	if($(window).innerWidth() > 998){
                   searchView();
                   
                   $('.dropdown').prop("disabled", false);
   				   $('a.nav-earrow-link-account').attr("href", "#");
            	} else
            		if($(window).innerWidth() <= 998){
						$('#search').unbind("click");
            			
            			$('#search').hide();
            			
            			$('.search-form input').addClass('mobile');
            			$('.search-form').addClass('mobile').appendTo('.search-item');
            			
            			
            			if(user != null){
            				$('.dropdown').prop("disabled", true);
            				$('a.nav-earrow-link-account').attr("href", "http://localhost:8080/eArrow/ProfileServlet");
            			
            			} else{
            				console.log("It's null");
            				$('.dropdown').prop("disabled", true);
            				$('a.nav-earrow-link-account').attr("href", "http://localhost:8080/eArrow/LoginServlet?launch=true");	
            			}
            		}
            	
            	$(window).resize(function(){
            		
            		if($(window).innerWidth() <= 998){
            			$('#search').unbind("click");
            			
            			$('#search').hide();
            			
            			$('.search-form input').addClass('mobile');
            			$('.search-form').addClass('mobile').appendTo('.search-item');
            	
            			
            			if(user != null){
            				$('a.nav-earrow-link-account').attr("href", "http://localhost:8080/eArrow/ProfileServlet");
            				$('.dropdown').prop("disabled", true);
            			
            			} else{
            				console.log("It's null");
            				$('a.nav-earrow-link-account').attr("href", "http://localhost:8080/eArrow/LoginServlet?launch=true");
            				$('.dropdown').prop("disabled", true);	
            			}
            		}
            		
            		if($(window).innerWidth() > 998){
            			$('#search').show();
            			
            			$('.search-form').removeClass('mobile').appendTo('.earrow-nav');
            			searchView();
            			
            			$('a.nav-earrow-link-account').attr("href", "#");
            			$('.dropdown').prop("disabled", false);
            		}
            	});
            });
            
            function removeElement(elementId) {
                var element = document.getElementById(elementId);
                if(element != null){
                	element.parentNode.removeChild(element);
                }
            }
            
            
            $(document).ready(function(){
            	$('.inputSearchInput').on("change paste keyup", function() {
            		var input = $(".inputSearchInput").val();
            		console.log("input utente = " + input);
            		
            		
            		//rimuove gli elementi all'interno del datalist avente id: dbSearch
					var elem = "nameE"
					
					var container = document.getElementById("dbSearch");
					var elements = container.getElementsByClassName(elem);

					while (elements[0]) {
					    elements[0].parentNode.removeChild(elements[0]);
					}
					
			

            		$.ajax({
    					type : "POST",
    					url : "SuggestionListServlet",
    					data : {"inputJ" : input,},
    					dataType : "json",
    					async : true,
    					success : function(response) {

    						//immette gli elementi all'interno del datalist avente id: dbSearch
    						var booleanRisposta = response[0];
    						
    						if(booleanRisposta == true){
    							var array = response[1];
    							var i = 0;
    							while(i < array.length){
    								var str = array[i];
									$( "#dbSearch" ).append('<option value="' + str + '"' + 'class="' + elem + '">');
    								console.log("input utente = " + array[i]);
    								i++;
    							}	
    						} else{
    							
    						}
    					},

    				});
            	});

            });

        </script>