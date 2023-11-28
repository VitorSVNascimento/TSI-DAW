<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Faça seu login</title>
	</head>
	<body>
	<div class="container">
		<jsp:include page="cabecalho.jsp"></jsp:include>
		<h1>Prencha os dados para fazer login</h1>
		
		<c:if test="${not empty message}">
			<c:forEach items="${message}" var="item">
				<h2>${item}</h2>
			</c:forEach>
		</c:if>
		
		
		
			<form action="login-validate" method="post">
				 <div class="mb-3">
				  <label for="email_id" class="form-label">Email</label>
					<input id="email_id" type="text" name="email">
				 </div>
				 <div class="mb-3">
				 	<label for="senha_id" class="form-label">Senha</label>
					<input id="senha_id" type="text" name="password">
				 
				 </div> 
				
				<button type="submit" class="btn btn-primary">Logar</button>
				
			</form>
			
		</div>
		
	
	</body>
</html>