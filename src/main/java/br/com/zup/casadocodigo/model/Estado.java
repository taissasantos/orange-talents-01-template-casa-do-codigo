package br.com.zup.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique = true , nullable = false)
	private String nome;
	
	
	@ManyToOne
	private Pais pais;
	
	
	@Deprecated
	public Estado() {}


	public Estado(@NotBlank String nome, @NotBlank Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public Pais getPais() {
		return pais;
	}


	public boolean pertenceAoPais(Pais pais) {
		return this.pais.equals(pais);
	}


		

}
