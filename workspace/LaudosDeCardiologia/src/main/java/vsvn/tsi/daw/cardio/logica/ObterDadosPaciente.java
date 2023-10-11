package vsvn.tsi.daw.cardio.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vsvn.tsi.daw.cardio.dao.PacienteDAO;
import vsvn.tsi.daw.cardio.modelo.Paciente;

public class ObterDadosPaciente implements Logica{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "errors/paciente-inexistente.jsp";
		String cpf = req.getParameter("cpf");
		System.out.println(cpf);
		Paciente paciente = new PacienteDAO().buscarPaciente(cpf);
		if(paciente != null) {
			HttpSession session = req.getSession();
			session.setAttribute("paciente", paciente);
			session.setAttribute("idade", Paciente.calcularIdade(paciente.getDatanascimento()));
			url = "pedir-exame-paciente.jsp";
		}
		return url;
	}
	
	
}
