package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.AvaliacaoMonitoramento;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Questionario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AvaliacaoMonitoramentoDAO extends CrudRepository<AvaliacaoMonitoramento, Long> {
  AvaliacaoMonitoramento findByNomeAndAtivoTrue(String paramString);
  
  List<AvaliacaoMonitoramento> findByAtivoTrue();
  
  List<AvaliacaoMonitoramento> findByQuestionario(Questionario paramQuestionario);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\AvaliacaoMonitoramentoDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */