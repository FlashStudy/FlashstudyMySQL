package br.com.flashstudy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

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
}
