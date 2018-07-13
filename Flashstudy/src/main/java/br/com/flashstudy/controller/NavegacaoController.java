package br.com.flashstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegacaoController {

	@GetMapping(path = "/")
	public String index() {
		return "index";
	}

	@GetMapping(path = "ajuda")
	public String ajuda() {
		return "ajuda";
	}

	@GetMapping(path = "ciclo")
	public String ciclo() {
		return "ciclo";
	}

	@GetMapping(path = "cronograma")
	public String cronograma() {
		return "cronograma";
	}

	@GetMapping(path = "flashcards")
	public String flashcards() {
		return "flashcards";
	}

	@GetMapping(path = "inicial")
	public String inicial() {
		return "inicial";
	}

	@GetMapping(path = "perfil")
	public String perfil() {
		return "perfil";
	}

}
