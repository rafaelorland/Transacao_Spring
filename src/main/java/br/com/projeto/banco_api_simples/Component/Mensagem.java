package br.com.projeto.banco_api_simples.Component;

import org.springframework.stereotype.Component;

@Component
public class Mensagem {
    
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
