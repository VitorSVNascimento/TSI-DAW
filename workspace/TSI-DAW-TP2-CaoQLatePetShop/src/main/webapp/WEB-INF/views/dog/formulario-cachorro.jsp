<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Registre seu cachorro</title>
	</head>
	<body>
	
		<h1>Fa�a o registro do seu cachorro para ter acesso ao nossos servi�os, e deixa-lo ainda mais feliz :)</h1>
		
		<form action="registrar-cachorro" method="post">
		
			Nome do seu lindo cachorro : <input type="text" name="name">
			Qual a ra�a dele? <input type="text" name="breed">
			E o tamanho? 
			<label>
				<input type="radio" name="size" value="pequeno">Pequeno 
			</label>
			<label>
				<input type="radio" name="size" value="medio">M�dio
			</label>
			<label>
				<input type="radio" name="size" value="grande">Grande
			</label>
			<input type="submit" value="Registrar">
		</form>
		
	</body>
</html>