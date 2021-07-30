package br.com.zup.transacao.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.zup.transacao.model.Transacao;

public class TransacaoDto {

	private BigDecimal valor;
	private LocalDateTime efetivadaEm;
	private String nomeEstabelecimento;

	public TransacaoDto(Transacao transacao) {
		super();
		this.valor = transacao.getValor();
		this.efetivadaEm = transacao.getEfetivadaEm();
		this.nomeEstabelecimento = transacao.getEstabelecimento().getNome();
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}

	public static Page<TransacaoDto> converter(Page<Transacao> transacoes) {
		return transacoes.map(TransacaoDto::new);
	}
}
