package br.com.projeto.banco_api_simples.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.banco_api_simples.model.Usuario;

@Repository
public interface UsuarioRepository extends  CrudRepository<Usuario, Integer>{
    
}
