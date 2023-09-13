<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Aluno adicionado</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		<h2>Aluno ${param.nome} adicionado com sucesso</h2><br><br>
		<c:import url="rodape.jsp"/>
	</body>
</html>