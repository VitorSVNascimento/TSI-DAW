package vsvn.daw.petshop.email;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PetShopEMail {
	
	
	public static String sendConfirmationLinkToUser(String username,String userEmail) {
		String hashString = String.format("%s%s%s", username,userEmail,getInstant());
		String hash_code = generateHash(hashString);
		Email email = new Email(userEmail, "Confirmação de Email", getMessage(username, hash_code));
		
		if(email.enviar())
			return hash_code;
		else
			return null;
		
		
	}
	
	private static String getInstant() {
        Date now = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(now);

        return formattedDate.toString();
	}
	
	private static String generateHash(String input) {
	        try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = digest.digest(input.getBytes());

	            // Converte o hash byte em representação hexadecimal
	            StringBuilder hexString = new StringBuilder();
	            for (byte b : hash) {
	                String hex = Integer.toHexString(0xff & b);
	                if (hex.length() == 1) {
	                    hexString.append('0');
	                }
	                hexString.append(hex);
	            }

	            return hexString.toString();
	        } catch (NoSuchAlgorithmException e) {
	            // Lida com a exceção, se o algoritmo não estiver disponível
	            e.printStackTrace();
	            return null;
	        }
	    }
	
	private static String getMessage(String username, String token) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(String.format("<h1>Bem vindo ao Cão Q Late Petshop, %s!</h1>\n\n", username));
		buffer.append("<h2> Para confirmar seu registro na plataforma clique no link a seguir </h2>\n");
		buffer.append(String.format("http://127.0.0.1:8080/TSI-DAW-TP2-CaoQLatePetShop/validate-email?token=%s\n\n", token));
		
		return buffer.toString();
	}
	
	
}
