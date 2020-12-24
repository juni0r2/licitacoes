package br.com.licitacoes.empenhos.model.dto;

import br.com.licitacoes.empenhos.model.Cliente;
import br.com.licitacoes.empenhos.model.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ItemDTO {

    private Long id;
    private Integer codigoItem;
    private String descricao;
    private LocalDateTime dataCricao = LocalDateTime.now();
    private BigDecimal valorUnitario;
    private Integer quantidadeTotal;
    private Integer quantidadeEntregue;
    private Integer quantidadeAEntregar;

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.codigoItem = item.getCodigoItem();
        this.descricao = item.getDescricao();
        this.dataCricao = item.getDataCricao();
        this.valorUnitario = item.getValorUnitario();
        this.quantidadeTotal = item.getQuantidadeTotal();
        this.quantidadeEntregue = item.getQuantidadeEntregue();
        this.quantidadeAEntregar = item.getQuantidadeAEntregar();
    }

    public static List<ItemDTO> converter(final List<Item> itens) {
        return itens.stream().map(ItemDTO::new).collect(Collectors.toList());
    }
}
