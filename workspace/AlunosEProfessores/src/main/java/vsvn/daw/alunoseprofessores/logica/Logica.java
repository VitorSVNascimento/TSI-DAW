package vsvn.daw.alunoseprofessores.logica;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Logica {
	void executa(HttpServletRequest req,HttpServletResponse resp) throws Exception;
}
