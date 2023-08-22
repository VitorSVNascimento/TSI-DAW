package vsvn.daw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vsvn.daw.utilities.Utilities;

@WebServlet("/fatorial")
public class FatorialServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String NUMBER_PARAM = "maximo";
		PrintWriter out = resp.getWriter();
		String param = req.getParameter(NUMBER_PARAM);

		out.print("<html>");
		out.print("<body>");
		out.print("<h1>Fatorial</h1>");
		if(param != null) {
			int max = Integer.parseInt(param);
			
			out.print("<table border=\"1px\">");
			out.print("<th>Numero</th> <th>Fatorial</th>");
			for(int i = 0; i <= max ; i++)
				out.print(String.format("<tr> <td>%s</td><td>%s</td> </tr>", i,Utilities.fatorial(i)));
			
			out.print("</table>");
		}else {
			out.print("<h1>Nenhum numero foi passado por parametro</h1>");
		}
		out.print("</body>");
		out.print("</html>");
		
		
	}

}
