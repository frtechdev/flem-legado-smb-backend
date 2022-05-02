/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RelatorioTrimestralDTO
/*    */ {
/*    */   private String demandante;
/*    */   private List<SinteseRelatorioTrimestralDTO> sintese;
/*    */   private List<MunicipioDTO> municipios;
/*    */   
/*    */   public RelatorioTrimestralDTO() {}
/*    */   
/*    */   public RelatorioTrimestralDTO(String demandante, List<SinteseRelatorioTrimestralDTO> sintese, List<MunicipioDTO> municipios) {
/* 19 */     this.demandante = demandante;
/* 20 */     this.sintese = sintese;
/* 21 */     this.municipios = municipios;
/*    */   }
/*    */   public String getDemandante() {
/* 24 */     return this.demandante;
/*    */   }
/*    */   
/*    */   public void setDemandante(String demandante) {
/* 28 */     this.demandante = demandante;
/*    */   }
/*    */   
/*    */   public List<SinteseRelatorioTrimestralDTO> getSintese() {
/* 32 */     return this.sintese;
/*    */   }
/*    */   
/*    */   public void setSintese(List<SinteseRelatorioTrimestralDTO> sintese) {
/* 36 */     this.sintese = sintese;
/*    */   }
/*    */   
/*    */   public List<MunicipioDTO> getMunicipios() {
/* 40 */     return this.municipios;
/*    */   }
/*    */   
/*    */   public void setMunicipios(List<MunicipioDTO> municipios) {
/* 44 */     this.municipios = municipios;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\RelatorioTrimestralDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */