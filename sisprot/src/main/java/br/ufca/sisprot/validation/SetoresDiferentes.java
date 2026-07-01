package br.ufca.sisprot.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * Valida que setorOrigem e setorDestino são diferentes.
 * Aplica-se a nível de classe (record/DTO inteiro).
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SetoresDiferentesValidator.class)
public @interface SetoresDiferentes {

    String message() default "O setor de destino deve ser diferente do setor de origem";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
