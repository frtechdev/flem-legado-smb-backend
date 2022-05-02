/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Embeddable;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.validation.constraints.NotNull;
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
/*    */ 
/*    */ 
/*    */ @Embeddable
/*    */ public class RespostaItemId
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -2521534221687010813L;
/*    */   @ManyToOne
/*    */   @NotNull
/*    */   private RegistroMonitoramento registroMonitoramento;
/*    */   @ManyToOne
/*    */   @NotNull
/*    */   private Pergunta pergunta;
/*    */   @ManyToOne
/*    */   @NotNull
/*    */   private Resposta resposta;
/*    */   
/*    */   public RespostaItemId() {}
/*    */   
/*    */   public RespostaItemId(Pergunta pergunta, Resposta resposta, RegistroMonitoramento registroMonitoramento) {
/* 43 */     this.pergunta = pergunta;
/* 44 */     this.resposta = resposta;
/* 45 */     this.registroMonitoramento = registroMonitoramento;
/*    */   }
/*    */   
/*    */   public Pergunta getPergunta() {
/* 49 */     return this.pergunta;
/*    */   }
/*    */   
/*    */   public void setPergunta(Pergunta pergunta) {
/* 53 */     this.pergunta = pergunta;
/*    */   }
/*    */   
/*    */   public Resposta getResposta() {
/* 57 */     return this.resposta;
/*    */   }
/*    */   
/*    */   public void setResposta(Resposta resposta) {
/* 61 */     this.resposta = resposta;
/*    */   }
/*    */   
/*    */   public RegistroMonitoramento getRegistroMonitoramento() {
/* 65 */     return this.registroMonitoramento;
/*    */   }
/*    */   
/*    */   public void setRegistroMonitoramento(RegistroMonitoramento registroMonitoramento) {
/* 69 */     this.registroMonitoramento = registroMonitoramento;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\RespostaItemId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */