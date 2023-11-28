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
		<div class="container">
		
			<jsp:include page="../cabecalho.jsp"></jsp:include>
			<h1>Agendar novo Atendimento</h1>
			<c:if test="${not empty message}">
				<h2>${message}</h2>
			</c:if>
			<form:form modelAttribute="scheduling" action="agendar" method="post">
				<div class="mb-3">
						<label for="dataat" class="form-label">Data do agendamento</label>
						<input id="dataat" type="date" name="schedulingDate">
					<div>
						<form:errors path="schedulingDate" id="schedulingDate" cssClass="text-danger"></form:errors>
					</div>
				</div>
	
				<div class="mb-3">
					<label for="seleectt" class="form-label">Cachorro que recebrá o serviço</label>
					<form:select id="seleectt" cssClass="form-select" path="dog.id">
		    			<form:options items="${dogs}" itemLabel="name" itemValue="id" />
					</form:select>
				</div>
				
				<div class="mb-3">
					 <c:forEach var="serviceType" items="${services_types}">
					 	<div class="form-check">
		                 <input class="form-check-input" type="checkbox" name="scheduling_services" id="service${serviceType.id}" value="${serviceType.id}" />
		                 <label class="form-check-label" for="service${serviceType.id}">${serviceType.name} -- ${serviceType.price}</label>
					 	</div>
		             </c:forEach>
				
				</div>
				
				<button type="submit" class="btn btn-primary">Agendar</button>
			</form:form>		
		</div>
	</body>
</html>