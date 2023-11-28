<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login administrador</title>
	</head>
	<body>
		<div class="container">
		<jsp:include page="../cabecalho.jsp"></jsp:include>
		<h1>Faça seu login para acessar o menu do administrador</h1>
		
		
			<form action="admin-validate" method="post">
				<div class="mb-3">
					<label for="login_id_in" class="form-label">Login</label>
					<input id="login_id_in" type="text" name="login"> 
				</div>
				<div class="mb-3">
					<label for="senha_in" class="form-label">Senha</label>
					<input id="senha_in" type="text" name="password">
				</div>
				<button type="submit" class="btn btn-primary">Logar</button>
			</form>
		</div>
		
	</body>
</html>