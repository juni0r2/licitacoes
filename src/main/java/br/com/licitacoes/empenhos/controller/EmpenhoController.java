package br.com.licitacoes.empenhos.controller;

import br.com.licitacoes.empenhos.model.Cliente;
import br.com.licitacoes.empenhos.model.Empenho;
import br.com.licitacoes.empenhos.model.dto.ClienteDTO;
import br.com.licitacoes.empenhos.model.dto.EmpenhoDTO;
import br.com.licitacoes.empenhos.model.form.ClienteForm;
import br.com.licitacoes.empenhos.model.form.EmpenhoForm;
import br.com.licitacoes.empenhos.repository.ClienteRepository;
import br.com.licitacoes.empenhos.repository.EmpenhoRepository;
import br.com.licitacoes.empenhos.service.EmpenhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/empenho")
public class EmpenhoController {

    @Autowired
    private EmpenhoService empenhoService;

    @GetMapping
    public List<EmpenhoDTO> listaEmpenhos() {
        return EmpenhoDTO.converter(this.empenhoService.buscaTodos());
    }

    @PostMapping
    public ResponseEntity<EmpenhoDTO> cadastrar(@RequestBody EmpenhoForm form, UriComponentsBuilder uriBuilder) {
        Empenho empenho = this.empenhoService.salvar(form);

        URI uri =  uriBuilder.path("/empenho/{id}").buildAndExpand(empenho.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmpenhoDTO(empenho));
    }
}
