package br.com.projeto.banco_api_simples.Transacao.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.banco_api_simples.Transacao.model.Transacao;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, UUID> {
    
}
