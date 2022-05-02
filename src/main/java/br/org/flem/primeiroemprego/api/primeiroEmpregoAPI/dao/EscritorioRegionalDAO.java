package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.EscritorioRegional;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.EscritorioRegionalProj;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EscritorioRegionalDAO extends CrudRepository<EscritorioRegional, Long> {
  List<EscritorioRegionalProj> findByAtivoTrueOrderByNomeAsc();
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\EscritorioRegionalDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */