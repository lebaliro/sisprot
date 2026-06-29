package br.ufca.sisprot.exception;

/**
 * Exceção de negócio — lançada quando tenta criar/atualizar com número já existente.
 * Totalmente desacoplada de HTTP. O ControllerAdvice traduz para 409.
 */
public class NumeroProcessoDuplicadoException extends RuntimeException {

    public NumeroProcessoDuplicadoException(String numero) {
        super("Já existe um processo com o número: " + numero);
    }
}
