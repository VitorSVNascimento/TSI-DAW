<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Agendar novo Atendimento</title>
	</head>
	<body>
		<jsp:include page="../cabecalho.jsp"></jsp:include>
		
		<c:if test="${not empty message}">
			<h2>${message}</h2>
		</c:if>
		<form:form modelAttribute="scheduling" action="agendar" method="post">
			
			<form:errors path="schedulingDate" id="schedulingDate" cssClass="form-error"></form:errors>
			Data do agendamento: <input type="date" name="schedulingDate">

			
			Cachorro que recebrá o serviço
			<form:select path="dog.id">
    			<form:options items="${dogs}" itemLabel="name" itemValue="id" />
			</form:select>
			
		
			 <form:checkboxes items="${services_type}" path="services" itemLabel="name" itemValue="id" />
		
			
			<input type="submit" value="Registrar">
		</form:form>		
	</body>
</html>