package br.com.licitacoes.empenhos.repository;

import br.com.licitacoes.empenhos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
