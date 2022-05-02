/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.util;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SMBUtil
/*    */ {
/*    */   public static void throwException(boolean condition, String message) {
/* 12 */     if (condition)
/* 13 */       throw new MonitoramentoException(message); 
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAP\\util\SMBUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */