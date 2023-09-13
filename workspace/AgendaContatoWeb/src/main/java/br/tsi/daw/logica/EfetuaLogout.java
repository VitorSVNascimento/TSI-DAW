package br.tsi.daw.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EfetuaLogout implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "login.jsp";
		HttpSession session = req.getSession(false);
		if(session != null) 
			session.invalidate();
		
		return url;
	}

}
