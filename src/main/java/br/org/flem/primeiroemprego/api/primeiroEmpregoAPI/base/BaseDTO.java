/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class BaseDTO
/*    */   extends AbstractHelper
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 5048829851361625414L;
/*    */   
/*    */   public String getUsuarioLogado() {
/* 18 */     return getCurrentUser();
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\base\BaseDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */