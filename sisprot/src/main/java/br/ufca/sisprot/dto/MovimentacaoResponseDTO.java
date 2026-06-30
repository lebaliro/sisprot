package br.ufca.sisprot.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * DTO de saída para leitura de movimentações.
 */
public record MovimentacaoResponseDTO(

        Long id,
        Long processoId,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime dataMovimentacao,

        String setorOrigem,
        String setorDestino,
        String despacho,
        String usuarioResponsavel

) {}
