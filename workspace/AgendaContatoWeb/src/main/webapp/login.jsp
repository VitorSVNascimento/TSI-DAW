<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="webjars/bootstrap/5.0.2/css/bootstrap.min.css">
		<title>Login</title>
	</head>
  <body class="text-center">
    <form class="form-signin" action="controladora">
	      <h1 class="h3 mb-3 font-weight-normal">Faça login</h1>
	      <label for="inputLogin" class="sr-only">Login</label>
	      <input name="login" type="text" id="inputLogin" class="form-control" placeholder="Login" required="" autofocus="">
	      
	      <label for="inputPassword" class="sr-only">Senha</label>
	      <input name="senha" type="password" id="inputPassword" class="form-control" placeholder="Senha" required="">
	      
	      <input type="hidden" name="logica" value="EfetuaLogin">
	      <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
	      <p class="mt-5 mb-3 text-muted">© 2023</p>
    </form>
  

</body>
</html>