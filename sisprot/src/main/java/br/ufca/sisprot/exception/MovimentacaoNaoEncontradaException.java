package br.ufca.sisprot.exception;

/**
 * Exceção lançada quando uma movimentação não é encontrada.
 */
public class MovimentacaoNaoEncontradaException extends RuntimeException {

    public MovimentacaoNaoEncontradaException(Long id) {
        super("Movimentação não encontrada com ID: " + id);
    }

}
