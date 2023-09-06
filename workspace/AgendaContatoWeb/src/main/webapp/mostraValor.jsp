<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		<%String valor = request.getParameter("valor");
		out.print(valor);%>
		<br>
		<!-- Recuperando valores também-->
		O valor fornecido foi: ${param.valor}
	</body>
</html>