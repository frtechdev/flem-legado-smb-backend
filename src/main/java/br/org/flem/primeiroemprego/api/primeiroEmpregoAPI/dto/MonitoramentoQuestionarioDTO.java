/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonFormat;
/*    */ import java.io.Serializable;
/*    */ import java.time.LocalDateTime;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MonitoramentoQuestionarioDTO
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -814267638074155615L;
/*    */   private Long id;
/*    */   @JsonFormat(pattern = "dd/MM/yyyy")
/*    */   private LocalDateTime dataMonitoramento;
/*    */   private String monitorNome;
/*    */   private String metaNome;
/*    */   private Long beneficiarioId;
/*    */   private String beneficiarioNome;
/*    */   private String beneficiarioMatriculaFlem;
/*    */   private String beneficiarioCpf;
/*    */   private String demandanteSigla;
/*    */   private String unidadeLotacao;
/*    */   
/*    */   public Long getId() {
/* 37 */     return this.id;
/*    */   }
/*    */   public void setId(Long id) {
/* 40 */     this.id = id;
/*    */   }
/*    */   public LocalDateTime getDataMonitoramento() {
/* 43 */     return this.dataMonitoramento;
/*    */   }
/*    */   public void setDataMonitoramento(LocalDateTime dataMonitoramento) {
/* 46 */     this.dataMonitoramento = dataMonitoramento;
/*    */   }
/*    */   public String getMonitorNome() {
/* 49 */     return this.monitorNome;
/*    */   }
/*    */   public void setMonitorNome(String monitorNome) {
/* 52 */     this.monitorNome = monitorNome;
/*    */   }
/*    */   public String getMetaNome() {
/* 55 */     return this.metaNome;
/*    */   }
/*    */   public void setMetaNome(String metaNome) {
/* 58 */     this.metaNome = metaNome;
/*    */   }
/*    */   public Long getBeneficiarioId() {
/* 61 */     return this.beneficiarioId;
/*    */   }
/*    */   public void setBeneficiarioId(Long beneficiarioId) {
/* 64 */     this.beneficiarioId = beneficiarioId;
/*    */   }
/*    */   public String getBeneficiarioNome() {
/* 67 */     return this.beneficiarioNome;
/*    */   }
/*    */   public void setBeneficiarioNome(String beneficiarioNome) {
/* 70 */     this.beneficiarioNome = beneficiarioNome;
/*    */   }
/*    */   public String getBeneficiarioMatriculaFlem() {
/* 73 */     return this.beneficiarioMatriculaFlem;
/*    */   }
/*    */   public void setBeneficiarioMatriculaFlem(String beneficiarioMatriculaFlem) {
/* 76 */     this.beneficiarioMatriculaFlem = beneficiarioMatriculaFlem;
/*    */   }
/*    */   public String getBeneficiarioCpf() {
/* 79 */     return this.beneficiarioCpf;
/*    */   }
/*    */   public void setBeneficiarioCpf(String beneficiarioCpf) {
/* 82 */     this.beneficiarioCpf = beneficiarioCpf;
/*    */   }
/*    */   public String getDemandanteSigla() {
/* 85 */     return this.demandanteSigla;
/*    */   }
/*    */   public void setDemandanteSigla(String demandanteSigla) {
/* 88 */     this.demandanteSigla = demandanteSigla;
/*    */   }
/*    */   public String getUnidadeLotacao() {
/* 91 */     return this.unidadeLotacao;
/*    */   }
/*    */   public void setUnidadeLotacao(String unidadeLotacao) {
/* 94 */     this.unidadeLotacao = unidadeLotacao;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\MonitoramentoQuestionarioDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */