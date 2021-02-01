package br.com.zup.casadocodigo.dto;

import java.math.BigDecimal;

import br.com.zup.casadocodigo.model.Livro;

public class DetalheLivroDTO {

	private String titulo;
	private AutorDetalhesSiteDTO autor;
	private String isbn;
	private Integer numeroPaginas;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	
	public DetalheLivroDTO() {}

	public DetalheLivroDTO(Livro livroBuscado) {
		titulo = livroBuscado.getTitulo();
		autor = new AutorDetalhesSiteDTO(livroBuscado.getAutor());
		isbn = livroBuscado.getIsbn();
		numeroPaginas = livroBuscado.getNumeroPaginas();
		preco = livroBuscado.getPreco();
		resumo = livroBuscado.getResumo();
		sumario = livroBuscado.getSumario();
		
	}

	public String getTitulo() {
		return titulo;
	}

	public AutorDetalhesSiteDTO getAutor() {
		return autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}
	
	

}
