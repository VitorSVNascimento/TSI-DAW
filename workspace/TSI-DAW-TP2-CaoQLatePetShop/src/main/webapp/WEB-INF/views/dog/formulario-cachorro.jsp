<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Registre seu cachorro</title>
	</head>
	<body>
	<div class="container">
	
		<jsp:include page="../cabecalho.jsp"></jsp:include>
		<h3>Faça o registro do seu cachorro para ter acesso ao nossos serviços, e deixa-lo ainda mais feliz :)</h3>
		<c:if test="${not empty message}">
			<h2>${message}</h2>
		</c:if>
		
		
		<form:form action="registrar-cachorro" method="post" modelAttribute="dog">
			
			<div class="mb-3">
				<label for="cac_nome" class="form-label">Nome do seu lindo cachorro </label>
				 <input id="cac_nome" type="text" name="name">
				<div>
					<form:errors path="name" id="name" cssClass="text-danger"></form:errors>
				</div>			
			</div>
			
			<div class="mb-3">
				<label for="raca_do" class="form-label">Qual a raça dele?</label>
				<input id="raca_do" type="text" name="breed">
				<div>
					<form:errors path="breed" id="breed" cssClass="text-danger"></form:errors>
				</div>
			</div>
			
			<div class="mb-3">
				E o tamanho? 
				<label>
					<input type="radio" name="size" value="pequeno">Pequeno 
				</label>
				<label>
					<input type="radio" name="size" value="medio">Médio
				</label>
				<label>
					<input type="radio" name="size" value="grande">Grande
				</label>
			
			</div>
		
			<button type="submit" class="btn btn-primary">Registrar</button>
		</form:form>
	</div>
		
	</body>
</html>