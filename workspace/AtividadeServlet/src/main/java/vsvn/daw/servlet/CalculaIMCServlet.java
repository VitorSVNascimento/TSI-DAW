package vsvn.daw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vsvn.daw.utilities.Utilities;

@WebServlet("/imc")
public class CalculaIMCServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		final String ALTURA = "altura",PESO="peso";
		
		String alt = req.getParameter(ALTURA),peso = req.getParameter(PESO);
		
		float alturaFloat = Float.parseFloat(alt),pesoFloat = Float.parseFloat(peso);
		
		float imc = Utilities.imcCalc(alturaFloat, pesoFloat);
		
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Calculadora IMC</h1>");
		out.print(String.format("<h3>%s</h3>", Utilities.imcMsg(imc)));
		out.print("</body>");
		out.print("</html>");
		
		
	}
	
}
