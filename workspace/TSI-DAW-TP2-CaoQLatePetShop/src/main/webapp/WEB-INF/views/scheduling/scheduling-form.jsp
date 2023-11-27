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
			
		
			 <c:forEach var="serviceType" items="${services_types}">
                 <input type="checkbox" name="scheduling_services" id="service${serviceType.id}" value="${serviceType.id}" />
                 <label for="service${serviceType.id}">${serviceType.name}</label>
             </c:forEach>
		
			
			<input type="submit" value="Registrar">
		</form:form>		
	</body>
</html>