package br.com.licitacoes.empenhos.model;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class EmpenhoItensId implements Serializable {

    private Long idEmpenho;
    private Long idItem;
}
