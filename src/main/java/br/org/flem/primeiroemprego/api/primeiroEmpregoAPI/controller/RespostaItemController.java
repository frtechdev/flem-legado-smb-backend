/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.MonitoramentoQuestionarioDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RespostaDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RespostaItemDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.RespostaItemService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"/respostasItems"})
/*    */ public class RespostaItemController
/*    */ {
/*    */   @Autowired
/*    */   private RespostaItemService service;
/*    */   
/*    */   @PostMapping
/*    */   public ResponseEntity<RespostaDTO> create(@RequestBody RespostaItemDTO respostaItem) {
/*    */     try {
/* 39 */       this.service.salvar(respostaItem);
/* 40 */       return ResponseEntity.ok().build();
/* 41 */     } catch (MonitoramentoException|net.sf.jasperreports.engine.JRException ex) {
/* 42 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   @GetMapping({"/beneficiarioLogado/monitoramento"})
/*    */   public ResponseEntity<MonitoramentoQuestionarioDTO> getMonitoramentoBeneficiarioLogado() {
/* 48 */     return new ResponseEntity(this.service.obterRegistroMonitoramentoDTO(), HttpStatus.OK);
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\controller\RespostaItemController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */