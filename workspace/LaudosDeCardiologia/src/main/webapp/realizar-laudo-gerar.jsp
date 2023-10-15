<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="autenticacaoResidente.jsp" %>
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
				<div class="mt-2">
					<label class="label-form" for="descricao_area">Descrição</label>
					<textarea id="descricao_area" class="form-control" rows="8" cols="50" name="descricao">
				
					</textarea>
				</div>
				
				<div class="mt-2">
				<label class="form-label" for="conclusao_select">Conclusão</label>
				<select id="conclusao_select" class="form-select" name="conclusao">
			    	<c:forEach items="<%= HipotesesDiagnosticas.values() %>" var="opcao">
		        		<option value="${opcao.getCodigo()}"><c:out value="${opcao.toString()}" /></option>
		    		</c:forEach>
				</select>
				
				</div>
				
				<input class="btn btn-primary mt-2" type="submit" value="Gerar Laudo">
				<input type="hidden" name="logica" value="RealizarLaudo">
				
			</form>
		</div>
	</div>
</body>
</html>