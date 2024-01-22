package br.com.projeto.banco_api_simples.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ValidarEmail {

    public static boolean validarEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        // Expressão regular para validar um e-mail
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";

        // Compilar a expressão regular
        Pattern pattern = Pattern.compile(regex);

        // Criar o objeto Matcher
        Matcher matcher = pattern.matcher(email);

        // Verificar se o e-mail corresponde à expressão regular
        return matcher.matches();
    }
}
