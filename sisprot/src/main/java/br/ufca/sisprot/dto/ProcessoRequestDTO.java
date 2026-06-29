package br.ufca.sisprot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO de entrada — recebe os dados que o cliente envia ao criar/atualizar um processo.
 * Usa Bean Validation para garantir que dados inválidos não cheguem ao Service.
 */
public record ProcessoRequestDTO(

        @NotBlank(message = "O número do processo é obrigatório")
        @Size(max = 25, message = "O número deve ter no máximo 25 caracteres")
        String numero,

        @NotBlank(message = "O título é obrigatório")
        @Size(min = 5, max = 200, message = "O título deve ter entre 5 e 200 caracteres")
        String titulo,

        @Size(min = 10, message = "A descrição deve ter no mínimo 10 caracteres")
        String descricao,

        @NotBlank(message = "O interessado é obrigatório")
        @Size(max = 100, message = "O interessado deve ter no máximo 100 caracteres")
        String interessado

) {}
