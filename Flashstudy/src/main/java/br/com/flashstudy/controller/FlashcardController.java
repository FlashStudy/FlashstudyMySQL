package br.com.flashstudy.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import br.com.flashstudy.error.ResourceNotFoundException;
import br.com.flashstudy.error.Resposta;
import br.com.flashstudy.model.Flashcard;
import br.com.flashstudy.model.Usuario;
import br.com.flashstudy.repository.FlashcardRepository;

//Controller dos flashcards

@Component
@RestController
@RequestMapping(value = "/flashcard")
public class FlashcardController {

	@Autowired
	FlashcardRepository flashcardRepository;

	@GetMapping(path = "/lista")
	public ResponseEntity<?> lista(HttpSession session) {
		
		return new ResponseEntity<>(flashcardRepository.getByUsuario((Usuario) session.getAttribute("usuario")),HttpStatus.OK);

	}

	@PostMapping(path = "/salvar")
	public ResponseEntity<?> salvar(@RequestBody Flashcard flashcard, HttpSession session) {

		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		System.out.println(usuario.getNome());
		
		flashcard.setUsuario(usuario);
		flashcard.setNivel("1");
		flashcard.setPublico("Publico");
		
		flashcardRepository.save(flashcard);
		
		return new ResponseEntity<>(new Resposta("Flashcard salvo!"), HttpStatus.OK);

	}

	@PutMapping("/atualizar")
	public ResponseEntity<?> atualizar(@Valid @RequestBody Flashcard flashcard) {
		if (flashcardRepository.findOne(flashcard.getCodigo()) == null)
			throw new ResourceNotFoundException("Flashcard não encontrado!");

		flashcardRepository.save(flashcard);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<?> deletar(@PathVariable("codigo") Long codigo) {
		if (flashcardRepository.findOne(codigo) == null)
			throw new ResourceNotFoundException("Flashcard não encontrado!");
		flashcardRepository.delete(codigo);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}