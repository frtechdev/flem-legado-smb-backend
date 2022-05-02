/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Demandante;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.DemandanteMunicipioProj;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.DemandanteService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"/demandantes"})
/*    */ public class DemandanteController
/*    */ {
/*    */   @Autowired
/*    */   private DemandanteService service;
/*    */   
/*    */   @PostMapping({"/naoVinculados"})
/*    */   public ResponseEntity<List<DemandanteMunicipioProj>> findByVagaMunicipioNaoAssociados(@RequestBody List<Municipio> municipios) {
/* 31 */     return new ResponseEntity(this.service.findByVagaMunicipioNaoAssociados(municipios), HttpStatus.OK);
/*    */   }
/*    */   
/*    */   @PostMapping({"/vinculados"})
/*    */   public ResponseEntity<List<DemandanteMunicipioProj>> findByMunicipios(@RequestBody List<Municipio> municipios) {
/* 36 */     return new ResponseEntity(this.service.findByMunicipios(municipios), HttpStatus.OK);
/*    */   }
/*    */   
/*    */   @GetMapping({"/{id}"})
/*    */   public ResponseEntity<Demandante> findById(@PathVariable("id") Long id) {
/* 41 */     return new ResponseEntity(this.service.findById(id), HttpStatus.OK);
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\controller\DemandanteController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */