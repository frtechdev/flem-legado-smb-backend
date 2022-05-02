/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.filtro;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonFormat;
/*    */ import java.time.LocalDate;
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
/*    */ public class ComprovacaoFiltro
/*    */ {
/*    */   @JsonFormat(pattern = "dd/MM/yyyy")
/*    */   private LocalDate startDate;
/*    */   @JsonFormat(pattern = "dd/MM/yyyy")
/*    */   private LocalDate endDate;
/*    */   private String unidade;
/*    */   private Long demandante;
/*    */   private Long municipio;
/*    */   
/*    */   public LocalDate getStartDate() {
/* 26 */     return this.startDate;
/*    */   }
/*    */   
/*    */   public void setStartDate(LocalDate startDate) {
/* 30 */     this.startDate = startDate;
/*    */   }
/*    */   
/*    */   public LocalDate getEndDate() {
/* 34 */     return this.endDate;
/*    */   }
/*    */   
/*    */   public void setEndDate(LocalDate endDate) {
/* 38 */     this.endDate = endDate;
/*    */   }
/*    */   
/*    */   public String getUnidade() {
/* 42 */     return this.unidade;
/*    */   }
/*    */   
/*    */   public void setUnidade(String unidade) {
/* 46 */     this.unidade = unidade;
/*    */   }
/*    */   
/*    */   public Long getDemandante() {
/* 50 */     return this.demandante;
/*    */   }
/*    */   
/*    */   public void setDemandante(Long demandante) {
/* 54 */     this.demandante = demandante;
/*    */   }
/*    */   
/*    */   public Long getMunicipio() {
/* 58 */     return this.municipio;
/*    */   }
/*    */   
/*    */   public void setMunicipio(Long municipio) {
/* 62 */     this.municipio = municipio;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\filtro\ComprovacaoFiltro.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */