package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Beneficiario;
import org.springframework.data.repository.CrudRepository;

public interface BeneficiarioDAO extends CrudRepository<Beneficiario, Long> {
  Beneficiario findByMatriculaFlem(String paramString);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\BeneficiarioDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */