package vsvn.daw.alunoseprofessores.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vsvn.daw.alunoseprofessores.logica.Logica;


@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String parameter = req.getParameter("logica");
		String className = "vsvn.daw.alunoseprofessores.logica."+parameter;
		
		try {
			Class classe = Class.forName(className);
			Logica logic = (Logica) classe.newInstance();
			logic.executa(req, resp);
			
		}catch (Exception e) {
			throw new ServletException("A lógica de negócios causou uma exeção",e);
		}
		
	}
	
	
}
