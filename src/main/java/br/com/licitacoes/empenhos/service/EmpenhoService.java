package br.com.licitacoes.empenhos.service;

import br.com.licitacoes.empenhos.model.Empenho;
import br.com.licitacoes.empenhos.model.form.EmpenhoForm;
import br.com.licitacoes.empenhos.repository.ClienteRepository;
import br.com.licitacoes.empenhos.repository.EmpenhoRepository;
import br.com.licitacoes.empenhos.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpenhoService {

    @Autowired
    private EmpenhoRepository empenhoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Empenho> buscaTodos() {
        return this.empenhoRepository.findAll();
    }

    public Empenho salvar(EmpenhoForm form) {
        Empenho empenho = form.converter(clienteRepository);
        return empenhoRepository.save(empenho);
    }
}
