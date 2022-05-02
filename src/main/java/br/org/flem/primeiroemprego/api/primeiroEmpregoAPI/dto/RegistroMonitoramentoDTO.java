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
/*    */ public class RegistroMonitoramentoDTO
/*    */   extends BaseDTO
/*    */ {
/*    */   private static final long serialVersionUID = -3109202928991285676L;
/*    */   private Long id;
/*    */   private String nome;
/*    */   private String descricao;
/*    */   private String filePath;
/*    */   
/*    */   public Long getId() {
/* 21 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 25 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 29 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 33 */     this.nome = nome;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 37 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 41 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public String getFilePath() {
/* 45 */     return this.filePath;
/*    */   }
/*    */   
/*    */   public void setFilePath(String filePath) {
/* 49 */     this.filePath = filePath;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 54 */     return "AvaliacaoDTO{id=" + this.id + ", nome=" + this.nome + ", descricao=" + this.descricao + ", filePath=" + this.filePath + '}';
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\RegistroMonitoramentoDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */