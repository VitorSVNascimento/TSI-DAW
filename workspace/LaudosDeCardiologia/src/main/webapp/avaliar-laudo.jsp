<%@page import="vsvn.tsi.daw.cardio.dao.PacienteDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="autenticacaoDocente.jsp" %> 
<% %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagina de laudos</title>
<link rel="stylesheet" href="webjars/bootstrap/5.0.2/css/bootstrap.min.css">

</head>


  <body class="align-middle">
	<div class="container">
	
	
		<h1>Laudos a serem avaliados</h1>
		
	<table class="table table-info table-striped table-hover align-middle">
		
			<thead>
			<tr class="text-center align-middle">
					<th>id do exame</th>
					<th>CPF do paciente</th>
					<th>Data e hora da realizacao</th>
					<th>descricao</th>
					<th>conclusao</th>
					<th>CRM do residente</th>
					<th>Visualizar as imagens do exame</th>
					<th>Aprovar Laudo</th>
				
				</tr>
			
			</thead>
			<tbody>
			
				<c:forEach items="${sessionScope.laudos}" var="laudo" varStatus="loop">
					
					<tr>
						 <td class="table-info">${laudo.exame.id}</td>
						 <td>${laudo.exame.cpf}</td>
						 <td> <fmt:formatDate value="${laudo.exame.data_e_hora_realizacao.time}" pattern="dd/MM/yyyy HH:mm"/> </td>
						 <td>${laudo.descricao}</td>
						 <td>${laudo.conclusao.toString()}</td>
						 <td>${laudo.crm}</td>
						 <td id="pdf_viewr">
						 
							 <a class="btn btn-danger" href="#" id="pdf_viewer_${loop.index}">Clique para abrir o PDF</a>	
						 
						 </td>
						 <td>
						 	<form method="post" action="controladora">
						 		<input type="hidden" name="id_laudo" value="${laudo.id}">
						 		<input type="hidden" name="logica" value="AprovarLaudo">
						 		<input class="btn btn-success" type="submit" value="Aprovar Laudo">
						 	</form>
						 </td>
					
					</tr>
					
				
				</c:forEach>	
			</tbody>
		
		
		</table>
	</div>
	
	<script>
		document.addEventListener("DOMContentLoaded", function () {
		    <c:forEach items="${sessionScope.laudos}" var="laudo" varStatus="loop">
		        var pdfViewer_${loop.index} = document.getElementById("pdf_viewer_${loop.index}");
		        pdfViewer_${loop.index}.addEventListener("click", function () {
		            var pdfURL = "pdfs_exames/${laudo.images_path}";
		            window.open(pdfURL, "_blank");
		        });	    </c:forEach>
		});
	</script>
</body>
</html>