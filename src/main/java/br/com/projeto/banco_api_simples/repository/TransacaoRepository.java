package br.com.projeto.banco_api_simples.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.banco_api_simples.model.Transacao;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, UUID> {
    
}
