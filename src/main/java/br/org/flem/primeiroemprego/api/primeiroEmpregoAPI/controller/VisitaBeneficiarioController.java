/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.VisitaBeneficiario;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.VisitaBeneficiarioService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"/visitaBeneficiarios"})
/*    */ public class VisitaBeneficiarioController
/*    */ {
/*    */   @Autowired
/*    */   private VisitaBeneficiarioService service;
/*    */   
/*    */   @GetMapping({"/visitar"})
/*    */   public ResponseEntity<VisitaBeneficiario> visitarBeneficiario(@RequestParam(required = false, value = "idMonitor") Long idMonitor, @RequestParam(required = false, name = "idFuncionario") Long idBeneficiario) {
/*    */     try {
/* 30 */       return new ResponseEntity(this.service.saveVisitaBeneficiario(idMonitor, idBeneficiario), HttpStatus.OK);
/* 31 */     } catch (MonitoramentoException ex) {
/* 32 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */   @GetMapping({"/desfazerVisita"})
/*    */   public ResponseEntity<VisitaBeneficiario> desfazerVisitaBeneficiario(@RequestParam(required = false, name = "idFuncionario") Long idBeneficiario) {
/*    */     try {
/* 38 */       return new ResponseEntity(this.service.saveDesfazerVisitaBeneficiario(idBeneficiario), HttpStatus.OK);
/* 39 */     } catch (MonitoramentoException ex) {
/* 40 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\controller\VisitaBeneficiarioController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */