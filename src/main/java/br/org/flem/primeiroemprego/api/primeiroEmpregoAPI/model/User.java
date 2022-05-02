/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ public class User
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -5655722622011679560L;
/*    */   private Long id;
/*    */   private String login;
/*    */   private String nome;
/*    */   private Boolean ativo;
/*    */   private Boolean alterarSenha;
/*    */   private String tipoAutenticacao;
/* 26 */   private Boolean bloqueadoAd = Boolean.valueOf(false);
/* 27 */   private Boolean bloqueadoSe = Boolean.valueOf(false);
/*    */   private Integer codigoDominio;
/*    */   
/*    */   public Long getId() {
/* 31 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 35 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getLogin() {
/* 39 */     return this.login;
/*    */   }
/*    */   
/*    */   public void setLogin(String login) {
/* 43 */     this.login = login;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 47 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 51 */     this.nome = nome;
/*    */   }
/*    */   
/*    */   public Boolean getAtivo() {
/* 55 */     return this.ativo;
/*    */   }
/*    */   
/*    */   public void setAtivo(Boolean ativo) {
/* 59 */     this.ativo = ativo;
/*    */   }
/*    */   
/*    */   public Boolean getAlterarSenha() {
/* 63 */     return this.alterarSenha;
/*    */   }
/*    */   
/*    */   public void setAlterarSenha(Boolean alterarSenha) {
/* 67 */     this.alterarSenha = alterarSenha;
/*    */   }
/*    */   
/*    */   public String getTipoAutenticacao() {
/* 71 */     return this.tipoAutenticacao;
/*    */   }
/*    */   
/*    */   public void setTipoAutenticacao(String tipoAutenticacao) {
/* 75 */     this.tipoAutenticacao = tipoAutenticacao;
/*    */   }
/*    */   
/*    */   public Boolean getBloqueadoAd() {
/* 79 */     return this.bloqueadoAd;
/*    */   }
/*    */   
/*    */   public void setBloqueadoAd(Boolean bloqueadoAd) {
/* 83 */     this.bloqueadoAd = bloqueadoAd;
/*    */   }
/*    */   
/*    */   public Boolean getBloqueadoSe() {
/* 87 */     return this.bloqueadoSe;
/*    */   }
/*    */   
/*    */   public void setBloqueadoSe(Boolean bloqueadoSe) {
/* 91 */     this.bloqueadoSe = bloqueadoSe;
/*    */   }
/*    */   
/*    */   public Integer getCodigoDominio() {
/* 95 */     return this.codigoDominio;
/*    */   }
/*    */   
/*    */   public void setCodigoDominio(Integer codigoDominio) {
/* 99 */     this.codigoDominio = codigoDominio;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\User.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */