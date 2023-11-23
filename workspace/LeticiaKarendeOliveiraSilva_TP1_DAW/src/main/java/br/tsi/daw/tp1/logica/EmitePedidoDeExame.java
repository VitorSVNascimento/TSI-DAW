package br.tsi.daw.tp1.logica;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.tsi.daw.tp1.dao.PedidoExameDAO;
import br.tsi.daw.tp1.modelo.EnviaEmail;
import br.tsi.daw.tp1.modelo.Medico;
import br.tsi.daw.tp1.modelo.Paciente;
import br.tsi.daw.tp1.modelo.PedidoExame;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmitePedidoDeExame implements Logica {
	
	public static String calcularDataApos3Dias() {
        Calendar calendar = Calendar.getInstance(); // Obtém a data e hora atuais
        calendar.add(Calendar.DAY_OF_MONTH, 3); // Adiciona 3 dias

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(calendar.getTime()); // Retorna a nova data
    }
	
	
	@Override
	public String execution(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomePaciente = req.getParameter("nomePaciente"),
			   cpf = req.getParameter("cpf"),
			   email = req.getParameter("email"),
			   sexo = req.getParameter("sexo"),
			   dataNascimento = req.getParameter("dataNascimento"),
			   tipoExame = req.getParameter("tipoExame"),
			   nomeMedico = req.getParameter("nomeMedico"),
			   crmMedico = req.getParameter("crmMedico"),
			   hipoteseDiagnostica = req.getParameter("hipoteseDiagnostica"),
			   recomendacoes = req.getParameter("recomendacoes");
		
		
		//data da realização do exame
		String dataDoExame = calcularDataApos3Dias();
		Paciente paciente = new Paciente();
		paciente.setCpf(cpf);
		paciente.setNome(nomePaciente);
		paciente.setSexo(sexo);
		paciente.setDataNascimento(dataNascimento);
		paciente.setEmail(email);
		
		Medico medico = new Medico();
		medico.setNome(nomeMedico);
		medico.setCrm(crmMedico);
		
		//Montando exame
		PedidoExame pedidoExame = new PedidoExame();
		pedidoExame.setPaciente(paciente);
		pedidoExame.setExameSolicitado(tipoExame);
		pedidoExame.setHipotseDiagnostica(hipoteseDiagnostica);
		pedidoExame.setRecomendacoes(recomendacoes);
		pedidoExame.setMedico(medico);
		pedidoExame.setSituacao("Aguardando Exame");
		
		Calendar dataFormatada = Calendar.getInstance();
		Calendar dataRealizado = Calendar.getInstance();
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataDoExame);
			dataFormatada.setTime(date);
			dataRealizado.setTime(date);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		
		pedidoExame.setDataExame(dataFormatada);
		pedidoExame.setDataRealizada(dataRealizado);
		pedidoExame.setHoraRealizado(obterHoraRealizado());
		pedidoExame.setImagePdf(null);
		PedidoExameDAO pedidoExameDAO = new PedidoExameDAO();
		pedidoExameDAO.adicionaPedido(pedidoExame);
		EnviaEmail enviaEmail = new EnviaEmail();
		enviaEmail.enviarEmail("lkarendeoliveirasilva@gmail.com", "Pedido de Exame", enviaEmail.montagemEmail(pedidoExame));
		return "menu-principal.jsp";
	}

	private Time obterHoraRealizado() {
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    return new Time(cal.getTimeInMillis());
	}
}
