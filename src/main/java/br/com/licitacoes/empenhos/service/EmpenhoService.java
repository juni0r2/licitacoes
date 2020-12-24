package br.com.licitacoes.empenhos.service;

import br.com.licitacoes.empenhos.model.Empenho;
import br.com.licitacoes.empenhos.model.EmpenhoItens;
import br.com.licitacoes.empenhos.model.Item;
import br.com.licitacoes.empenhos.model.form.EmpenhoForm;
import br.com.licitacoes.empenhos.model.form.ItemForm;
import br.com.licitacoes.empenhos.repository.ClienteRepository;
import br.com.licitacoes.empenhos.repository.EmpenhoItensRepository;
import br.com.licitacoes.empenhos.repository.EmpenhoRepository;
import br.com.licitacoes.empenhos.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpenhoService {

    @Autowired
    private EmpenhoRepository empenhoRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmpenhoItensRepository empenhoItensRepository;

    public List<Empenho> buscaTodos() {
        return this.empenhoRepository.listarTodosComItens();
    }

    public Empenho salvar(EmpenhoForm form) {

        if (form.getIdEmpenhoOrigem() != null) {
            Optional<Empenho> optional = empenhoRepository.findById(form.getIdEmpenhoOrigem());

            if (optional.isPresent()) {
                Empenho empenhoBD = optional.get();
                if (form.getValor().compareTo(empenhoBD.getValor()) != 1) {
                    BigDecimal valorFinal = empenhoBD.getValor().subtract(form.getValor());
                    empenhoBD.setValor(valorFinal);
                    empenhoRepository.save(empenhoBD);
                }
            }
        }

        Empenho empenho = form.converter(clienteRepository);
        empenhoRepository.save(empenho);

        final List<Integer> codigoItem = form.getItensForm().stream().map(ItemForm::getCodigoItem).collect(Collectors.toList());
        final List<Item> itensDB = itemRepository.findAllByCodigoItemIn(codigoItem);
        itensDB.stream().forEach(itemDB -> {
            form.getItensForm().stream().forEach(itemForm -> {
                if (itemForm.getCodigoItem().compareTo(itemDB.getCodigoItem()) == 0) {
                    itemForm.setId(itemDB.getId());
                }
            });
        });

        List<Item> itens = new ArrayList<>();
        form.getItensForm().stream().forEach(itemForm -> itens.add(itemForm.converter()));
        List<Item> itensSalvos = itemRepository.saveAll(itens);

        itensSalvos.stream().forEach(item -> empenhoItensRepository.save(new EmpenhoItens(empenho.getId(), item.getId())));
        return empenho;
    }
}
