package br.com.licitacoes.empenhos.controller;

import br.com.licitacoes.empenhos.model.form.ClienteForm;
import br.com.licitacoes.empenhos.model.Cliente;
import br.com.licitacoes.empenhos.model.dto.ClienteDTO;
import br.com.licitacoes.empenhos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteDTO> listaClientes() {
        return ClienteDTO.converter(this.clienteRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrar(@RequestBody ClienteForm form, UriComponentsBuilder uriBuilder) {
        Cliente cliente = form.converter();
        this.clienteRepository.save(cliente);

        URI uri =  uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
    }

}
