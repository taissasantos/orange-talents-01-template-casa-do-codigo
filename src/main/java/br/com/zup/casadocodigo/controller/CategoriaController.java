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

import br.com.zup.casadocodigo.dto.CategoriaDTO;
import br.com.zup.casadocodigo.model.Categoria;

@RestController
public class CategoriaController {

	@PersistenceContext
	EntityManager manager;

	@PostMapping(value = "/categorias")
	@Transactional
	public ResponseEntity<Categoria>cadastraCategoria(@RequestBody @Valid CategoriaDTO categoriaDto){

		Categoria categoria = new Categoria(categoriaDto.getNome());
		manager.persist(categoria);
		return ResponseEntity.status(HttpStatus.OK).build();


	}
}
