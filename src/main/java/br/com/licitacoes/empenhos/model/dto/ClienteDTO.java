package br.com.licitacoes.empenhos.model.dto;

import br.com.licitacoes.empenhos.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClienteDTO {

    private Long id;
    private String nome;
    private String sigla;
    private LocalDateTime dataCriacao;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.sigla = cliente.getSigla();
        this.dataCriacao = cliente.getDataCriacao();
    }

    public Cliente converter() {
        return new Cliente(this.id, this.nome, this.sigla, this.dataCriacao);
    }

    public static List<ClienteDTO> converter(final List<Cliente> clientes) {
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

}
