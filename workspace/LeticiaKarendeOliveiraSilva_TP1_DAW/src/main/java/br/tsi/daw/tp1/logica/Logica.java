package br.tsi.daw.tp1.logica;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Logica {
	public String execution(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
