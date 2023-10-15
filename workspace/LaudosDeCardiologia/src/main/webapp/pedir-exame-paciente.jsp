<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="autenticacaoDemaisMedicos.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="vsvn.tsi.daw.cardio.enums.TiposDeExames" %>
<%@ page import="vsvn.tsi.daw.cardio.enums.HipotesesDiagnosticas" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina de exame</title>
<link rel="stylesheet" href="webjars/bootstrap/5.0.2/css/bootstrap.min.css">
</head>
<body class="align-middle">
	<div class="container bg-light">
	
		<h2 class="mt-3">Dados do Paciente</h2>	
	<div>
		<span class="font-weight-bold">Nome:</span><span>${sessionScope.paciente.nome}</span>
	</div>
	<div>
		<span class="font-weight-bold">Sexo:</span><span>${sessionScope.paciente.sexo}</span>
	</div>
	<div>
		<span class="font-weight-bold">Data de Nascimento:</span><span> <fmt:formatDate value="${sessionScope.paciente.datanascimento.time}" pattern="dd/MM/yyyy"/> </span>
	</div>
	<div>
		<span class="font-weight-bold">Idade:</span><span> ${sessionScope.idade} Anos</span>
	</div>
	<div>
		<span class="font-weight-bold">Cpf:</span><span>${sessionScope.paciente.cpf}</span>
	</div>
	<div>
		<span class="font-weight-bold">Email:</span><span>${sessionScope.paciente.email}</span>
	</div>
	
	<div>
		<form method="post" action="controladora">
		<div class="mt-4">
			<label class="form-label" for="tipo_exame_id">Tipo do exame</label>
			<select id="tipo_exame_id" class="form-select" name="tipo_exame">
		    	<c:forEach items="<%= TiposDeExames.values() %>" var="opcao">
	        		<option value="${opcao.getDescricao()}"><c:out value="${opcao.getDescricao()}" /></option>
	    		</c:forEach>
			</select>
		
		</div>
		
		<div class="mt-3">
			<label class="form-label" for="hipotese_id">Hipótese</label>
			<select id="hipotese_id" class="form-select" name="hipotese">
		    	<c:forEach items="<%= HipotesesDiagnosticas.values() %>" var="opcao">
	        		<option value="${opcao.getCodigo()}"><c:out value="${opcao.toString()}" /></option>
	    		</c:forEach>
			</select>
		
		</div>
			
			
			<input class="btn btn-primary mt-2" type="submit" value="Realizar Pedido">
			<input type="hidden" name="logica" value="RealizarPedido">
			
		</form>
	</div>
	
	
	</div>

</body>
</html>