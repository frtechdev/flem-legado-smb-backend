/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import java.util.Objects;
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
/*    */ public class DemandanteMunicipioDTO
/*    */ {
/*    */   private Long id;
/*    */   private Long idDemandante;
/*    */   private Long idMunicipio;
/*    */   private String nomeDemandante;
/*    */   private String nomeMunicipio;
/*    */   
/*    */   public DemandanteMunicipioDTO(Long idDemandante, Long idMunicipio, String nomeDemandante, String nomeMunicipio) {
/* 25 */     this.idDemandante = idDemandante;
/* 26 */     this.idMunicipio = idMunicipio;
/* 27 */     this.nomeDemandante = nomeDemandante;
/* 28 */     this.nomeMunicipio = nomeMunicipio;
/*    */   }
/*    */   
/*    */   public Long getId() {
/* 32 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 36 */     this.id = id;
/*    */   }
/*    */ 
/*    */   
/*    */   public DemandanteMunicipioDTO() {}
/*    */   
/*    */   public Long getIdDemandante() {
/* 43 */     return this.idDemandante;
/*    */   }
/*    */   
/*    */   public void setIdDemandante(Long idDemandante) {
/* 47 */     this.idDemandante = idDemandante;
/*    */   }
/*    */   
/*    */   public Long getIdMunicipio() {
/* 51 */     return this.idMunicipio;
/*    */   }
/*    */   
/*    */   public void setIdMunicipio(Long idMunicipio) {
/* 55 */     this.idMunicipio = idMunicipio;
/*    */   }
/*    */   
/*    */   public String getNomeDemandante() {
/* 59 */     return this.nomeDemandante;
/*    */   }
/*    */   
/*    */   public void setNomeDemandante(String nomeDemandante) {
/* 63 */     this.nomeDemandante = nomeDemandante;
/*    */   }
/*    */   
/*    */   public String getNomeMunicipio() {
/* 67 */     return this.nomeMunicipio;
/*    */   }
/*    */   
/*    */   public void setNomeMunicipio(String nomeMunicipio) {
/* 71 */     this.nomeMunicipio = nomeMunicipio;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 76 */     int hash = 7;
/* 77 */     return hash;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 82 */     if (this == obj) {
/* 83 */       return true;
/*    */     }
/* 85 */     if (obj == null) {
/* 86 */       return false;
/*    */     }
/* 88 */     if (getClass() != obj.getClass()) {
/* 89 */       return false;
/*    */     }
/* 91 */     DemandanteMunicipioDTO other = (DemandanteMunicipioDTO)obj;
/* 92 */     if (!Objects.equals(this.idDemandante, other.idDemandante)) {
/* 93 */       return false;
/*    */     }
/* 95 */     if (!Objects.equals(this.idMunicipio, other.idMunicipio)) {
/* 96 */       return false;
/*    */     }
/* 98 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\DemandanteMunicipioDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */