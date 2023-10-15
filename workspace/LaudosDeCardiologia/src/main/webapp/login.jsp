<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link rel="stylesheet" href="webjars/bootstrap/5.0.2/css/bootstrap.min.css">
	</head>
  <body class="align-middle">
	<div class="container">

		<form method="post" action="controladora">
			<h1 class="text-center mt-3">Faça seu login</h1>
			<div class="mb-3">
				<label class="form-label" for="inputCrm">CRM</label><input class="form-control" name="crm" type="text" id="inputCrm" placeholder="Digite seu CRM" required="required">
			</div>
			<label class="form-label" for="inputSenha">Senha</label><input class="form-control" name="senha" type="password" id="inputSenha" placeholder="Digite sua senha" required="required">
			<input type="hidden" name="logica" value="EfetuaLogin">
			
			<div class="mt-3">
				<input class="btn btn-primary" type="submit" value="Entrar">
			
			</div>
			
		</form>


	</div>

</body>
</html>