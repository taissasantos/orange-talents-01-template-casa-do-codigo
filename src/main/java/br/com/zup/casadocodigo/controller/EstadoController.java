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

import br.com.zup.casadocodigo.dto.EstadoDTO;
import br.com.zup.casadocodigo.model.Estado;

@RestController
public class EstadoController {

	@PersistenceContext
	EntityManager manager;

	@PostMapping(value = "/estado")
	@Transactional
	public ResponseEntity<Estado>cadastraEstado(@RequestBody @Valid EstadoDTO estadoDto){
		Estado estado = estadoDto.toModel(manager);
		manager.persist(estado);

		return ResponseEntity.status(HttpStatus.OK).build();

	}

}
