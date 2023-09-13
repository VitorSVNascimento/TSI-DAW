<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Nav Bar</title>
	</head>
	<body>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="menu-principal.jsp">Agenda Contatos</a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    <div class="collapse navbar-collapse" id="navbarNav">
			      <ul class="navbar-nav">
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="adiciona-contato.jsp">Adicionar Contato</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="lista-contato.jstl.jsp">Todos os Contatos</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="remover-contato.jsp">Remover Contato</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="obter-id-alteracao.jsp" tabindex="-1" aria-disabled="true">Alterar Contato</a>
			        </li>
			      </ul>
			    </div>
			  </div>
			</nav>
			
			<form action="controladora">
				<input type="hidden" name="logica" value="EfetuaLogout">
				<input type="submit" value="logout">
			
			</form>
	</body>
</html>