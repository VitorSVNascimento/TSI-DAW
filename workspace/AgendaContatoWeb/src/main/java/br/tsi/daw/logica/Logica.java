package br.tsi.daw.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Logica {
	
	public String execute (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
