<%@page import="br.tsi.daw.tp1.dao.LaudoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="autenticacao-medicoD.jsp"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Avaliação Laudo parte 2</title>
		<link rel="stylesheet" href="css/gerar-laudo.css">
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		
		<c:set var="laudoId" value="${param.id}"/>
		<c:set var="dao" value="<%= new br.tsi.daw.tp1.dao.LaudoDAO() %>"/>
		<c:set var="laudo" value="${dao.obterLaudoPorId(laudoId)}"/>
		
		<h1>Avaliação do Laudo</h1>
		<c:if test="${not empty laudoId}">
			<form action="controladora" method="post">
				<c:set var="caminhoP" value="<%= new br.tsi.daw.tp1.modelo.CaminhoPDF() %>"/>
				<c:choose>
					<c:when test="${laudo.pedidoExame.exameSolicitado eq 'ecocardiograma'}">
						<c:set var="caminho" value="${caminhoP.extrairCaminhoRelativo(laudo.pedidoExame.imagePdf, laudo.pedidoExame.exameSolicitado)}"/>
					</c:when>
					<c:when test="${laudo.pedidoExame.exameSolicitado eq 'eletrocardiograma'}">
						<c:set var="caminho" value="${caminhoP.extrairCaminhoRelativo(laudo.pedidoExame.imagePdf, laudo.pedidoExame.exameSolicitado)}"/>
					</c:when>
				</c:choose>
				<div class="pdf-container">
                	<embed src="${caminho}" type="application/pdf" width="100%" height="100%" />
            	</div>
				
				<p><b>Descrição :</b></p>
				<p><input type="text" value="${laudo.descricao}" readonly/></p>
				
				<p><b>Conclusão :</b></p>
				<p><input type="text" value="${laudo.conclusao}" readonly/></p>
				
				<input type="hidden" name="id" value="${laudo.id}"/>
            	<input type="hidden" name="logica" value="AvaliacaoLaudo"/>
            	<p id="input"><input type="submit" value="Confirmar avaliação do laudo"/></p>
			</form>
		</c:if>
		
	</body>
</html>