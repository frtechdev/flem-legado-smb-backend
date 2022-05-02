package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.FuncionarioDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Colaborador;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Demandante;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
import java.util.List;
import org.springframework.stereotype.Repository;

public interface CustomFuncionarioDAO extends Repository {
  List<FuncionarioDTO> findVagasByUnidadeDeLotacaoInAndMunicipioInAndDemandanteIn(Long paramLong, List<String> paramList, List<Municipio> paramList1, List<Demandante> paramList2);
  
  List<FuncionarioDTO> obterFuncionariosVinculados(List<Colaborador> paramList, List<Municipio> paramList1, List<Demandante> paramList2);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\CustomFuncionarioDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */