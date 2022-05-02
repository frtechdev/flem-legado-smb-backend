/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.MonitoramentoComprovacaoDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.ResponseMessage;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.filtro.ComprovacaoFiltro;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Comprovacao;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.ComprovacaoService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.core.io.Resource;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.MediaType;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ import org.springframework.web.multipart.MultipartFile;
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
/*    */ @RequestMapping({"/comprovacoes"})
/*    */ public class ComprovacaoController
/*    */ {
/*    */   @Autowired
/*    */   private ComprovacaoService service;
/*    */   
/*    */   @PostMapping(value = {"/associacao"}, consumes = {"multipart/form-data"})
/*    */   public ResponseEntity<ResponseMessage> associar(@RequestParam("monitoramentos") List<Long> monitoramentos, @RequestParam("comprovacao") MultipartFile avaliacoes) {
/* 41 */     this.service.associarComprovacao(monitoramentos, avaliacoes, null);
/* 42 */     return new ResponseEntity(new ResponseMessage(Integer.valueOf(1), "Associação realizada com sucesso"), HttpStatus.OK);
/*    */   }
/*    */   
/*    */   @PostMapping({"/filter"})
/*    */   public ResponseEntity<List<MonitoramentoComprovacaoDTO>> getFuncionariosByDemandante(@RequestBody ComprovacaoFiltro filtro) {
/*    */     try {
/* 48 */       return new ResponseEntity(this.service.filterBy(filtro.getStartDate(), filtro.getEndDate(), filtro.getUnidade(), filtro.getMunicipio(), filtro.getDemandante()), HttpStatus.OK);
/* 49 */     } catch (MonitoramentoException|java.io.UnsupportedEncodingException ex) {
/* 50 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   @GetMapping({"/{id}/download"})
/*    */   public ResponseEntity<Resource> downloadById(@PathVariable("id") Long id) {
/*    */     try {
/* 57 */       Comprovacao comprovacao = this.service.findById(id);
/*    */       
/* 59 */       Resource resource = this.service.downloadById(id);
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 64 */       return ((ResponseEntity.BodyBuilder)ResponseEntity.ok().header("Content-Disposition", new String[] { "attachment;filename=" + comprovacao.getFileName() })).contentType(MediaType.parseMediaType(comprovacao.getContentType())).contentLength(comprovacao.getFileSize().longValue()).body(resource);
/* 65 */     } catch (MonitoramentoException ex) {
/* 66 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\controller\ComprovacaoController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */