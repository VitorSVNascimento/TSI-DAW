package vsvn.tsi.daw.cardio.logica;

import java.io.IOException;
import java.util.Calendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vsvn.tsi.daw.cardio.Utilities;
import vsvn.tsi.daw.cardio.dao.ExameDAO;
import vsvn.tsi.daw.cardio.email.Email;
import vsvn.tsi.daw.cardio.enums.HipotesesDiagnosticas;
import vsvn.tsi.daw.cardio.enums.TiposDeExames;
import vsvn.tsi.daw.cardio.modelo.Exame;
import vsvn.tsi.daw.cardio.modelo.Paciente;

import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.*;

public class RealizarPedido implements Logica{
	
	private int DIAS_DE_ESPERA_PARA_O_EXAME = 3;
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = "pedir-exame-sucesso.jsp";
		
		HttpSession session = req.getSession();
		Paciente paciente = (Paciente)session.getAttribute("paciente");
		try {
			ExameDAO dao = new ExameDAO();
			TiposDeExames tipoExame = TiposDeExames.getTipoDeExameFromDescricao(req.getParameter("tipo_exame"));
			if(dao.verificarExameEmAguardo(dao.getExamesDoPaciente(tipoExame, paciente.getCpf()))) 
				return getErrorPage(String.format("O Paciente %s já possui um exame de %s agendado", paciente.getNome(),tipoExame.getDescricao()), session);
			
			System.out.println("Hipotese = "+ req.getParameter("hipotese"));
			Exame exame = setAtributesExame(paciente.getCpf(), session.getAttribute(CRM).toString(), HipotesesDiagnosticas.fromCodigo(req.getParameter("hipotese")), tipoExame);
			
			if(!dao.inserir(exame)) 
				url = getErrorPage(String.format("Erro ao inserir exame no banco de dados"), session);
			else 
				if(!sendEmail(session, exame,paciente)) 
					url = getErrorPage("O exame foi agendado - Mas ocorreu um erro ao enviar o email para o paciente" , session);
				
			
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
			url =  getErrorPage( String.format("Tipo de exame inexistente"), session);
		}catch (Exception e) {
			e.printStackTrace();
			url = getErrorPage(String.format("Ocorreu um erro ao realizar o pedido"), session);
		}
			
		
		return url;
	}
	
	private Exame setAtributesExame(String cpf,String crm,HipotesesDiagnosticas hipotese,TiposDeExames tipo) {
		Exame exame = new Exame();
		exame.setCpf(cpf);
		exame.setCrm(crm);
		exame.setHipotese(hipotese);
		exame.setTipo(tipo);
		exame.setDatapedido(Calendar.getInstance());
		return exame;
		
	}
	
	private boolean sendEmail(HttpSession session, Exame exame,Paciente paciente) {
		try {
			Email email = new Email(paciente.getEmail(), String.format("Exame de %s", exame.getTipo().getDescricao()), getMessage(session,exame,paciente));
			email.enviar();
			return true;
			
		}catch (Exception e) {
			return false;
		}
		
		
	}

	private String getMessage(HttpSession session, Exame exame, Paciente paciente) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(String.format("<h1>Seu exame de %s foi agendado </h1>\n\n", exame.getTipo().getDescricao()));
		buffer.append("<h2> Dados do Paciente </h2>\n");
		buffer.append(String.format("%s\n\n", getDadosDoPacienteEmail(paciente)));
		buffer.append("<h2> Dados do Exame </h2>\n");
		buffer.append(String.format("%s\n\n", getDadosDoExameEmail(exame)));
		buffer.append("<h2> Dados do Médico</h2>\n");
		buffer.append(getDadosDoMedicoEmail(session));
		
		return buffer.toString();
	}
	
	private String getDadosDoPacienteEmail(Paciente paciente) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(String.format("Nome: %s   |   Sexo: %s    |    Data De Nascimento %s\n", paciente.getNome(),paciente.getSexo(),Utilities.ConverteData(paciente.getDatanascimento())));
		buffer.append(String.format("CPF: %s   |   Email: %s", paciente.getCpf(),paciente.getEmail()));
		
		return buffer.toString();
		
		
	}
	
	private String getDadosDoMedicoEmail(HttpSession sessao) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(String.format("Nome: %s   |   CRM: %s", sessao.getAttribute("nome_medico"),sessao.getAttribute(CRM)));
		return buffer.toString();
		
		
	}
	
	private String getDadosDoExameEmail(Exame exame) {
		Calendar data_hora_realizacao = Calendar.getInstance();
		data_hora_realizacao.setTimeInMillis(exame.getDatapedido().getTimeInMillis());
		data_hora_realizacao.add(Calendar.DAY_OF_MONTH, DIAS_DE_ESPERA_PARA_O_EXAME);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(String.format("Data e Hora: %s   |   Tipo do exame: %s    |    Hipótese %s\n",Utilities.ConverteDataHora(data_hora_realizacao) ,exame.getTipo().getDescricao(),exame.getHipotese().getDescricao()));
		buffer.append("<h3> Recomendações </h3>\n");
		buffer.append(exame.getTipo().getRecomendacoes());
		return buffer.toString();
		
		
	}
	
	private String getErrorPage(String msg,HttpSession session) {
		session.setAttribute("error_msg", msg);
		return "errors/erros-pedido.jsp";
	}
	
	
}
