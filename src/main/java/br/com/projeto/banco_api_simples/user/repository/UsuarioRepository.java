package br.com.projeto.banco_api_simples.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.banco_api_simples.user.model.Usuario;

@Repository
public interface UsuarioRepository extends  CrudRepository<Usuario, Integer>{
    
    List<Usuario> findByOrderByNome();

    List<Usuario> findTop10ByNomeStartingWith(String nomebusca);

}
