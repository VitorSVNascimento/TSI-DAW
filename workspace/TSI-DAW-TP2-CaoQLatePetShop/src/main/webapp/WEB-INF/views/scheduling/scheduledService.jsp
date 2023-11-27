<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.Calendar" %>
<%
    Calendar twentyFourHoursAgo = Calendar.getInstance();
    twentyFourHoursAgo.setTimeInMillis(twentyFourHoursAgo.getTimeInMillis() + 24 * 60 * 60 * 1000);
    pageContext.setAttribute("twentyFourHoursAgo", twentyFourHoursAgo);
%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Serviços-Agendados</title>
	</head>
	<body>
	<jsp:include page="../cabecalho.jsp"></jsp:include>

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
								 <c:choose>
								        <c:when test="${service.schedulingDate.time.time gt twentyFourHoursAgo.timeInMillis}">
								            <a href="#" onclick="excluirAgora(${service.id})">Remover</a>
								        </c:when>
								        <c:otherwise>
								            <!-- Conteúdo para quando a condição não for atendida -->
								        </c:otherwise>
								    </c:choose>
                            </td>
							
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