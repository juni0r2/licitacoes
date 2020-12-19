package br.com.licitacoes.empenhos.model.form;

import br.com.licitacoes.empenhos.model.Cliente;
import br.com.licitacoes.empenhos.model.Empenho;
import br.com.licitacoes.empenhos.model.Item;
import br.com.licitacoes.empenhos.repository.ClienteRepository;
import br.com.licitacoes.empenhos.repository.ItemRepository;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class EmpenhoForm {

    private String numeroEmpenho;
    private BigDecimal valor;
    private Long idEmpenhoOrigem;
    private Long idCliente;
    private List<Long> idItens;

    public Empenho converter(ClienteRepository clienteRepository, ItemRepository itemRepository) {
        Cliente cliente = null;
        if (idCliente != null) {
            Optional<Cliente> optionalCliente = clienteRepository.findById(idCliente);
            if (optionalCliente.isPresent()) {
                cliente = optionalCliente.get();
            }
        }

        List<Item> itens = itemRepository.findAllById(idItens);

        if (itens.isEmpty())
            itens = null;

        return new Empenho(this.numeroEmpenho, this.idEmpenhoOrigem, this.valor, cliente, itens);
    }
}
