<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="bootstrap-5.0.2/css/bootstrap.min.css">
        <title>Adiciona aluno</title>
    </head>
    <body>
    	<c:import url="cabecalho.jsp"/>
        <form action="adicionaAluno">
            <div class="row g-3 align-items-center">
                <div class="col-auto">
                    <label for="nome" class="form-label">Nome:</label>
                    <input type="text" name="nome" class="form-control" id="nome" aria-describedby="emailHelp">
                  </div>
      
                  <div class="col-auto">
                    <label for="exampleInputEmail1" class="form-label">Email:</label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
      
                  <div class="col-auto">
                    <label for="endereco" class="form-label">Endereço:</label>
                    <input type="text" name="endereco" class="form-control" id="endereco">
                  </div>
      
                  <div class="col-auto">
                    <label for="datanascimento" class="form-label">Data de Nascimento:</label>
                    <input type="text" name="datanascimento" class="form-control" id="datanascimento">
                  </div>
      
                  <button type="submit" class="btn btn-primary">Salvar</button>


            </div>
           
          </form>
          <c:import url="rodape.jsp"/>
          <script src="bootstrap-5.0.2/js/bootstrap.min.js"></script>
    </body>
</html>