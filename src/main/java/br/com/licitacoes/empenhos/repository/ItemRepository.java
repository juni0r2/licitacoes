package br.com.licitacoes.empenhos.repository;

import br.com.licitacoes.empenhos.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
