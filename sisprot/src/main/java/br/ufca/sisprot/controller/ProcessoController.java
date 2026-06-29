package br.ufca.sisprot.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.ufca.sisprot.dto.ProcessoRequestDTO;
import br.ufca.sisprot.dto.ProcessoResponseDTO;
import br.ufca.sisprot.service.ProcessoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/processos")
@RequiredArgsConstructor
public class ProcessoController {

    private final ProcessoService service;

    @GetMapping
    public Page<ProcessoResponseDTO> listar(Pageable pageable) {
        return service.listarTodos(pageable);
    }

    @GetMapping("/{id}")
    public ProcessoResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProcessoResponseDTO criar(@Valid @RequestBody ProcessoRequestDTO dto) {
        return service.criar(dto);
    }

    @PutMapping("/{id}")
    public ProcessoResponseDTO atualizar(@PathVariable Long id,
                                         @Valid @RequestBody ProcessoRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
