/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseDTO;
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
/*    */ public class RespostaDTO
/*    */   extends BaseDTO
/*    */ {
/*    */   private static final long serialVersionUID = -285741379863008384L;
/*    */   private Long id;
/*    */   private String descricao;
/*    */   
/*    */   public RespostaDTO() {}
/*    */   
/*    */   public RespostaDTO(Long id, String descricao) {
/* 25 */     this.id = id;
/* 26 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public Long getId() {
/* 30 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 34 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 38 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 42 */     this.descricao = descricao;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\RespostaDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */