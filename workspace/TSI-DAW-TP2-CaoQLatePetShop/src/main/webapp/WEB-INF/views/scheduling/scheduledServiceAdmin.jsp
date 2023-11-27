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
	<jsp:include page="../cabecalho.jsp"></jsp:include>
		<h1>Serviços agendados</h1>
		Forneça a data desejada: <input type="date" id="calDate" name="sdate">
		<a href="#"onclick="buscarLista($('#calDate').val())">Buscar por data</a>
		<div id="table_div"></div>
		
            
		<script type="text/javascript" src="resources/javaScript/jquery-3.6.1.js"></script>			
   		<script type="text/javascript">

			function buscarLista(calendar) {
				$.post("get-scheduling-admin-byDate",{'calendar':calendar},function(resposta){
					$("#table_div").html(resposta);
					
				})
			}
			
			function realizarServico(id){
				$.post("make-scheduling",{"id":id},function(){
					$("#service_"+id).closest("tr").hide();
				})
			}
		
		</script>
	</body>
</html>