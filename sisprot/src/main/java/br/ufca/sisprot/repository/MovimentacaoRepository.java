package br.ufca.sisprot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufca.sisprot.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    List<Movimentacao> findByProcessoId(Long processoId);

}
