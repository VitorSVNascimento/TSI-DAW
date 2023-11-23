<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="autenticacao.jsp"%>

<!DOCTYPE html>
<html>

	<head>
	<meta charset="ISO-8859-1">
	<title>Recupera paciente</title>
	<link rel="stylesheet" href="css/procura-paciente.css">
	</head>
	
	<body>
		<c:import url="cabecalho.jsp"/>
		<h1>Solicitação de pedido de exame</h1>
		<form action="controladora" method="post">
			<p id="mensagem">Buscando paciente pelo cpf.</p>
			<p>
				<b>CPF:</b>
				<input type="text" name="cpf" maxlength="11"/>
			</p>
			<p>
				<b>Escolha o tipo de exame:</b>
				<select id="tipoExame" name="tipoExame">
				  <option value="ecocardiograma">Ecocardiograma</option>
				  <option value="eletrocardiograma">Eletrocardiograma</option>
				</select>
			</p>
			<input type="hidden" name="logica" value="ConsultaPaciente"/>	
			<p id="input"><input type="submit" value="Consultar"/></p>
		</form>
	</body>
</html>