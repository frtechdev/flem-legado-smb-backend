/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
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
/*    */ public class Situacao
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 2884261907421971537L;
/*    */   @Id
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   @Column(name = "id_situacao")
/*    */   private Long id;
/*    */   @NotEmpty(message = "{situacao.nome.notempty}")
/*    */   private String nome;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_categoria")
/*    */   private Categoria categoria;
/*    */   private String cor;
/*    */   
/*    */   public Long getId() {
/* 49 */     return this.id;
/*    */   }
/*    */   public void setId(Long id) {
/* 52 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 56 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 60 */     this.nome = nome;
/*    */   }
/*    */   
/*    */   public String getCor() {
/* 64 */     return this.cor;
/*    */   }
/*    */   
/*    */   public void setCor(String cor) {
/* 68 */     this.cor = cor;
/*    */   }
/*    */   
/*    */   public Categoria getCategoria() {
/* 72 */     return this.categoria;
/*    */   }
/*    */   
/*    */   public void setCategoria(Categoria categoria) {
/* 76 */     this.categoria = categoria;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\Situacao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */