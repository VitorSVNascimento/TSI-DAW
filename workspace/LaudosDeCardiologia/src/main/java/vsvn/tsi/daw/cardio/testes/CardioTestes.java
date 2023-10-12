package vsvn.tsi.daw.cardio.testes;

import java.util.List;

import vsvn.tsi.daw.cardio.dao.MedicoDAO;
import vsvn.tsi.daw.cardio.email.Email;
import vsvn.tsi.daw.cardio.modelo.Medico;

public class CardioTestes {

	public static void main(String[] args) {
		//testeMedico();
		testeEmail();
		

	}

	public static void testeEmail() {
		Email mail = new Email("vitorsamuel0808@gmail.com", "Email teste", "Este é um email de teste");
		mail.enviar();
	}

	public static void testeMedico() {
		MedicoDAO dao = new MedicoDAO();
		List<Medico> medicos = dao.listaMedico();
		Medico medico = dao.validaCredencial("crm890123", "123456");
		System.out.println(medico);
		
//		for(Medico m : medicos)
//			System.out.println(m);
		
	}
	
	

}
