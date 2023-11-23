<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="autenticacao-medicoD.jsp"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Avaliação dos laudos</title>
		<link rel="stylesheet" href="css/exibicao-tabela.css">
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		<h1>Avaliação de laudos</h1>
		<jsp:useBean id="dao" class="br.tsi.daw.tp1.dao.LaudoDAO"/>
		
		<table border="1">
			<thead>
				<tr>
					<th>Id do laudo</th>
					<th>Id do Exame</th>
					<th>Status Laudo</th>
					<th>Avaliar laudo</th>
				</tr>
			</thead>
			<c:forEach var="laudo" items="${dao.laudosParaAvaliar()}">
				<tr>
					<td>${laudo.id}</td>
					<td>${laudo.pedidoExame.id}</td>
					<td>${laudo.status}</td>
					<td><a href="avaliacao-laudo2.jsp?id=${laudo.id}">
		                                Avaliar</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>