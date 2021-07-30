package br.com.zup.transacao.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.transacao.controller.dto.TransacaoDto;
import br.com.zup.transacao.controller.validacao.ApiErroException;
import br.com.zup.transacao.model.Cartao;
import br.com.zup.transacao.model.Transacao;
import br.com.zup.transacao.repository.CartaoRepository;
import br.com.zup.transacao.repository.TransacaoRepository;

@RestController
@RequestMapping("/transacoes")
public class TransacoesController {

	@Autowired
	private TransacaoRepository transacaoRepository;
	@Autowired
	private CartaoRepository cartaoRepository;

	@GetMapping("/{idCartao}")
	public Page<TransacaoDto> consultarTransacoes(@PathVariable String idCartao,
			@PageableDefault(sort = "efetivadaEm", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		Optional<Cartao> cartao = cartaoRepository.findByIdCartao(idCartao);
		
		if (cartao.isPresent()) {
			Page<Transacao> transacoes = transacaoRepository.findByCartao(cartao.get(), paginacao);
			Page<TransacaoDto> transacoesDto = TransacaoDto.converter(transacoes);
			return transacoesDto;
		}
		
		throw new ApiErroException(HttpStatus.NOT_FOUND, "Não foram encontradas transações para esse cartão");
	}
}
