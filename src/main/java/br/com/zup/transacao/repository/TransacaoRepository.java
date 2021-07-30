package br.com.zup.transacao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.transacao.model.Cartao;
import br.com.zup.transacao.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{

	Page<Transacao> findByCartao(Cartao cartao, Pageable pageable);
}
