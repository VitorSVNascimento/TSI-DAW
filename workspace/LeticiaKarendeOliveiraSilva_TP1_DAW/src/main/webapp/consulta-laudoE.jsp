<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Consulta Laudo</title>
		<link rel="stylesheet" href="css/exibicao-dados.css">
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		<c:choose>
	    	<c:when test="${sessionScope.tipo == 'medico' || sessionScope.tipo == 'medico_residente' || sessionScope.tipo == 'medico_docente'}">
				<h1>Consulta a Laudo e Exame</h1>
				<c:set var="laudoId" value="${param.id}"/>
				<c:set var="dao" value="<%= new br.tsi.daw.tp1.dao.LaudoDAO() %>"/>
				<c:set var="laudo" value="${dao.obterLaudoPorId(laudoId)}"/>
				
				<h2>Dados do Médico</h2>
				<p>
					<b>Nome do Médico Responsável: </b>
					<input type="text" value="${laudo.pedidoExame.medico.nome}" readonly/>
				</p>
				<p>
					<b>Crm do Médico Responsável: </b>
					<input type="text" value="${laudo.pedidoExame.medico.crm}" readonly/>
				</p>
				
				<h2>Dados do Paciente</h2>
				<p>
				<b>Nome do Paciente: </b>
				<input type="text" value="${laudo.pedidoExame.paciente.nome}" readonly/>
				</p>
				<p>
					<b>Cpf: </b>
					<input type="text" value="${laudo.pedidoExame.paciente.cpf}" readonly/>
				<p/>
				<p>
					<b>Idade: </b>
					<input type="text" value="${laudo.pedidoExame.paciente.idade} anos" readonly/>
				<p/>
				<p>
					<b>Sexo: </b>
					<input type="text" value="${laudo.pedidoExame.paciente.sexo}" readonly/>
				<p/>
				<p>
					<b>E-mail: </b>
					<input type="text" value="${laudo.pedidoExame.paciente.email}" readonly/>
				<p/>
				
				<h2>Dados Exame</h2>
				<p>
					<b>Tipo de Exame: </b>
					<input type="text" value="${laudo.pedidoExame.exameSolicitado}" readonly/>
				<p/>
				<p>
					<b>Data Realização: </b>
					<input type="text" value="${laudo.pedidoExame.dataRealizada}" readonly/>
				<p/>
				<p>
					<b>Exame</b>
				<p/>
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
                	<embed src="${caminho}" type="application/pdf" width="100%" height="800px" />
            	</div>
				
				<h2>Dados Laudo</h2>
				<p id="maior">
					<b>Descrição :</b>
					<input type="text" value="${laudo.descricao}" readonly/>
				<p/>
				<p id="maior">
					<b>Conclusão :</b>
					<input type="text" value="${laudo.conclusao}" readonly/>
				<p/>
				<form action="menu-principal.jsp">
					<button class ="button">Voltar a tela principal</button>
				</form>
			</c:when>
	    	<c:otherwise>
	        	<jsp:forward page="login.jsp"/> <!-- Redireciona para a página de login se não for um médico -->
	    	</c:otherwise>
	    </c:choose>
	</body>
</html>