package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.MyCrudRepository;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.OpcaoResposta;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.OpcaoRespostaId;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Pergunta;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Resposta;
import java.util.List;

public interface OpcaoRespostaDAO extends MyCrudRepository<OpcaoResposta, OpcaoRespostaId> {
  List<OpcaoResposta> findByIdPergunta(Pergunta paramPergunta);
  
  List<OpcaoResposta> findByIdResposta(Resposta paramResposta);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\OpcaoRespostaDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */