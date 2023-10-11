<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>Alterar Tarefa ${tarefa.id}</h3>
		<form action="alterarTarefa">
			<input type="hidden" name="id" value="${tarefa.id }">
			<b>Descrição</b>
			<textarea rows="5" cols="100" name="descricao">
			
				${tarefa.descricao}
			</textarea>
			<br>
			Finalizado? <input type="checkbox" name="finalizado" value="true" ${tarefa.finalizado? 'checked' : ''} >
			
			<br>
			
			Data de finalização 
			<input type="text" name="dataFinalizacao" value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>">
			<br>
			<input type="submit" value="Alterar">
		</form>
	</body>
</html>