package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Colaborador;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Demandante;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.MonitorDemandante;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface MonitorDemandanteDAO extends CrudRepository<MonitorDemandante, Long>, JpaSpecificationExecutor<MonitorDemandante> {
  List<MonitorDemandante> findByMonitorOrderByMunicipioNomeAsc(Colaborador paramColaborador);
  
  MonitorDemandante findByMunicipioAndDemandante(Municipio paramMunicipio, Demandante paramDemandante);
  
  MonitorDemandante findByMunicipioAndDemandanteAndMonitor(Municipio paramMunicipio, Demandante paramDemandante, Colaborador paramColaborador);
  
  List<MonitorDemandante> findByMunicipioInAndMonitorNot(List<Municipio> paramList, Colaborador paramColaborador);
  
  List<MonitorDemandante> findByMunicipioInAndMonitor(List<Municipio> paramList, Colaborador paramColaborador);
  
  List<MonitorDemandante> findByMunicipioInAndDemandanteInAndMonitor(List<Municipio> paramList, List<Demandante> paramList1, Colaborador paramColaborador);
  
  List<MonitorDemandante> findByDemandanteInAndMonitor(List<Demandante> paramList, Colaborador paramColaborador);
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\MonitorDemandanteDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */