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
		<link rel="stylesheet" href="css/exibicao-dados.css">
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		<c:set var="exameId" value="${param.id}" />
		<c:set var="dao" value="<%= new br.tsi.daw.tp1.dao.PedidoExameDAO() %>" />
		<c:set var="pedidoExame" value="${dao.obterPedidoExamePorId(exameId)}" />
		
		<h1>Dados para a Realização de exame</h1>
		<c:out value="${param.id}" />
		<c:if test="${not empty pedidoExame}">
			<form action="controladora" method="post">
				<h2>Dados Médico</h2>
				<p><b>Nome: </b><c:out value="${pedidoExame.medico.nome}"/></p>
				<p><b>Crm: </b><c:out value="${pedidoExame.medico.crm}"/></p>
				
				<h2>Dados do Paciente</h2>
				<p><b>Cpf: </b><c:out value="${pedidoExame.paciente.cpf}" /></p>
				<p><b>Nome: </b><c:out value="${pedidoExame.paciente.nome}"/></p>
				
				<h2>Dados do Exame</h2>
				<p><b>Pedido ID: </b><c:out value="${pedidoExame.id}"/></p>
				<p><b>Tipo de Exame: </b><c:out value="${pedidoExame.exameSolicitado}"/></p>
				<p><b>Hipotése Diagóstica: </b><c:out value="${pedidoExame.hipotseDiagnostica}"/></p>
				
				<input type="hidden" name="tipoExame" value="${pedidoExame.exameSolicitado}"/>
				<input type="hidden" name="id" value="${pedidoExame.id}"/>
				<input type="hidden" name="logica" value="RealizacaoDoExame"/>
				<p id="input"><input type="submit" value="Gerar Exame"/></p>
			</form>
		</c:if>
		
		<c:if test="${empty pedidoExame}">
			<p>Nenhum pedido de exame encontrado para o ID ${exameId}</p>
		</c:if>
	</body>
</html>
