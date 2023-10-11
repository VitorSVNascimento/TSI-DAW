<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Menu-Principal</title>
	</head>
	<body>
		<h1>Este � o menu principal</h1>
		<h2>${sessionScope.categoria }</h2>
		<c:if test="${sessionScope.categoria == 'M�dico Residente'}">
			<h2><a href="realizar-exame.jsp">Realizar exame </a></h2>
		</c:if>
		<c:if test="${sessionScope.categoria == 'M�dico'}">
			<h2><a href="pedir-exame-cpf.jsp">Efatuar Pedido de Exame </a></h2>
		</c:if>
		<c:if test="${sessionScope.categoria == 'M�dico Docente'}">
			<h2><a href="pedir-exame.jsp">Avaliar Laudos </a></h2>
		</c:if>
	</body>
</html>