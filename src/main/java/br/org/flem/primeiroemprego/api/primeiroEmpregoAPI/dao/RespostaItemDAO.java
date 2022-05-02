package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.MyCrudRepository;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.RegistroMonitoramento;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.RespostaItem;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.RespostaItemId;
import java.util.List;

public interface RespostaItemDAO extends MyCrudRepository<RespostaItem, RespostaItemId> {
  List<RespostaItem> findByIdRegistroMonitoramento(RegistroMonitoramento paramRegistroMonitoramento);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\RespostaItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */