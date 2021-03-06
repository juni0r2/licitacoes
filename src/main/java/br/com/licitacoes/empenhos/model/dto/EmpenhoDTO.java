package br.com.licitacoes.empenhos.model.dto;

import br.com.licitacoes.empenhos.model.Cliente;
import br.com.licitacoes.empenhos.model.Empenho;
import br.com.licitacoes.empenhos.model.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmpenhoDTO {

    private Long id;
    private String numeroEmpenho;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private BigDecimal valor;
    private ClienteDTO cliente;
    private List<ItemDTO> itens;

    public EmpenhoDTO(Empenho empenho) {
        this.id = empenho.getId();
        this.numeroEmpenho = empenho.getNumeroEmpenho();
        this.dataCriacao = empenho.getDataCriacao();
        this.valor = empenho.getValor();
        this.itens = ItemDTO.converter(empenho.getItens());
        this.cliente = new ClienteDTO(empenho.getCliente());
    }

    public static List<EmpenhoDTO> converter(List<Empenho> empenhos) {
        return empenhos.stream().map(EmpenhoDTO::new).collect(Collectors.toList());
    }
}
