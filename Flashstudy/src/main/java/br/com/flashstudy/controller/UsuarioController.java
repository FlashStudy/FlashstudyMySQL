package br.com.flashstudy.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import br.com.flashstudy.error.Resposta;
import br.com.flashstudy.model.Usuario;
import br.com.flashstudy.repository.UsuarioRepository;

//Controller do Usário

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	// Finalizar a sessão
	@GetMapping(path = "/sair")
	public String sair(HttpSession http) {

		http.invalidate();

		return "index";

	}

	// Cadastrar
	@PostMapping(value = "/cadastro")
	public @ResponseBody ResponseEntity<?> cadastro(@Valid @RequestBody Usuario usuario, HttpSession httpSession) {

		Usuario aux = usuarioRepository.save(usuario);

		httpSession.setAttribute("usuario", aux);

		return new ResponseEntity<>(new Resposta("Usuário cadastrado com sucesso!"), HttpStatus.OK);
	}

	// Login
	@PostMapping(value = "/login")
	public @ResponseBody ResponseEntity<?> login(@RequestBody Usuario usuario, HttpSession http) {

		if (usuarioRepository.findByEmail(usuario.getEmail()) == null)

			return new ResponseEntity<>(new Resposta("Usuário não encontrado!"), HttpStatus.NOT_FOUND);

		else {

			Usuario aux = usuarioRepository.findByEmail(usuario.getEmail());

			if (aux.getSenha().equals(usuario.getSenha())) {
				usuario = aux;
				http.setAttribute("usuario", usuario);
				return new ResponseEntity<>(new Resposta("Usuário logado com sucesso!"), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new Resposta("Senha incorreta!"), HttpStatus.NOT_FOUND);
			}

		}
	}

	// Atualizar
	@PostMapping(value = "/atualiza", produces = { "application/json", "application/xml" }, consumes = {
			"application/x-www-form-urlencoded" })
	public @ResponseBody String atualiza(@SuppressWarnings("rawtypes") @RequestBody MultiValueMap params, HttpSession session) throws Exception {

		System.out.println(params);
		Usuario usuario = new Usuario();
		
		
		//usuario.setCodigo((Long) params.get("codigo"));
		//usuario.setEmail((String) params.get("email"));
		//usuario.setNome((String) params.get("nome"));
		//usuario.setSenha((String) params.get("senha"));

		System.out.println(usuario.toString());

		return "index";
	}

	// Verifica se o email já está cadastrado
	@GetMapping(value = "/verifica/{email}")
	public @ResponseBody ResponseEntity<?> verifica(@PathVariable("email") String email) {
		if (usuarioRepository.findByEmail(email) == null)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);

	}

	@GetMapping(value = "/logado")
	public @ResponseBody ResponseEntity<?> logado(HttpSession session) {
		return new ResponseEntity<>((Usuario) session.getAttribute("usuario"), HttpStatus.OK);
	}
}
