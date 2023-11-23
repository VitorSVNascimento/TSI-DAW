<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width-device-width, initial-scale-'.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>Cabeçalho do site</title>
		<link rel="stylesheet" href="css/cabecalho.css">
	</head> 
	<body>
		<c:choose>
	    	<c:when test="${sessionScope.tipo == 'medico' || sessionScope.tipo == 'medico_residente' || sessionScope.tipo == 'medico_docente'}">
	        	<!-- Conteúdo permitido para todos os tipos de médico -->
	        	<div class="header">
				    <div class="medcar">
				      <p>MEDCAR</p>
				      <img src="imagemCabecalho/coracao.png" alt="Logo MEDCAR">
				    </div>
				    <a href=controladora?logica=EfetuaLogout class="sair">Sair</a>
			  </div>
	    	</c:when>
	    	<c:otherwise>
	        	<jsp:forward page="login.jsp"/> <!-- Redireciona para a página de login se não for um médico -->
	    	</c:otherwise>
		</c:choose>
		
	</body>
</html>