package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.model.Autor;

public class AutorDetalhesSiteDTO  {
	
	private String nome;
	private String descricao;
	
	public AutorDetalhesSiteDTO() {}

	public AutorDetalhesSiteDTO(Autor autor) {
		nome = autor.getNome();
		descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	
}
