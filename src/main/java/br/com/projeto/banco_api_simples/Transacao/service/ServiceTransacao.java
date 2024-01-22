package br.com.projeto.banco_api_simples.Transacao.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.banco_api_simples.Transacao.model.Transacao;
import br.com.projeto.banco_api_simples.Transacao.repository.TransacaoRepository;
import br.com.projeto.banco_api_simples.user.model.Usuario;
import br.com.projeto.banco_api_simples.user.repository.UsuarioRepository;

@Service
public class ServiceTransacao {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TransacaoRepository transacaoRepository;


    // Metódo de transação entre usuários
    public ResponseEntity<?> fazerTransacao(int remetenteId, int destinatarioId, float  valor) {

        if (usuarioRepository.existsById(remetenteId) && usuarioRepository.existsById(destinatarioId)) {

            Usuario remetente = usuarioRepository.findById(remetenteId).orElse(null);
            Usuario destinatario = usuarioRepository.findById(destinatarioId).orElse(null);

            if (remetente != null && destinatario != null && remetente.getSaldo() >= valor) {

                Transacao novaTransacao = new Transacao();
                novaTransacao.setDestinatario(destinatario.getNome());
                novaTransacao.setRemetente(remetente.getNome());
                novaTransacao.setValor(valor);
                novaTransacao.setHorarioDaTransacao(LocalDate.now());

                remetente.setSaldo(remetente.getSaldo() - valor);

                destinatario.setSaldo(destinatario.getSaldo() + valor);

                usuarioRepository.save(remetente);
                usuarioRepository.save(destinatario);

                return new ResponseEntity<>(transacaoRepository.save(novaTransacao), HttpStatus.OK);

            } else {
                return new ResponseEntity<>("Saldo insuficiente no remetente", HttpStatus.BAD_REQUEST);
            }

        } else {
            return new ResponseEntity<>("Usuário não encontrado", HttpStatus.BAD_REQUEST);
        }
    }

    // Método para mostrar o histórico
    public ResponseEntity<?> historicoDeTransacao () {
        return new ResponseEntity<>(transacaoRepository.findAll() ,HttpStatus.OK);
    }
}
