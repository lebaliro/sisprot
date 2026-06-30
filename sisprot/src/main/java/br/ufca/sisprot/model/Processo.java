package br.ufca.sisprot.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // Gera getters, setters, toString, equals, hashCode
@NoArgsConstructor // Construtor vazio (exigido pelo JPA)
@AllArgsConstructor // Construtor com todos os campos
@Entity
@Table(name = "processos")
public class Processo {

    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento
    private Long id;

    @Column(unique = true, nullable = false, length = 25)
    private String numero;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false, length = 100)
    private String interessado;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "processo", cascade = CascadeType.ALL)
    @JsonIgnore // Evita loop infinito na serialização JSON
    @ToString.Exclude // Evita loop infinito no toString
    @EqualsAndHashCode.Exclude // Evita loop infinito no equals/hashCode
    private Set<Movimentacao> movimentacoes = new HashSet<>();

}