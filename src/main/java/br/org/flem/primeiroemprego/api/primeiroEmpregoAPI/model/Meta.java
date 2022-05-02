/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseEntityAudited;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.TipoMetaEnum;
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.EnumType;
/*    */ import javax.persistence.Enumerated;
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
/*    */ @AuditOverrides({@AuditOverride(forClass = Meta.class), @AuditOverride(forClass = BaseEntityAudited.class)})
/*    */ @Entity
/*    */ @Table(name = "metas")
/*    */ public class Meta
/*    */   extends BaseEntityAudited<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 1258030784286610180L;
/*    */   @Id
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Long id;
/*    */   private String nome;
/*    */   @Column(columnDefinition = "TEXT")
/*    */   private String descricao;
/*    */   @Enumerated(EnumType.STRING)
/*    */   private TipoMetaEnum tipo;
/*    */   
/*    */   public Long getId() {
/* 42 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 46 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 50 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 54 */     this.nome = nome;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 58 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 62 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public TipoMetaEnum getTipo() {
/* 66 */     return this.tipo;
/*    */   }
/*    */   
/*    */   public void setTipo(TipoMetaEnum tipo) {
/* 70 */     this.tipo = tipo;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\Meta.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */