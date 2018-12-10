package br.com.flashstudy.controller;

import br.com.flashstudy.model.Assunto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flashstudy.repository.AssuntoRepository;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

//Controller de Assuntos
@Component
@RestController
@RequestMapping(value = "/assunto")
public class AssuntoController {

    @Autowired
    private AssuntoRepository assuntoRepository;

    // Deleta os assuntos selecinados
    @DeleteMapping("/delete/{codigo}")
    public ResponseEntity<?> deletar(@RequestBody List<Assunto> assuntosSelecionados) {

        for (Assunto assunto : assuntosSelecionados) {
            assuntoRepository.delete(assunto);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
