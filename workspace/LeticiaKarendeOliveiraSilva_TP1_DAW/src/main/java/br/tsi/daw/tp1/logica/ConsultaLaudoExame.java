package br.tsi.daw.tp1.logica;

import java.io.IOException;

import br.tsi.daw.tp1.dao.PacienteDAO;
import br.tsi.daw.tp1.modelo.Paciente;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConsultaLaudoExame implements Logica{

	@Override
	public String execution(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cpfPaciente = req.getParameter("cpf"),
				url = "menu-principal.jsp";
		
		Paciente paciente = new Paciente();
		paciente.setCpf(cpfPaciente);
		PacienteDAO pacienteDAO = new PacienteDAO();
		paciente = pacienteDAO.recuperaPaciente(paciente);
		
		if(paciente != null) {
			url = "consulta-laudo-exame.jsp" ;
			// atributo no HttpServletRequest
	        req.setAttribute("cpfPaciente", cpfPaciente);
		}
		return url;
	}
	
}
