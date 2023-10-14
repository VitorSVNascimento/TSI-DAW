<%@page import="vsvn.tsi.daw.cardio.dao.PacienteDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="autenticacaoResidente.jsp" %> 
<% %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina de laudos</title>

</head>


<body>
	<h1>Laudos a serem realizados</h1>
	
	<table border="1px">
	
		<thead>
			<tr>
				<th>CPF do paciente</th>
				<th>Tipo do exame</th>
				<th>Hipótese</th>
				<th>CRM do médico</th>
				<th>Pdf para download</th>
				<th>Realizar exame</th>
			
			</tr>
		
		</thead>
		
		<c:forEach items="${sessionScope.exames_laudo}" var="exame" varStatus="loop">
			
			<tr>
					
				 <td>${exame.cpf}</td>
				 <td>${exame.tipo.getDescricao()}</td>
				 <td>${exame.hipotese.toString()}</td>
				 <td>${exame.crm}</td>
				 <td id="pdf_viewr">
				 
					 <a href="#" id="pdf_viewer_${loop.index}">Clique para abrir o PDF</a>	
				 
				 </td>
				 <td>
				 	<form method="post" action="controladora">
				 		<input type="hidden" name="id_exame" value="${exame.id}">
				 		<input type="hidden" name="logica" value="FornecerInformacoesLaudo">
				 		<input type="submit" value="Fornecer informações do laudo">
				 	</form>
				 </td>
			
			</tr>
			
		
		</c:forEach>	
	
	
	</table>
	
	<script>
		document.addEventListener("DOMContentLoaded", function () {
		    <c:forEach items="${sessionScope.exames_laudo}" var="exame" varStatus="loop">
		        var pdfViewer_${loop.index} = document.getElementById("pdf_viewer_${loop.index}");
		        pdfViewer_${loop.index}.addEventListener("click", function () {
		            var pdfURL = "pdfs_exames/${exame.cpf}/${exame.id}.pdf";
		            window.open(pdfURL, "_blank");
		        });	    </c:forEach>
		});
	</script>
</body>
</html>