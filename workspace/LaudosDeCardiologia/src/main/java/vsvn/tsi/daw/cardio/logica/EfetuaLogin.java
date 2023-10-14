package vsvn.tsi.daw.cardio.logica;

import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.CATEGORIA;
import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.CRM;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vsvn.tsi.daw.cardio.Utilities;
import vsvn.tsi.daw.cardio.dao.ExameDAO;
import vsvn.tsi.daw.cardio.dao.MedicoDAO;
import vsvn.tsi.daw.cardio.dao.PacienteDAO;
import vsvn.tsi.daw.cardio.email.Email;
import vsvn.tsi.daw.cardio.enums.SituacaoExame;
import vsvn.tsi.daw.cardio.modelo.Exame;
import vsvn.tsi.daw.cardio.modelo.Medico;
import vsvn.tsi.daw.cardio.modelo.Paciente;

public class EfetuaLogin implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "login.jsp";
		String login = req.getParameter("crm");
		String senha = req.getParameter("senha");
		
		cancelarExames();
		
		MedicoDAO dao = new MedicoDAO();
		Medico medico = dao.validaCredencial(login, senha);
		
		if(medico != null) {
			HttpSession session = req.getSession();
			session.setAttribute(CRM, medico.getCrm());
			session.setAttribute(CATEGORIA, medico.getCategoria().getDescricao());
			session.setAttribute("nome_medico", medico.getNome());
			session.setAttribute("status", true);
			
			session.setMaxInactiveInterval(10*60);
			url = "menu-principal.jsp";
			return url;
		}
		return url;
		
	}

	private void cancelarExames() {
		try {
			
			ExameDAO dao = new ExameDAO();
			List<Exame> examesParaCancelar = dao.getExamesParaCancelar();
			for(Exame exame : examesParaCancelar) {
				exame.setSituacao(SituacaoExame.CANCELADO);
				dao.cancelarExame(exame);
				sendEmail(new MedicoDAO().obterMedicoPeloCRM(exame.getCrm()), exame, new PacienteDAO().buscarPaciente(exame.getCpf()));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private boolean sendEmail(Medico medico, Exame exame,Paciente paciente) {
		try {
			Email email = new Email(paciente.getEmail(), String.format("Exame de %s cancelado!", exame.getTipo().getDescricao()), getMessage(medico,exame,paciente));
			email.enviar();
			return true;
			
		}catch (Exception e) {
			return false;
		}
		
		
	}

	private String getMessage(Medico medico, Exame exame, Paciente paciente) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(String.format("<h1>Seu exame de %s foi cancelado devido ao não comparecimento </h1>\n\n", exame.getTipo().getDescricao()));
		buffer.append("<h2> Dados do Paciente </h2>\n");
		buffer.append(String.format("%s\n\n", getDadosDoPacienteEmail(paciente)));
		buffer.append("<h2> Dados do Exame </h2>\n");
		buffer.append(String.format("%s\n\n", getDadosDoExameEmail(exame)));
		buffer.append("<h2> Dados do Médico</h2>\n");
		buffer.append(getDadosDoMedicoEmail(medico));
		
		return buffer.toString();
	}
	
	private String getDadosDoPacienteEmail(Paciente paciente) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(String.format("Nome: %s   |   Sexo: %s    |    Data De Nascimento %s\n", paciente.getNome(),paciente.getSexo(),Utilities.ConverteData(paciente.getDatanascimento())));
		buffer.append(String.format("CPF: %s   |   Email: %s", paciente.getCpf(),paciente.getEmail()));
		
		return buffer.toString();
		
		
	}
	
	private String getDadosDoMedicoEmail(Medico medico) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(String.format("Nome: %s   |   CRM: %s", medico.getNome(),medico.getNome()));
		return buffer.toString();
		
		
	}
	
	private String getDadosDoExameEmail(Exame exame) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(String.format("Tipo do exame: %s    |    Hipótese %s\n",exame.getTipo().getDescricao(),exame.getHipotese().getDescricao()));
		buffer.append("<h3> Recomendações </h3>\n");
		buffer.append(exame.getTipo().getRecomendacoes());
		return buffer.toString();
		
		
	}

}
