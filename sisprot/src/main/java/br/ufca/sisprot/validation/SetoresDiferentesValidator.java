package br.ufca.sisprot.validation;

import br.ufca.sisprot.dto.MovimentacaoRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Implementação da validação @SetoresDiferentes.
 * Compara setorOrigem e setorDestino do DTO.
 */
public class SetoresDiferentesValidator implements ConstraintValidator<SetoresDiferentes, MovimentacaoRequestDTO> {

    @Override
    public boolean isValid(MovimentacaoRequestDTO dto, ConstraintValidatorContext context) {
        if (dto.setorOrigem() == null || dto.setorDestino() == null) {
            return true; // null é tratado por @NotBlank
        }
        return !dto.setorOrigem().equalsIgnoreCase(dto.setorDestino());
    }

}
