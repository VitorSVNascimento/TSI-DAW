<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Lista Alunos Elegante</title>
	</head>
	<body>
		<!-- Cria o DAO -->
		<jsp:useBean id="dao" class="vsvn.daw.alunoseprofessores.dao.AlunoDAO"/>
		<table>
			<thead>
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
			</thead>
			<tbody>
				<c:import url="cabecalho.jsp"/>
				<c:forEach var="aluno" items="${dao.listaAluno}" varStatus="rowColor">
				<tr bgcolor="${rowColor.count %2 == 0 ? 'ff6bbc' : 'ab5db2'}" style="color: #fff">
					<td>${aluno.nome}</td>
					<td>
					
                   		<c:choose>
             	           	<c:when test="${not empty aluno.email}">
                    			<a href="mailto:${aluno.email}">${aluno.email}</a>
	                    	</c:when>
	                    	
							<c:otherwise>
								Email não informado!
							</c:otherwise>    
                    	
                    	</c:choose>
					
					</td>
					<td>${aluno.endereco}</td>
					<td>
						<fmt:formatDate value="${aluno.datanascimento.time}" pattern="dd/MM/yyyy"/> 
					</td>			
				</tr>
				
				</c:forEach>
			</tbody>
		</table>
		
		<c:import url="rodape.jsp"/>
	</body>
</html>