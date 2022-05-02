/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseEntityAudited;
/*    */ import java.io.Serializable;
/*    */ import java.util.Set;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.FetchType;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.OneToMany;
/*    */ import javax.persistence.Table;
/*    */ import javax.validation.constraints.NotNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "avaliacao_monitoramento")
/*    */ public class AvaliacaoMonitoramento
/*    */   extends BaseEntityAudited<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 4652367807899831786L;
/*    */   @Id
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Long id;
/*    */   @NotNull
/*    */   private String nome;
/*    */   private String descricao;
/* 31 */   private Boolean ativo = Boolean.TRUE;
/*    */   
/*    */   @OneToMany(mappedBy = "id.questionario", fetch = FetchType.LAZY)
/*    */   private Set<AvaliacaoQuestionario> questionario;
/*    */   
/*    */   public Long getId() {
/* 37 */     return this.id;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setId(Long id) {
/* 42 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 46 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 50 */     this.nome = nome;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 54 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 58 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public Boolean getAtivo() {
/* 62 */     return this.ativo;
/*    */   }
/*    */   
/*    */   public void setAtivo(Boolean ativo) {
/* 66 */     this.ativo = ativo;
/*    */   }
/*    */   
/*    */   public Set<AvaliacaoQuestionario> getQuestionario() {
/* 70 */     return this.questionario;
/*    */   }
/*    */   
/*    */   public void setQuestionario(Set<AvaliacaoQuestionario> questionario) {
/* 74 */     this.questionario = questionario;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\AvaliacaoMonitoramento.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */