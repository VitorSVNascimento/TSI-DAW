<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.tsi.daw.tp1.modelo.PedidoExame" %>
<%@ page import="br.tsi.daw.tp1.dao.PedidoExameDAO" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="autenticacao-medicoR.jsp"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Realização exame</title>
	</head>
	<body>
		<c:set var="exameId" value="${param.id}" />
		<c:set var="dao" value="<%= new br.tsi.daw.tp1.dao.PedidoExameDAO() %>" />
		<c:set var="pedidoExame" value="${dao.obterPedidoExamePorId(exameId)}" />
		
		<h1>Realização de exame</h1>
		<c:out value="${param.id}" />
		<c:if test="${not empty pedidoExame}">
			<form action="controladora" method="post">
				<b>CPF: </b><c:out value="${pedidoExame.paciente.cpf}" /><br />
				<b>Tipo de Exame: </b><c:out value="${pedidoExame.exameSolicitado}" />
				<input type="hidden" name="tipoExame" value="${pedidoExame.exameSolicitado}"/>
				<input type="hidden" name="logica" value="RealizacaoDoExame"/>
				<p><input type="submit" value="Gerar PDF"/></p>
			</form>
		</c:if>
		
		<c:if test="${empty pedidoExame}">
			<p>Nenhum pedido de exame encontrado para o ID ${exameId}</p>
		</c:if>
	</body>
</html>
