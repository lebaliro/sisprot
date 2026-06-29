package br.ufca.sisprot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufca.sisprot.model.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long> {

    Optional<Processo> findByNumero(String numero);

    boolean existsByNumero(String numero);
}