<%@page import="br.tsi.daw.agenda.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.tsi.daw.agenda.dao.ContatoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	
	<style>
		h1{
			text-align: center;
			color: blue;
		}
		table, th,td {
  			border: 1px solid black;
  			margin: 0 auto;
  			width: 50%;
		}
	</style>
	</head>
	<body>
		<h1>Lista de Contatos</h1>
		<br>
		<table> <tr><th>Nome</th> <th>Email</th></tr>
		<%ContatoDAO contatoDAO = new ContatoDAO();
			List<Contato>contatos = contatoDAO.listaConatos();
			for(Contato contato: contatos){%>
				<tr>
					<td>
						<%=contato.getNome()%>
					</td>
					<td>
						<%=contato.getEmail()%>
					</td>
				</tr>
		<%}%>
		</table>
	</body>
</html>