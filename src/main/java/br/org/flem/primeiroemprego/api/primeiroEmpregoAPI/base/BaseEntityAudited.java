/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*    */ import java.io.Serializable;
/*    */ import java.time.LocalDateTime;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.EntityListeners;
/*    */ import javax.persistence.MappedSuperclass;
/*    */ import org.springframework.data.jpa.domain.support.AuditingEntityListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @MappedSuperclass
/*    */ @EntityListeners({AuditingEntityListener.class})
/*    */ public abstract class BaseEntityAudited<ID extends Serializable>
/*    */   implements BaseID<ID>
/*    */ {
/*    */   private static final long serialVersionUID = 404517387231898597L;
/*    */   @Column(name = "datacriacao", updatable = false)
/*    */   @JsonIgnore
/*    */   protected LocalDateTime dataCriacao;
/*    */   @Column(name = "dataalteracao")
/*    */   @JsonIgnore
/*    */   protected LocalDateTime dataAtualizacao;
/*    */   @Column(name = "usuario_criacao", updatable = false)
/*    */   @JsonIgnore
/*    */   protected String usuarioCriacao;
/*    */   @Column(name = "usuario_atualizacao")
/*    */   @JsonIgnore
/*    */   protected String usuarioAtualizacao;
/*    */   @Column(name = "excluido")
/*    */   @JsonIgnore
/* 34 */   protected Boolean excluido = Boolean.FALSE;
/*    */ 
/*    */ 
/*    */   
/*    */   public LocalDateTime getDataCriacao() {
/* 39 */     return this.dataCriacao;
/*    */   }
/*    */   
/*    */   public void setDataCriacao(LocalDateTime dataCriacao) {
/* 43 */     this.dataCriacao = dataCriacao;
/*    */   }
/*    */   
/*    */   public LocalDateTime getDataAtualizacao() {
/* 47 */     return this.dataAtualizacao;
/*    */   }
/*    */   
/*    */   public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
/* 51 */     this.dataAtualizacao = dataAtualizacao;
/*    */   }
/*    */   
/*    */   public String getUsuarioCriacao() {
/* 55 */     return this.usuarioCriacao;
/*    */   }
/*    */   
/*    */   public void setUsuarioCriacao(String usuarioCriacao) {
/* 59 */     this.usuarioCriacao = usuarioCriacao;
/*    */   }
/*    */   
/*    */   public String getUsuarioAtualizacao() {
/* 63 */     return this.usuarioAtualizacao;
/*    */   }
/*    */   
/*    */   public void setUsuarioAtualizacao(String usuarioAtualizacao) {
/* 67 */     this.usuarioAtualizacao = usuarioAtualizacao;
/*    */   }
/*    */   
/*    */   public Boolean getExcluido() {
/* 71 */     return this.excluido;
/*    */   }
/*    */   
/*    */   public void setExcluido(Boolean excluido) {
/* 75 */     this.excluido = excluido;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\base\BaseEntityAudited.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */