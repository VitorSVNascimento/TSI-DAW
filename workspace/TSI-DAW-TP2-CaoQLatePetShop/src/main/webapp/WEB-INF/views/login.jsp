<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Faça seu login</title>
	</head>
	<body>
		<jsp:include page="cabecalho.jsp"></jsp:include>
		<h1>Prencha os dados para fazer login</h1>
		
		<c:if test="${not empty message}">
			<c:forEach items="${message}" var="item">
				<h2>${item}</h2>
			</c:forEach>
		</c:if>
		
		<form action="login-validate" method="post">
		
			Email:<input type="text" name="email">
			Senha:<input type="text" name="password">
			
			<input type="submit" value="Logar">
			
		</form>
		
		
	
	</body>
</html>