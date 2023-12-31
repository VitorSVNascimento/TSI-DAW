package vsvn.tsi.daw.cardio.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vsvn.tsi.daw.cardio.dao.LaudoDAO;
import vsvn.tsi.daw.cardio.enums.SituacaoLaudo;

public class ObterLaudosParaAvaliacao implements Logica{
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			session.setAttribute("laudos", new LaudoDAO().getLaudoPorSituacao(SituacaoLaudo.PROVISORIO));
			return "avaliar-laudo.jsp";
			
		}catch (Exception e) {
			e.printStackTrace();
			return "errors/erro-ao-obter-exames.jsp";
		}
		
	}
	
	
	
}
