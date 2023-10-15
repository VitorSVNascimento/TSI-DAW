<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="webjars/bootstrap/5.0.2/css/bootstrap.min.css">
		<title>Menu-Principal</title>
	</head>
	<body class="text-center">
		<div class="container bg-info mb-4 mt-2">
			<h1 >Bem Vindo! ${sessionScope.nome_medico}</h1>
			
			<form method="post" action="controladora" >
			<input type="hidden" name="logica" value="EfetuaLogout">
			<input class="btn btn-info text-primary " type="submit" value="Clique para fazer logout">
			
			</form>
		
		</div>
		
		<c:if test="${sessionScope.categoria == 'Médico Residente'}">
			
			<form class="d-inline" method="post" action="controladora" >
				<input type="hidden" name="logica" value="ObterExames">
				<h3> <input class="btn btn-success inline m-5 text-lg" type="submit" value="Exames do dia"></h3>
		
			</form>
			
			<form class="d-inline" method="post" action="controladora" >
				<input type="hidden" name="logica" value="ObterExamesAguardandoLaudo">
				<h3> <input class="btn btn-success m-5  text-lg" type="submit" value="Realizar Laudos"></h3>
		
			</form>
		</c:if>
		
		<c:if test="${sessionScope.categoria == 'Médico'}">
			<a class="btn btn-success m-5 text-lg" href="pedir-exame-cpf.jsp">Efetuar Pedido de Exame </a>
			<a class="btn btn-success m-5 text-lg" href="consultar-laudo-cpf.jsp">Consultar Laudos </a>
		</c:if>
		
		<c:if test="${sessionScope.categoria == 'Médico Docente'}">
			<form method="post" action="controladora" >
				<input type="hidden" name="logica" value="ObterLaudosParaAvaliacao">
				<h3> <input class="btn btn-success m-5 text-lg" type="submit" value="Avaliar Laudos"></h3>
		
			</form>
		</c:if>
	</body>
</html>