<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="autenticacao.jsp"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Menu médico</title>
	</head>
	
	<body>
		<c:import url="cabecalho.jsp"/>
		<h1>Solicitação de pedido de exame</h1>
		<p>Buscando paciente</p>
		<form action="controladora" method="post">
			<b>CPF:</b>
			<input type="text" name="cpf" maxlength="11"/>
			<b>Escolha o tipo de exame:</b>
			<select id="tipoExame" name="tipoExame">
			  <option value="ecocardiograma">Ecocardiograma</option>
			  <option value="eletrocardiograma">Eletrocardiograma</option>
			</select>
			<input type="hidden" name="logica" value="ConsultaPaciente"/>	
			<p><input type="submit" value="Consultar"/></p>
		</form>
	</body>
</html>