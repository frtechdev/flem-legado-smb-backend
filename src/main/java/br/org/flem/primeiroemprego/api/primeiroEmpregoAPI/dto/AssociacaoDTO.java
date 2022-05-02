/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
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
/*    */ public class AssociacaoDTO
/*    */ {
/*    */   private Long idMonitor;
/*    */   private List<Long> idMunicipios;
/*    */   private List<Long> idDemandantes;
/*    */   
/*    */   public Long getIdMonitor() {
/* 21 */     return this.idMonitor;
/*    */   }
/*    */   
/*    */   public void setIdMonitor(Long idMonitor) {
/* 25 */     this.idMonitor = idMonitor;
/*    */   }
/*    */   
/*    */   public List<Long> getIdMunicipios() {
/* 29 */     return this.idMunicipios;
/*    */   }
/*    */   
/*    */   public void setIdMunicipios(List<Long> idMunicipios) {
/* 33 */     this.idMunicipios = idMunicipios;
/*    */   }
/*    */   
/*    */   public List<Long> getIdDemandantes() {
/* 37 */     return this.idDemandantes;
/*    */   }
/*    */   
/*    */   public void setIdDemandantes(List<Long> idDemandantes) {
/* 41 */     this.idDemandantes = idDemandantes;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\AssociacaoDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */