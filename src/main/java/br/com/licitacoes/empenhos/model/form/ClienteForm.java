package br.com.licitacoes.empenhos.model.form;

import br.com.licitacoes.empenhos.model.Cliente;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteForm {

    private String nome;
    private String sigla;

    public Cliente converter() {
        return new Cliente(this.nome, this.sigla);
    }
}
