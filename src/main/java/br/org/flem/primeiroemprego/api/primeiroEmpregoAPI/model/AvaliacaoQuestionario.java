/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseEntityAudited;
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.EmbeddedId;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "avaliacao_questionario")
/*    */ public class AvaliacaoQuestionario
/*    */   extends BaseEntityAudited<AvaliacaoQuestionarioId>
/*    */ {
/*    */   private static final long serialVersionUID = -2985413681463666167L;
/*    */   @EmbeddedId
/*    */   private AvaliacaoQuestionarioId id;
/*    */   private String filePath;
/*    */   
/*    */   public AvaliacaoQuestionario() {
/* 25 */     this.id = new AvaliacaoQuestionarioId();
/*    */   }
/*    */   
/*    */   public AvaliacaoQuestionario(AvaliacaoQuestionarioId id, String filePath) {
/* 29 */     this.id = id;
/* 30 */     this.filePath = filePath;
/*    */   }
/*    */   
/*    */   public AvaliacaoQuestionarioId getId() {
/* 34 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(AvaliacaoQuestionarioId id) {
/* 38 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getFilePath() {
/* 42 */     return this.filePath;
/*    */   }
/*    */   
/*    */   public void setFilePath(String filePath) {
/* 46 */     this.filePath = filePath;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\AvaliacaoQuestionario.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */