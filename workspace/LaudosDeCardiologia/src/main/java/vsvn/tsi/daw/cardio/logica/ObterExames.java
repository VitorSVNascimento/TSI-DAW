package vsvn.tsi.daw.cardio.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vsvn.tsi.daw.cardio.dao.ExameDAO;

public class ObterExames implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.setAttribute("exames", new ExameDAO().getExamesDoDia());
		
		return "realizar-exame.jsp";
	}

}
