/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.EscritorioRegionalProj;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.EscritorioRegionalService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"/escritorios"})
/*    */ public class EscritorioRegionalController
/*    */ {
/*    */   @Autowired
/*    */   private EscritorioRegionalService service;
/*    */   
/*    */   @GetMapping
/*    */   public ResponseEntity<List<EscritorioRegionalProj>> findAll() {
/* 26 */     return new ResponseEntity(this.service.findAllActive(), HttpStatus.OK);
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\controller\EscritorioRegionalController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */