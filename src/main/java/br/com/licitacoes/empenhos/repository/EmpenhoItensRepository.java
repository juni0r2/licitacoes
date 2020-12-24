package br.com.licitacoes.empenhos.repository;

import br.com.licitacoes.empenhos.model.EmpenhoItens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpenhoItensRepository  extends JpaRepository<EmpenhoItens, Long> {
}
