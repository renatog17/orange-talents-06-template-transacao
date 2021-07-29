package br.com.zup.transacao;

import br.com.zup.transacao.dto.kafka.EventoDeTransacao;
import br.com.zup.transacao.kafka.ListenerDeTransacao;

public class Main {

	public static void main(String[] args) {
		EventoDeTransacao evento = null;
		ListenerDeTransacao listener = new ListenerDeTransacao();

		listener.ouvir(evento);
	}

}
