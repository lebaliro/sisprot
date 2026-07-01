package br.ufca.sisprot.dto;

import java.time.LocalDateTime;

import br.ufca.sisprot.validation.DataNaoFutura;
import br.ufca.sisprot.validation.SetoresDiferentes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * DTO de entrada para criação de uma movimentação.
 */
@SetoresDiferentes
public record MovimentacaoRequestDTO(

        @NotNull(message = "A data da movimentação é obrigatória")
        @DataNaoFutura
        LocalDateTime dataMovimentacao,

        @NotBlank(message = "O setor de origem é obrigatório")
        @Size(max = 100, message = "O setor de origem deve ter no máximo 100 caracteres")
        String setorOrigem,

        @NotBlank(message = "O setor de destino é obrigatório")
        @Size(max = 100, message = "O setor de destino deve ter no máximo 100 caracteres")
        String setorDestino,

        @NotBlank(message = "O despacho é obrigatório")
        @Size(max = 500, message = "O despacho deve ter no máximo 500 caracteres")
        String despacho,

        @NotBlank(message = "O usuário responsável é obrigatório")
        @Size(max = 100, message = "O usuário responsável deve ter no máximo 100 caracteres")
        String usuarioResponsavel

) {}
