package br.ufca.sisprot.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufca.sisprot.dto.MovimentacaoRequestDTO;
import br.ufca.sisprot.dto.MovimentacaoResponseDTO;
import br.ufca.sisprot.exception.MovimentacaoNaoEncontradaException;
import br.ufca.sisprot.exception.ProcessoNaoEncontradoException;
import br.ufca.sisprot.model.Movimentacao;
import br.ufca.sisprot.repository.MovimentacaoRepository;
import br.ufca.sisprot.repository.ProcessoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MovimentacaoService {

    private final ProcessoRepository processoRepository;
    private final MovimentacaoRepository movimentacaoRepository;

    @Transactional(readOnly = true)
    public List<MovimentacaoResponseDTO> listarPorProcesso(Long processoId) {
        if (!processoRepository.existsById(processoId)) {
            throw new ProcessoNaoEncontradoException(processoId);
        }
        return movimentacaoRepository.findByProcessoId(processoId)
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public MovimentacaoResponseDTO buscarPorId(Long id) {
        Movimentacao mov = movimentacaoRepository.findById(id)
                .orElseThrow(() -> new MovimentacaoNaoEncontradaException(id));
        return toResponseDTO(mov);
    }

    public MovimentacaoResponseDTO criar(Long processoId, MovimentacaoRequestDTO dto) {
        var processo = processoRepository.findById(processoId)
                .orElseThrow(() -> new ProcessoNaoEncontradoException(processoId));

        Movimentacao mov = new Movimentacao();
        mov.setProcesso(processo);
        mov.setDataMovimentacao(dto.dataMovimentacao());
        mov.setSetorOrigem(dto.setorOrigem());
        mov.setSetorDestino(dto.setorDestino());
        mov.setDespacho(dto.despacho());
        mov.setUsuarioResponsavel(dto.usuarioResponsavel());

        // Salva explicitamente — o save() retorna o objeto com ID populado
        mov = movimentacaoRepository.save(mov);

        // Mantém a coleção sincronizada (bidirecionalidade)
        processo.getMovimentacoes().add(mov);

        return toResponseDTO(mov);
    }

    private MovimentacaoResponseDTO toResponseDTO(Movimentacao mov) {
        return new MovimentacaoResponseDTO(
                mov.getId(),
                mov.getProcesso().getId(),
                mov.getDataMovimentacao(),
                mov.getSetorOrigem(),
                mov.getSetorDestino(),
                mov.getDespacho(),
                mov.getUsuarioResponsavel()
        );
    }

}
