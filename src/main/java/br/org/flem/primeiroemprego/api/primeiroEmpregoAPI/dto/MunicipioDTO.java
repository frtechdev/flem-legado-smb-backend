/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import java.util.Set;
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
/*    */ public class MunicipioDTO
/*    */ {
/*    */   private Long id;
/*    */   private String nome;
/*    */   private Set<RelatorioMonitoramentoDTO> monitoramentos;
/*    */   
/*    */   public MunicipioDTO(Long id, String nome) {
/* 22 */     this.id = id;
/* 23 */     this.nome = nome;
/*    */   }
/*    */ 
/*    */   
/*    */   public MunicipioDTO() {}
/*    */ 
/*    */   
/*    */   public Long getId() {
/* 31 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 35 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 39 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 43 */     this.nome = nome;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 48 */     int hash = 7;
/* 49 */     hash = 11 * hash + Objects.hashCode(this.id);
/* 50 */     hash = 11 * hash + Objects.hashCode(this.nome);
/* 51 */     return hash;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 56 */     if (this == obj) {
/* 57 */       return true;
/*    */     }
/* 59 */     if (obj == null) {
/* 60 */       return false;
/*    */     }
/* 62 */     if (getClass() != obj.getClass()) {
/* 63 */       return false;
/*    */     }
/* 65 */     MunicipioDTO other = (MunicipioDTO)obj;
/* 66 */     if (!Objects.equals(this.nome, other.nome)) {
/* 67 */       return false;
/*    */     }
/* 69 */     if (!Objects.equals(this.id, other.id)) {
/* 70 */       return false;
/*    */     }
/* 72 */     return true;
/*    */   }
/*    */   
/*    */   public Set<RelatorioMonitoramentoDTO> getMonitoramentos() {
/* 76 */     return this.monitoramentos;
/*    */   }
/*    */   
/*    */   public void setMonitoramentos(Set<RelatorioMonitoramentoDTO> monitoramentos) {
/* 80 */     this.monitoramentos = monitoramentos;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\MunicipioDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */