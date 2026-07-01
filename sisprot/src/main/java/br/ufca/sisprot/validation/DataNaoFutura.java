package br.ufca.sisprot.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * Valida que a data não está no futuro.
 * Aplica-se a campos LocalDateTime.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DataNaoFuturaValidator.class)
public @interface DataNaoFutura {

    String message() default "A data não pode ser no futuro";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
