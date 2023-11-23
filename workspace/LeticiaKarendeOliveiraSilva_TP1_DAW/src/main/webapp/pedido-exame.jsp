<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="autenticacao.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Pedido Exame</title>
		<link rel="stylesheet" href="css/pedido-exame.css">
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		
		<h1>Solicitação de Pedido de exame:</h1>
    	
    	<form action="controladora" method="post">
    			<h2>Dados do paciente</h2>
    			<p><b>Nome do paciente: </b> <c:out value="${paciente.nome}"/></p>
	        	<p><b>Cpf: </b> <c:out value="${paciente.cpf}"/></p>
	        	<p><b>E-mail: </b> <c:out value="${paciente.email}"/></p>
	        	<p><b>Sexo: </b> <c:out value="${paciente.sexo}"/></p>
	        	<p><b>Data de nascimento: </b> <c:out value="${paciente.dataNascimento}"/></p>
	        	<p><b>Idade: </b> <c:out value="${paciente.idade}" />anos</p>
	        	
	        	<h2>Dados do Médico</h2>
	        	<p><b>Nome médico: </b> <c:out value="${sessionScope.nome}"/></p>
	        	<p><b>Crm médico: </b> <c:out value="${sessionScope.crm}"/></p>
	        	
	        	<h2>Dados Exame</h2>
	        	<p><b>Exame:</b> <c:out value="${tipoExame}"/></p>
	        	<p><b>Escolha a hipótese diagnóstica: </b>
				<select id="hipoteseDiagnostica" name="hipoteseDiagnostica">
			  		<option value="I46- Parada cardiaca">I46- Parada cardíaca</option>
			  		<option value="I47- Taquicardia paroxistica">I47- Taquicardia paroxística</option>
			  		<option value="I48- Flutter e fibrilacao atrial">I48- Flutter e fibrilacao atrial</option>
			  		<option value="I49- Outras arritmias cardiacas">I49- Outras arritmias cardíacas</option>
			  		<option value="I42- Cardiomiopatias">I42- Cardiomiopatias</option>
				</select>
				</p>
				<p><b>Recomendações para o exame: </b></p>
				<p><textarea id="recomendacoes" name="recomendacoes" rows="3" cols="33"></textarea></p>
				
				<input type="hidden" name="nomePaciente" value="${paciente.nome}" />
			    <input type="hidden" name="cpf" value="${paciente.cpf}" />
			    <input type="hidden" name="email" value="${paciente.email}" />
			    <input type="hidden" name="sexo" value="${paciente.sexo}" />
			    <input type="hidden" name="dataNascimento" value="${paciente.dataNascimento}" />
			    <input type="hidden" name="idade" value="${paciente.idade}" />
			    <input type="hidden" name="tipoExame" value="${tipoExame}" />
			    <input type="hidden" name="nomeMedico" value="${sessionScope.nome}" />
			    <input type="hidden" name="crmMedico" value="${sessionScope.crm}" />
				<input type="hidden" name="logica" value="EmitePedidoDeExame"/>
				<p id="input"><input type="submit" value="Emitir pedido"/></p>
	    </form>
	    
	</body>
</html>