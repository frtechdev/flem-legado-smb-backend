/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BeneficiarioQuestionarioDTO
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -425273598722925694L;
/*    */   private Long id;
/*    */   private String nome;
/*    */   private String matriculaFlem;
/*    */   private String cpf;
/*    */   private String vagaDemandanteSigla;
/*    */   private String vagaUnidadeDeLotacao;
/*    */   
/*    */   public Long getId() {
/* 20 */     return this.id;
/*    */   }
/*    */   public void setId(Long id) {
/* 23 */     this.id = id;
/*    */   }
/*    */   public String getNome() {
/* 26 */     return this.nome;
/*    */   }
/*    */   public void setNome(String nome) {
/* 29 */     this.nome = nome;
/*    */   }
/*    */   public String getMatriculaFlem() {
/* 32 */     return this.matriculaFlem;
/*    */   }
/*    */   public void setMatriculaFlem(String matriculaFlem) {
/* 35 */     this.matriculaFlem = matriculaFlem;
/*    */   }
/*    */   public String getCpf() {
/* 38 */     return this.cpf;
/*    */   }
/*    */   public void setCpf(String cpf) {
/* 41 */     this.cpf = cpf;
/*    */   }
/*    */   public String getVagaDemandanteSigla() {
/* 44 */     return this.vagaDemandanteSigla;
/*    */   }
/*    */   public void setVagaDemandanteSigla(String vagaDemandanteSigla) {
/* 47 */     this.vagaDemandanteSigla = vagaDemandanteSigla;
/*    */   }
/*    */   public String getVagaUnidadeDeLotacao() {
/* 50 */     return this.vagaUnidadeDeLotacao;
/*    */   }
/*    */   public void setVagaUnidadeDeLotacao(String vagaUnidadeDeLotacao) {
/* 53 */     this.vagaUnidadeDeLotacao = vagaUnidadeDeLotacao;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\BeneficiarioQuestionarioDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */