package vsvn.tsi.daw.cardio.logica;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vsvn.tsi.daw.cardio.enums.TiposDeExames;
import vsvn.tsi.daw.cardio.modelo.Paciente;

public class RealizarPedido implements Logica{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Paciente paciente = (Paciente)session.getAttribute("paciente");
		try {
			TiposDeExames exame = TiposDeExames.getTipoDeExameFromDescricao(req.getParameter("tipo_exame"));
			
		}catch (IllegalArgumentException e) {
			
		}
			
		
		
	}
	
	
}
