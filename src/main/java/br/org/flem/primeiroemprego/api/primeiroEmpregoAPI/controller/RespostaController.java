/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseController;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseModel;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseService;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RespostaDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Resposta;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.RespostaService;
/*    */ import java.io.Serializable;
/*    */ import java.util.Optional;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.DeleteMapping;
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
/*    */ @RequestMapping({"/respostas"})
/*    */ public class RespostaController
/*    */   extends BaseController<Resposta, Long, RespostaDTO>
/*    */ {
/*    */   private final RespostaService service;
/*    */   
/*    */   @Autowired
/*    */   public RespostaController(RespostaService service) {
/* 39 */     super((BaseService)service, RespostaDTO.class);
/* 40 */     this.service = service;
/*    */   }
/*    */ 
/*    */   
/*    */   @PutMapping
/*    */   public ResponseEntity<RespostaDTO> update(@RequestBody RespostaDTO dto) {
/* 46 */     return (ResponseEntity<RespostaDTO>)Optional.<BaseDTO>ofNullable(toDto((BaseModel)this.service.atualizar(dto))).map(obj -> new ResponseEntity(obj, HttpStatus.OK))
/* 47 */       .orElseThrow(() -> new MonitoramentoException("Erro salvar pergunta"));
/*    */   }
/*    */ 
/*    */   
/*    */   @PostMapping
/*    */   public ResponseEntity<RespostaDTO> create(@RequestBody RespostaDTO dto) {
/*    */     try {
/* 54 */       return (ResponseEntity<RespostaDTO>)Optional.<BaseDTO>ofNullable(toDto((BaseModel)this.service.salvar(dto)))
/* 55 */         .map(obj -> new ResponseEntity(obj, HttpStatus.OK))
/* 56 */         .orElseThrow(() -> new MonitoramentoException("Erro salvar pergunta"));
/* 57 */     } catch (MonitoramentoException ex) {
/* 58 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @DeleteMapping({"/{id}"})
/*    */   public ResponseEntity<RespostaDTO> delete(@PathVariable("id") Long id) {
/*    */     try {
/* 66 */       this.service.delete(id);
/* 67 */       return ResponseEntity.ok().build();
/* 68 */     } catch (MonitoramentoException ex) {
/* 69 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\controller\RespostaController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */