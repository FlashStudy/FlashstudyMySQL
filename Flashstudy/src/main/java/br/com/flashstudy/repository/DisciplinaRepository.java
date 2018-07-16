package br.com.flashstudy.repository;

//Repository das disciplinas (Comunicação com o BD)
import org.springframework.data.repository.CrudRepository;

import br.com.flashstudy.model.Disciplina;

public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {

}
