/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseDTO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AvaliacaoDTO
/*    */   extends BaseDTO
/*    */ {
/*    */   private Long id;
/*    */   private String nome;
/*    */   private String descricao;
/*    */   private String filePath;
/*    */   
/*    */   public Long getId() {
/* 17 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 21 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 25 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 29 */     this.nome = nome;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 33 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 37 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public String getFilePath() {
/* 41 */     return this.filePath;
/*    */   }
/*    */   
/*    */   public void setFilePath(String filePath) {
/* 45 */     this.filePath = filePath;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 50 */     return "AvaliacaoDTO{id=" + this.id + ", nome=" + this.nome + ", descricao=" + this.descricao + ", filePath=" + this.filePath + '}';
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\AvaliacaoDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */