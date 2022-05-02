/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import org.hibernate.annotations.Immutable;
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
/*    */ @Entity
/*    */ @Immutable
/*    */ public class Formacao
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 5584938351338409950L;
/*    */   @Id
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   @Column(name = "id_formacao")
/*    */   private Long id;
/*    */   private String nome;
/*    */   
/*    */   public Long getId() {
/* 34 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 38 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 42 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 46 */     this.nome = nome;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\Formacao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */