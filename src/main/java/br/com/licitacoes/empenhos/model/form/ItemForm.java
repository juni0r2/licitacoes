package br.com.licitacoes.empenhos.model.form;

import br.com.licitacoes.empenhos.model.Empenho;
import br.com.licitacoes.empenhos.model.Item;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemForm {

    private Long id;
    private Integer codigoItem;
    private String descricao;
    private BigDecimal valorUnitario;
    private Integer quantidadeSolicitada = 0;

    public Item converter() {
        return new Item(this.id, this.codigoItem, this.descricao, this.valorUnitario,
                this.quantidadeSolicitada);
    }
}
