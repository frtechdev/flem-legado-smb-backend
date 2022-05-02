/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Embeddable;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
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
/*    */ @Embeddable
/*    */ public class AvaliacaoQuestionarioId
/*    */   implements Serializable
/*    */ {
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_questionario", nullable = false)
/*    */   private Questionario questionario;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_avaliacao", nullable = false)
/*    */   private AvaliacaoMonitoramento avaliacao;
/*    */   
/*    */   public AvaliacaoQuestionarioId() {}
/*    */   
/*    */   public AvaliacaoQuestionarioId(Questionario questionario, AvaliacaoMonitoramento avaliacao) {
/* 31 */     this.questionario = questionario;
/* 32 */     this.avaliacao = avaliacao;
/*    */   }
/*    */   
/*    */   public Questionario getQuestionario() {
/* 36 */     return this.questionario;
/*    */   }
/*    */   
/*    */   public void setQuestionario(Questionario questionario) {
/* 40 */     this.questionario = questionario;
/*    */   }
/*    */   
/*    */   public AvaliacaoMonitoramento getAvaliacao() {
/* 44 */     return this.avaliacao;
/*    */   }
/*    */   
/*    */   public void setAvaliacao(AvaliacaoMonitoramento avaliacao) {
/* 48 */     this.avaliacao = avaliacao;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\AvaliacaoQuestionarioId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */