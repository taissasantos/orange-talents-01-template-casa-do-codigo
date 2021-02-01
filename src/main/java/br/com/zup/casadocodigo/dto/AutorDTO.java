package br.com.zup.casadocodigo.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.validator.UniqueValue;

public class AutorDTO {

	
	public String nome;

	
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	public String email;

	
	public String descricao;
	
	public AutorDTO(){}

	public AutorDTO(String nome, String email,  String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;

	}

	
	public Autor toModel() { 
		return new Autor(this.nome, this.email, this.descricao);
	}


	public String getEmail() {
		return this.getEmail();
	}
	 


	



}
