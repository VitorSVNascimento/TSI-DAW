package br.tsi.daw.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.tsi.daw.servelet.dao.ContatoDAO;
import br.tsi.daw.servelet.modelo.Contato;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
			return;
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
		
		//Imprimindo os dados do usuário em outra página
		output.print("<html><head><style>");
		output.print("body{background-color :#87CEFA; width: 100%;}");
		output.print("h1{color: black; text-align:center;}");
		output.print("</style></head><body>");
		output.print("<h1>Adicionado com sucesso</h1>");
		output.print(String.format("O contao %s foi adicionado com sucesso!",contato.getNome()));
		output.print("</body></html>");
	}
	
}
