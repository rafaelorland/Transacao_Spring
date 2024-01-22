package br.com.projeto.banco_api_simples.Transacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.banco_api_simples.Transacao.service.ServiceTransacao;

@RestController
public class TransacaoController {
    
    @Autowired
    ServiceTransacao serviceTransacao;

    @GetMapping("/transacao")
    public ResponseEntity<?> fazerTransacao(@RequestParam int remetente, int destinatario, int valor) {
        return serviceTransacao.fazerTransacao(remetente, destinatario, valor);
    }

}
