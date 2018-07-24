package br.com.flashstudy.controller;

import java.util.HashSet;
import java.util.Set;

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

import br.com.flashstudy.model.Assunto;
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

	//Operações no BD do cronograma
	@Autowired
	CronogramaRepository cronogramaRepository;

	//Operações no BD das disciplinas
	@Autowired
	DisciplinaRepository disciplinaRepository;

	// Salva/atualiza o cronograma do usuário
	@PostMapping(path = "/salvar")
	public ResponseEntity<?> salvar(@RequestBody Cronograma cronograma, HttpSession session) {

		Cronograma c = new Cronograma(cronograma.getCodigo(), cronograma.getInicio(), cronograma.getFim(),
				(Usuario) session.getAttribute("usuario"));
		
		c.setDisciplinas(new HashSet<>());
		
		for (Disciplina disciplina : cronograma.getDisciplinas()) {
			disciplina.setUsuario((Usuario) session.getAttribute("usuario"));
			
			Set<Assunto> assuntos = disciplina.getAssuntos();
			
			if(assuntos != null) {
				disciplina.setAssuntos(new HashSet<>());
				for(Assunto assunto : assuntos) {
					disciplina.addAssunto(assunto);
				}
			}
			
			c.addDisciplina(disciplina);
		}

		return new ResponseEntity<>(cronogramaRepository.save(c), HttpStatus.OK);

	}

	// Busca o cronograma atual do usuário
	@GetMapping(path = "/atual")
	public ResponseEntity<?> lista(HttpSession session) {

		return new ResponseEntity<>(cronogramaRepository.getByUsuario((Usuario) session.getAttribute("usuario")),
				HttpStatus.OK);

	}

}
