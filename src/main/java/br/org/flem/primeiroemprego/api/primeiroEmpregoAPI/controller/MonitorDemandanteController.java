/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.DemandanteMunicipioDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.ResponseMessage;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.MonitorDemandanteService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.DeleteMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"/monitorDemandantes"})
/*    */ public class MonitorDemandanteController
/*    */ {
/*    */   @Autowired
/*    */   private MonitorDemandanteService monitorDemandanteService;
/*    */   
/*    */   @PostMapping({"/{idMonitor}"})
/*    */   public ResponseEntity<?> associarDemandantes(@PathVariable("idMonitor") Long idMonitor, @RequestBody List<DemandanteMunicipioDTO> selecionados) {
/*    */     try {
/* 31 */       this.monitorDemandanteService.associar(idMonitor, selecionados);
/* 32 */       return new ResponseEntity(new ResponseMessage(Integer.valueOf(1), "Associação realizada com sucesso"), HttpStatus.CREATED);
/* 33 */     } catch (MonitoramentoException ex) {
/* 34 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @DeleteMapping({"/{id}"})
/*    */   public ResponseEntity<?> deletarAssociacao(@PathVariable("id") Long id) {
/*    */     try {
/* 42 */       this.monitorDemandanteService.desassociar(id);
/* 43 */       return new ResponseEntity(new ResponseMessage(Integer.valueOf(1), "Desassociação realizada com sucesso"), HttpStatus.OK);
/* 44 */     } catch (MonitoramentoException ex) {
/* 45 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\controller\MonitorDemandanteController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */