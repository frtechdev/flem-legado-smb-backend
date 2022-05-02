package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.StatusVisitaEnum;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Beneficiario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.VisitaBeneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VisitaBeneficiarioDAO extends JpaRepository<VisitaBeneficiario, Long>, JpaSpecificationExecutor {
  VisitaBeneficiario findFirstByEgressoAndExcluidoOrderByDataVisitaDesc(Beneficiario paramBeneficiario, Boolean paramBoolean);
  
  VisitaBeneficiario findFirstByEgressoAndStatusAndExcluidoOrderByDataVisitaDesc(Beneficiario paramBeneficiario, StatusVisitaEnum paramStatusVisitaEnum, Boolean paramBoolean);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\VisitaBeneficiarioDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */