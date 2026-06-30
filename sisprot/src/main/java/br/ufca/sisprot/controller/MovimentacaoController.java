package br.ufca.sisprot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.ufca.sisprot.dto.MovimentacaoRequestDTO;
import br.ufca.sisprot.dto.MovimentacaoResponseDTO;
import br.ufca.sisprot.service.MovimentacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MovimentacaoController {

    private final MovimentacaoService service;

    @GetMapping("/api/processos/{processoId}/movimentacoes")
    public List<MovimentacaoResponseDTO> listarPorProcesso(@PathVariable Long processoId) {
        return service.listarPorProcesso(processoId);
    }

    @GetMapping("/api/movimentacoes/{id}")
    public MovimentacaoResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/api/processos/{processoId}/movimentacoes")
    @ResponseStatus(HttpStatus.CREATED)
    public MovimentacaoResponseDTO criar(@PathVariable Long processoId,
                                         @Valid @RequestBody MovimentacaoRequestDTO dto) {
        return service.criar(processoId, dto);
    }

}
