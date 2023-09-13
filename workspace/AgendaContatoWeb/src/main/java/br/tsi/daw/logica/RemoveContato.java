package br.tsi.daw.logica;

import java.io.IOException;
import java.io.PrintWriter;

import br.tsi.daw.agenda.dao.ContatoDAO;
import br.tsi.daw.agenda.modelo.Contato;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RemoveContato implements Logica{
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter output = resp.getWriter();
		String id = req.getParameter("id");
		
		try {
			ContatoDAO dao = new ContatoDAO();
			Contato contato = dao.Pesquisar(Integer.parseInt(id));
			if (contato == null) {
				
				output.print("<h1>Este contato não existe!</h1>");
				return null;
			}
			dao.remove(contato);	
			return "listacontato.jstl.jsp";
			
		}catch (Exception e) {
			output.print("<h1>Erro ao remover o contato!</h1>");
			return null;
		}
	}

}
