<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Esta é a página do index</title>
<link rel="stylesheet" href="webjars/bootstrap/5.0.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>Bem vindo ${user.name}</h1>
	<h2>Utilize o menu para navegar entre as funcionalidades</h1>

</div>

</body>
</html>