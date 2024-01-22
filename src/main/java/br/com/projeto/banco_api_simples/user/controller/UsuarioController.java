package br.com.projeto.banco_api_simples.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.banco_api_simples.user.model.CriarUsuario;
import br.com.projeto.banco_api_simples.user.service.ServiceUsuario;

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
    public ResponseEntity<?> buscarUsuario(@RequestParam(required = false) String seach){
        return serviceUsuario.buscarUsuário(seach);
    }

}
