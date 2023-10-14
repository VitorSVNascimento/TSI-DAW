package vsvn.tsi.daw.cardio.logica;

import java.io.IOException;
import java.util.Calendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vsvn.tsi.daw.cardio.constantes.Files;
import vsvn.tsi.daw.cardio.dao.ExameDAO;
import vsvn.tsi.daw.cardio.enums.SituacaoExame;
import vsvn.tsi.daw.cardio.modelo.Exame;
import vsvn.tsi.daw.cardio.pdf.PdfExame;

public class RealizarExame implements Logica{
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ExameDAO dao = new ExameDAO();
		String id_exame = req.getParameter("id_exame");
		Exame exame = dao.getExameByID(Long.parseLong(id_exame));
		
		exame.setData_e_hora_realizacao(Calendar.getInstance());
		exame.setSituacao(SituacaoExame.AGUARDANDO_LAUDO);
		PdfExame.generatePDFWithRandomImages(String.format("%s/%s", Files.PDFS_IMAGENS,exame.getTipo().getDescricao().toLowerCase()) , String.format("%s%s/%d.pdf", Files.PASTA_PDFS,exame.getCpf(),exame.getId()),3);
		if(dao.realizaExame(exame))
			return "realizar-exame-sucesso.jsp";
		
		return "errors/erro-realizar-exame.jsp";
	}

}
