package vsvn.daw.pizzaria.email;


public class PizzariaEmail {
	public static boolean sendConfirmationLinkToUser(String userEmail,String token) {
		Email email = new Email(userEmail, "Pizzaria Express - Código de Confirmação", getMessage(token));
		
		return email.enviar();
	}	
	
	private static String getMessage(String token) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(String.format("<h1>Obrigado por vir a nossa pizzaria!</h1>\n\n"));
		buffer.append("<h2> Para confirmar seu registro envie o código abaixo no formulário de login </h2>\n");
		buffer.append(String.format("<h1>%s</h1>\n\n", token));
		
		return buffer.toString();
	}
}
