package br.com.flashstudy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

		List<Disciplina> disciplinas = new ArrayList<>();
		List<Disciplina> aux = new ArrayList<>();

		disciplinas = cronograma.getDisciplinas();

		Usuario usuario = (Usuario) session.getAttribute("usuario");

		cronograma.setUsuario(usuario);

		for (Disciplina d : disciplinas) {
			d.setUsuario(usuario);

			disciplinaRepository.save(d);

			System.out.println(d.toString());

			aux.add(d);
		}

		cronograma.setDisciplinas(aux);

		cronogramaRepository.save(cronograma);

		System.out.println(cronograma.toString());

		return new ResponseEntity<>(new Resposta("Cronograma e Disciplinas salvos!"), HttpStatus.OK);

	}

	// Busca o cronograma atual do usuário
	@GetMapping(path = "/atual")
	public ResponseEntity<?> lista(HttpSession session) {

		return new ResponseEntity<>(cronogramaRepository.getByUsuario((Usuario) session.getAttribute("usuario")),
				HttpStatus.OK);

	}

}
