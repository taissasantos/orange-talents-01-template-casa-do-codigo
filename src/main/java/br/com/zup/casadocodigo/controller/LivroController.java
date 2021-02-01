package br.com.zup.casadocodigo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.LivroDTO;
import br.com.zup.casadocodigo.model.Livro;
import br.com.zup.casadocodigo.repository.LivroRepository;

@RestController
public class LivroController {

	@Autowired
	LivroRepository repository;

	@PersistenceContext
	EntityManager manager;

	@PostMapping(value = "/livros")
	@Transactional
	public ResponseEntity<Livro>criaLivro(@RequestBody @Valid LivroDTO livroDto){
		try {
			Livro livro = livroDto.toModel(manager);
			repository.save(livro);
			return ResponseEntity.status(HttpStatus.OK).body(livro);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}



	@GetMapping(value = "/listLivros") 
	public ResponseEntity<List<Livro>>buscaLivro(){ 
		List<Livro> list = repository.findAll(); 
		return ResponseEntity.ok().body(list); }



}
