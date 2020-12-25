package br.com.licitacoes.empenhos.model;

import br.com.licitacoes.empenhos.model.enums.EnumSituacaoAtivoInativo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_ITEM")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IT_ID")
    private Long id;

    @Column(name = "IT_CODIGO")
    private Integer codigoItem;

    @Column(name = "IT_DESCRICAO")
    private String descricao;

    @Column(name = "IT_DATA_CRIACAO")
    private LocalDateTime dataCricao = LocalDateTime.now();

    @Column(name = "IT_VALOR_UNIT")
    private BigDecimal valorUnitario;

    @Column(name = "IT_QTD_TOTAL")
    private Integer quantidadeTotal = 0;

    @Column(name = "IT_QTD_ENTREGUE")
    private Integer quantidadeEntregue = 0;

    @Column(name = "IT_QTD_ENTREGAR")
    private Integer quantidadeAEntregar = 0;

    @Column(name = "IT_ATIVO")
    @Enumerated(EnumType.STRING)
    private EnumSituacaoAtivoInativo situaco = EnumSituacaoAtivoInativo.ATIVO;

    public Item(final Long id,
                final Integer codigoItem,
                final String descricao,
                final BigDecimal valorUnitario,
                final Integer quantidadeSolicitada) {

        this.id = id;
        this.codigoItem = codigoItem;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidadeTotal = quantidadeSolicitada;
    }
}
