<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login administrador</title>
	</head>
	<body>
		<h1>Faça seu login para acessar o menu do administrador</h1>
		<form action="admin-validate" method="post">
			Login: <input type="text" name="login"> 
			Senha: <input type="text" name="password">
			<input type="submit" value="Logar"> 
		</form>
	</body>
</html>