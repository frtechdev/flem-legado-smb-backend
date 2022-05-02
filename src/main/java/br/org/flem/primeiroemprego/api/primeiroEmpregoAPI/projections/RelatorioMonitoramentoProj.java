package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public interface RelatorioMonitoramentoProj {
  Long getId();
  
  Long getIdEgresso();
  
  String getNomeEgresso();
  
  String getCpfEgresso();
  
  String getAdmissaoEgresso();
  
  Integer getMatriculaEgresso();
  
  @JsonFormat(pattern = "MM/yyyy")
  LocalDateTime getProxMonitoramento();
  
  String getUnidadeDeLotacao();
  
  Long getIdComprovacao();
  
  LocalDateTime getDataMonitoramento();
  
  String getLoginMonitor();
  
  String getFileName();
  
  String getNomeDemandante();
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\projections\RelatorioMonitoramentoProj.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */