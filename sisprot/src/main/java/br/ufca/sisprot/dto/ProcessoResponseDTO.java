package br.ufca.sisprot.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * DTO de saída — o que a API devolve ao cliente.
 * NUNCA expõe a entidade JPA diretamente.
 */
public record ProcessoResponseDTO(

        Long id,

        String numero,

        String titulo,

        String descricao,

        String interessado,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime dataCriacao,

        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime dataAtualizacao

) {}
