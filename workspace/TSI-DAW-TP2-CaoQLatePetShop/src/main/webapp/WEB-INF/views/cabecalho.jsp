<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
	
		<c:if test="${empty user and empty employee}">
			<a href="novaConta">Fazer cadastro</a>
			<a href="formulario-admin">Pagina do administrador</a>
		</c:if>

		<c:if test="${not empty user}">
			<a href="formulario-cachorro">Registrar cachorro</a>
			<a href="scheduling-form">Agendar atendimento</a>
			<a href="logout">clique para fazer logout</a>
		</c:if>

		<c:if test="${not empty employee}">
			<a href="service-page">Registrar serviço</a>
			<a href="employee-logout">clique para deslogar</a>
		</c:if>
		
	</div>
</body>
</html>