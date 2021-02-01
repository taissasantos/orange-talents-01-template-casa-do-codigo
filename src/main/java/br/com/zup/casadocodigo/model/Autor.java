package br.com.zup.casadocodigo.model;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long	id;
	
	@NotBlank
	@Column(unique = true , nullable = false)
	public String nome;
	
	@Email
	@Column(unique = true , nullable = false)
	public String email;
	
	@NotBlank
	@Column(nullable = false)
	@Size(max = 400)
	public String descricao;
	
	@Column(nullable = false)
	public LocalDateTime dataCriacao = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
	
	
	public Autor() {}


	public Autor(@NotBlank String nome, @Email String email, @NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	

}
