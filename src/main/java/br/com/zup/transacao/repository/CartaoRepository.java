package br.com.zup.transacao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.transacao.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Long>{

	Optional<Cartao> findByIdCartao(String idCartao);
}
