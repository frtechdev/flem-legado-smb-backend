/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RelQuestionarioDTO
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 5158002063135399560L;
/*    */   private String beneficiarioNome;
/*    */   private String beneficiarioCpf;
/*    */   private String demandanteSigla;
/*    */   private String unidadeLotacao;
/*    */   private String dataCriacao;
/*    */   private String dataMonitoramento;
/*    */   private List<RelPerguntaDTO> perguntas;
/*    */   
/*    */   public String getBeneficiarioNome() {
/* 22 */     return this.beneficiarioNome;
/*    */   }
/*    */   
/*    */   public void setBeneficiarioNome(String beneficiarioNome) {
/* 26 */     this.beneficiarioNome = beneficiarioNome;
/*    */   }
/*    */   
/*    */   public String getBeneficiarioCpf() {
/* 30 */     return this.beneficiarioCpf;
/*    */   }
/*    */   
/*    */   public void setBeneficiarioCpf(String beneficiarioCpf) {
/* 34 */     this.beneficiarioCpf = beneficiarioCpf;
/*    */   }
/*    */   
/*    */   public String getDemandanteSigla() {
/* 38 */     return this.demandanteSigla;
/*    */   }
/*    */   
/*    */   public void setDemandanteSigla(String demandanteSigla) {
/* 42 */     this.demandanteSigla = demandanteSigla;
/*    */   }
/*    */   
/*    */   public String getUnidadeLotacao() {
/* 46 */     return this.unidadeLotacao;
/*    */   }
/*    */   
/*    */   public void setUnidadeLotacao(String unidadeLotacao) {
/* 50 */     this.unidadeLotacao = unidadeLotacao;
/*    */   }
/*    */   
/*    */   public List<RelPerguntaDTO> getPerguntas() {
/* 54 */     return this.perguntas;
/*    */   }
/*    */   
/*    */   public void setPerguntas(List<RelPerguntaDTO> perguntas) {
/* 58 */     this.perguntas = perguntas;
/*    */   }
/*    */   
/*    */   public String getDataCriacao() {
/* 62 */     return this.dataCriacao;
/*    */   }
/*    */   
/*    */   public void setDataCriacao(String dataCriacao) {
/* 66 */     this.dataCriacao = dataCriacao;
/*    */   }
/*    */   
/*    */   public String getDataMonitoramento() {
/* 70 */     return this.dataMonitoramento;
/*    */   }
/*    */   
/*    */   public void setDataMonitoramento(String dataMonitoramento) {
/* 74 */     this.dataMonitoramento = dataMonitoramento;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\RelQuestionarioDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */