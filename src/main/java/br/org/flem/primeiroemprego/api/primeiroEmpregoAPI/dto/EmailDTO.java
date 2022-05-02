/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseDTO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class EmailDTO
/*    */   extends BaseDTO
/*    */ {
/*    */   private static final long serialVersionUID = 8223631962579263809L;
/* 22 */   private List<String> destinatarios = new ArrayList<>();
/*    */   private String aliasRemetente;
/*    */   private String remetente;
/*    */   private String assunto;
/*    */   private String mensagem;
/*    */   private List<String> comCopia;
/*    */   private List<String> paths;
/*    */   
/*    */   public EmailDTO(List<String> destinatarios, String aliasRemetente, String remetente, String assunto, String mensagem) {
/* 31 */     this.destinatarios = destinatarios;
/* 32 */     this.aliasRemetente = aliasRemetente;
/* 33 */     this.remetente = remetente;
/* 34 */     this.assunto = assunto;
/* 35 */     this.mensagem = mensagem;
/*    */   }
/*    */ 
/*    */   
/*    */   public EmailDTO() {}
/*    */   
/*    */   public List<String> getDestinatarios() {
/* 42 */     return this.destinatarios;
/*    */   }
/*    */   
/*    */   public void setDestinatarios(List<String> destinatarios) {
/* 46 */     this.destinatarios = destinatarios;
/*    */   }
/*    */   
/*    */   public String getAliasRemetente() {
/* 50 */     return this.aliasRemetente;
/*    */   }
/*    */   
/*    */   public void setAliasRemetente(String aliasRemetente) {
/* 54 */     this.aliasRemetente = aliasRemetente;
/*    */   }
/*    */   
/*    */   public String getRemetente() {
/* 58 */     return this.remetente;
/*    */   }
/*    */   
/*    */   public void setRemetente(String remetente) {
/* 62 */     this.remetente = remetente;
/*    */   }
/*    */   
/*    */   public String getAssunto() {
/* 66 */     return this.assunto;
/*    */   }
/*    */   
/*    */   public void setAssunto(String assunto) {
/* 70 */     this.assunto = assunto;
/*    */   }
/*    */   
/*    */   public String getMensagem() {
/* 74 */     return this.mensagem;
/*    */   }
/*    */   
/*    */   public void setMensagem(String mensagem) {
/* 78 */     this.mensagem = mensagem;
/*    */   }
/*    */   
/*    */   public List<String> getComCopia() {
/* 82 */     return this.comCopia;
/*    */   }
/*    */   
/*    */   public void setComCopia(List<String> comCopia) {
/* 86 */     this.comCopia = comCopia;
/*    */   }
/*    */   
/*    */   public List<String> getPaths() {
/* 90 */     return this.paths;
/*    */   }
/*    */   
/*    */   public void setPaths(List<String> paths) {
/* 94 */     this.paths = paths;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 99 */     return "EmailDTO{ destinatarios=" + this.destinatarios + ", aliasRemetente=" + this.aliasRemetente + ", remetente=" + this.remetente + ", assunto=" + this.assunto + ", mensagem=" + this.mensagem + '}';
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\EmailDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */