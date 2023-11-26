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
		<jsp:include page="../cabecalho.jsp"></jsp:include>
		
		<c:if test="${not empty message}">
			<h2>${message}</h2>
		</c:if>
		<form:form action="registrar-servico" method="post" modelAttribute="service">
			<form:errors path="name" id="name" cssClass="form-error"></form:errors>
			Nome: <input type="text" name="name">
			<form:errors path="name" id="name" cssClass="form-error"></form:errors>
			Valor R$: <input type="number" name="price" step="0.01">
			
			<input type="submit" value="Registrar">
		</form:form>		
	</body>
</html>