<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Remover contato</title>
	</head>
	<body>
		<h1>Remover contato</h1>

		<form action="controladora">

			 <label for="id">Id do contato:</label> <input type="number" name="id" id="id">
			 <input type="submit" value="Remover"> <br>
			 <input type="hidden" name="logica" value="RemoveContato">

		</form>
	</body>
</html>