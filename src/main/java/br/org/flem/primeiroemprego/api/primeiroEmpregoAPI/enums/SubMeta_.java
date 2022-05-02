/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum SubMeta_
/*    */ {
/* 13 */   SUBMETA_41("SUBMETA_41", "Submeta 4.1 (4.500 profissionais técnicos trimestralmente acompanhados e monitorados no desenvolvimento das suas funções)"),
/* 14 */   SUBMETA_42("SUBMETA_42", "Submeta 4.2 (4.500 profissionais técnicos avaliados semestralmente)");
/*    */   
/*    */   private String descricao;
/*    */   private String codigo;
/*    */   
/*    */   SubMeta_(String codigo, String descricao) {
/* 20 */     this.descricao = descricao;
/* 21 */     this.codigo = codigo;
/*    */   }
/*    */ 
/*    */   
/*    */   public static SubMeta_ get(String codigo) {
/* 26 */     if (codigo.equalsIgnoreCase("SUBMETA_41"))
/* 27 */       return SUBMETA_41; 
/* 28 */     if (codigo.equalsIgnoreCase("SUBMETA_42")) {
/* 29 */       return SUBMETA_42;
/*    */     }
/* 31 */     throw new MonitoramentoException("Submeta não selecionada");
/*    */   }
/*    */   
/*    */   public static Map<String, String> getSubMetas() {
/* 35 */     Map<String, String> respostas = new HashMap<>();
/* 36 */     respostas.put("SUBMETA_41", "Submeta 4.1 (4.500 profissionais técnicos trimestralmente acompanhados e monitorados no desenvolvimento das suas funções)");
/* 37 */     respostas.put("SUBMETA_42", "Submeta 4.2 (4.500 profissionais técnicos avaliados semestralmente)");
/* 38 */     return respostas;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 42 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 46 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public String getCodigo() {
/* 50 */     return this.codigo;
/*    */   }
/*    */   
/*    */   public void setCodigo(String codigo) {
/* 54 */     this.codigo = codigo;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\enums\SubMeta_.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */