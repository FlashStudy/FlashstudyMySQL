package br.com.flashstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Controller para navegação entre as telas da aplicação
@Controller
public class NavegacaoController {

	// Index
	@GetMapping(path = "/")
	public String index() {
		return "index";
	}

	// Tela de ajuda
	@GetMapping(path = "ajuda")
	public String ajuda() {
		return "ajuda";
	}

	// Tela de ciclo
	@GetMapping(path = "ciclo")
	public String ciclo() {
		return "ciclo";
	}

	// Tela de cronograma
	@GetMapping(path = "cronograma")
	public String cronograma() {
		return "cronograma";
	}

	// Tela de flashcards
	@GetMapping(path = "flashcards")
	public String flashcards() {
		return "flashcards";
	}

	// Tela inicial do usuário
	@GetMapping(path = "inicial")
	public String inicial() {
		return "inicial";
	}

	// Tela de perfil do usuário
	@GetMapping(path = "perfil")
	public String perfil() {
		return "perfil";
	}

}
