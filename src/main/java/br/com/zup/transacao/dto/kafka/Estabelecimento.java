package br.com.zup.transacao.dto.kafka;

public class Estabelecimento {

	private String nome;
	private String cidade;
	private String endereco;

	public Estabelecimento(String nome, String cidade, String endereco) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public Estabelecimento() {
		super();
		// TODO Auto-generated constructor stub
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

}
