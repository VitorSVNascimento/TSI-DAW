package vsvn.daw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/nomeParametros")
public class NomeParametroServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Enumeration<String> names = req.getParameterNames();
		
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Nomes dos parametros</h1>");
		out.print("<table border=\"1px\">");
		out.print("<th>Nome </th> <th>Valor </th>");
		
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			out.print(String.format("<tr> <td>%s</td> <td>%s</td> </tr>", 
					name,req.getParameterValues(name)[0]));
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
	}
}
