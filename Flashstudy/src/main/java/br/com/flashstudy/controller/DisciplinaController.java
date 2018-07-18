package br.com.flashstudy.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import br.com.flashstudy.error.Resposta;
import br.com.flashstudy.model.Assunto;
import br.com.flashstudy.model.Disciplina;
import br.com.flashstudy.model.Usuario;
import br.com.flashstudy.repository.DisciplinaRepository;

//Controller de Disciplinas
@Component
@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	// Lista as disciplinas de um usuário
	@GetMapping(value = "/lista")
	public ResponseEntity<?> lista(HttpSession session) {
		return new ResponseEntity<>(disciplinaRepository.getByUsuario((Usuario) session.getAttribute("usuario")),
				HttpStatus.OK);
	}

	// Salva/atualiza a disciplina
	@PostMapping(path = "/salvar")
	public ResponseEntity<?> salvar(@RequestBody Disciplina disciplina, HttpSession session) {

		Disciplina d = new Disciplina();

		Set<Assunto> assuntos = disciplina.getAssuntos();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		d.setCodigo(disciplina.getCodigo());
		d.setNome(disciplina.getNome());
		d.setUsuario(usuario);

		for (Assunto a : assuntos) {
			a.setUsuario(usuario);
			d.addAssunto(a);
		}

		disciplinaRepository.save(d);

		return new ResponseEntity<>(new Resposta("Disciplina e assuntos salvos!"), HttpStatus.OK);

	}
}
