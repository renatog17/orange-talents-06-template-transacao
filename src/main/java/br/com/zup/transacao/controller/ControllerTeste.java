package br.com.zup.transacao.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.transacao.model.Estabelecimento;
import br.com.zup.transacao.repository.EstabelecimentoRepository;

@RestController
@RequestMapping("/teste")
public class ControllerTeste {

	@Autowired
	EstabelecimentoRepository repo;

	@GetMapping
	public void teste() {
		Estabelecimento estabelecimento = new Estabelecimento("Bar", "Camaçari", "Rua das flores");
		Optional<Estabelecimento> pE= repo.findByNomeAndEnderecoAndCidade(estabelecimento.getNome(), estabelecimento.getCidade(),
				estabelecimento.getEndereco());
		
		if(!pE.isPresent())
			repo.save(estabelecimento);
		}
}
