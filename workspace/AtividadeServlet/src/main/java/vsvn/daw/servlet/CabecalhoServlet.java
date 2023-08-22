package vsvn.daw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cabecalho")
public class CabecalhoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Enumeration<String> names = req.getHeaderNames();
		
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Cabecalhos</h1>");
		out.print("<table border=\"1px\">");
		out.print("<th>Nome </th> <th>Valor </th>");
		
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println(name);
			out.print(String.format("<tr> <td>%s</td> <td>%s</td> </tr>", 
					name,req.getHeaders(name)));
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		
	}
}
