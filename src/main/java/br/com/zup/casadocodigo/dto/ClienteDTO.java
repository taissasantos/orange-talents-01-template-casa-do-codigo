package br.com.zup.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

public class ClienteDTO {
	
	@Email
	@NotBlank(message ="email é obrigatório" )
	private String email;
	
	@NotBlank(message = "nome é obrigatório")
	private String nome;
	
	@NotBlank(message ="sobrenome é obrigatório" )
	private String sobrenome;
	
	@NotBlank(message ="documento é obrigatório" )
	private String documento;
	
	@NotBlank(message = "endereço é obrigatório" )
	private String endereco;
	
	@NotBlank(message = "complemento é obrigatório" )
	private String complemento;
	
	@NotBlank(message = " cidade é obrigatório")
	private String cidade;
	
	@NotNull
	//@UniqueValue(domainClass = Pais.class, fieldName = "id", message = "pais é obrigatório")
	private Long idPais;
	
	//@UniqueValue(domainClass = Estado.class, fieldName = "id" , message = "estado é obrigatório")
	private Long idEstado;
	
	@NotBlank(message = " telefone é obrigatório")
	private String telefone;
	
	@NotBlank(message = "cep é obrigatório" )
	private String cep;

	public ClienteDTO() {}

	public ClienteDTO(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, Long idEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	@Override
	public String toString() {
		return "ClienteDTO [email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento=" + documento
				+ ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade + ", idPais="
				+ idPais + ", idEstado=" + idEstado + ", telefone=" + telefone + ", cep=" + cep + "]";
	}

	public boolean documentoValido() {
		Assert.hasLength(documento, "você deve usar um documento válido");
		
		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);
		
		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);
		
		return cpfValidator.isValid(documento, null)
				|| cnpjValidator.isValid(documento, null);
	}
	
	

}
