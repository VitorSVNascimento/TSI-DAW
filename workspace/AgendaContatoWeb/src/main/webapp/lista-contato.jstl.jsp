<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
	    <meta charset="ISO-8859-1">
	    <title>Insert title here</title>
    </head>
    <body>
    	<c:import url="cabecalho.jsp"></c:import>
    	<jsp:useBean id="dao" class="br.tsi.daw.servelet.dao.ContatoDAO"></jsp:useBean>
        <h2>Lista de contatos</h2>
        <hr>
        <table border="1px">
            <thead>
                <tr>
                    <th>ID:</th>
                    <th>Nome:</th>
                    <th>Email:</th>
                    <th>Endereço:</th>
                    <th>Data de Nascimento:</th>
                </tr>
            </thead>
            
            <c:forEach var="contato" items="${dao.listaConatos()}" varStatus="id">
                <tr bgcolor="${id.count %2 == 0 ? 'aaee88' : 'ffffff'}">
                    <td>${contato.id}</td>
                    <td>${contato.nome}</td>
                    
                    <td>
                    	<c:choose>
             	           	<c:when test="${not empty contato.email}">
                    			<a href="mailto:${contato.email}">${contato.email}</a>
	                    	</c:when>
	                    	
							<c:otherwise>
								Email não informado!
							</c:otherwise>    
                    	
                    	</c:choose>
                
                    
                    </td>
                    
                    <td>${contato.endereco}</td>
                    
                    
                    <td>
                    	<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>
                    </td>
                </tr>
            
            </c:forEach>
        </table>
        <hr>
        <a href="adicionaC.html">Adicionar novo contato!</a>
        <br>
        <c:import url="rodape.jsp"></c:import>
    </body>
</html>