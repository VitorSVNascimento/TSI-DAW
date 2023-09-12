package vsvn.daw.alunoseprofessores.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vsvn.daw.alunoseprofessores.dao.ProfessorDAO;
import vsvn.daw.alunoseprofessores.modelo.Professor;

@WebServlet("/adicionaProfessor")
public class AdicionaProfessorServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("nome");
		String grauFormacao = req.getParameter("grauformacao");
		String email = req.getParameter("email");
		
		Professor teacher = new Professor();
		teacher.setEmail(email);
		teacher.setGrau_formacao(grauFormacao);
		teacher.setNome(name);
		
		ProfessorDAO dao = new ProfessorDAO();
		dao.adiciona(teacher);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Professor adicionado com sucesso! </h1>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
