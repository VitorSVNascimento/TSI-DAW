package vsvn.daw.agendacontato.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vsvn.daw.agendacontato.dao.AlunoDAO;
import vsvn.daw.agendacontato.modelo.Aluno;


@WebServlet("/adicionaAluno")
public class AdicionaAlunoServlet extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("nome");
		String addr = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dateString = req.getParameter("datanascimento");
		Calendar birthday= null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
			birthday = Calendar.getInstance();
			birthday.setTime(date);
			
		} catch (Exception e) {
			out.println("Erro ao converter a data");
			return;
		}
		
		Aluno student = new Aluno();
		student.setDatanascimento(birthday);
		student.setEmail(email);
		student.setEndereco(addr);
		student.setNome(name);
		
		AlunoDAO dao = new AlunoDAO();
		dao.adiciona(student);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Aluno adicionado com sucesso! </h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
