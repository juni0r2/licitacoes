package br.com.licitacoes.empenhos.model.form;

import br.com.licitacoes.empenhos.model.Item;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ItemForm {

    private Integer codigoItem;
    private String descricao;
    private BigDecimal valorUnitario;

    public Item converter() {
        return new Item(this.codigoItem, this.descricao, this.valorUnitario);
    }
}
