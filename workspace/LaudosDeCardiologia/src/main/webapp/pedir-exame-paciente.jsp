<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
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
</head>
<body>
	
	<h2>Dados do Paciente</h2>	
	<div>
		<span>Nome:</span><span>${sessionScope.paciente.nome}</span>
	</div>
	<div>
		<span>Sexo:</span><span>${sessionScope.paciente.sexo}</span>
	</div>
	<div>
		<span>Data de Nascimento:</span><span> <fmt:formatDate value="${sessionScope.paciente.datanascimento.time}" pattern="dd/MM/yyyy"/> </span>
	</div>
	<div>
		<span>Idade:</span><span> ${sessionScope.idade} Anos</span>
	</div>
	<div>
		<span>Cpf:</span><span>${sessionScope.paciente.cpf}</span>
	</div>
	<div>
		<span>Email:</span><span>${sessionScope.paciente.email}</span>
	</div>
	
	<div>
		<form method="post" action="controladora">
		
			<select name="tipo_exame">
		    	<c:forEach items="<%= TiposDeExames.values() %>" var="opcao">
	        		<option value="${opcao.getDescricao()}"><c:out value="${opcao.getDescricao()}" /></option>
	    		</c:forEach>
			</select>
			
			<select name="hipotese">
		    	<c:forEach items="<%= HipotesesDiagnosticas.values() %>" var="opcao">
	        		<option value="${opcao.getCodigo()}"><c:out value="${opcao.toString()}" /></option>
	    		</c:forEach>
			</select>
			
			<input type="submit" value="Realizar Pedido">
			<input type="hidden" name="logica" value="RealizarPedido">
			
		</form>
	</div>
</body>
</html>