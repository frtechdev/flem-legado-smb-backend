/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonFormat;
/*    */ import java.time.LocalDateTime;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MonitoramentoDTO
/*    */ {
/*    */   private Long id;
/*    */   @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
/*    */   private LocalDateTime dataMonitoramento;
/*    */   private String usuarioCriacao;
/*    */   private String unidadeLotacao;
/*    */   private String municipio;
/*    */   private String demandante;
/*    */   
/*    */   public Long getId() {
/* 21 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 25 */     this.id = id;
/*    */   }
/*    */   
/*    */   public LocalDateTime getDataMonitoramento() {
/* 29 */     return this.dataMonitoramento;
/*    */   }
/*    */   
/*    */   public void setDataMonitoramento(LocalDateTime dataMonitoramento) {
/* 33 */     this.dataMonitoramento = dataMonitoramento;
/*    */   }
/*    */   
/*    */   public String getUsuarioCriacao() {
/* 37 */     return this.usuarioCriacao;
/*    */   }
/*    */   
/*    */   public void setUsuarioCriacao(String usuarioCriacao) {
/* 41 */     this.usuarioCriacao = usuarioCriacao;
/*    */   }
/*    */   
/*    */   public String getUnidadeLotacao() {
/* 45 */     return this.unidadeLotacao;
/*    */   }
/*    */   
/*    */   public void setUnidadeLotacao(String unidadeLotacao) {
/* 49 */     this.unidadeLotacao = unidadeLotacao;
/*    */   }
/*    */   
/*    */   public String getMunicipio() {
/* 53 */     return this.municipio;
/*    */   }
/*    */   
/*    */   public void setMunicipio(String municipio) {
/* 57 */     this.municipio = municipio;
/*    */   }
/*    */   
/*    */   public String getDemandante() {
/* 61 */     return this.demandante;
/*    */   }
/*    */   
/*    */   public void setDemandante(String demandante) {
/* 65 */     this.demandante = demandante;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\MonitoramentoDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */