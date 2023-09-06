<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Alterar Contato</title>
	</head>
	<body>
	
		<form action="controladora">
		<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" var="dataFormatada"/>
			
			Nome: <input type="text" name="nome" value="${requestScope.contato.nome}"><br/>
			E-mail: <input type="text" name="email" value="${requestScope.contato.email}"/><br/>
			Endereço: <input type="text" name="endereco" value="${requestScope.contato.endereco}"/><br/>
			Data Nascimento: <input type="text" name="dataNascimento" value="${dataFormatada}"/><br/>
			<input type="submit" value="Alterar"><br>
		 <input type="hidden" name="logica" value="AlteraContato">
		 <input type="hidden" name="pagina" value="altera">
		 <input type="hidden" name="id" value="${requestScope.contato.id}">
			 
		</form>
	
	</body>
</html>