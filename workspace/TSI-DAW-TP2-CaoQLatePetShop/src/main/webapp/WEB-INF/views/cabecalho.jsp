<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
  <a class="navbar-brand" href="#">Menu</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
		<c:if test="${empty user and empty employee}">
			<li class="nav-item">
				<a class="nav-link" href="novaConta">Fazer cadastro</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="formulario-admin">Pagina do administrador</a>
			
			</li>
		</c:if>

		<c:if test="${not empty user}">
			<li class="nav-item">
				<a class="nav-link" href="formulario-cachorro">Registrar cachorro</a>			
			</li>
			<li class="nav-item">
				<a class="nav-link" href="scheduling-form">Agendar atendimento</a>			
			</li>
			<li class="nav-item">
				<a class="nav-link" href="servicos-agendados">Serviços Agendados</a>
			
			</li>
			<li class="nav-item">
				<a class="nav-link" href="excecuted-scheduling">Serviços Realizados</a>
			
			</li>
			<li class="nav-item">
				<a class="nav-link" href="logout">clique para fazer logout</a>
			
			</li>
		
		</c:if>

		<c:if test="${not empty employee}">
			<li class="nav-item">
				<a class="nav-link" href="service-page">Registrar serviço</a>
			
			</li>
			<li class="nav-item">
				<a class="nav-link" href="agenda-servico-admin">Agenda de serviços</a>
			
			</li>
			<li class="nav-item">
				<a class="nav-link" href="provided-services-admin">Relatório de serviços prestados</a>			
			
			</li>
			<li class="nav-item">
				<a class="nav-link" href="employee-logout">clique para deslogar</a>
			
			</li>
		</c:if>
    </ul>
  </div>
</nav>
	

	
</body>
</html>