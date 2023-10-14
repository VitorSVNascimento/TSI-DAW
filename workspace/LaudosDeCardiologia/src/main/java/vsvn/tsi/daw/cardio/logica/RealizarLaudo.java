package vsvn.tsi.daw.cardio.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vsvn.tsi.daw.cardio.dao.ExameDAO;
import vsvn.tsi.daw.cardio.dao.LaudoDAO;
import vsvn.tsi.daw.cardio.enums.SituacaoExame;
import vsvn.tsi.daw.cardio.enums.SituacaoLaudo;
import vsvn.tsi.daw.cardio.modelo.Exame;
import vsvn.tsi.daw.cardio.modelo.Laudo;

public class RealizarLaudo implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			HttpSession session = req.getSession();
			Exame exame = (Exame)session.getAttribute("exame_para_laudo");
			if(exame == null)
				System.out.println("Ta nulo esse trem");
			Laudo laudo = new Laudo();
			exame.setSituacao(SituacaoExame.LAUDO_REALIZADO);
			new ExameDAO().realizaLaudoExame(exame);
			
			laudo.setConclusao(req.getParameter("conclusao"));
			laudo.setDescricao(req.getParameter("descricao"));
			laudo.setCrm(exame.getCrm());
			laudo.setId_exame(exame.getId());
			laudo.setImages_path(String.format("%s/%d.pdf", exame.getCpf(),exame.getId()));
			laudo.setCrm((String)session.getAttribute("crm"));
			laudo.setSituacao(SituacaoLaudo.PROVISORIO);
			new LaudoDAO().insert(laudo);
			
			return "realizar-laudo-sucesso.jsp";
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
			
			
			
	}

}
