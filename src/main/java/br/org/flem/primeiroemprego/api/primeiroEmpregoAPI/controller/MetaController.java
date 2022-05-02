/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.MetaDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.ResponseMessage;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Meta;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.MetaService;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"/metas"})
/*    */ public class MetaController
/*    */ {
/*    */   @Autowired
/*    */   private MetaService service;
/*    */   
/*    */   @GetMapping
/*    */   public ResponseEntity<List<Meta>> findAll() {
/* 39 */     return new ResponseEntity(this.service.getList(), HttpStatus.OK);
/*    */   }
/*    */   
/*    */   @GetMapping({"/{id}"})
/*    */   public ResponseEntity<Meta> findOne(@PathVariable("id") Long id) {
/* 44 */     return new ResponseEntity(this.service.findById(id), HttpStatus.OK);
/*    */   }
/*    */   
/*    */   @PostMapping
/*    */   public ResponseEntity<Meta> gravar(@RequestBody MetaDTO dto) {
/*    */     try {
/* 50 */       return new ResponseEntity(this.service.salvar(dto), HttpStatus.OK);
/* 51 */     } catch (MonitoramentoException ex) {
/* 52 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   @PutMapping
/*    */   public ResponseEntity<Meta> atualizar(@RequestBody MetaDTO dto) {
/*    */     try {
/* 59 */       return new ResponseEntity(this.service.atualizar(dto), HttpStatus.OK);
/* 60 */     } catch (MonitoramentoException ex) {
/* 61 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   @DeleteMapping({"/{id}"})
/*    */   public ResponseEntity<ResponseMessage> deletar(@PathVariable("id") Long id) {
/*    */     try {
/* 68 */       this.service.deletar(id);
/* 69 */       return new ResponseEntity(new ResponseMessage(Integer.valueOf(1), "Excluido com sucesso"), HttpStatus.OK);
/* 70 */     } catch (MonitoramentoException ex) {
/* 71 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\controller\MetaController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */