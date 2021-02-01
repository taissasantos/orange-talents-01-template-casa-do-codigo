package br.com.zup.casadocodigo.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.casadocodigo.model.Livro;

public class ListLivroDTO {

	private String nome;

	public ListLivroDTO() {}
	
	public ListLivroDTO(Livro livro) {
		nome = livro.getTitulo();
		
	}

	public List<ListLivroDTO> converter(List<Livro> livro) {
		return livro.stream().map(ListLivroDTO::new).collect(Collectors.toList());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
