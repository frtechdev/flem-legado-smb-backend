/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum CriteriaOpereration
/*    */ {
/*  9 */   EQ("="),
/* 10 */   NE("<>"),
/* 11 */   GT(">"),
/* 12 */   GE(">="),
/* 13 */   LT("<"),
/* 14 */   LE("<="),
/* 15 */   LIKE("%"),
/* 16 */   IN("in"),
/* 17 */   NOTIN("not in");
/*    */   
/*    */   private final String descricao;
/*    */   
/*    */   CriteriaOpereration(String descricao) {
/* 22 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 26 */     return this.descricao;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 31 */     return super.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\base\CriteriaOpereration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */