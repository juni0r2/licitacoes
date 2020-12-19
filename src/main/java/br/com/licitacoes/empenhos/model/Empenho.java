package br.com.licitacoes.empenhos.model;

import br.com.licitacoes.empenhos.repository.ClienteRepository;
import br.com.licitacoes.empenhos.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @Column(name = "EM_ID_ORIGEM")
    private Long idEmpenhoOrigem;

    @Column(name = "EM_NUM_EMPENHO")
    private String numeroEmpenho;

    @Column(name = "EM_DATA_CRIACAO")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "EM_VALOR_EMPENHO")
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "CLI_ID")
    private Cliente cliente;

    @OneToMany
    private List<Item> itensPedido;

    @OneToMany
    private List<Empenho> empenhos;

    public Empenho(String numeroEmpenho, Long idEmpenhoOrigem, BigDecimal valor, Cliente cliente, List<Item> itens) {
        this.numeroEmpenho = numeroEmpenho;
        this.idEmpenhoOrigem = idEmpenhoOrigem;
        this.valor = valor;
        this.cliente = cliente;
        this.itensPedido = itens;
    }
}
