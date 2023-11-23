package br.tsi.daw.tp1.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EfetuaLogout implements Logica {

	@Override
	public String execution(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessao = req.getSession(false);
		sessao.invalidate();
		return "login.jsp";
	}

}
