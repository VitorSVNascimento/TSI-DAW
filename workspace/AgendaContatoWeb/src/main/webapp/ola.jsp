<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		Bem vindo!<br>Usu�rio
		
		<%-- Chama-se projetos java aqui: <%@%> --%>
		
		<% String nome = "Let�cia"; 
		out.print(nome);%>
		<!-- Recuperando o valor da vari�vel acima -->
		<%-- Coment�rio JSP <%=nome %> --%>
		<!-- Dificuldades e misturas que podem ocorrer entre as express�es num arquivo .jsp  -->
		
		<%for(int i=0; i<10; i++){ %>
			<p>Est� � a linha <%=i %></p>
		<%}%>
	</body>
</html>