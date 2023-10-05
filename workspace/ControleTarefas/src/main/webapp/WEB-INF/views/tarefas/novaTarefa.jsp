<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>	Nova Tarefa</title>
	</head>
	<body>
		<h3> Nova tarefa</h3>
		
		<form action="adicionaTarefa">
			Descricao:<textarea rows="5" cols="10" name="descricao"> </textarea>
			<input type="submit" value="Gravar">
		</form>
	</body>
</html>