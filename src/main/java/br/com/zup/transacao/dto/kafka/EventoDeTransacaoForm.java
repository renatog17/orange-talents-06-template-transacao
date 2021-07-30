package br.com.zup.transacao.dto.kafka;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EventoDeTransacaoForm {

	private String id;
	private BigDecimal valor;
	private EstabelecimentoForm estabelecimento;
	private CartaoForm cartao;
	private LocalDateTime efetivadaEm;
	
	public EventoDeTransacaoForm() {
		super();
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoForm getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoForm getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
	
	
	
}