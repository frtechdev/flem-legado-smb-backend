/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.MunicipioProj;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.MunicipioService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"/municipios"})
/*    */ public class MunicipioController
/*    */ {
/*    */   @Autowired
/*    */   private MunicipioService service;
/*    */   
/*    */   @GetMapping({"/byEscritorio/{idEscritorio}"})
/*    */   public ResponseEntity<List<MunicipioProj>> findByEscritorioRegional(@PathVariable("idEscritorio") Long idEscritorio) {
/* 32 */     return new ResponseEntity(this.service.findByEscritorioRegional(idEscritorio), HttpStatus.OK);
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\controller\MunicipioController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */