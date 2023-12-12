package vsvn.daw.pizzaria.utilities;

import java.security.SecureRandom;
import java.util.Random;

public class TokenGenerator {
    private static final String CHARACTERS = "0123456789";
    private static final int TOKEN_LENGTH = 6;
    
    public static String generateToken() {
        StringBuilder token = new StringBuilder(TOKEN_LENGTH);
        Random random = new SecureRandom();

        for (int i = 0; i < TOKEN_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            token.append(CHARACTERS.charAt(randomIndex));
        }

        return token.toString();
    }
    
}
