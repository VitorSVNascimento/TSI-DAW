<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="autenticacao.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Menu-Principal</title>
	</head>
	<body>
		<h1>Bem Vindo! ${sessionScope.nome_medico}</h1>
		
		<form method="post" action="controladora" >
		<input type="hidden" name="logica" value="EfetuaLogout">
		<h3> <input type="submit" value="Clique para fazer logout"></h3>
		
		</form>
		<h2>${sessionScope.categoria}</h2>
		
		<c:if test="${sessionScope.categoria == 'Médico Residente'}">
			
			<form method="post" action="controladora" >
				<input type="hidden" name="logica" value="ObterExames">
				<h3> <input type="submit" value="Exames do dia"></h3>
		
			</form>
			
			<form method="post" action="controladora" >
				<input type="hidden" name="logica" value="ObterExamesAguardandoLaudo">
				<h3> <input type="submit" value="Realizar Laudos"></h3>
		
			</form>
		</c:if>
		
		<c:if test="${sessionScope.categoria == 'Médico'}">
			<h2><a href="pedir-exame-cpf.jsp">Efetuar Pedido de Exame </a></h2>
			<h2><a href="consultar-laudo-cpf.jsp">Consultar Laudos </a></h2>
		</c:if>
		
		<c:if test="${sessionScope.categoria == 'Médico Docente'}">
			<form method="post" action="controladora" >
				<input type="hidden" name="logica" value="ObterLaudosParaAvaliacao">
				<h3> <input type="submit" value="Avaliar Laudos"></h3>
		
			</form>
		</c:if>
	</body>
</html>