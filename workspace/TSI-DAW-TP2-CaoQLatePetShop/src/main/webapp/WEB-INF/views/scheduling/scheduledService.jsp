<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Serviços-Agendados</title>
	</head>
	<body>
		<h1>Serviços agendados</h1>
		
		<table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Data do Agendamento</th>
                        <th>Cachorro</th>
                        <th>Serviços</th>
                        <th>Cancelar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="service" items="${scheduledService}" varStatus="id">
                        <tr id="service_${service.id}" bgcolor="${id.count % 2 != 0  ? 'ffffff' : 'cccccc'}">
                            <td>${service.id}</td>
                            <td>
                                <fmt:formatDate value="${service.schedulingDate.time}" pattern="dd/MM/yyyy"/>
                            </td>
                            <td>${service.dog.name}</td>
                            <td>
                                <select >
                                    <c:forEach var="item" items="${service.services}">
                                        <option value="${item.name}">${item.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td class="btn-td">
                                        <a href="#"onclick="excluirAgora(${service.id})">Remover</a>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            
		<script type="text/javascript" src="resources/javaScript/jquery-3.6.1.js"></script>			
   		<script type="text/javascript">

			function excluirAgora(id) {
				$.post("cancel-scheduling",{'id':id},function(){
					$("#service_"+id).closest("tr").hide();
				})
			}
		
		</script>
	</body>
</html>