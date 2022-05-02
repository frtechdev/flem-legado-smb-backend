package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public interface RelatorioRegistroVisitaProj {
  Long getId();
  
  Long getIdEgresso();
  
  String getMunicipio();
  
  @JsonFormat(pattern = "dd/MM/yyyy")
  LocalDateTime getDataMonitoramento();
  
  @JsonFormat(pattern = "MM/yyyy")
  LocalDateTime getProxMonitoramento();
  
  String getDemandante();
  
  String getUnidadeDeLotacao();
  
  String getNomeEgresso();
  
  String getFormacao();
  
  Long getSubMeta();
  
  String getObservacao();
  
  String getDesvioDeFuncao();
  
  String getTipoDesvio();
  
  String getAutonomia();
  
  String getConhecimento();
  
  String getHabilidade();
  
  String getMotivacao();
  
  String getPontualidade();
  
  String getExperienciaProfissional();
  
  String getLinks();
  
  String getPrincipaisRegistros();
  
  Long getMonitor();
  
  Boolean getPresente();
  
  Long getIdComprovacao();
  
  String getFileName();
}


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\projections\RelatorioRegistroVisitaProj.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */