package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Demandante;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public interface MonitoramentoProj {
  Long getId();
  
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  LocalDateTime getDataMonitoramento();
  
  String getUsuarioCriacao();
  
  String getUnidadeLotacao();
  
  Demandante getDemandante();
  
  Municipio getMunicipio();
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\projections\MonitoramentoProj.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */