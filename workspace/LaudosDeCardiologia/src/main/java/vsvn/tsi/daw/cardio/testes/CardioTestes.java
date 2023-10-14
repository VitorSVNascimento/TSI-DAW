package vsvn.tsi.daw.cardio.testes;

import java.util.List;

import vsvn.tsi.daw.cardio.constantes.Files;
import vsvn.tsi.daw.cardio.dao.MedicoDAO;
import vsvn.tsi.daw.cardio.enums.TiposDeExames;
import vsvn.tsi.daw.cardio.modelo.Medico;
import vsvn.tsi.daw.cardio.pdf.PdfExame;

public class CardioTestes {

	public static void main(String[] args) {
		//testeMedico();
		//testeEmail();
		testePdf();

	}

	private static void testePdf() {
		PdfExame.generatePDFWithRandomImages(String.format("%s/%s", Files.PDFS_IMAGENS,TiposDeExames.ECOCARDIOGRAMA.getDescricao().toLowerCase()) , Files.PASTA_PDFS+"120/5.pdf",3);
		
	}

	public static void testeEmail() {
//		Email mail = new Email("vitorsamuel0808@gmail.com", "Teste de email2","Men2sag2em teste");
//		mail.enviar();
	}

	public static void testeMedico() {
		MedicoDAO dao = new MedicoDAO();
		List<Medico> medicos = dao.listaMedico();
		Medico medico = dao.validaCredencial("crm890123", "123456");
		System.out.println(medico);
		
		for(Medico m : medicos)
			System.out.println(m);
		
	}
	
  
	
	


}
