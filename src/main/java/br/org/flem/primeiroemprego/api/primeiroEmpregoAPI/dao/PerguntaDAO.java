package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.MyCrudRepository;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Pergunta;

public interface PerguntaDAO extends MyCrudRepository<Pergunta, Long> {
  Pergunta findByDescricao(String paramString);
  
  Pergunta findByOrdem(int paramInt);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\PerguntaDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */