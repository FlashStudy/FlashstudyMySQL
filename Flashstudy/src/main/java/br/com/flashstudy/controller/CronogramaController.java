package br.com.flashstudy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import br.com.flashstudy.error.Resposta;

import br.com.flashstudy.model.Cronograma;
import br.com.flashstudy.model.Disciplina;
import br.com.flashstudy.model.Usuario;

import br.com.flashstudy.repository.CronogramaRepository;
import br.com.flashstudy.repository.DisciplinaRepository;

//Controller do Cronograma
@Component
@RestController
@RequestMapping(value = "/cronograma")
public class CronogramaController {

	@Autowired
	CronogramaRepository cronogramaRepository;

	@Autowired
	DisciplinaRepository disciplinaRepository;

	// Salva/atualiza o cronograma do usuário
	@PostMapping(path = "/salvar")
	public ResponseEntity<?> salvar(@RequestBody Cronograma cronograma, HttpSession session) {

		Cronograma c = new Cronograma(cronograma.getCodigo(), cronograma.getInicio(), cronograma.getFim(),
				(Usuario) session.getAttribute("usuario"));

		for (Disciplina disciplina : cronograma.getDisciplinas()) {
			disciplina.setUsuario((Usuario) session.getAttribute("usuario"));
			c.addDisciplina(disciplina);
		}

		cronogramaRepository.save(c);

		return new ResponseEntity<>(new Resposta("Cronograma e Disciplinas salvos!"), HttpStatus.OK);

	}

	// Busca o cronograma atual do usuário
	@GetMapping(path = "/atual")
	public ResponseEntity<?> lista(HttpSession session) {

		return new ResponseEntity<>(cronogramaRepository.getByUsuario((Usuario) session.getAttribute("usuario")),
				HttpStatus.OK);

	}

}
