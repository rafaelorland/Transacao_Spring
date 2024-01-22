package br.com.projeto.banco_api_simples.Transacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.banco_api_simples.Transacao.service.ServiceTransacao;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    
    @Autowired
    ServiceTransacao serviceTransacao;

    @GetMapping("")
    public ResponseEntity<?> fazerTransacao(@RequestParam(required = false) int remetente, int destinatario, float valor) {
        return serviceTransacao.fazerTransacao(remetente, destinatario, valor);
    }

    @GetMapping("/historico")
    public ResponseEntity<?> historioDeTransacao() {
        return serviceTransacao.historicoDeTransacao();
    }
    

}
