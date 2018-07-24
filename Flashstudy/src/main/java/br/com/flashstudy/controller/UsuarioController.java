package br.com.flashstudy.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.com.flashstudy.error.Resposta;
import br.com.flashstudy.model.Duvida;
import br.com.flashstudy.model.Usuario;
import br.com.flashstudy.repository.UsuarioRepository;
import br.com.flashstudy.service.EmailService;

//Controller do Usário
@Component
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	// Operações no BD do usupário
	@Autowired
	UsuarioRepository usuarioRepository;

	// Service para envio dos emails
	@Autowired
	private EmailService emailService;

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

		try {
			emailService.enviarEmailCadastro(aux);
		} catch (MailException e) {
			System.out.println(e.getMessage());
		}

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

	// Verifica se o email já está cadastrado
	@GetMapping(value = "/verifica/{email}")
	public @ResponseBody ResponseEntity<?> verifica(@PathVariable("email") String email) {
		if (usuarioRepository.findByEmail(email) == null)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);

	}

	// Retorna o atual usuário logado
	@GetMapping(value = "/logado")
	public @ResponseBody ResponseEntity<?> logado(HttpSession session) {
		return new ResponseEntity<>((Usuario) session.getAttribute("usuario"), HttpStatus.OK);
	}

	// Envia a mensagem de sugestão/crítica/dúvida pelo email
	@PostMapping(value = "/mensagem")
	public @ResponseBody ResponseEntity<?> enviarMensagem(@RequestBody Duvida duvida, HttpSession session) {
		try {
			emailService.enviarEmailDuvida((Usuario) session.getAttribute("usuario"), duvida);
			return new ResponseEntity<>(new Resposta("Sua mensagem foi enviada com êxito!"), HttpStatus.OK);
		} catch (MailException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(
					new Resposta("Ocorreu um erro ao enviar sua mensagem! Por favor, tente mais tarde."),
					HttpStatus.BAD_GATEWAY);
		}
	}

	@PutMapping(value = "/atualizar")
	public @ResponseBody ResponseEntity<?> atualizar(@RequestBody Usuario usuario, HttpSession session) {

		usuarioRepository.save(usuario);

		session.setAttribute("usuario", usuario);
		
		System.out.println();
		
		try {
			emailService.enviarEmailAtualizacao(usuario);
		} catch (MailException e) {
			System.out.println(e.getMessage());
		}

		return new ResponseEntity<>(new Resposta("Seus dados foram atualizados com êxito!"), HttpStatus.OK);
	}
}
