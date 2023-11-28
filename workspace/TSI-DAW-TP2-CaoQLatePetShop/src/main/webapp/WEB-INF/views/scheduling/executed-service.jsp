<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Serviços-Realizados</title>
	</head>
	<body>
	<div class="container">
	
		<jsp:include page="../cabecalho.jsp"></jsp:include>
			<h1>Serviços Realizados</h1>
			
			<table class="table table-info table-striped table-hover">
	                <thead>
	                    <tr class="text-center">
	                        <th>Data do Agendamento</th>
	                        <th>Cachorro</th>
	                        <th>Serviços</th>
	                        <th>Total</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <c:forEach var="service" items="${executed_services}" varStatus="id">
	                        <tr id="service_${service.id}" class="text-center">
	                            <td>
	                                <fmt:formatDate value="${service.schedulingDate.time}" pattern="dd/MM/yyyy"/>
	                            </td>
	                            <td>${service.dog.name}</td>
	                            <td>
	                                <select >
	                                    <c:forEach var="item" items="${service.services}">
	                                        <option value="${item.name}">${item.name} -- R$ ${item.price}</option>
	                                    </c:forEach>
	                                </select>
	                            </td>
	                            <td class="total-td">${service.ammount}</td>
	                        </tr>
	                    </c:forEach>
	                </tbody>
	            </table>
	            
	</div>
	</body>
</html>