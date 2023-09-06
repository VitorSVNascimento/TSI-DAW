<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Adiciona contato</title>
		
		<style>
			body{
				background-color :#87CEFA;
				width: 100%;
			}
			
			h1{
				color: black;
				text-align:center;
			}
		</style>
	</head>
	
	<body>
			<h1>Informações pessoais</h1>
		
		<form action="controladora">
		
			Nome: <input type="text" name="nome"/><br/>
			E-mail: <input type="text" name="email"/><br/>
			Endereço: <input type="text" name="endereco"/><br/>
			Data Nascimento: <input type="text" name="dataNascimento"/><br/>
			<input type="submit" value="Gravar"/>
			<input type="hidden" name="logica" value="AdicionaContato"/>
		</form>
	</body>
</html>