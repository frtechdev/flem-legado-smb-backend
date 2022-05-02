package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Demandante;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DemandanteDAO extends CrudRepository<Demandante, Long> {
  List<Demandante> findByIdIn(List<Long> paramList);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\DemandanteDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */