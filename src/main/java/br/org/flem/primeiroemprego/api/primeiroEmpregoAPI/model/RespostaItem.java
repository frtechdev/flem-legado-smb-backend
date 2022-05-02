/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseModel;
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ import org.hibernate.envers.AuditOverride;
/*    */ import org.hibernate.envers.AuditOverrides;
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
/*    */ @AuditOverrides({@AuditOverride(forClass = RespostaItem.class), @AuditOverride(forClass = BaseModel.class)})
/*    */ @Entity
/*    */ @Table(name = "resposta_item")
/*    */ public class RespostaItem
/*    */   extends BaseModel<RespostaItemId>
/*    */ {
/*    */   private static final long serialVersionUID = 5451923595892412614L;
/*    */   @Id
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private RespostaItemId id;
/*    */   @Column(columnDefinition = "TEXT")
/*    */   private String observacao;
/*    */   
/*    */   public RespostaItem() {}
/*    */   
/*    */   public RespostaItem(Pergunta pergunta, Resposta resposta, RegistroMonitoramento registroMonitoramento) {
/* 39 */     this.id = new RespostaItemId(pergunta, resposta, registroMonitoramento);
/*    */   }
/*    */ 
/*    */   
/*    */   public RespostaItemId getId() {
/* 44 */     return this.id;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setId(RespostaItemId id) {
/* 49 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getObservacao() {
/* 53 */     return this.observacao;
/*    */   }
/*    */   
/*    */   public void setObservacao(String observacao) {
/* 57 */     this.observacao = observacao;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\RespostaItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */