/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.AvaliacaoMonitoramentoDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.AvaliacaoQuestionarioDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.ResponseMessage;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.AvaliacaoMonitoramentoService;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.AvaliacaoQuestionarioService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.DeleteMapping;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.PutMapping;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"/avaliacoes"})
/*    */ public class AvaliacaoMonitoramentoController
/*    */ {
/*    */   @Autowired
/*    */   private AvaliacaoMonitoramentoService avaliacaoMonitoramentoService;
/*    */   @Autowired
/*    */   private AvaliacaoQuestionarioService avaliacaoQuestionarioService;
/*    */   
/*    */   @PostMapping
/*    */   public ResponseEntity<AvaliacaoMonitoramentoDTO> gravar(@RequestBody AvaliacaoMonitoramentoDTO dto) {
/*    */     try {
/* 40 */       return new ResponseEntity(this.avaliacaoMonitoramentoService.salvar(dto), HttpStatus.CREATED);
/* 41 */     } catch (MonitoramentoException ex) {
/* 42 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @PutMapping
/*    */   public ResponseEntity<AvaliacaoMonitoramentoDTO> atualizar(@RequestBody AvaliacaoMonitoramentoDTO dto) {
/*    */     try {
/* 50 */       return new ResponseEntity(this.avaliacaoMonitoramentoService.atualizar(dto), HttpStatus.OK);
/* 51 */     } catch (MonitoramentoException ex) {
/* 52 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @DeleteMapping({"/{id}"})
/*    */   public ResponseEntity<ResponseMessage> atualizar(@PathVariable("id") Long id) {
/*    */     try {
/* 60 */       this.avaliacaoMonitoramentoService.delete(id);
/* 61 */       return new ResponseEntity(new ResponseMessage(Integer.valueOf(1), "Avaliação Excluída com Sucesso"), HttpStatus.OK);
/* 62 */     } catch (MonitoramentoException ex) {
/* 63 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   @GetMapping({"/{id}"})
/*    */   public ResponseEntity<AvaliacaoMonitoramentoDTO> obter(@PathVariable("id") Long id) {
/*    */     try {
/* 70 */       return new ResponseEntity(this.avaliacaoMonitoramentoService.findDTOById(id), HttpStatus.FOUND);
/* 71 */     } catch (MonitoramentoException ex) {
/* 72 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   @GetMapping
/*    */   public ResponseEntity<List<AvaliacaoMonitoramentoDTO>> obterTodos() {
/*    */     try {
/* 79 */       return new ResponseEntity(this.avaliacaoMonitoramentoService.findDTOAll(), HttpStatus.OK);
/* 80 */     } catch (MonitoramentoException ex) {
/* 81 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   @GetMapping({"/monitoramento/{id}"})
/*    */   public ResponseEntity<List<AvaliacaoQuestionarioDTO>> findByIdRegistroMonitoramento(@PathVariable("id") Long id) {
/*    */     try {
/* 88 */       return new ResponseEntity(this.avaliacaoQuestionarioService.findByIdRegistroMonitoramento(id), HttpStatus.OK);
/* 89 */     } catch (MonitoramentoException ex) {
/* 90 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\controller\AvaliacaoMonitoramentoController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */