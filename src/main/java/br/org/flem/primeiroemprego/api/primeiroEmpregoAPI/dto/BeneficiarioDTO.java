/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
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
/*    */ public class BeneficiarioDTO
/*    */ {
/*    */   private Long idFuncionario;
/*    */   private String nomeFuncionario;
/*    */   private String sexo;
/*    */   private FormacaoDTO formacao;
/*    */   
/*    */   public BeneficiarioDTO(Long idFuncionario, String nomeFuncionario, String sexo, FormacaoDTO formacao) {
/* 20 */     this.idFuncionario = idFuncionario;
/* 21 */     this.nomeFuncionario = nomeFuncionario;
/* 22 */     this.sexo = sexo;
/* 23 */     this.formacao = formacao;
/*    */   }
/*    */ 
/*    */   
/*    */   public BeneficiarioDTO() {}
/*    */   
/*    */   public Long getIdFuncionario() {
/* 30 */     return this.idFuncionario;
/*    */   }
/*    */   
/*    */   public void setIdFuncionario(Long idFuncionario) {
/* 34 */     this.idFuncionario = idFuncionario;
/*    */   }
/*    */   
/*    */   public String getNomeFuncionario() {
/* 38 */     return this.nomeFuncionario;
/*    */   }
/*    */   
/*    */   public void setNomeFuncionario(String nomeFuncionario) {
/* 42 */     this.nomeFuncionario = nomeFuncionario;
/*    */   }
/*    */   
/*    */   public String getSexo() {
/* 46 */     return this.sexo;
/*    */   }
/*    */   
/*    */   public void setSexo(String sexo) {
/* 50 */     this.sexo = sexo;
/*    */   }
/*    */   
/*    */   public FormacaoDTO getFormacao() {
/* 54 */     return this.formacao;
/*    */   }
/*    */   
/*    */   public void setFormacao(FormacaoDTO formacao) {
/* 58 */     this.formacao = formacao;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\BeneficiarioDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */