package br.tsi.daw.tp1.logica;

import java.io.IOException;

import br.tsi.daw.tp1.dao.LaudoDAO;
import br.tsi.daw.tp1.modelo.Laudo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AvaliacaoLaudo implements Logica{

	@Override
	public String execution(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idLaudo = req.getParameter("id");
		
		try {
			int id = Integer.parseInt(idLaudo);
			LaudoDAO laudoDAO = new LaudoDAO();
			Laudo laudo = laudoDAO.obterLaudoPorId(id);
			if(laudo != null) {
				laudoDAO.alterandoStatus("definitivo", id);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "menu-principal.jsp";
	}

}
