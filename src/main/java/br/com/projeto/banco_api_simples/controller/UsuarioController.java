package br.com.projeto.banco_api_simples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.banco_api_simples.service.CriarUsuario;
import br.com.projeto.banco_api_simples.service.ServiceUsuario;

@RestController
public class UsuarioController {

    @Autowired
    ServiceUsuario serviceUsuario;

    //Criar Usuário
    @PostMapping("/user")
    public ResponseEntity<?> criarUsuario(@RequestBody(required = false) CriarUsuario usuario){
        return serviceUsuario.criarUsuario(usuario);
    }

    //Buscar Usuário
    @GetMapping("/user")
    public ResponseEntity<?> buscarUsuario(@RequestParam String busca){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
