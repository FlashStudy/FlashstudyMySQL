package br.com.flashstudy.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.flashstudy.model.Ciclo;
import br.com.flashstudy.model.Usuario;

//Repository do ciclo (Comunicação com o BD)
public interface CicloRepository extends CrudRepository<Ciclo, Long> {

	// Solicita o ciclo do usuário
	Ciclo getByUsuario(Usuario usuario);
}