<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Cliente</title>
</head>
<body>
		<h3> Novo Cliente</h3>
		
		<form action="adicionarConta">
			Nome: <input type="text" name="name">
			CPF: <input type="text" name="cpf">
			Data de Nascimento:<input type="date" name="birthday">
			Email: <input type="text" name="email">
			Senha: <input type="text" name="password">
			Telefone: <input type="text" name="telephone">
			
			
			<input type="submit" value="Gravar">
		</form>
</body>
</html>