package br.com.flashstudy.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

//Controller para a navegação entre as telas

@Component
@RestController
public class NavegacaoController {

	@RequestMapping(path = "estudante-ajuda")
	public String ajuda() {
		return "estudante-ajdua";
	}

	@RequestMapping(path = "estudante-ciclo")
	public String ciclo() {
		return "estudante-ciclo";
	}

	@RequestMapping(path = "estudante-cronograma")
	public String cronograma() {
		return "estudante-cronograma";
	}

	@RequestMapping(path = "estudante-flashcards")
	public String flashcards() {
		return "estudante-flashcards";
	}

	@RequestMapping(path = "estudante-inicial")
	public String inicial() {
		return "estudante-inicial";
	}

	@RequestMapping(path = "estudante-perfil")
	public String perfil() {
		return "estudante-perfil";
	}

	@RequestMapping(path = "index")
	public String index() {
		return "index";
	}
}
