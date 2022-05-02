package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Situacao;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface SituacaoDAO extends CrudRepository<Situacao, Long> {
  List<Situacao> findByCategoriaValueIn(List<Long> paramList);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\SituacaoDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */