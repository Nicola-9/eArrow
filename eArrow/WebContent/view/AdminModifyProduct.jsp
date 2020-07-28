<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList, model.bean.*, model.dao.*"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Modifica Prodotto</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">		
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footerStyle.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/InsertProductAdminStyle.css">	
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/NavbareArrowStyle.css">	
		
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	</head>
	
	<body>
	
		<jsp:include page="NavbareArrow.jsp"/>
	
		<%
			ProdottoBean p = (ProdottoBean) request.getAttribute("product");
		
			if(p != null){
		%>
		
		<div class="content">
			<h5 class="doc-title-sm">MODIFICA PRODOTTO</h5>
			<div class="card">
				<div class="card-body">
					<form id="modifyForm" method="post" action="./AdminModifyProductServlet?modify=true&productCode=<%=p.getCodice() %>" onsubmit="this.form.submit();" enctype="multipart/form-data" accept-charset="utf-8">
						
						<div class="form-row nameCategoryRow">
							<div class="col form-group">
								<label>Nome</label> <input type="text" name="name" class="form-control name"
									value="<%=p.getNome() %>">
							</div>
							<!-- form-group end.// -->
							<div class="col form-group">
								<label class="titleSelect">Categoria</label> 
									<select	class="custom-select" name="category">
									
									<%
										if(p.getCategoria().equals("archi")){
									
									%>
										<option value="archi" selected>Archi</option>
										<option value="accessori-arco">Accessori Arco</option>
										<option value="accessori-arciere">Accessori Arciere</option>
										<option value="frecce">Frecce e Componenti</option>
										<option value="paglioni">Paglioni e Bersagli</option>
									<%
										} else
											if(p.getCategoria().equals("accessori-arco")){
									%>
									
											<option value="archi">Archi</option>
											<option value="accessori-arco" selected>Accessori Arco</option>
											<option value="accessori-arciere">Accessori Arciere</option>
											<option value="frecce">Frecce e Componenti</option>
											<option value="paglioni">Paglioni e Bersagli</option>
									<%
										} else
											if(p.getCategoria().equals("accessori-arciere")){
									%>		
												<option value="archi">Archi</option>
												<option value="accessori-arco">Accessori Arco</option>
												<option value="accessori-arciere" selected>Accessori Arciere</option>
												<option value="frecce">Frecce e Componenti</option>
												<option value="paglioni">Paglioni e Bersagli</option>
									
									<%
										} else
											if(p.getCategoria().equals("frecce")){
									%>			
												
												<option value="archi">Archi</option>
												<option value="accessori-arco">Accessori Arco</option>
												<option value="accessori-arciere">Accessori Arciere</option>
												<option value="frecce" selected>Frecce e Componenti</option>
												<option value="paglioni">Paglioni e Bersagli</option>	
												
									<%
										} else
											if(p.getCategoria().equals("paglioni")){
									%>
												
												<option value="archi">Archi</option>
												<option value="accessori-arco">Accessori Arco</option>
												<option value="accessori-arciere">Accessori Arciere</option>
												<option value="frecce">Frecce e Componenti</option>
												<option value="paglioni" selected>Paglioni e Bersagli</option>
									<%
											}
									%>
												
									</select>
							</div>
							<!-- form-group end.// -->
						</div>
						<!-- form-row.// -->
						<div class="errRow errRowNameCategory">
							<span class="error errNameHide">
									<small id="errorName" class="form-text text-danger">We'll never share your email..</small>
							</span>
							<span class="error error-second errCategoryHide">
									<small id="errorCategory" class="form-text text-danger">We'll never share your email..</small>
							</span>
						</div>
		
						<div class="form-row tipologyPriceRow">
							<div class="col form-group">
								<label>Tipologia</label> <input type="text" name="tipology" class="form-control tipology"
									value="<%=p.getTipologia() %>">
							</div>
							
							<%
								String priceS = Double.toString(p.getPrezzo());
							
								priceS = priceS.replace(",", ".");
								
								double price = Double.parseDouble(priceS);
							%>
							<div class="col form-group">
								<label>Prezzo</label> <input type="text" name="prezzo" class="form-control price"
									value="<%=price %>">
							</div>
							<!-- form-group end.// -->
						</div>
						
						<div class="errRow errRowTipologyPrice">
							<span class="error errTipologyHide">
									<small id="errorTipology" class="form-text text-danger">We'll never share your email..</small>
							</span>
							<span class="error error-second errPriceHide">
									<small id="errorPrice" class="form-text text-danger">We'll never share your email..</small>
							</span>
						</div>
						
						<div class="form-row disponibilityQuantityRow">
							<div class="col form-group">
								<label class="titleSelect">Disponibilità</label> 
									<select	class="custom-select dispSelect" name="disponibility">
									
									<%
										if(p.isDisponibilita()){
									%>
										<option value="true" selected>Disponibile</option>
										<option value="false">Non Disponibile</option>
										
									<%
										} else{
									%>
									
										<option value="true">Disponibile</option>
										<option value="false" selected>Non Disponibile</option>
										
									<%
										}
									%>
											
									</select>
							</div>
							<!-- form-group end.// -->
							<div class="col form-group">
								<label>Quantità</label> <input type="number" name="quantity" min="0" class="form-control quantity"
									value="<%=p.getQuantita() %>">
							</div>
							<!-- form-group end.// -->
						</div>
						
						<div class="errRow errRowDisponibilityQuantity">
							<span class="error errDisponibilityHide">
									<small id="errorDisponibility" class="form-text text-danger">We'll never share your email..</small>
							</span>
							<span class="error error-second errQuantityHide">
									<small id="errorQuantity" class="form-text text-danger">We'll never share your email..</small>
							</span>
						</div>
						
						
						<div class="form-row descriptionRow">
							<div class="col form-group">
								<label>Descrizione</label> <input type="text" name="description" class="form-control description"
									value="<%=p.getDescrizione() %>">
							</div>
							<!-- form-group end.// -->
						</div>
						
						<div class="errRow errRowDescription">
							<span class="error errDescriptionHide">
									<small id="errorDescription" class="form-text text-danger">We'll never share your email..</small>
							</span>
						</div>
						
						<div class="form-row imageUploadRow">
							<div class="col form-group">
								<label>Immagine prodotto</label>
								<div class="custom-file">
									<input type="file" name="file" accept="image/*" class="custom-file-input form-control" id="inputGroupFile01" value="null">
    								<label class="custom-file-label" for="inputGroupFile01">Carica immagine...</label>
								</div>
							</div>
							<!-- form-group end.// -->
						</div>
					
		
						<button type="submit" class="btn btn-primary btn-block save-btn">Modifica il prodotto</button>
					</form>
				</div>
				<!-- card-body.// -->
			</div>
			<!-- card .// -->
		</div>
		
		<%
			}
		%>
			
			
		<div class="eArrow-footer">
			<jsp:include page="Footer.jsp"/>
		</div>
		
		<!-- Bootstrap Script -->	
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>	
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/AdminInsertModifyProductCheckJS.js"></script>
		<script type="text/javascript">
            $('#inputGroupFile01').on('change',function(){
                //get the file name
                var fileName = $(this).val();
                //replace the "Choose a file" label
                var cleanFileName = fileName.replace('C:\\fakepath\\', "");
                $(this).next('.custom-file-label').html(cleanFileName);
            });
        </script>
	</body>
</html>