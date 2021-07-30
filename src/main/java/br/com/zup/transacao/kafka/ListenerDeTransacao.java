package br.com.zup.transacao.kafka;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.zup.transacao.dto.kafka.EventoDeTransacaoForm;
import br.com.zup.transacao.model.Cartao;
import br.com.zup.transacao.model.Estabelecimento;
import br.com.zup.transacao.model.Transacao;
import br.com.zup.transacao.repository.CartaoRepository;
import br.com.zup.transacao.repository.EstabelecimentoRepository;
import br.com.zup.transacao.repository.TransacaoRepository;

@Component
@EnableKafka
public class ListenerDeTransacao {

	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@KafkaListener(topics = "transacoes")
	public void ouvir(@Payload EventoDeTransacaoForm eventoDeTransacao) {
		
		Cartao cartao = new Cartao(eventoDeTransacao.getCartao().getId(), eventoDeTransacao.getCartao().getEmail());
		Estabelecimento estabelecimento = new Estabelecimento(eventoDeTransacao.getEstabelecimento().getNome(), eventoDeTransacao.getEstabelecimento().getCidade(), eventoDeTransacao.getEstabelecimento().getEndereco());
		
		Optional<Estabelecimento> possivelEstabelecimento = estabelecimentoRepository.findByNomeAndEnderecoAndCidade(estabelecimento.getNome(), estabelecimento.getEndereco(), estabelecimento.getCidade());
		if (possivelEstabelecimento.isPresent()) {
			estabelecimento = possivelEstabelecimento.get();
		}
		
		Optional<Cartao> possivelCartao = cartaoRepository.findByIdCartao(cartao.getIdCartao());
		if(possivelCartao.isPresent()) {
			cartao = possivelCartao.get();
		}
		
		Transacao transacao = new Transacao(eventoDeTransacao.getId(), eventoDeTransacao.getValor(), estabelecimento, cartao, eventoDeTransacao.getEfetivadaEm());
		
		cartaoRepository.save(cartao);
		estabelecimentoRepository.save(estabelecimento);
		transacaoRepository.save(transacao);
		
		System.out.print("id: "+ eventoDeTransacao.getId()+", ");
		System.out.print("valor: "+eventoDeTransacao.getValor()+", ");
		System.out.print("estabelecimento: "+eventoDeTransacao.getEstabelecimento().getCidade()+", ");
		System.out.print("cartao email: "+eventoDeTransacao.getCartao().getEmail()+", ");
		System.out.println("efetivado em "+eventoDeTransacao.getEfetivadaEm());
	}
}