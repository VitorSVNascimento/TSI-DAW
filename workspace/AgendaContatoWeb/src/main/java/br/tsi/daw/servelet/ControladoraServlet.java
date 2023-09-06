package br.tsi.daw.servelet;

import java.io.IOException;

import br.tsi.daw.logica.Logica;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/controladora")
public class ControladoraServlet extends HttpServlet{
@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nomeClasse = "br.tsi.daw.logica." + req.getParameter("logica");
		
		Class classe;
		String url="";
		try {
			classe = Class.forName(nomeClasse);
			try {
				Logica logica = (Logica)classe.newInstance();
				url = logica.execute(req, resp);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.getRequestDispatcher(url).forward(req, resp);
	}
	
}
