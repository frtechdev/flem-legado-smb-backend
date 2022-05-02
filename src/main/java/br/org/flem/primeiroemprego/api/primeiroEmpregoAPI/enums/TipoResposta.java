/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonProperty;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum TipoResposta
/*    */ {
/*  9 */   UNICA("Escolha Única"),
/*    */   
/* 11 */   MULTIPLA("Multipla Escolha");
/*    */   
/*    */   private String descricao;
/*    */ 
/*    */   
/*    */   TipoResposta(String descricao) {
/* 17 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 21 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public static Map<TipoResposta, String> getValues() {
/* 25 */     Map<TipoResposta, String> values = new HashMap<>();
/* 26 */     values.put(UNICA, "Escolha Única");
/* 27 */     values.put(MULTIPLA, "Multipla Escolha");
/* 28 */     return values;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\enums\TipoResposta.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */