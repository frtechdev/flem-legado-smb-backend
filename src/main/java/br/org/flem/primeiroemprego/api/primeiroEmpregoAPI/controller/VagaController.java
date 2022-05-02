/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.FuncionarioDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.DemandanteMunicipioProj;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.DemandanteProj;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.MunicipioProj;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.VagaService;
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"/vagas"})
/*    */ public class VagaController
/*    */ {
/*    */   @Autowired
/*    */   private VagaService service;
/*    */   
/*    */   @GetMapping({"/municipios"})
/*    */   public ResponseEntity<List<MunicipioProj>> findAllMunicipiosVaga() {
/* 37 */     return new ResponseEntity(this.service.findAllMunicipiosVaga(), HttpStatus.OK);
/*    */   }
/*    */   
/*    */   @GetMapping({"/demandantes"})
/*    */   public ResponseEntity<List<DemandanteProj>> findAllDemandantesVaga() {
/* 42 */     return new ResponseEntity(this.service.findAllDemandatesVaga(), HttpStatus.OK);
/*    */   }
/*    */   
/*    */  @GetMapping({"/funcionariosPorUnidadesDeLotacaoAndMunsAndDems"})
/*    */   public ResponseEntity<List<FuncionarioDTO>> findFuncionariosPorUnidadeLotacao(@RequestParam("unidades") List<String> unidadeDeLotacao, @RequestParam("municipios") List<Long> idMunicipios, @RequestParam("demandantes") List<Long> idDemandantes) {
/* 47 */     return new ResponseEntity(this.service.obterBeneficiariosPorUnidadesDeLotacaoAndMunsAndDems(null, unidadeDeLotacao, idMunicipios, idDemandantes), HttpStatus.OK);
/*    */   }
/*    */   
/*    */   @GetMapping({"/unidadesPorDemandantesMunicipios"})
/*    */   public ResponseEntity<List<String>> getUnidadesByDemandantes(@RequestParam("demandantes") List<Long> demandantes, @RequestParam("municipios") List<Long> municipios) {
/*    */     try {
/* 53 */       return new ResponseEntity(this.service.obterUnidadeLotacaoByDemandantesAndMunicipios(demandantes, municipios), HttpStatus.OK);
/* 54 */     } catch (MonitoramentoException ex) {
/* 55 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   @GetMapping({"/demandantesNaoAssociadosByMunicipios"})
/*    */   public ResponseEntity<List<DemandanteMunicipioProj>> findDemandantesNaoAssociaodsByMunicipios(@RequestParam("municipios") List<Municipio> municipios) {
/* 61 */     return new ResponseEntity(this.service.findByVagaMunicipioNaoAssociados(municipios), HttpStatus.OK);
/*    */   }
/*    */   
/*    */   @GetMapping({"/demandantesAssociadosByMunicipios"})
/*    */   public ResponseEntity<List<DemandanteMunicipioProj>> findDemandantesAssociaodsByMunicipios(@RequestParam("municipios") List<Municipio> municipios) {
/* 66 */     return new ResponseEntity(this.service.findByVagaMunicipio(municipios), HttpStatus.OK);
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\controller\VagaController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */