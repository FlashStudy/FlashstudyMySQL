package br.com.flashstudy.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.flashstudy.model.Assunto;

//Repository dos assuntos (Comunicação com o BD)
public interface AssuntoRepository extends CrudRepository<Assunto, Long> {

}