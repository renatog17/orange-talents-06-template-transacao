package br.com.zup.transacao.dto.kafka;

public class Cartao {

	private String id;
	private String email;

	public Cartao(String id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	public Cartao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

}
