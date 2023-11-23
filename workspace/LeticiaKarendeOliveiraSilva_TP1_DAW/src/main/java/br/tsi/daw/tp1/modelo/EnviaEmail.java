package br.tsi.daw.tp1.modelo;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class EnviaEmail {
	
	public String convertDate(Calendar data) {
	    long timestamp = data.getTimeInMillis();

	    Date date = new Date(timestamp);

	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    String formattedDate = dateFormat.format(date);

	    System.out.println(formattedDate);
	    return formattedDate;
	}
	
	public void enviarEmail(String destinatario, String assunto, String mensagem) {
//      Properties props = new Properties();
//      props.setProperty("mail.smtp.ssl.trust", "*");
		 System.out.println("E-mail");
      SimpleEmail email = new SimpleEmail();
      email.setHostName("smtp.googlemail.com");
      email.setSmtpPort(465);  // Porta SMTP do Gmail
      email.setAuthenticator(new DefaultAuthenticator("leticia20teste@gmail.com", "nhqbpinapdtvenct"));
      email.setStartTLSEnabled(true);
      email.setSSLOnConnect(true);
      //email.setDebug(true);
      
      try {
    	  System.out.println("Entrou no envia e-mail");
          email.setFrom("leticia20teste@gmail.com");
          email.addTo(destinatario);
          email.setSubject(assunto);
          email.setMsg(mensagem);
          email.send();
          System.out.println("enviado");
      } catch (EmailException e) {
          e.printStackTrace();
      }
  }
	
	public String montagemEmail(PedidoExame pedidoExame) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Olá " + pedidoExame.getPaciente().getNome() + "\n");
		stringBuilder.append("Seu exame de " + pedidoExame.getExameSolicitado() + "acaba de ser marcado aqui na MedCar pelo médico " + pedidoExame.getMedico().getNome() + " com o crm " + pedidoExame.getMedico().getCrm() + "\n");
		stringBuilder.append("O exame será realizado: " + convertDate(pedidoExame.getDataExame()) + " as 8 horas da manhã.");
		stringBuilder.append("\nPara o dia do exame pedimos que siga essas recomendções abaixo:\n");
		stringBuilder.append(pedidoExame.getRecomendacoes());
		stringBuilder.append("\n\n Atenciosamente MedCar");
		return stringBuilder.toString();
	}
	
	public String montagemCancelamentoEmail(PedidoExame pedidoExame) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Olá " + pedidoExame.getPaciente().getNome() + "\n");
		stringBuilder.append("Seu exame de " + pedidoExame.getExameSolicitado() + "acaba de cancelado aqui na MedCar\n O médico " + pedidoExame.getMedico().getNome() + " com o crm " + pedidoExame.getMedico().getCrm() + " havia marcado\n Porém a data de realização do mesmo expirou.\n");
		stringBuilder.append("\n\n Atenciosamente MedCar");
		return stringBuilder.toString();
	}
}
