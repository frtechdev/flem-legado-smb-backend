/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum StatusAgendaEnum
/*    */ {
/* 12 */   AGENDADA("AGENDADA", "Agendado"),
/* 13 */   REALIZADO("REALIZADO", "Realizado"),
/* 14 */   NAO_REALIZADO("NAO_REALIZADO", "Não realizado"),
/* 15 */   CANCELADO("CANCELADO", "Cancelado");
/*    */   
/*    */   private String descricao;
/*    */   private String codigo;
/*    */   
/*    */   StatusAgendaEnum(String codigo, String descricao) {
/* 21 */     this.descricao = descricao;
/* 22 */     this.codigo = codigo;
/*    */   }
/*    */   
/*    */   public static Map<String, String> getStatusAgendaEnum() {
/* 26 */     Map<String, String> respostas = new HashMap<>();
/* 27 */     respostas.put("AGENDADA", "Agendado");
/* 28 */     respostas.put("REALIZADO", "Realizado");
/* 29 */     respostas.put("NAO_REALIZADO", "Não realizado");
/* 30 */     respostas.put("CANCELADO", "Cancelado");
/* 31 */     return respostas;
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


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\enums\StatusAgendaEnum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */