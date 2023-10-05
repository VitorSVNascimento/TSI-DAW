package vsvn.tsi.daw.cardio.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vsvn.tsi.daw.cardio.dao.MedicoDAO;
import vsvn.tsi.daw.cardio.modelo.Medico;

import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.*;

public class EfetuaLogin implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "login.jsp";
		String login = req.getParameter("crm");
		String senha = req.getParameter("senha");
		
		MedicoDAO dao = new MedicoDAO();
		Medico medico = dao.validaCredencial(login, senha);
		
		if(medico != null) {
			HttpSession session = req.getSession();
			session.setAttribute(CRM, medico.getCrm());
			session.setAttribute(CATEGORIA, medico.getCategoria().getDescricao());
			session.setAttribute("status", true);
			session.setMaxInactiveInterval(2*60);
			url = "menu-principal.jsp";
			return url;
		}
		return url;
		
	}

}
