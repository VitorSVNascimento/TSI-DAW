<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Registrar novo serviço</title>
	</head>
	<body>
		<jsp:include page="../cabecalho.jsp"></jsp:include>
		<form action="registrar-servico" method="post">
			Nome: <input type="text" name="name">
			Valor R$: <input type="number" name="price">
			
			<input type="submit" value="Registrar">
		</form>		
	</body>
</html>