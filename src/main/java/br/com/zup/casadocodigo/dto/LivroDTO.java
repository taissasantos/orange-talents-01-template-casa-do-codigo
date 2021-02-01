package br.com.zup.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.model.Livro;

public class LivroDTO {

	@NotBlank(message = "informe o título.")
	public String titulo;

	@NotBlank(message = "Digite o resumo.")
	@Size(max = 500 , message = "limite máximo 500.")
	public String resumo;

	@NotBlank(message = "Digite o sumario.")
	public String sumario;

	@NotNull
	@Min(20)
	public BigDecimal preco;

	@Min(100)
	public Integer numeroPaginas;

	@NotBlank
	public String isbn;

	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	public LocalDate dataPublicacao;

	private Long idCategoria;

	private Long idAutor;


	public LivroDTO(){}
	


	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getResumo() {
		return resumo;
	}


	public String getSumario() {
		return sumario;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}


	public String getIsbn() {
		return isbn;
	}


	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}


	public Long getIdCategoria() {
		return idCategoria;
	}


	public Long getIdAutor() {
		return idAutor;
	}


	public Livro toModel(EntityManager manager) {
		
		Autor autor = manager.find(Autor.class, idAutor);
		Categoria categoria = manager.find(Categoria.class, idCategoria);

		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, autor, categoria);
	}


	

}
