package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.ColaboradorDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Colaborador;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.EscritorioRegional;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ColaboradorDAO extends CrudRepository<Colaborador, Long> {
  @Query(" select new br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.ColaboradorDTO(col.id, col.nome) from Colaborador col where col.escritorioRegional = ?1 order by col.nome asc")
  List<ColaboradorDTO> findByEscritorioRegional(EscritorioRegional paramEscritorioRegional);
  
  @Query(" select new br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.ColaboradorDTO(col.id, col.nome) from Colaborador col where col.ativo = true")
  List<ColaboradorDTO> findByAtivoTrue();
  
  Colaborador findByEmailAndAtivoTrue(String paramString);
  
  List<Colaborador> findByIdIn(List<Long> paramList);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\ColaboradorDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */