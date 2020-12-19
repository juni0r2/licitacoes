package br.com.licitacoes.empenhos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLI_ID")
    private Long id;

    @Column(name = "CLI_NOME")
    private String nome;

    @Column(name = "CLI_SIGLA")
    private String sigla;

    @Column(name = "CLI_DATA_CRIACAO")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Cliente(final String nome, final String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }
}
