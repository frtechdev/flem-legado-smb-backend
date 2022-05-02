/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RelRespostaDTO
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -285741379863008384L;
/*    */   private Long id;
/*    */   private String descricao;
/*    */   private boolean respondida = false;
/*    */   
/*    */   private RelRespostaDTO(Long id, String descricao, boolean respondida) {
/* 22 */     this.id = id;
/* 23 */     this.descricao = descricao;
/* 24 */     this.respondida = respondida;
/*    */   }
/*    */   
/*    */   public static RelRespostaDTO of(Long id, String descricao) {
/* 28 */     return new RelRespostaDTO(id, descricao, false);
/*    */   }
/*    */   
/*    */   public static RelRespostaDTO of(Long id, String descricao, boolean respondida) {
/* 32 */     return new RelRespostaDTO(id, descricao, respondida);
/*    */   }
/*    */   
/*    */   public Long getId() {
/* 36 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 40 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 44 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 48 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public boolean isRespondida() {
/* 52 */     return this.respondida;
/*    */   }
/*    */   
/*    */   public void setRespondida(boolean respondida) {
/* 56 */     this.respondida = respondida;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\RelRespostaDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */