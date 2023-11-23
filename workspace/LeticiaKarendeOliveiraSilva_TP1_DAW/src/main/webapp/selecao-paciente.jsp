<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="autenticacao-medicoR.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>seleção do paciente</title>
		<link rel="stylesheet" href="css/exibicao-tabela.css">
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		<h1>Seleçao de paciente:</h1>
		<c:set var="now" value="<%= new java.util.Date() %>"/>
		<h2> Exames de hoje : 
         <fmt:formatDate value="${now}" pattern="dd-MM-yyyy"/></h2>
		<jsp:useBean id="dao" class="br.tsi.daw.tp1.dao.PedidoExameDAO"/>
		
			<table border="1">
		    	<thead>
		        	<tr>
		                <th>Tipo de Exame</th>
		                <th>CPF do Paciente</th>
		                <th>Hipótese Diagnóstica</th>
		                <th>Realizar Exame</th>
		             </tr>
		        </thead>
		            
		                <c:forEach var="exame" items="${dao.pedidosDoDia()}">
		                    <tr>
		                        <td>${exame.exameSolicitado}</td>
		                        <td>${exame.paciente.cpf}</td>
		                        <td>${exame.hipotseDiagnostica}</td>
		                        <td>
		                            <a href="realizacao-exame.jsp?id=${exame.id}">
		                                Realizar Exame
		                            </a>
		                        </td>
		                    </tr>
		                </c:forEach>
		        </table>
	</body>
</html>