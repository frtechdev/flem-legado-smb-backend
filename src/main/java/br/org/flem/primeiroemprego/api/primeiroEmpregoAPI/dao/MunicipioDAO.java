package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.EscritorioRegional;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.MunicipioProj;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MunicipioDAO extends CrudRepository<Municipio, Long> {
  @Query("SELECT count(distinct dem.id) as countDemandantes, mun.id as id, mun.nome as nome FROM Vaga vag INNER JOIN vag.municipio mun INNER JOIN vag.demandante dem WHERE mun.escritorioRegional = ?1 group by mun.nome, mun.id order by mun.nome")
  List<MunicipioProj> findByEscritorioRegional(EscritorioRegional paramEscritorioRegional);
  
  List<Municipio> findByIdIn(List<Long> paramList);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\MunicipioDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */