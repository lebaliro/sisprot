package br.ufca.sisprot.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Registra cada tramitação de um processo entre setores.
 * Relacionamento bidirecional com Processo via @ManyToOne.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movimentacoes")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "processo_id", nullable = false)
    @ToString.Exclude // Evita loop infinito no toString
    @EqualsAndHashCode.Exclude // Evita loop infinito no equals/hashCode
    private Processo processo;

    @Column(name = "data_movimentacao", nullable = false)
    private LocalDateTime dataMovimentacao;

    @Column(name = "setor_origem", nullable = false, length = 100)
    private String setorOrigem;

    @Column(name = "setor_destino", nullable = false, length = 100)
    private String setorDestino;

    @Column(nullable = false, length = 500)
    private String despacho;

    @Column(name = "usuario_responsavel", nullable = false, length = 100)
    private String usuarioResponsavel;

}
