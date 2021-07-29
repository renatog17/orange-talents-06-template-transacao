package br.com.zup.transacao.dto.kafka;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EventoDeTransacao {

	private String id;
	private BigDecimal valor;
	private Estabelecimento estabelecimento;
	private Cartao cartao;
	private LocalDate efetivadaEm;
	
	public EventoDeTransacao() {
		super();
	}

	public String getId() {
		return id;
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

	public LocalDate getEfetivadaEm() {
		return efetivadaEm;
	}
	
	
	
}