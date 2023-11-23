<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Login dos funcionarios</title>
  		<link rel="stylesheet" href="css/login.css">	
	</head>
	
	<body>
		<div class="container">
		    <div class="form-container">
		      <center><img src="imagemCabecalho/medico.png" alt="Imagem de fundo" class="avatar"></center>
		      <form action="controladora" method="post">
		        <b>crm: </b>
		        <input type="text" name="crm" /><br>
		        <b>senha: </b>
		        <input type="password" name="senha" maxlength="12" />
		        <input type="hidden" name="logica" value="EfetuaLogin">
		        <center><p id="gravar"><input type="submit" value="Entrar" /></p></center>
		      </form>
		    </div>
	  </div>
	</body>
</html>