package vsvn.tsi.daw.cardio.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vsvn.tsi.daw.cardio.dao.ExameDAO;
import vsvn.tsi.daw.cardio.dao.PacienteDAO;
import vsvn.tsi.daw.cardio.modelo.Exame;

public class FornecerInformacoesLaudo implements Logica{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String idExame = req.getParameter("id_exame");
			Exame exame = new ExameDAO().getExameByID(Long.parseLong(idExame));
			HttpSession session = req.getSession();
			session.setAttribute("exame_para_laudo", exame);
			session.setAttribute("paciente", new PacienteDAO().buscarPaciente(exame.getCpf()));
			return "realizar-laudo-gerar.jsp";
			
			
		}catch (Exception e) {
			e.printStackTrace();
			return "errors/erro-ao-obter-exames.jsp";
		}
	}
}
