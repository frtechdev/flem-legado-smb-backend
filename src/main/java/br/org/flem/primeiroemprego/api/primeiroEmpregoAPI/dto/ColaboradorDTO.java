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
/*    */ 
/*    */ public class ColaboradorDTO
/*    */ {
/*    */   private Long id;
/*    */   private String nome;
/*    */   private List<DemandanteMunicipioDTO> associacoes;
/*    */   
/*    */   public ColaboradorDTO(Long id, String nome) {
/* 22 */     this.id = id;
/* 23 */     this.nome = nome;
/*    */   }
/*    */ 
/*    */   
/*    */   public ColaboradorDTO() {}
/*    */   
/*    */   public Long getId() {
/* 30 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 34 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 38 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 42 */     this.nome = nome;
/*    */   }
/*    */   
/*    */   public List<DemandanteMunicipioDTO> getAssociacoes() {
/* 46 */     return this.associacoes;
/*    */   }
/*    */   
/*    */   public void setAssociacoes(List<DemandanteMunicipioDTO> associacoes) {
/* 50 */     this.associacoes = associacoes;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\ColaboradorDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */