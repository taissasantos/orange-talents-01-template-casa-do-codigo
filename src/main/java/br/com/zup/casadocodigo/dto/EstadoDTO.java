package br.com.zup.casadocodigo.dto;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.model.Estado;
import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.validator.UniqueValue;

public class EstadoDTO {
	
	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome" , message = "insira o nome")
	private String nome;
	
	private Long idPais;
	
	public EstadoDTO() {}

	public EstadoDTO(@NotBlank String nome, Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}


	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Estado toModel(EntityManager manager) {
		
		return new Estado(nome, manager.find(Pais.class, idPais));
		
	}
	

}
