package br.tsi.daw.tp1.controle;

import java.io.IOException;

import br.tsi.daw.tp1.logica.Logica;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/controladora")
public class Controladora extends HttpServlet{

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomeClasse = "br.tsi.daw.tp1.logica." + req.getParameter("logica");
		Class classe;
		String url = "login.jsp";
		
		try {
			classe = Class.forName(nomeClasse);
			try {
				Logica logica = (Logica)classe.newInstance();
				url= logica.execution(req, resp);
			}catch(InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher(url).forward(req, resp);
	}
}
