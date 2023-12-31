<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Servi�os-Agendados</title>
	</head>
	<body>
		<table class="table table-info table-striped table-hover">
                <thead>
                    <tr class="text-center">
                        <th>ID</th>
                        <th>Data do Agendamento</th>
                        <th>Dono</th>
                        <th>Cachorro</th>
                        <th>Servi�os</th>
                        <th>Realizar</th>
                    </tr>
                </thead>
                <tbody>
                	
                    <c:forEach var="service" items="${date_scheduling}" varStatus="id">
                        <tr id="service_${service.id}" class="text-center">
                            <td>${service.id}</td>
                            <td>
                                <fmt:formatDate value="${service.schedulingDate.time}" pattern="dd/MM/yyyy"/>
                            </td>
                            <td>${service.dog.account.name}</td>
                            <td>${service.dog.name}</td>
                            <td>
                                <select >
                                    <c:forEach var="item" items="${service.services}">
                                        <option value="${item.name}">${item.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td class="btn-td">
                                <span id="span_link_${service.id}"> </span> <a class="btn btn-success" href="#"onclick="realizarServico(${service.id})">Realizar</a>
                            </td>
                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
	</body>
</html>