<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Faça seu login</title>
	</head>
	<body>
	
		<h1>Prencha os dados para fazer login</h1>
		
		<form action="login-validate" method="post">
		
			Email:<input type="text" name="email">
			Senha:<input type="text" name="password">
			
			<input type="submit" value="Logar">
			
		</form>
		
		<a href="novaConta">Fazer cadastro</a>
	
	</body>
</html>