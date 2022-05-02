/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Embeddable;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Embeddable
/*    */ public class OpcaoRespostaId
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -2521534221687010813L;
/*    */   @ManyToOne
/*    */   private Pergunta pergunta;
/*    */   @ManyToOne
/*    */   private Resposta resposta;
/*    */   
/*    */   public OpcaoRespostaId() {}
/*    */   
/*    */   public OpcaoRespostaId(Pergunta pergunta, Resposta resposta) {
/* 35 */     this.pergunta = pergunta;
/* 36 */     this.resposta = resposta;
/*    */   }
/*    */   
/*    */   public Pergunta getPergunta() {
/* 40 */     return this.pergunta;
/*    */   }
/*    */   
/*    */   public void setPergunta(Pergunta pergunta) {
/* 44 */     this.pergunta = pergunta;
/*    */   }
/*    */   
/*    */   public Resposta getResposta() {
/* 48 */     return this.resposta;
/*    */   }
/*    */   
/*    */   public void setResposta(Resposta resposta) {
/* 52 */     this.resposta = resposta;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\OpcaoRespostaId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */