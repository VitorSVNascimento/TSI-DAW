package br.tsi.daw.tp1.logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.tsi.daw.tp1.dao.PedidoExameDAO;
import br.tsi.daw.tp1.modelo.PedidoExame;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SelecaoDoPaciente implements Logica{

	@Override
	public String execution(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "menu-principal.jsp";
		List<PedidoExame> exames = new ArrayList<PedidoExame>();
		PedidoExameDAO pedidoExameDAO = new PedidoExameDAO();
		exames = pedidoExameDAO.pedidosDoDia();
		
		if(!exames.isEmpty()) {
			req.setAttribute("exame",exames);
			url = "selecao-paciente.jsp";
		}
		return url;
	}

}
