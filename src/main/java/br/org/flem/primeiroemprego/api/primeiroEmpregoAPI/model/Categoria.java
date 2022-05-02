/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ import org.hibernate.annotations.Immutable;
/*    */ import org.hibernate.validator.constraints.NotEmpty;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "categoriadasituacao")
/*    */ @Immutable
/*    */ public class Categoria
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -1206070816457740592L;
/*    */   @Id
/*    */   @Column(name = "id_categoriadasituacao")
/*    */   private Long value;
/*    */   @Column(name = "nome")
/*    */   @NotEmpty
/*    */   private String label;
/*    */   
/*    */   public Long getValue() {
/* 34 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(Long value) {
/* 38 */     this.value = value;
/*    */   }
/*    */   
/*    */   public String getLabel() {
/* 42 */     return this.label;
/*    */   }
/*    */   
/*    */   public void setLabel(String label) {
/* 46 */     this.label = label;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\Categoria.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */