<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista de tarefas</title>
		<script type="text/javascript" src="resources/javaScript/jquery-3.6.1.js"></script>
	</head>
	<body>
		<!--   <script type="text/javascript">
		
			function finalizaAgora(id) {
				$.post("finalizaTarefa",{'id':id},function(){
					$("#tarefa_"+id).html("Finalizado");
				});
			}
		
		</script>	
		
		-->
		
		<script type="text/javascript">
		function finalizaAgora(id) {
			$.post("finalizaTarefa",{'id':id},function(resposta){
				$("#tarefa_"+id).html(resposta);
			});
		}
		
		function excluirAgora(id) {
			$.post("removeAjax",{'id':id},function(){
				$("#tarefa_"+id).closest("tr").hide();
			})
		}
		
		</script>
		<a href="novaTarefa">Criar nova tarefa</a>
		<br>
		<br>
		<table border="1px">
		
			<tr>
			
				<th>Id</th>
				<th>Descrição</th>
				<th>Finalizado</th>
				<th>Data de Finalização</th>
				<th>Remover</th>
				<th>Editar</th>
			</tr>
			
			<c:forEach items="${tarefas}" var="tarefa">
				
			<!-- <tr> -->
				<tr id="tarefa_${tarefa.id}">	
					<td>${tarefa.id}</td>
					<td>${tarefa.descricao}</td>
					<c:if test="${tarefa.finalizado eq true}">
						<td>Finalizada</td> 
					</c:if>
					<c:if test="${tarefa.finalizado eq false}">
						<td>
							<a href="#" onclick="finalizaAgora(${tarefa.id})">
								Finalizar agora?
							</a>
						</td> 
					</c:if>
					<td>
						<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
					</td>
					<td><a href="#"onclick="excluirAgora(${tarefa.id})">Remover</a></td>
					<td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
				</tr>
			
			</c:forEach>
			
		</table>
		
	</body>
</html>