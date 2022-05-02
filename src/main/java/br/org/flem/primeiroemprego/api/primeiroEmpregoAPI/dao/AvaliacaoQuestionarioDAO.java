package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.AvaliacaoMonitoramento;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.AvaliacaoQuestionario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.AvaliacaoQuestionarioId;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Questionario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AvaliacaoQuestionarioDAO extends CrudRepository<AvaliacaoQuestionario, AvaliacaoQuestionarioId> {
  List<AvaliacaoQuestionario> findByIdQuestionarioAndExcluidoFalse(Questionario paramQuestionario);
  
  List<AvaliacaoQuestionario> findByIdAvaliacaoAndExcluidoFalse(AvaliacaoMonitoramento paramAvaliacaoMonitoramento);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\AvaliacaoQuestionarioDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */