package br.ufca.sisprot.exception;

/**
 * Exceção de negócio — lançada quando um processo não é encontrado.
 * Totalmente desacoplada de HTTP. O ControllerAdvice traduz para 404.
 */
public class ProcessoNaoEncontradoException extends RuntimeException {

    public ProcessoNaoEncontradoException(Long id) {
        super("Processo não encontrado com id: " + id);
    }
}
