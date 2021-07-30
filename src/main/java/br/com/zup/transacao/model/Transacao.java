package br.com.zup.transacao.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String idTransacao;
	@NotNull
	private BigDecimal valor;
	@NotNull
	@ManyToOne
	private Estabelecimento estabelecimento;
	@NotNull
	@ManyToOne
	private Cartao cartao;
	@NotNull
	private LocalDateTime efetivadaEm;

	public Transacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transacao(@NotBlank String idTransacao, @NotNull BigDecimal valor, @NotNull Estabelecimento estabelecimento,
			@NotNull Cartao cartao, @NotNull LocalDateTime efetivadaEm) {
		super();
		this.idTransacao = idTransacao;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public String getIdTransacao() {
		return idTransacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

}
