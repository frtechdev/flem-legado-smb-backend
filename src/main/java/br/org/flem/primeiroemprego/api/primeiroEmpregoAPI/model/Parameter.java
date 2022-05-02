/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseEntityAudited;
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "parametros")
/*    */ public class Parameter
/*    */   extends BaseEntityAudited<String>
/*    */ {
/*    */   private static final long serialVersionUID = 1377910170488447389L;
/*    */   @Id
/*    */   private String id;
/*    */   private String descricao;
/*    */   private String valor;
/*    */   
/*    */   public String getId() {
/* 27 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(String id) {
/* 31 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 35 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 39 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public String getValor() {
/* 43 */     return this.valor;
/*    */   }
/*    */   
/*    */   public void setValor(String valor) {
/* 47 */     this.valor = valor;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\Parameter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */