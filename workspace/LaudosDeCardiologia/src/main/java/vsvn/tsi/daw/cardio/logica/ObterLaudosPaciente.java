package vsvn.tsi.daw.cardio.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vsvn.tsi.daw.cardio.dao.LaudoDAO;
import vsvn.tsi.daw.cardio.dao.PacienteDAO;

public class ObterLaudosPaciente implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String cpfPaciente = req.getParameter("cpf");
			HttpSession session = req.getSession();
			if(new PacienteDAO().buscarPaciente(cpfPaciente) == null)
				return "errors/paciente-inxistente.jsp";
			session.setAttribute("laudos_paciente", new LaudoDAO().getLaudosDefinitivosDoPaciente(cpfPaciente));
			return "consultar-laudo-paciente.jsp";
		} catch (Exception e) {
			
			return "errors/erro-ao-obter-laudos-paciente.jsp";
		}
		
		
	}

}
