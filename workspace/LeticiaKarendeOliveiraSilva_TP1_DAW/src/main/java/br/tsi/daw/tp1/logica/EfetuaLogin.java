package br.tsi.daw.tp1.logica;

import java.io.IOException;
import br.tsi.daw.tp1.dao.MedicoDAO;
import br.tsi.daw.tp1.dao.MedicoDocenteDAO;
import br.tsi.daw.tp1.dao.MedicoResidenteDAO;
import br.tsi.daw.tp1.dao.PedidoExameDAO;
import br.tsi.daw.tp1.modelo.Medico;
import br.tsi.daw.tp1.modelo.MedicoDocente;
import br.tsi.daw.tp1.modelo.MedicoResidente;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EfetuaLogin implements Logica{

	@Override
	public String execution(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String senha = req.getParameter("senha"),
			   crm = req.getParameter("crm");
		String url = "login.jsp";
		
		MedicoDAO medicoDAO = new MedicoDAO();
		Medico medico = medicoDAO.validaDados(crm, senha);
		PedidoExameDAO pedidoExameDAO = new PedidoExameDAO();
		pedidoExameDAO.verificaExamesCancelados();
		
		if(medico != null) {
			HttpSession sessao = req.getSession();
			sessao.setAttribute("tipo", "medico");
			sessao.setAttribute("nome", medico.getNome());
			sessao.setAttribute("crm", crm);
			sessao.setMaxInactiveInterval(2*60);
			System.out.println("Medico");
			url="menu-principal.jsp";
		}else {
			MedicoDocenteDAO medicoDocenteDAO = new MedicoDocenteDAO();
			MedicoDocente medicoDocente = medicoDocenteDAO.validaDados(crm, senha);
			
			if(medicoDocente != null) {
				HttpSession sessao = req.getSession();
				sessao.setAttribute("tipo", "medico_docente");
				sessao.setAttribute("nome", medicoDocente.getNome());
				sessao.setAttribute("crm", crm);
				sessao.setMaxInactiveInterval(2*60);
				System.out.println("Medico D");
				url = "menu-principal.jsp";
			}else {
				MedicoResidenteDAO medicoResidenteDAO = new MedicoResidenteDAO();
				MedicoResidente medicoResidente = medicoResidenteDAO.validaDados(crm, senha);
				
				if(medicoResidente != null) {
					HttpSession sessao = req.getSession();
					sessao.setAttribute("tipo", "medico_residente");
					sessao.setAttribute("nome", medicoResidente.getNome());
					sessao.setAttribute("crm", crm);
					sessao.setMaxInactiveInterval(2*60);
					System.out.println("Medico R");
					url = "menu-principal.jsp";
					}
			}
		}
		return url;
	}

}
