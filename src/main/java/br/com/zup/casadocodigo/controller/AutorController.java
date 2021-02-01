package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.AutorDTO;
import br.com.zup.casadocodigo.model.Autor;

@RestController
public class AutorController {
	 
	@PersistenceContext
	EntityManager manager;
	
	@PostMapping(value = "/autores")
	@Transactional
	public ResponseEntity<Autor>cadastrarAutor(@RequestBody @Valid AutorDTO autorDto) {
		Autor autor = autorDto.toModel();					
		manager.persist(autor);
		
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}
	

}
