package br.com.zup.transacao.kafka;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.zup.transacao.dto.kafka.EventoDeTransacao;

@Component
@EnableKafka
public class ListenerDeTransacao {

	
	@KafkaListener(topics = "transacoes")
	public void ouvir(@Payload EventoDeTransacao eventoDeTransacao) {
		System.out.print("id: "+ eventoDeTransacao.getId()+", ");
		System.out.print("valor: "+eventoDeTransacao.getValor()+", ");
		System.out.print("estabelecimento: "+eventoDeTransacao.getEstabelecimento().getCidade()+", ");
		System.out.print("cartao email: "+eventoDeTransacao.getCartao().getEmail()+", ");
		System.out.println("efetivado em "+eventoDeTransacao.getEfetivadaEm());
	}

}