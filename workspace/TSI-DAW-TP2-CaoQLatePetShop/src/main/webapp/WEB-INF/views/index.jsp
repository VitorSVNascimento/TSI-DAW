<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Esta � a p�gina do index</title>
</head>
<body>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<h1>Esta � minha p�gina principal</h1>
	<h2>Bem vindo ${user.name}</h2>

</body>
</html>