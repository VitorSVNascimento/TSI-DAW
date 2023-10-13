<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="autenticacaoDemaisMedicos.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina de exame</title>
</head>
<body>
	<form method="post" action="controladora">
		CPF do paciente: <input type="text" name="cpf">
		<input type="hidden" name="logica" value="ObterDadosPaciente">
		<input type="submit">
	</form>
	
	
</body>
</html>