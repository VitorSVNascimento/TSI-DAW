package vsvn.daw.alunoseprofessores.logica;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vsvn.daw.alunoseprofessores.dao.AlunoDAO;
import vsvn.daw.alunoseprofessores.modelo.Aluno;

public class AlteraAlunoLogic implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Aluno student = new Aluno();
		
		long id = Long.parseLong(req.getParameter("id"));
		student.setId(id);
		student.setNome(req.getParameter("nome"));
		student.setEndereco(req.getParameter("endereco"));
		student.setEmail(req.getParameter("email"));
		
		String dataEmTexto = req.getParameter("dataNascimento");
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(date);
		
		AlunoDAO dao = new AlunoDAO();
		dao.altera(student);
		
		RequestDispatcher rd = req.getRequestDispatcher("/lista-alunos-elegante.jsp");
		rd.forward(req, resp);
		System.out.println("Alterando aluno..." + student.getNome());
		
	}

}
