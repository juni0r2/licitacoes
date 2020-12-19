package br.com.licitacoes.empenhos.repository;

import br.com.licitacoes.empenhos.model.Empenho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpenhoRepository extends JpaRepository<Empenho, Long> {
}
