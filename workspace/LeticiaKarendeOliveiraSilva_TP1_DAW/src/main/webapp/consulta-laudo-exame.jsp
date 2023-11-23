<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Consulta laudos e exames</title>
		<link rel="stylesheet" href="css/exibicao-tabela.css">
	</head>
	<body>
	<c:import url="cabecalho.jsp"/>
		<c:choose>
	    	<c:when test="${sessionScope.tipo == 'medico' || sessionScope.tipo == 'medico_residente' || sessionScope.tipo == 'medico_docente'}">
				<h1>Consulta a Laudos e Exames</h1>
				<jsp:useBean id="dao" class="br.tsi.daw.tp1.dao.LaudoDAO"/>
				<table border="1">
					<thead>
						<tr>
							<th>Id do laudo</th>
							<th>Id do Exame</th>
							<th>Status Laudo</th>
							<th>Laudo/Exame</th>
						</tr>
						</thead>
						<c:forEach var="laudo" items="${dao.listaLaudosPaciente(requestScope.cpfPaciente)}">
							<tr>
								<td>${laudo.id}</td>
								<td>${laudo.pedidoExame.id}</td>
								<td>${laudo.status}</td>
								<td><a href="consulta-laudoE.jsp?id=${laudo.id}">
		                                Consultar</a></td>
							</tr>
						</c:forEach>
				</table>
	    	</c:when>
	    	<c:otherwise>
	        	<jsp:forward page="login.jsp"/> <!-- Redireciona para a página de login se não for um médico -->
	    	</c:otherwise>
	    </c:choose>
	</body>
</html>