/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SearchCriteria
/*    */ {
/*    */   private String key;
/*    */   private CriteriaOpereration operation;
/*    */   private Object value;
/*    */   
/*    */   public SearchCriteria() {}
/*    */   
/*    */   public SearchCriteria(String key, CriteriaOpereration operation, Object value) {
/* 16 */     this.key = key;
/* 17 */     this.operation = operation;
/* 18 */     this.value = value;
/*    */   }
/*    */   
/*    */   public String getKey() {
/* 22 */     return this.key;
/*    */   }
/*    */   
/*    */   public void setKey(String key) {
/* 26 */     this.key = key;
/*    */   }
/*    */   
/*    */   public CriteriaOpereration getOperation() {
/* 30 */     return this.operation;
/*    */   }
/*    */   
/*    */   public void setOperation(CriteriaOpereration operation) {
/* 34 */     this.operation = operation;
/*    */   }
/*    */   
/*    */   public Object getValue() {
/* 38 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(Object value) {
/* 42 */     this.value = value;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\base\SearchCriteria.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */