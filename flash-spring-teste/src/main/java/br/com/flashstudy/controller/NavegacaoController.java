package br.com.flashstudy.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//Controller para a navegação entre as telas

@Component
@Controller
public class NavegacaoController {

	@RequestMapping(path = "usuario-ajuda")
	public String ajuda() {
		return "usuario-ajdua";
	}

	@RequestMapping(path = "usuario-ciclo")
	public String ciclo() {
		return "usuario-ciclo";
	}

	@RequestMapping(path = "usuario-cronograma")
	public String cronograma() {
		return "usuario-cronograma";
	}

	@RequestMapping(path = "usuario-flashcards")
	public String flashcards() {
		return "usuario-flashcards";
	}

	@RequestMapping(path = "usuario-inicial")
	public String inicial() {
		return "usuario-inicial";
	}

	@RequestMapping(path = "usuario-perfil")
	public String perfil() {
		return "usuario-perfil";
	}

	@RequestMapping(path = "index")
	public String index() {
		return "index";
	}
}
