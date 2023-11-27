<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Serviços prestados por um intervalo de datas</title>
</head>
<body>
		<h1>Serviços Prestados</h1>
		Forneça a data inicial: <input type="date" id="initDate" name="idate">
		Forneça a data final: <input type="date" id="endDate" name="edate">
		<a href="#"onclick="buscarLista($('#initDate').val(),$('#endDate').val())">Buscar por intervalo de datas</a>
		<div id="table_div"></div>
		
            
		<script type="text/javascript" src="resources/javaScript/jquery-3.6.1.js"></script>			
   		<script type="text/javascript">

			function buscarLista(initDate,endDate) {
				$.post("get-provided-scheduling-admin-byDate-interval",{'initDate':initDate,'endDate':endDate},function(resposta){
					$("#table_div").html(resposta);
					
				})
			}

		
		</script>
</body>
</html>