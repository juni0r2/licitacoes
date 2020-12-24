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
    private Long idEmpenhoOrigem;
    private String numeroEmpenho;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private BigDecimal valor;
    private Cliente cliente;
    private List<Item> itens;

    public EmpenhoDTO(Empenho empenho) {
        this.id = empenho.getId();
        this.idEmpenhoOrigem = empenho.getIdEmpenhoOrigem();
        this.numeroEmpenho = empenho.getNumeroEmpenho();
        this.dataCriacao = empenho.getDataCriacao();
        this.valor = empenho.getValor();
        this.itens = empenho.getItens();
    }

    public static List<EmpenhoDTO> converter(List<Empenho> empenhos) {
        return empenhos.stream().map(EmpenhoDTO::new).collect(Collectors.toList());
    }
}
