package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.DetalheLivroDTO;
import br.com.zup.casadocodigo.model.Livro;

@RestController
public class LivroDetalhesController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@GetMapping(value = "/detalhes/{id}")
	public ResponseEntity<?> getDetalhesLivro(@PathVariable("id") Long id) {
		
		Livro livroBuscado = manager.find(Livro.class, id);
		
		if(livroBuscado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		DetalheLivroDTO detalheLivroDTO = new DetalheLivroDTO(livroBuscado);
		return ResponseEntity.ok(detalheLivroDTO);
	}

}
