<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Cliente</title>
</head>
<body>
<div class="container">
<jsp:include page="../cabecalho.jsp"></jsp:include>
		<h3> Novo Cliente</h3>
		<c:if test="${not empty message}">
			<h2 class="text-success">${message}</h2>
		</c:if>
		
			<form:form  action="adicionarConta" method="post" modelAttribute="account">
			<div class="mb-3">
			 	<label for="nome_id" class="form-label">Nome</label>
				<input id="nome_id" type="text" name="name">
				<div>
					<form:errors path="name" id="name" cssClass="text-danger"></form:errors>
				</div>
			
			</div>
			
			
			<div class="mb-3">	
				<label for="cpf_input_id" class="form-label">CPF</label>		
				<input id="cpf_input_id" type="text" name="cpf">
				<div>
					<form:errors path="cpf" id="cpf" cssClass="text-danger"></form:errors>
				
				</div>
			</div>
			<div class="mb-3">
				<label for="data_n_id" class="form-label">Data de Nascimento</label>
				<input id="data_n_id" type="date" name="birthday">
			</div>
			<div class="mb-3">
					<label for="email_id_in" class="form-label">Email</label>
					<input id="email_id_in" type="email" name="email">
				<div>
					<form:errors path="email" id="email" cssClass="text-danger"></form:errors>
				</div>
			</div>
			<div class="mb-3">
				<label  for="senha_id" class="form-label">Senha</label>
				 <input id="senha_id" type="text" name="password">
			</div>
			<div class="mb-3">
				<label for="telefona_id" class="form-label">Telefone</label>
				 <input id="telefona_id" type="text" name="telephone">
				<div>
				</div>
			</div>
			
				<button type="submit" class="btn btn-primary">Registrar</button>
			</form:form>
		
		</div>
		
</body>
</html>