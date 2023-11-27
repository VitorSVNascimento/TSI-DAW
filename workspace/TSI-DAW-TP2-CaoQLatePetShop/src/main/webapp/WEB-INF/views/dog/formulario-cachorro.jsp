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
		<jsp:include page="../cabecalho.jsp"></jsp:include>
		<h1>Faça o registro do seu cachorro para ter acesso ao nossos serviços, e deixa-lo ainda mais feliz :)</h1>
		<c:if test="${not empty message}">
			<h2>${message}</h2>
		</c:if>
		<form:form action="registrar-cachorro" method="post" modelAttribute="dog">
			<form:errors path="name" id="name" cssClass="form-error"></form:errors>
			Nome do seu lindo cachorro : <input type="text" name="name">
			<form:errors path="breed" id="breed" cssClass="form-error"></form:errors>
			Qual a raça dele? <input type="text" name="breed">
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
			<input type="submit" value="Registrar">
		</form:form>
		
	</body>
</html>