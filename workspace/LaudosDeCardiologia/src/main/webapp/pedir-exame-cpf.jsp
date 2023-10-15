<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@include file="autenticacaoDemaisMedicos.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Obter dados do paciente</title>
<link rel="stylesheet" href="webjars/bootstrap/5.0.2/css/bootstrap.min.css">
</head>
<body class="align-middle">
	<div class="container">

		<form method="post" action="controladora">
		<div class="mb-3 mt-5">
			<label class="form-label" for="cpf_input">CPF do paciente</label>
			 <input class="form-control" id="cpf_input" type="text" name="cpf">
		
		</div>
			<input type="hidden" name="logica" value="ObterDadosPaciente">
			<div class="mt-3">
				<input class="btn btn-primary" type="submit" value="Buscar">
			
			</div>
		</form>

	</div>
	
	
</body>
</html>