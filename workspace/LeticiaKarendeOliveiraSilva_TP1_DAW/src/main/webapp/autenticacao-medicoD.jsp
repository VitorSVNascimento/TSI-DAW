<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${sessionScope.tipo != 'medico_docente'}">
				<jsp:forward page="login.jsp"/>
			</c:when>		
		</c:choose>
	</body>
</html>