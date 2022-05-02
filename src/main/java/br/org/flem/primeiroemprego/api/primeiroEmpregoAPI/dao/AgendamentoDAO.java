package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.StatusAgendaEnum;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Agendamento;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Beneficiario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface AgendamentoDAO extends CrudRepository<Agendamento, Long>, JpaSpecificationExecutor<Agendamento> {
  List<Agendamento> findByBeneficiario(Beneficiario paramBeneficiario);
  
  
  List<Agendamento> findByBeneficiarioAndStatus(Beneficiario paramBeneficiario, StatusAgendaEnum paramStatusAgendaEnum);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\AgendamentoDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */