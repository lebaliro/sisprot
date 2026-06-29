package br.ufca.sisprot.config;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.ufca.sisprot.exception.NumeroProcessoDuplicadoException;
import br.ufca.sisprot.exception.ProcessoNaoEncontradoException;

/**
 * Traduz exceções de negócio (puras, sem HTTP) em respostas HTTP apropriadas.
 * Único ponto da aplicação que conhece códigos HTTP — o Service permanece puro.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProcessoNaoEncontradoException.class)
    public ResponseEntity<Map<String, Object>> handleNaoEncontrado(ProcessoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "status", 404,
                        "erro", "Não encontrado",
                        "mensagem", ex.getMessage(),
                        "timestamp", LocalDateTime.now()
                )
        );
    }

    @ExceptionHandler(NumeroProcessoDuplicadoException.class)
    public ResponseEntity<Map<String, Object>> handleDuplicado(NumeroProcessoDuplicadoException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                Map.of(
                        "status", 409,
                        "erro", "Conflito",
                        "mensagem", ex.getMessage(),
                        "timestamp", LocalDateTime.now()
                )
        );
    }
}
