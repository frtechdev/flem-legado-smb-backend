/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum StatusVisitaEnum
/*    */ {
/* 13 */   VISITADO("VISITADO", "Visitado"),
/* 14 */   MONITORADO("MONITORADO", "Monitorado"),
/* 15 */   NAO_MONITORADO("NAO_MONITORADO", "Não Monitorado");
/*    */   
/*    */   private String descricao;
/*    */   private String codigo;
/*    */   
/*    */   StatusVisitaEnum(String codigo, String descricao) {
/* 21 */     this.descricao = descricao;
/* 22 */     this.codigo = codigo;
/*    */   }
/*    */   
/*    */   public StatusVisitaEnum getInstance(String codigo) {
/* 26 */     for (StatusVisitaEnum t : values()) {
/* 27 */       if (codigo.equals(t.codigo)) {
/* 28 */         return t;
/*    */       }
/*    */     } 
/* 31 */     return null;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 35 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 39 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public String getCodigo() {
/* 43 */     return this.codigo;
/*    */   }
/*    */   
/*    */   public void setCodigo(String codigo) {
/* 47 */     this.codigo = codigo;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\enums\StatusVisitaEnum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */