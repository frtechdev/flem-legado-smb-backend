/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception;

/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.validation.ConstraintViolation;
/*    */ import javax.validation.ConstraintViolationException;
/*    */ import org.springframework.http.HttpHeaders;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.util.MultiValueMap;
/*    */ import org.springframework.validation.FieldError;
/*    */ import org.springframework.validation.ObjectError;
/*    */ import org.springframework.web.bind.MethodArgumentNotValidException;
/*    */ import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
/*    */ import org.springframework.web.bind.annotation.ExceptionHandler;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ import org.springframework.web.context.request.WebRequest;
/*    */ import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
/*    */ import org.springframework.web.multipart.MaxUploadSizeExceededException;
/*    */ import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/*    */ 
/*    */ @ControllerAdvice
/*    */ @RestController
/*    */ public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
/*    */   protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
/* 25 */     List<String> errors = new ArrayList<>();
/* 26 */     ex.getBindingResult().getFieldErrors().forEach(error -> errors.add(error.getField() + ": " + error.getDefaultMessage()));
/*    */ 
/*    */     
/* 29 */     ex.getBindingResult().getGlobalErrors().forEach(error -> errors.add(error.getObjectName() + ": " + error.getDefaultMessage()));
/*    */ 
/*    */ 
/*    */     
/* 33 */     ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
/* 34 */     return handleExceptionInternal((Exception)ex, apiError, headers, apiError.getStatus(), request);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
/* 39 */     String error = ex.getParameterName() + " parâmetro obrigatório";
/*    */     
/* 41 */     ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
/* 42 */     return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
/*    */   }
/*    */   
/*    */   @ExceptionHandler({ConstraintViolationException.class})
/*    */   public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
/* 47 */     List<String> errors = new ArrayList<>();
/* 48 */     ex.getConstraintViolations().forEach(violation -> errors.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": " + violation.getMessage()));
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 53 */     ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
/* 54 */     return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
/*    */   }
/*    */   
/*    */   @ExceptionHandler({MethodArgumentTypeMismatchException.class})
/*    */   public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
/* 59 */     String error = ex.getName() + " deve ser do tipo " + ex.getRequiredType().getName();
/*    */     
/* 61 */     ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
/* 62 */     return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
/*    */   }
/*    */   
/*    */   @ExceptionHandler({MonitoramentoException.class})
/*    */   public final ResponseEntity<Object> handleUserNotFoundException(MonitoramentoException ex, WebRequest request) {
/* 67 */     ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex.getMessage());
/* 68 */     return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
/*    */   }
/*    */   
/*    */   @ExceptionHandler({MaxUploadSizeExceededException.class})
/*    */   public final ResponseEntity<Object> handleMultipartException(MaxUploadSizeExceededException ex, WebRequest request) {
/* 73 */     String error = "Tamanho máximo de " + ex.getMaxUploadSize() + " excedido";
/* 74 */     ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
/* 75 */     return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\exception\CustomRestExceptionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */