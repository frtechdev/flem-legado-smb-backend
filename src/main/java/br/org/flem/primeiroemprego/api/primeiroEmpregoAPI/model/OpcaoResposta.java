/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseModel;
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.EmbeddedId;
/*    */ import javax.persistence.Entity;
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
/*    */ @AuditOverrides({@AuditOverride(forClass = OpcaoResposta.class), @AuditOverride(forClass = BaseModel.class)})
/*    */ @Entity
/*    */ @Table(name = "opcao_resposta")
/*    */ public class OpcaoResposta
/*    */   extends BaseModel<OpcaoRespostaId>
/*    */ {
/*    */   private static final long serialVersionUID = -8652011767158098854L;
/*    */   @EmbeddedId
/*    */   private OpcaoRespostaId id;
/*    */   
/*    */   public OpcaoResposta() {}
/*    */   
/*    */   public OpcaoResposta(Pergunta pergunta, Resposta resposta) {
/* 33 */     this.id = new OpcaoRespostaId(pergunta, resposta);
/*    */   }
/*    */   
/*    */   public OpcaoRespostaId getId() {
/* 37 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(OpcaoRespostaId id) {
/* 41 */     this.id = id;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\OpcaoResposta.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */