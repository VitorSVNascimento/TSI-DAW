package br.tsi.daw.logica;

import java.io.IOException;

import br.tsi.daw.agenda.dao.UsuarioDAO;
import br.tsi.daw.agenda.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EfetuaLogin implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "login.jsp";
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario user = dao.validaCredencial(login, senha);
		
		if(user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", login);
			session.setAttribute("status", true);
			session.setMaxInactiveInterval(2*60);
			url = "menu-principal.jsp";
			return url;
		}
		return url;
		
	}

}
