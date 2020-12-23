package br.com.licitacoes.empenhos.controller;

import br.com.licitacoes.empenhos.model.Cliente;
import br.com.licitacoes.empenhos.model.Item;
import br.com.licitacoes.empenhos.model.dto.ClienteDTO;
import br.com.licitacoes.empenhos.model.dto.ItemDTO;
import br.com.licitacoes.empenhos.model.form.ClienteForm;
import br.com.licitacoes.empenhos.model.form.ItemForm;
import br.com.licitacoes.empenhos.repository.ClienteRepository;
import br.com.licitacoes.empenhos.repository.ItemRepository;
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
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<ItemDTO> listaItens() {
        return ItemDTO.converter(this.itemRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<ItemDTO> cadastrar(@RequestBody ItemForm form, UriComponentsBuilder uriBuilder) {
        Item item = form.converter();
        this.itemRepository.save(item);

        URI uri =  uriBuilder.path("/item/{id}").buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(uri).body(new ItemDTO(item));
    }

}
