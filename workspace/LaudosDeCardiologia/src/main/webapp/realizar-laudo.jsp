<%@page import="vsvn.tsi.daw.cardio.dao.PacienteDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="autenticacaoResidente.jsp" %> 
<% %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="webjars/bootstrap/5.0.2/css/bootstrap.min.css">
<title>Pagina de laudos</title>

</head>


  <body class="align-middle">
  <div class="container">
  
	<h1>Laudos a serem realizados</h1>
	
	<table class="table table-info table-striped table-hover align-middle">
	
		<thead>
			<tr class="text-center align-middle">
				<th>CPF do paciente</th>
				<th>Tipo do exame</th>
				<th>Hip�tese</th>
				<th>CRM do m�dico</th>
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
				 
					 <a class="btn btn-danger" href="#" id="pdf_viewer_${loop.index}">Clique para abrir o PDF</a>	
				 
				 </td>
				 <td>
				 	<form method="post" action="controladora">
				 		<input type="hidden" name="id_exame" value="${exame.id}">
				 		<input type="hidden" name="logica" value="FornecerInformacoesLaudo">
				 		<input class="btn btn-success" type="submit" value="Fornecer informa��es do laudo">
				 	</form>
				 </td>
			
			</tr>
			
		
		</c:forEach>	
	
	
	</table>
  </div>
	
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