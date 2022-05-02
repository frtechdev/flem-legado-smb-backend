package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Meta;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface MetaDAO extends CrudRepository<Meta, Long> {
  Optional<Meta> findByNomeAndExcluidoFalse(String paramString);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\MetaDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */