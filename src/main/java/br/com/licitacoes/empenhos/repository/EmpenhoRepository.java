package br.com.licitacoes.empenhos.repository;

import br.com.licitacoes.empenhos.model.Empenho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpenhoRepository extends JpaRepository<Empenho, Long> {

//    @Query("SELECT DISTINCT e FROM Empenho e JOIN FETCH e.itens i")
//    List<Empenho> listarTodosComItens();
//
//    @Query("SELECT DISTINCT e FROM Empenho e JOIN FETCH e.itens i WHERE e.id =:id")
//    Empenho buscarPorId(Long id);
}
