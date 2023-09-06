<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		Bem vindo!<br>Usuário
		
		<%-- Chama-se projetos java aqui: <%@%> --%>
		
		<% String nome = "Letícia"; 
		out.print(nome);%>
		<!-- Recuperando o valor da variável acima -->
		<%-- Comentário JSP <%=nome %> --%>
		<!-- Dificuldades e misturas que podem ocorrer entre as expressões num arquivo .jsp  -->
		
		<%for(int i=0; i<10; i++){ %>
			<p>Está é a linha <%=i %></p>
		<%}%>
	</body>
</html>