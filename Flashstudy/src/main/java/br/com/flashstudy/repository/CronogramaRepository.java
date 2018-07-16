package br.com.flashstudy.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.flashstudy.model.Cronograma;
import br.com.flashstudy.model.Usuario;


public interface CronogramaRepository  extends CrudRepository<Cronograma, Long>{
	
	Cronograma getByUsuario(Usuario usuario);
	
}
