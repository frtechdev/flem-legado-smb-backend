/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseModel;
/*    */ import com.fasterxml.jackson.annotation.JsonIdentityInfo;
/*    */ import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/*    */ import java.io.Serializable;
/*    */ import java.time.LocalDateTime;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "foempregados")
/*    */ @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
/*    */ @Immutable
/*    */ public class FoEmpregadosView
/*    */   extends BaseModel<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -4866848910438866144L;
/*    */   @Id
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   @Column(name = "matricula")
/*    */   private Long id;
/*    */   private String nome;
/*    */   @Column(name = "admissao")
/*    */   private LocalDateTime dataAdmissao;
/*    */   
/*    */   public Long getId() {
/* 46 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 50 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 54 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 58 */     this.nome = nome;
/*    */   }
/*    */   
/*    */   public LocalDateTime getDataAdmissao() {
/* 62 */     return this.dataAdmissao;
/*    */   }
/*    */   
/*    */   public void setDataAdmissao(LocalDateTime dataAdmissao) {
/* 66 */     this.dataAdmissao = dataAdmissao;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\FoEmpregadosView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */