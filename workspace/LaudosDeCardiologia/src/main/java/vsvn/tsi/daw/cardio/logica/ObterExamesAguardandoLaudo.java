package vsvn.tsi.daw.cardio.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vsvn.tsi.daw.cardio.dao.ExameDAO;

public class ObterExamesAguardandoLaudo implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			session.setAttribute("exames_laudo", new ExameDAO().getExamesAguardandoLaudo());
			return "realizar-laudo.jsp";
			
		}catch (Exception e) {
			// TODO: handle exception
			return "errors/erro-ao-obter-exames.jsp";
		}
		
	}

}
