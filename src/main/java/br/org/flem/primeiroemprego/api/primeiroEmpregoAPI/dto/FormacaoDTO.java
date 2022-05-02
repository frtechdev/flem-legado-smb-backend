/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
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
/*    */ public class FormacaoDTO
/*    */ {
/*    */   private Long id;
/*    */   private String nome;
/*    */   
/*    */   public FormacaoDTO(Long id, String nome) {
/* 18 */     this.id = id;
/* 19 */     this.nome = nome;
/*    */   }
/*    */ 
/*    */   
/*    */   public FormacaoDTO() {}
/*    */   
/*    */   public Long getId() {
/* 26 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 30 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 34 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 38 */     this.nome = nome;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\FormacaoDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */