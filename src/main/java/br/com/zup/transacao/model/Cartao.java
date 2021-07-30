package br.com.zup.transacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String idCartao;
	@NotBlank
	private String email;
	@Deprecated
	public Cartao() {
		super();
	}

	public Cartao(@NotBlank String idCartao, @NotBlank String email) {
		super();
		this.idCartao = idCartao;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getIdCartao() {
		return idCartao;
	}

	public String getEmail() {
		return email;
	}

}
