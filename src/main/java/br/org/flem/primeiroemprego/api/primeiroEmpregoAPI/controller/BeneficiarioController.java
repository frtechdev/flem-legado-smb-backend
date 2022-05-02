/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.BeneficiarioDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.BeneficiarioService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"/beneficiarios"})
/*    */ public class BeneficiarioController
/*    */ {
/*    */   @Autowired
/*    */   private BeneficiarioService beneficiarioService;
/*    */   
/*    */   @GetMapping({"/{idBeneficiario}"})
/*    */   public ResponseEntity<BeneficiarioDTO> findById(@PathVariable("idBeneficiario") Long idBeneficiario) {
/* 23 */     return new ResponseEntity(this.beneficiarioService.dtoFindById(idBeneficiario), HttpStatus.OK);
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\controller\BeneficiarioController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */