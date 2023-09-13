package br.tsi.daw.logica;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.tsi.daw.agenda.dao.ContatoDAO;
import br.tsi.daw.agenda.modelo.Contato;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AlteraContato implements Logica{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter output = resp.getWriter();
		String pagina = req.getParameter("pagina");
		Contato contato;
		
		if(pagina.equals("busca")) {
			contato = processIdPage(req, resp);
			if(contato == null) {
				output.print("<h1>Este contato não existe!</h1>");
				return null;
			}
			
		    
		    req.setAttribute("contato", contato);
			return "alterar-contato.jsp";
		}
		
		try{
			if(processAlterarPage(req, resp))
				return "lista-contato.jstl.jsp";
			output.print("<h1>Erro ao alterar!</h1>");
			return null;
			
		}catch(Exception e){
			output.print("<h1>Erro ao alterar!</h1>");
			return null;
		}
		
		
	}
	
	private Contato processIdPage(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		try {
			ContatoDAO dao = new ContatoDAO();
			return dao.Pesquisar(Integer.parseInt(id));
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	private boolean processAlterarPage(HttpServletRequest req, HttpServletResponse resp) {
		
		String nome = req.getParameter("nome"),
				idStr = req.getParameter("id"),
				   email = req.getParameter("email"),
				   endereco = req.getParameter("endereco"),
				   dataString = req.getParameter("dataNascimento");
			Calendar dataNascimento = null;
			
			//Conversão da data
			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);
				dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(date);
				
			}catch(ParseException e) {
				return false;
			}
			
			//Montando o objeto a ser adicionado
			Contato contato = new Contato();
			contato.setNome(nome);
			contato.setEndereco(endereco);
			contato.setEmail(email);
			contato.setDataNascimento(dataNascimento);
			contato.setId(Long.parseLong(idStr));
			
			//Salvando o contato no BD
			ContatoDAO dao = new ContatoDAO();
			dao.altera(contato);
				
			return true;
			}
}
