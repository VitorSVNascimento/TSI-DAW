<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="bootstrap-5.0.2/css/bootstrap.min.css">
        <title>Adiciona Professor</title>
    </head>
    <body>
    	<c:import url="cabecalho.jsp"/>
        <form action="adicionaProfessor">
            <div class="mb-3">
              <label for="nome" class="form-label">Nome:</label>
              <input type="text" name="nome" class="form-control" id="nome" aria-describedby="emailHelp">
            </div>

            <div class="mb-3">
              <label for="exampleInputEmail1" class="form-label">Email:</label>
              <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            </div>

            <div class="mb-3">
              <label for="grauformacao" class="form-label">Grau de formação:</label>
              <input type="text" name="grauformacao" class="form-control" id="grauformacao">
            </div>

            <button type="submit" class="btn btn-primary">Salvar</button>
          </form>
          <c:import url="rodape.jsp"/>
          <script src="bootstrap-5.0.2/js/bootstrap.min.js"></script>
    </body>
</html>