package vsvn.tsi.daw.cardio.logica;

import java.io.IOException;
import java.util.Calendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vsvn.tsi.daw.cardio.dao.ExameDAO;
import vsvn.tsi.daw.cardio.email.Email;
import vsvn.tsi.daw.cardio.enums.HipotesesDiagnosticas;
import vsvn.tsi.daw.cardio.enums.TiposDeExames;
import vsvn.tsi.daw.cardio.modelo.Exame;
import vsvn.tsi.daw.cardio.modelo.Paciente;

import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.*;

public class RealizarPedido implements Logica{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = "pedir-exame-sucesso.jsp";
		
		HttpSession session = req.getSession();
		Paciente paciente = (Paciente)session.getAttribute("paciente");
		try {
			ExameDAO dao = new ExameDAO();
			TiposDeExames tipoExame = TiposDeExames.getTipoDeExameFromDescricao(req.getParameter("tipo_exame"));
			if(dao.verificarExameEmAguardo(dao.getExamesDoPaciente(tipoExame, paciente.getCpf()))) {
				
				session.setAttribute("error_msg", String.format("O Paciente %s já possui um exame de %s agendado", paciente.getNome(),tipoExame.getDescricao()));
				url =  "errors/erros-pedido.jsp";
			}
			System.out.println("Hipotese = "+ req.getParameter("hipotese"));
			Exame exame = setAtributesExame(paciente.getCpf(), session.getAttribute(CRM).toString(), HipotesesDiagnosticas.fromCodigo(req.getParameter("hipotese")), tipoExame);
			
			if(!dao.inserir(exame)) {
				session.setAttribute("error_msg", String.format("Erro ao inserir exame no banco de dados"));
				url =  "errors/erros-pedido.jsp";
			}else {
				sendEmail(session, exame);
			}
				
				
			
			
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
			session.setAttribute("error_msg", String.format("Tipo de exame inexistente"));
			url =  "errors/erros-pedido.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error_msg", String.format("Ocorreu um erro ao realizar o pedido"));
			url =  "errors/erros-pedido.jsp";
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
		Email email = new Email(paciente.getEmail(), String.format("Exame de %s", exame.getTipo().getDescricao()), getMessage(session,exame,paciente));
		return true;
		
		
	}

	private String getMessage(HttpSession session, Exame exame, Paciente paciente) {
		StringBuffer buffer;
	}
	
	
}
