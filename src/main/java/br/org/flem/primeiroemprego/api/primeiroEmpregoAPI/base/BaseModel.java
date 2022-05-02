/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base;
/*    */ 
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
/*    */ @MappedSuperclass
/*    */ @EntityListeners({AuditingEntityListener.class})
/*    */ public abstract class BaseModel<I extends Serializable>
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 834148313926293676L;
/*    */   @Column(name = "datacriacao", updatable = false)
/*    */   protected LocalDateTime dataCriacao;
/*    */   @Column(name = "dataalteracao")
/*    */   protected LocalDateTime dataAtualizacao;
/*    */   @Column(name = "usuario_criacao", updatable = false)
/*    */   protected String usuarioCriacao;
/*    */   @Column(name = "usuario_atualizacao")
/*    */   protected String usuarioAtualizacao;
/*    */   @Column(name = "excluido")
/* 38 */   protected Boolean excluido = Boolean.FALSE;
/*    */   
/*    */   public abstract I getId();
/*    */   
/*    */   public abstract void setId(I paramI);
/*    */   
/*    */   public LocalDateTime getDataCriacao() {
/* 45 */     return this.dataCriacao;
/*    */   }
/*    */   public void setDataCriacao(LocalDateTime dataCriacao) {
/* 48 */     this.dataCriacao = dataCriacao;
/*    */   }
/*    */   public LocalDateTime getDataAtualizacao() {
/* 51 */     return this.dataAtualizacao;
/*    */   }
/*    */   public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
/* 54 */     this.dataAtualizacao = dataAtualizacao;
/*    */   }
/*    */   public String getUsuarioCriacao() {
/* 57 */     return this.usuarioCriacao;
/*    */   }
/*    */   public void setUsuarioCriacao(String usuarioCriacao) {
/* 60 */     this.usuarioCriacao = usuarioCriacao;
/*    */   }
/*    */   public String getUsuarioAtualizacao() {
/* 63 */     return this.usuarioAtualizacao;
/*    */   }
/*    */   public void setUsuarioAtualizacao(String usuarioAtualizacao) {
/* 66 */     this.usuarioAtualizacao = usuarioAtualizacao;
/*    */   }
/*    */   public Boolean getExcluido() {
/* 69 */     return this.excluido;
/*    */   }
/*    */   public void setExcluido(Boolean excluido) {
/* 72 */     this.excluido = excluido;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\base\BaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */