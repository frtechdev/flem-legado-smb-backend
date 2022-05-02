/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.filtro;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonFormat;
/*    */ import java.time.LocalDate;
/*    */ import java.util.List;
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
/*    */ public class RegistroMonitoramentoFiltro
/*    */ {
/*    */   @JsonFormat(pattern = "dd/MM/yyyy")
/*    */   private LocalDate startDate;
/*    */   @JsonFormat(pattern = "dd/MM/yyyy")
/*    */   private LocalDate endDate;
/*    */   private List<String> unidades;
/*    */   private List<Long> demandantes;
/*    */   private List<Long> municipios;
/*    */   
/*    */   public LocalDate getStartDate() {
/* 27 */     return this.startDate;
/*    */   }
/*    */   
/*    */   public void setStartDate(LocalDate startDate) {
/* 31 */     this.startDate = startDate;
/*    */   }
/*    */   
/*    */   public LocalDate getEndDate() {
/* 35 */     return this.endDate;
/*    */   }
/*    */   
/*    */   public void setEndDate(LocalDate endDate) {
/* 39 */     this.endDate = endDate;
/*    */   }
/*    */   
/*    */   public List<String> getUnidades() {
/* 43 */     return this.unidades;
/*    */   }
/*    */   
/*    */   public void setUnidades(List<String> unidades) {
/* 47 */     this.unidades = unidades;
/*    */   }
/*    */   
/*    */   public List<Long> getDemandantes() {
/* 51 */     return this.demandantes;
/*    */   }
/*    */   
/*    */   public void setDemandantes(List<Long> demandantes) {
/* 55 */     this.demandantes = demandantes;
/*    */   }
/*    */   
/*    */   public List<Long> getMunicipios() {
/* 59 */     return this.municipios;
/*    */   }
/*    */   
/*    */   public void setMunicipios(List<Long> municipios) {
/* 63 */     this.municipios = municipios;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\filtro\RegistroMonitoramentoFiltro.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */