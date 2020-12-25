package br.com.licitacoes.empenhos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TB_EMPENHO")
public class Empenho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EM_ID")
    private Long id;

    @Column(name = "EM_NUM_EMPENHO")
    private String numeroEmpenho;

    @Column(name = "EM_DATA_CRIACAO")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "EM_VALOR_EMPENHO")
    private BigDecimal valor;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "CLI_ID")
    private Cliente cliente;

    @ManyToMany
    private List<Item> itens = new LinkedList<>();

    public Empenho(String numeroEmpenho, BigDecimal valor, Cliente cliente, List<Item> itens) {
        this.numeroEmpenho = numeroEmpenho;
        this.valor = valor;
        this.cliente = cliente;
        this.itens = itens;
    }
}
