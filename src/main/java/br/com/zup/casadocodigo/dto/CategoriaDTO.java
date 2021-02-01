package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.validator.UniqueValue;

public class CategoriaDTO {

	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	
	public CategoriaDTO() {}

	public CategoriaDTO(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	
	
	
}
