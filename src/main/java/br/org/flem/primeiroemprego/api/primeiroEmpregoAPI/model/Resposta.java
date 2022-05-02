/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseModel;
/*    */ import java.io.Serializable;
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
/*    */ @AuditOverrides({@AuditOverride(forClass = Resposta.class), @AuditOverride(forClass = BaseModel.class)})
/*    */ @Entity
/*    */ @Table(name = "respostas")
/*    */ public class Resposta
/*    */   extends BaseModel<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 1375689861963794082L;
/*    */   @Id
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Long id;
/*    */   private String descricao;
/*    */   
/*    */   public Long getId() {
/* 31 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 35 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 39 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 43 */     this.descricao = descricao;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\Resposta.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */