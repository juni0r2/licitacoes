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
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TB_ITEM")
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

    public Item(final Integer codigoItem, final String descricao, final BigDecimal valorUnitario) {
        this.codigoItem = codigoItem;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
    }
}
