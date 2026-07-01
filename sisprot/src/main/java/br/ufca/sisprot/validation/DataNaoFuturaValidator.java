package br.ufca.sisprot.validation;

import java.time.LocalDateTime;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Implementação da validação @DataNaoFutura.
 */
public class DataNaoFuturaValidator implements ConstraintValidator<DataNaoFutura, LocalDateTime> {

    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // null é tratado por @NotNull
        }
        return !value.isAfter(LocalDateTime.now());
    }

}
