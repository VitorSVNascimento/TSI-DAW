<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Buscando paciente para laudo e exame</title>
		<link rel="stylesheet" href="css/consulta-paciente.css">
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		
		<h1>Buscando paciente</h1>
		<c:choose>
	    	<c:when test="${sessionScope.tipo == 'medico' || sessionScope.tipo == 'medico_residente' || sessionScope.tipo == 'medico_docente'}">
				<form action="controladora" method="post">
	    			<p id="mensagem">Buscando paciente para consultar laudo e exame</p>
	    			<p id="mensagem">
						<b>CPF: </b>
						<input type="text" name="cpf" maxlength="11"/>
					</p>
					<input type="hidden" name="logica" value="ConsultaLaudoExame"/>	
					<p id="input"><input type="submit" value="Consultar"/></p>
	    		</form>
	    	</c:when>
	    	<c:otherwise>
	        	<jsp:forward page="login.jsp"/> <!-- Redireciona para a página de login se não for um médico -->
	    	</c:otherwise>
	    </c:choose>
</html>