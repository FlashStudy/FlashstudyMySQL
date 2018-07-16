package br.com.flashstudy.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.flashstudy.model.Cronograma;
import br.com.flashstudy.model.Usuario;

//Repository do cronograma (Comunicação com o BD)
public interface CronogramaRepository extends CrudRepository<Cronograma, Long> {

	// Procura o cronograma atual do usuário
	Cronograma getByUsuario(Usuario usuario);

}
