<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.tsi.daw.tp1.modelo.PedidoExame" %>
<%@ page import="br.tsi.daw.tp1.dao.PedidoExameDAO" %>
<%@ page import="br.tsi.daw.tp1.modelo.CaminhoPDF" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="autenticacao-medicoR.jsp"%>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="ISO-8859-1">
	    <title>Gerar laudo do exame</title>
	    <link rel="stylesheet" href="css/gerar-laudo.css">
	    
	</head>
	<body>
	    <c:import url="cabecalho.jsp"/>
	    <c:set var="exameId" value="${param.id}"/>
	    <c:set var="dao" value="<%= new br.tsi.daw.tp1.dao.PedidoExameDAO() %>" />
	    <c:set var="exameG" value="${dao.obterPedidoExamePorId(exameId)}"/>
	    
	    <h1>Gerar Laudo do exame</h1>
	    <c:if test="${not empty exameG}">
	        <form action="controladora" method="post">
	            <c:set var="caminhoP" value="<%= new br.tsi.daw.tp1.modelo.CaminhoPDF() %>" />
	            <c:choose>
	                <c:when test="${exameG.exameSolicitado eq 'ecocardiograma'}">
	                    <c:set var="caminho" value="${caminhoP.extrairCaminhoRelativo(exameG.imagePdf, exameG.exameSolicitado)}"/>
	                </c:when>
	                <c:when test="${exameG.exameSolicitado eq 'eletrocardiograma'}">
	                    <c:set var="caminho" value="${caminhoP.extrairCaminhoRelativo(exameG.imagePdf, exameG.exameSolicitado)}"/>
	                </c:when>
	            </c:choose>
	
	            <!-- Contêiner para o PDF -->
	            <div class="pdf-container">
	                <object data="${caminho}?version=${timestamp}" type="application/pdf" width="100%" height="800px">
        				<p>Seu navegador não suporta PDF. Você pode <a href="${caminho}">baixá-lo aqui</a>.</p>
    				</object>
	            </div>
	            
	            <p><b>Descrição: </b></p>
	            <p><textarea id="descricao" name="descricao" rows="3" cols="99"></textarea></p>
	            <p><b>Conclusão: </b></p>
	            <p><textarea id="conclusao" name="conclusao" rows="5" cols="99"></textarea></p>
	            
	            <input type="hidden" name="id" value="${exameG.id}"/>
	            <input type="hidden" name="logica" value="GerarLaudo"/>
	            <p id="input"><input type="submit" value="Gerar laudo"/></p>
	        </form>
	    </c:if>
	    
	    <c:if test="${empty exameG}">
	        <p>Nenhum exame foi realizado!</p>
	    </c:if>
	</body>
</html>
