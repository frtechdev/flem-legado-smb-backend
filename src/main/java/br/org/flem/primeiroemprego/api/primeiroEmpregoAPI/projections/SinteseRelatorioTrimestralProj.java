package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections;

import java.time.LocalDateTime;

public interface SinteseRelatorioTrimestralProj {
  Long getId();
  
  Long getIdEgresso();
  
  Long getIdComprovacao();
  
  String getCpfEgresso();
  
  String getNomeEgresso();
  
  String getMatriculaEgresso();
  
  String getMunicipio();
  
  LocalDateTime getDataMonitoramento();
  
  String getDemandante();
  
  String getUnidadeDeLotacao();
  
  String getMonitor();
  
  String getSiglaDemandante();
  
  LocalDateTime getAdmissao();
  
  String getUsuarioCriacao();
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\projections\SinteseRelatorioTrimestralProj.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */