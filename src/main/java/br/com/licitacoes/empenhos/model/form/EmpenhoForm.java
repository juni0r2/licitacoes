package br.com.licitacoes.empenhos.model.form;

import br.com.licitacoes.empenhos.model.Cliente;
import br.com.licitacoes.empenhos.model.Empenho;
import br.com.licitacoes.empenhos.model.Item;
import br.com.licitacoes.empenhos.model.dto.ClienteDTO;
import br.com.licitacoes.empenhos.model.dto.ItemDTO;
import br.com.licitacoes.empenhos.repository.ClienteRepository;
import br.com.licitacoes.empenhos.repository.ItemRepository;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class EmpenhoForm {

    private String numeroEmpenho;
    private BigDecimal valor;
    private ClienteDTO clienteDTO;
    private List<ItemForm> itensForm;

    public Empenho converter(ClienteRepository clienteRepository) {
        List<Item> itens = new ArrayList<>();
        itensForm.stream().forEach(itemForm -> itens.add(itemForm.converter()));
        return new Empenho(this.numeroEmpenho, this.valor, clienteDTO.converter(), itens);
    }
}
