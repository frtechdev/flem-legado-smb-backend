package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.integracao.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.integracao.model.RHFuncionario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface RHFuncionarioDAO extends CrudRepository<RHFuncionario, Integer>, JpaSpecificationExecutor {
  RHFuncionario findByMatricula(Integer paramInteger);
  
  List<RHFuncionario> findByCpf(String paramString);
  
  List<RHFuncionario> findByEmail(String paramString);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\integracao\dao\RHFuncionarioDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */