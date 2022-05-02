/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseDTO;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MetaDTO
/*    */   extends BaseDTO
/*    */ {
/*    */   private Long id;
/*    */   private String nome;
/*    */   private String descricao;
/*    */   
/*    */   public Long getId() {
/* 15 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 19 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 23 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 27 */     this.nome = nome;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 31 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 35 */     this.descricao = descricao;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 40 */     return "MetaDTO{id=" + this.id + ", nome=" + this.nome + ", descricao=" + this.descricao + '}';
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\MetaDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */