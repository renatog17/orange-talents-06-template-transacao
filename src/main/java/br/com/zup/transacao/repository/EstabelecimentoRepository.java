package br.com.zup.transacao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.transacao.model.Estabelecimento;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long>{

	Optional<Estabelecimento> findByNomeAndEnderecoAndCidade(String nome, String endereco, String cidade);
	
}
