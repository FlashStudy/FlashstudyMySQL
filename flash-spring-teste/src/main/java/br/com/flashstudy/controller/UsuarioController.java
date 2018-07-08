package br.com.flashstudy.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.flashstudy.erro.ResourceNotFoundException;
import br.com.flashstudy.model.Usuario;
import br.com.flashstudy.repository.UsuarioRepository;

//Controller do Usuario

@Component
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	// Finalizar a sessão
	@RequestMapping(value = "/sair", method = RequestMethod.GET, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody String sair(HttpSession http) {

		http.invalidate();

		return "index";

	}

	// Cadastrar
	@PostMapping("/cadastro")
	public @ResponseBody String cadastro(@Valid @RequestBody Usuario usuario, HttpSession http, Model model) {

		System.out.println(usuario.toString());

		Usuario aux = usuarioRepository.save(usuario);

		model.addAttribute("usuario", aux);

		return "estudante-inicial";
	}

	// Login
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody String login(@Valid @RequestBody Usuario usuario, HttpSession http) {

		if (usuarioRepository.findOne(usuario.getCodigo()) == null)

			throw new ResourceNotFoundException("Usuário não cadastrado!");

		else {

			Usuario aux = usuarioRepository.findByEmail(usuario.getEmail());

			if (aux.getSenha().equals(usuario.getSenha())) {
				usuario = aux;
				http.setAttribute("usuario", usuario);
				return "usuario-inicial";
			} else {
				http.setAttribute("erro", "As senhas diferem");
				return "index";
			}

		}
	}

	// Atualizar
	@RequestMapping(value = "/atualiza", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> atualiza(@Valid @RequestBody Usuario usuario) {

		usuarioRepository.save(usuario);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	// Verifica se o email já está cadastrado
	@RequestMapping(value = "/verifica/{email}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> verifica(@PathVariable("email") String email) {
		if (usuarioRepository.findByEmail(email) == null)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);

	}

}
