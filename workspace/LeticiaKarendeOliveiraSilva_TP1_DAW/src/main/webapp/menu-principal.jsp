<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Menu principal</title>
		<link rel="stylesheet" href="css/menu-principal.css">
	</head>
	
	<body>
		<c:import url="cabecalho.jsp"/>
		<c:choose>
    		<c:when test="${sessionScope.tipo == 'medico_docente'}">
        	<!-- Conte�do espec�fico para m�dico docente -->
                 <h1>Seja bem-vindo, m�dico docente!</h1>
        		 <div class="container">
                    <img src="imagemCabecalho/medico.png" alt="Imagem M�dico">
                    <div style="margin-top: 80px;">
	                    <form action="avaliacao-laudo.jsp">
	                    	<button class="button">Avalia��o dos dados</button>
	                    </form>
	                    <form action="consulta-laudo-exame-paciente.jsp">
	                    	<button class="button">Consultar laudos e exames</button>
	                    </form>
                    </div>
                </div>
    		</c:when>
    		
    		<c:when test="${sessionScope.tipo == 'medico_residente'}">
        	<!-- Conte�do espec�fico para m�dico residente -->
        		<h1>Seja bem-vindo, m�dico residente!</h1>
        		<div class="container">
	        		<img src="imagemCabecalho/medico.png" alt="Imagem M�dico">
	        		<div style="margin-top: 50px;">
		        		<form action="selecao-paciente.jsp">
		        			<button class ="button">Realiza��o de Exame</button>
						</form>
						
						<form action="selecao-paciente-gerarE.jsp">
							<button class ="button">Gerar Laudo dos exames</button>
						</form>
						
						<form action="consulta-laudo-exame-paciente.jsp">
							<button class ="button">Consultar laudos e exames</button>
						</form>
					</div>
				</div>
    		</c:when>
    		
    		<c:when test="${sessionScope.tipo == 'medico'}">
        	<!-- Conte�do espec�fico para m�dico -->
        		<h1>Seja bem-vindo, m�dico!</h1>
        		<div class="container">
	        		<img src="imagemCabecalho/medico.png" alt="Imagem M�dico">
	        		<div style="margin-top: 80px;">
				        <form action="recupera-paciente.jsp">
							<button class ="button">Solicitar pedido de exame</button>
						</form>
								
						<form action="consulta-laudo-exame-paciente.jsp">
							<button class ="button">Consultar laudos e exames</button>
						</form>
					</div>
				</div>
    		</c:when>
    		
    		<c:otherwise>
        		<jsp:forward page="login.jsp"/> <!-- Redireciona para a p�gina de login se n�o for um m�dico -->
    		</c:otherwise>
		</c:choose>
	</body>
</html>