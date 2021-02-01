package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.PaisDTO;
import br.com.zup.casadocodigo.model.Pais;

@RestController
public class PaisController {

	@Autowired
	EntityManager manager;

	@PostMapping(value = "/pais")
	@Transactional
	public ResponseEntity<Pais>cadastraPais(@RequestBody @Valid PaisDTO paisDTO){	
		Pais pais = new Pais(paisDTO.getNome());
		manager.persist(pais);

		return ResponseEntity.status(HttpStatus.OK).build();

	}

}
