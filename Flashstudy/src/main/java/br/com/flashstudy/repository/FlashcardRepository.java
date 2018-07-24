package br.com.flashstudy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.flashstudy.model.Flashcard;
import br.com.flashstudy.model.Usuario;

//Repository dos flashcards (Comunicação com o BD)
public interface FlashcardRepository extends CrudRepository<Flashcard, Long> {

	// Lista os flashcards do usuário
	List<Flashcard> getByUsuario(Usuario usuario);

}