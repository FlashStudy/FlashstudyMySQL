package br.com.flashstudy.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.flashstudy.model.Usuario;

//Repository dos usuário (Comunicação com o BD)
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	// Procura o usuário pelo email
	Usuario findByEmail(String email);

}
