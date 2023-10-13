<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="autenticacaoDemaisMedicos.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="vsvn.tsi.daw.cardio.enums.TiposDeExames" %>
<%@ page import="vsvn.tsi.daw.cardio.enums.HipotesesDiagnosticas" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina de exame</title>
</head>
<body>
	
	<h2>Pedido realizado com sucesso</h2>	
	<div>
		<p>
		Um email foi enviado ao paciente
		</p>
	</div>
	<div>
		<a href="menu-principal.jsp">Voltar para página principal</a>
	</div>
	
</body>
</html>