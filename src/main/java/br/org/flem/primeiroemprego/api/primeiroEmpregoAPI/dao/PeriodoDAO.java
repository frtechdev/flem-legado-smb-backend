package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Periodo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tscortes
 */
public interface PeriodoDAO extends CrudRepository<Periodo, Long> {
    
    Optional<Periodo> findByNomeAndOrdemAndExcluidoFalse(String nome, Short ordem);
    @Query("select pe from Periodo pe where pe.excluido = false order by pe.ordem desc")
    List<Periodo> obterTodosAtivosOrdemAsc();
    
    Periodo findByOrdemAndTipo(Short ordem, String tipo);
    @Query("select pe from Periodo pe where pe.excluido = false and ?1 between mesInicio and mesFim and tipo = ?2")
    Periodo obterPeriodoPorMes(Integer mes, String tipo);
    
}
