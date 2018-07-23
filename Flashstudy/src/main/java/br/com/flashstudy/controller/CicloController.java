package br.com.flashstudy.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import br.com.flashstudy.error.Resposta;
import br.com.flashstudy.model.*;
import br.com.flashstudy.repository.CicloRepository;
import br.com.flashstudy.repository.DisciplinaRepository;

//Controller do ciclo
@Component
@RestController
@RequestMapping(value = "/ciclo")
public class CicloController {

	@Autowired
	private CicloRepository cicloRepository;

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@GetMapping(path = "/atual")
	public ResponseEntity<?> getAtual(HttpSession session) {
		return new ResponseEntity<>(cicloRepository.getByUsuario((Usuario) session.getAttribute("usuario")),
				HttpStatus.OK);
	}

	// Salva/atualiza o cronograma do usuário
	@PostMapping(path = "/salvar")
	public ResponseEntity<?> salvar(@RequestBody Ciclo ciclo, HttpSession session) {
		Random rand = new Random();
		
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		Ciclo c = new Ciclo(ciclo.getCodigo(), ciclo.getNumMaterias(), usuario);

		Set<DiaDaSemana> dias = ciclo.getDias();

		List<Disciplina> disciplinas = disciplinaRepository.getByUsuario(usuario);

		int arrLength = disciplinas.size();
		
		c.setDias(new HashSet<>());

		for (DiaDaSemana dia : dias) {
			for(int i = 0; i < ciclo.getNumMaterias(); i++) {
				
				Horario horario = new Horario(i, disciplinas.get(rand.nextInt(arrLength)), usuario);
				dia.addHorario(horario);
			}
			dia.setUsuario(usuario);
			c.addDiaDaSemana(dia);
		}
		
		return new ResponseEntity<>(cicloRepository.save(c), HttpStatus.OK);

	}
}
