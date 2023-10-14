<%@page import="vsvn.tsi.daw.cardio.dao.PacienteDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="autenticacaoResidente.jsp" %> 
<% %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina de exame</title>
</head>
<body>
	<h1>Exames do dia</h1>
	
	<table border="1px">
	
		<thead>
			<tr>
				<th>CPF do paciente</th>
				<th>Tipo do exame</th>
				<th>Hipótese</th>
				<th>CRM do médico</th>
				<th>Realizar exame</th>
			
			</tr>
		
		</thead>
		
		<c:forEach items="${sessionScope.exames}" var="exame">
			
			<tr>
				 <td>${exame.cpf}</td>
				 <td>${exame.tipo.getDescricao()}</td>
				 <td>${exame.hipotese.toString()}</td>
				 <td>${exame.crm}</td>
				 <td>
				 	<form method="post" action="controladora">
				 		<input type="hidden" name="id_exame" value="${exame.id}">
				 		<input type="hidden" name="logica" value="RealizarExame">
				 		<input type="submit" value="Realizar exame">
				 	</form>
				 </td>
			
			</tr>
			
		
		</c:forEach>	
	
	
	</table>
	
</body>
</html>