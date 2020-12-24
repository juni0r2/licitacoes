package br.com.licitacoes.empenhos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TB_EMPENHO_ITENS")
@IdClass(EmpenhoItensId.class)
public class EmpenhoItens {

    @Id
    @Column(name = "EMPENHO_EM_ID")
    private Long idEmpenho;

    @Id
    @Column(name = "ITENS_IT_ID", unique = false)
    private Long idItem;

    public EmpenhoItens(){}

    public EmpenhoItens(final Long idEmpenho, final Long idItem) {
        this.idEmpenho = idEmpenho;
        this.idItem = idItem;
    }
}
