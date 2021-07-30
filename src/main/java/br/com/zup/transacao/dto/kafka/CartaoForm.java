package br.com.zup.transacao.dto.kafka;

public class CartaoForm {

	private String id;
	private String email;

	public CartaoForm(String id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	public CartaoForm() {
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
