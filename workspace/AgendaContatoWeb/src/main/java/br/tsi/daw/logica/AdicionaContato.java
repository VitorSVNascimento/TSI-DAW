package br.tsi.daw.logica;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.tsi.daw.servelet.dao.ContatoDAO;
import br.tsi.daw.servelet.modelo.Contato;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdicionaContato implements Logica{
@Override
public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html;charset=UTF-8");
	PrintWriter output = resp.getWriter();
	
	//Pegando os parametros do request
	String nome = req.getParameter("nome"),
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
		output.print("<h1>Erro ao tentar converter a data!</h1>");
		return null;
	}
	
	//Montando o objeto a ser adicionado
	Contato contato = new Contato();
	contato.setNome(nome);
	contato.setEndereco(endereco);
	contato.setEmail(email);
	contato.setDataNascimento(dataNascimento);
	
	//Salvando o contato no BD
	ContatoDAO dao = new ContatoDAO();
	dao.adiciona(contato);
		
	String url = "contato-adicionado.jsp";
	return url;
	}
}
