package br.ufca.sisprot.service;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufca.sisprot.dto.ProcessoRequestDTO;
import br.ufca.sisprot.dto.ProcessoResponseDTO;
import br.ufca.sisprot.exception.NumeroProcessoDuplicadoException;
import br.ufca.sisprot.exception.ProcessoNaoEncontradoException;
import br.ufca.sisprot.model.Processo;
import br.ufca.sisprot.repository.ProcessoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProcessoService {

    private final ProcessoRepository repository;

    @Transactional(readOnly = true)
    public Page<ProcessoResponseDTO> listarTodos(Pageable pageable) {
        return repository.findAll(pageable)
                .map(this::toResponseDTO);
    }

    @Transactional(readOnly = true)
    public ProcessoResponseDTO buscarPorId(Long id) {
        Processo processo = repository.findById(id)
                .orElseThrow(() -> new ProcessoNaoEncontradoException(id));
        return toResponseDTO(processo);
    }

    @Transactional
    public ProcessoResponseDTO criar(ProcessoRequestDTO dto) {
        if (repository.existsByNumero(dto.numero())) {
            throw new NumeroProcessoDuplicadoException(dto.numero());
        }

        Processo processo = new Processo();
        processo.setNumero(dto.numero());
        processo.setTitulo(dto.titulo());
        processo.setDescricao(dto.descricao());
        processo.setInteressado(dto.interessado());
        processo.setDataCriacao(LocalDateTime.now());

        Processo salvo = repository.save(processo);
        return toResponseDTO(salvo);
    }

    @Transactional
    public ProcessoResponseDTO atualizar(Long id, ProcessoRequestDTO dto) {
        Processo processo = repository.findById(id)
                .orElseThrow(() -> new ProcessoNaoEncontradoException(id));

        // Verifica se o novo número já pertence a OUTRO processo
        repository.findByNumero(dto.numero()).ifPresent(outro -> {
            if (!outro.getId().equals(id)) {
                throw new NumeroProcessoDuplicadoException(dto.numero());
            }
        });

        processo.setNumero(dto.numero());
        processo.setTitulo(dto.titulo());
        processo.setDescricao(dto.descricao());
        processo.setInteressado(dto.interessado());
        processo.setDataAtualizacao(LocalDateTime.now());

        Processo atualizado = repository.save(processo);
        return toResponseDTO(atualizado);
    }

    @Transactional
    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new ProcessoNaoEncontradoException(id);
        }
        repository.deleteById(id);
    }

    // --- Métodos auxiliares de mapeamento ---

    private ProcessoResponseDTO toResponseDTO(Processo processo) {
        return new ProcessoResponseDTO(
                processo.getId(),
                processo.getNumero(),
                processo.getTitulo(),
                processo.getDescricao(),
                processo.getInteressado(),
                processo.getDataCriacao(),
                processo.getDataAtualizacao()
        );
    }
}
