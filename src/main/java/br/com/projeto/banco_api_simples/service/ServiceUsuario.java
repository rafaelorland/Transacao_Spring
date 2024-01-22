package br.com.projeto.banco_api_simples.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.banco_api_simples.model.CriarUsuario;
import br.com.projeto.banco_api_simples.model.Usuario;
import br.com.projeto.banco_api_simples.model.Component.Mensagem;
import br.com.projeto.banco_api_simples.repository.UsuarioRepository;

@Service
public class ServiceUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private Mensagem mensagem;

    
    // Serviço para criação de usuário
    public ResponseEntity<?> criarUsuario(CriarUsuario obj){

        Usuario novoUsuario = new Usuario();

        // Verificar nome
        try {
            if (obj.getNome() == null || obj.getNome().isEmpty() ) {

                mensagem.setMensagem("Insirar um nome para efetuar a criação");
    
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            }
            // Verificar Senha não for nula
            else if (obj.getSenha() == null || obj.getSenha().isEmpty()) {
    
                mensagem.setMensagem("Insirar uma senha!");
    
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            }
            // Verificar se a senha é menor que 8
            else if (obj.getSenha().length() < 8) {
    
                mensagem.setMensagem("A senha não pode ser menor que 8 caracteres");
    
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            }
            // Verificar Email
            else if (ValidarEmail.validarEmail(obj.getEmail()) == false) {
                
                mensagem.setMensagem("O email está inválido");
    
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            }
            // criação do usuário
            else {
    
                novoUsuario.setNome(obj.getNome());
                novoUsuario.setEmail(obj.getEmail());
                novoUsuario.setSenha(obj.getSenha());
    
                return new ResponseEntity<>(usuarioRepository.save(novoUsuario), HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error no servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    
}
