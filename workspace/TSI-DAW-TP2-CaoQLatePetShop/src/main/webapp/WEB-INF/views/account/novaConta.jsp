<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Cliente</title>
</head>
<body>
		<h3> Novo Cliente</h3>
		<c:if test="${not empty message}">
			<h2>${message}</h2>
		</c:if>
		<form:form action="adicionarConta" method="post" modelAttribute="account">
		<form:errors path="name" id="name" cssClass="form-error"></form:errors>
			Nome: <input type="text" name="name">
		<form:errors path="cpf" id="cpf" cssClass="form-error"></form:errors>
			CPF: <input type="text" name="cpf">
		Data de Nascimento:<input type="date" name="birthday">
		<form:errors path="email" id="email" cssClass="form-error"></form:errors>
			Email: <input type="text" name="email">
			Senha: <input type="text" name="password">
			Telefone: <input type="text" name="telephone">
			
			
			<input type="submit" value="Registrar">
		</form:form>
</body>
</html>