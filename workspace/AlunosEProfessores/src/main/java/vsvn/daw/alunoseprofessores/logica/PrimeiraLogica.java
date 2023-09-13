package vsvn.daw.alunoseprofessores.logica;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("Executando a lógica e redirecionando!");
		RequestDispatcher rd = req.getRequestDispatcher("/primeira-logica.jsp");
		rd.forward(req, resp);

	}

}
