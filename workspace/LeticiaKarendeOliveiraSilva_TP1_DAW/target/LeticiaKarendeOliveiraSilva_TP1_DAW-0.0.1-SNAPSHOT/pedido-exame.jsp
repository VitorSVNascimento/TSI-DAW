<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="autenticacao.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		<h1>Solicitação de Pedido de exame:</h1>
    	
    	<form action="controladora" method="post">
    			<h2>Dados do paciente</h2><br>
    			<b>nome do paciente:</b> <c:out value="${paciente.nome}"/>
	        	<b>cpf: </b> <c:out value="${paciente.cpf}"/>
	        	<b>e-mail: </b> <c:out value="${paciente.email}"/>
	        	<b>sexo: </b> <c:out value="${paciente.sexo}"/>
	        	<b>data de nascimento: </b> <c:out value="${paciente.dataNascimento}"/>
	        	<b>idade: </b> <c:out value="${paciente.idade}" />anos
	        	<br>
	        	<b>exame:</b> <c:out value="${tipoExame}"/>
	        	<b>nome médico:</b> <c:out value="${sessionScope.nome}"/>
	        	<b>crm médico</b> <c:out value="${sessionScope.crm}"/>
	        	<b>Escolha a hipótese diagnóstica:</b>
				<select id="hipoteseDiagnostica" name="hipoteseDiagnostica">
			  		<option value="paradaCardiaca">I46- Parada cardíaca</option>
			  		<option value="taquicardia">I47- Taquicardia paroxística</option>
			  		<option value="flutterFibrilacao">I48- Flutter e fibrilacao atrial</option>
			  		<option value="arritmias">I49- Outras arritmias cardíacas</option>
			  		<option value="cardiomiopatias">I42- Cardiomiopatias</option>
				</select>
				<b>Recomendações para o exame: </b>
				<textarea id="recomendacoes" name="recomendacoes" rows="3" cols="33"></textarea>
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
				<p><input type="submit" value="Emitir pedido"/></p>
	    </form>
	    
	</body>
</html>