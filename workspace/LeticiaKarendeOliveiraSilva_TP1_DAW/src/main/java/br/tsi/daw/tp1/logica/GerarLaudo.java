package br.tsi.daw.tp1.logica;

import java.io.IOException;

import br.tsi.daw.tp1.dao.LaudoDAO;
import br.tsi.daw.tp1.dao.PedidoExameDAO;
import br.tsi.daw.tp1.modelo.Laudo;
import br.tsi.daw.tp1.modelo.PedidoExame;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GerarLaudo implements Logica{

	@Override
	public String execution(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String descricao = req.getParameter("descricao"),
				conclusao = req.getParameter("conclusao"),
				idPedidoExame = req.getParameter("id");
				
				PedidoExameDAO pedidoExameDAO = new PedidoExameDAO();
				try {
					int id = Integer.parseInt(idPedidoExame);
					PedidoExame pedidoExame = pedidoExameDAO.obterPedidoExamePorId(id);
					pedidoExameDAO.mudaSituacaoDoExame("Laudo realizado", pedidoExame.getId());
					
					Laudo laudo = new Laudo();
					laudo.setDescricao(descricao);
					laudo.setConclusao(conclusao);
					laudo.setPedidoExame(pedidoExame);
					laudo.setStatus("provisorio");
					
					LaudoDAO laudoDAO = new LaudoDAO();
					laudoDAO.adicionaLaudo(laudo);
				}catch(Exception e) {
					e.printStackTrace();
				}
				return "menu-principal.jsp";
	}
}
