<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Cliente</title>
</head>
<body>
		<h3> Novo Cliente</h3>
		
		<form action="adicionaCliente">
			Nome: <input type="text" name="name">
			CPF: <input type="text" name="cpf">
			Email: <input type="text" name="email">
			Senha: <input type="text" name="password">
			Telefone: <input type="text" name="telephone">
			
			
			<input type="submit" value="Gravar">
		</form>
</body>
</html>