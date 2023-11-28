<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Registrar novo serviço</title>
	</head>
	<body>
	<div class="container">
	
		<jsp:include page="../cabecalho.jsp"></jsp:include>
		
		<c:if test="${not empty message}">
			<h2>${message}</h2>
		</c:if>
		<form:form action="registrar-servico" method="post" modelAttribute="service">
			<div class="mb-3">
				<label for="nameas_id" class="form-label">Nome</label>
				<input id="nameas_id" type="text" name="name">
				<div >
					<form:errors path="name" id="name" cssClass="text-danger"></form:errors>
				</div>
			</div>
			<div class="mb-3">
				<label for="numberas_id" class="form-label">Valor R$</label>
				<input type="number" name="price" step="0.01" id="numberas_id">
				<div>
					<form:errors path="price" id="price" cssClass="text-danger"></form:errors>
				
				</div>
			</div>
			
			
			<button type="submit" class="btn btn-primary">Registrar</button>
		</form:form>		
	</div>
	</body>
</html>