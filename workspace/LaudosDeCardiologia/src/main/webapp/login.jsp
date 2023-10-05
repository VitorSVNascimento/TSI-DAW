<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
	</head>
  <body class="text-center">

 	<form action="controladora">
 		<h1>Faça seu login</h1>
 		<label for="inputCrm">CRM:</label><input name="crm" type="text" id="inputCrm" placeholder="Digite seu CRM" required="required">
 		<label for="inputSenha">Senha:</label><input name="senha" type="password" id="inputSenha" placeholder="Digite sua senha" required="required">
 		<input type="hidden" name="logica" value="EfetuaLogin">
 		<input type="submit" value="Entrar">
 	</form>

</body>
</html>