package br.com.zup.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.validator.UniqueValue;

public class PaisDTO {
	
	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome" , message = "insira o nome do pais")
	private String nome;
	
	public PaisDTO() {}

	public PaisDTO(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	
	
}
