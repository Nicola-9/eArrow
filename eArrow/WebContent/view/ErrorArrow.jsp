<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  
    <!--Fontawesome CDN-->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

<!--Custom styles-->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/ErrorCSS.css">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footerStyle.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/NavbareArrowStyle.css">	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body>

	<!-- Barra Navigazione -->
<jsp:include page="NavbareArrow.jsp"/>


<div class="content">
	
	<div class="erroe-text">
	<i class='fas fa-exclamation-triangle' style='font-size:48px;color:#a2a2a2'></i><br><br>
	
	
	<%
		String s = request.getParameter("testoErrore"); 
	
		if(s != null){
	%>
			<p id="testo"><%=s %>>.</p>
	<% 
		} else{
	%>
	
		<p id="testo">E' stato riscontrato un problema,<br> Verrai reindirizzato alla
		pagina di Login.</p>
		
	<% 
		}
	%>
	</div>
		
</div>

<div class="eArrow-footer">
	<jsp:include page="Footer.jsp"/>
</div>
	
	<script>
	
		$(document).ready(function() {
			setTimeout(function(){ window.location.replace("${pageContext.request.contextPath}/HomePageServlet"); }, 5000);
		});

	</script>
	
	<!-- Bootstrap Script -->
		<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>	
</body>
</html>