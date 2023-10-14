package vsvn.tsi.daw.cardio.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vsvn.tsi.daw.cardio.dao.LaudoDAO;

public class AprovarLaudo implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String id = req.getParameter("id_laudo");
			new LaudoDAO().autorizarLaudo(Long.parseLong(id));
			return "avaliar-laudo-sucesso.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			return "errors/erro-ao-aprovar-laudos.jsp";
		}
	}

}
