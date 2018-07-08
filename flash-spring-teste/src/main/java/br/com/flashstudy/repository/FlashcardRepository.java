package br.com.flashstudy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.flashstudy.model.Flashcard;
import br.com.flashstudy.model.Usuario;

public interface FlashcardRepository  extends CrudRepository<Flashcard, Long>{

	List<Flashcard> getByUsuario(Usuario usuario);
	
}
