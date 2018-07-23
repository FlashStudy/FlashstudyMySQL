package br.com.flashstudy.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.flashstudy.model.Ciclo;
import br.com.flashstudy.model.Usuario;

public interface CicloRepository extends CrudRepository<Ciclo, Long>{
	
	Ciclo getByUsuario (Usuario usuario);
}
