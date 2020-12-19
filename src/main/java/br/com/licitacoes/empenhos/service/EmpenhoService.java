package br.com.licitacoes.empenhos.service;

import br.com.licitacoes.empenhos.model.Empenho;
import br.com.licitacoes.empenhos.model.dto.EmpenhoDTO;
import br.com.licitacoes.empenhos.model.form.EmpenhoForm;
import br.com.licitacoes.empenhos.repository.ClienteRepository;
import br.com.licitacoes.empenhos.repository.EmpenhoRepository;
import br.com.licitacoes.empenhos.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class EmpenhoService {

    @Autowired
    private EmpenhoRepository empenhoRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Empenho> buscaTodos() {
        return this.empenhoRepository.findAll();
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

        Empenho empenho = form.converter(clienteRepository, itemRepository);
        return empenhoRepository.save(empenho);
    }
}
