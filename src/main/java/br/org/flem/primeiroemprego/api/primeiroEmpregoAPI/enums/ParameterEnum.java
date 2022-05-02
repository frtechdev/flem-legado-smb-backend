/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum ParameterEnum
/*    */ {
/*  9 */   LOGO_FLEM_HORIZONTAL("LOGO_FLEM_HORIZONTAL", "Logomarca da flem"),
/* 10 */   LOGO_PRIM_EMPREGO("LOGO_PRIM_EMPREGO", "Logomarca do primeiro emprego"),
/* 11 */   PP_GOV_2019("PP_GOV_2019", "Logomarca do governo"),
/* 12 */   ENDERECO_FLEM("ENDERECO_FLEM", "Endereço da Fundação Luis Eduardo Magalhães"),
/* 13 */   CEP_FLEM("CEP_FLEM", "CEP da Fundação Luis Eduardo Magalhães"),
/* 14 */   CNPJ_FLEM("CNPJ_FLEM", "CNPJ da Fundação Luis Eduardo Magalhães"),
/* 15 */   TELEFONE_FLEM("TELEFONE_FLEM", "Telefone da Fundação Luis Eduardo Magalhães");
/*    */   
/*    */   private String chave;
/*    */   private String descricao;
/*    */   
/*    */   ParameterEnum(String chave, String descricao) {
/* 21 */     this.descricao = descricao;
/* 22 */     this.chave = chave;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 26 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 30 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public String getChave() {
/* 34 */     return this.chave;
/*    */   }
/*    */   
/*    */   public void setChave(String chave) {
/* 38 */     this.chave = chave;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\enums\ParameterEnum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */