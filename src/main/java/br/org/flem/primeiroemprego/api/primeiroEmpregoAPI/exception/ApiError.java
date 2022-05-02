/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import org.springframework.http.HttpStatus;
/*    */ 
/*    */ 
/*    */ public class ApiError
/*    */ {
/*    */   private HttpStatus status;
/*    */   private String message;
/*    */   private List<String> errors;
/*    */   
/*    */   public ApiError(HttpStatus status, String message, List<String> errors) {
/* 15 */     this.status = status;
/* 16 */     this.message = message;
/* 17 */     this.errors = errors;
/*    */   }
/*    */ 
/*    */   
/*    */   public ApiError(HttpStatus status, String message, String error) {
/* 22 */     this.status = status;
/* 23 */     this.message = message;
/* 24 */     this.errors = Arrays.asList(new String[] { error });
/*    */   }
/*    */   
/*    */   public HttpStatus getStatus() {
/* 28 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(HttpStatus status) {
/* 32 */     this.status = status;
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 36 */     return this.message;
/*    */   }
/*    */   
/*    */   public void setMessage(String message) {
/* 40 */     this.message = message;
/*    */   }
/*    */   
/*    */   public List<String> getErrors() {
/* 44 */     return this.errors;
/*    */   }
/*    */   
/*    */   public void setErrors(List<String> errors) {
/* 48 */     this.errors = errors;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\exception\ApiError.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */