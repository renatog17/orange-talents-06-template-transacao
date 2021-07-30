package br.com.zup.transacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Estabelecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String cidade;
	@NotBlank
	private String endereco;

	public Estabelecimento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estabelecimento(@NotBlank String nome, @NotBlank String cidade, @NotBlank String endereco) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return "Estabelecimento [id=" + id + ", nome=" + nome + ", cidade=" + cidade + ", endereco=" + endereco + "]";
	}

}
