package vsvn.tsi.daw.cardio.email;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email {

	private String EMAIL_CONF_FILE = "conf/config.properties";
	private String EMAIL_HOST_NAME = "smtp.googlemail.com";
	private int EMAIL_SMTP_PORT= 465;
	
	private String email;
	private String senha;
	private String destinatario;
	private String assunto;
	private String mensagem;
	
	
	
	public Email(String email, String senha, String destinatario, String assunto) {
		this.email = email;
		this.senha = senha;
		this.destinatario = destinatario;
		this.assunto = assunto;
	}
	
	

	public Email(String destinatario, String assunto, String mensagem) {
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.mensagem = mensagem;
		loadProperties();
	}
	
	
	
	public Email(String email, String senha, String destinatario, String assunto, String mensagem) {
		this.email = email;
		this.senha = senha;
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.mensagem = mensagem;
	}



	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDestinatario() {
		return destinatario;
	}
	
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	
	public String getAssunto() {
		return assunto;
	}
	
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public boolean enviar() {
		
		try {
			SimpleEmail email = new SimpleEmail();
			email.setHostName(EMAIL_HOST_NAME);
			email.setSmtpPort(EMAIL_SMTP_PORT);
			
			email.setAuthenticator(new DefaultAuthenticator(this.email, this.senha));
			email.setStartTLSEnabled(true);
			email.setSSLOnConnect(true);
			email.setFrom(this.email);
			email.setSubject(this.assunto);
			email.setMsg(this.mensagem);
			email.addTo(this.destinatario);
			email.send();
			
		}catch (EmailException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	private void loadProperties() {
		String currentDirectory = System.getProperty("user.dir");
		System.out.println("Diretório Atual: " + currentDirectory);
		 Properties prop = new Properties();
	        try {
	            FileInputStream fis = new FileInputStream(EMAIL_CONF_FILE);
	            prop.load(fis);
	            fis.close();
	            
	            this.email = prop.getProperty("email");
	            this.senha = prop.getProperty("password");
	            
	            System.out.println("Email: " + email);
	            System.out.println("password: " + senha);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

	
}
