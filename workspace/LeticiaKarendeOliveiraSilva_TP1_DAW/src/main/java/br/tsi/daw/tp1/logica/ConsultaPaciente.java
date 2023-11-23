package br.tsi.daw.tp1.logica;

import java.io.IOException;

import br.tsi.daw.tp1.dao.PacienteDAO;
import br.tsi.daw.tp1.dao.PedidoExameDAO;
import br.tsi.daw.tp1.modelo.Paciente;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConsultaPaciente implements Logica{

	@Override
	public String execution(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cpf = req.getParameter("cpf"),
				tipoExame = req.getParameter("tipoExame");
		String url = "menu-principal.jsp";
		
		Paciente paciente = new Paciente();
		paciente.setCpf(cpf);
		PacienteDAO pacienteDAO = new PacienteDAO();
		paciente = pacienteDAO.recuperaPaciente(paciente);
		
		if(paciente != null) {
			PedidoExameDAO pedidoExameDAO = new PedidoExameDAO();
			if(pedidoExameDAO.verificaPedido("Aguardando Exame",paciente.getCpf(), tipoExame))
				url = "menu-principal.jsp";
			else {
				req.setAttribute("paciente", paciente);
				req.setAttribute("tipoExame", tipoExame);
				url = "pedido-exame.jsp";
			}
		}
		return url;
	}

}
