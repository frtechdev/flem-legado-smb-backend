package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.MyCrudRepository;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Resposta;

public interface RespostaDAO extends MyCrudRepository<Resposta, Long> {
  Resposta findByDescricao(String paramString);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\RespostaDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */