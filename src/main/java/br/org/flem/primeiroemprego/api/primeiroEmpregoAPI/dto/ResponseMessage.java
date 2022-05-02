/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ResponseMessage
/*    */ {
/*    */   private Integer id;
/*    */   private String value;
/*    */   
/*    */   public ResponseMessage(Integer id, String value) {
/* 16 */     this.id = id;
/* 17 */     this.value = value;
/*    */   }
/*    */   
/*    */   public Integer getId() {
/* 21 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 25 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getValue() {
/* 29 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(String value) {
/* 33 */     this.value = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\ResponseMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */