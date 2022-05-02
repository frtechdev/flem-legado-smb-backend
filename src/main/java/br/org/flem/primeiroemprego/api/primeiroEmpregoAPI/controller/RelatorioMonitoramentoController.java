/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.ListaMonitoramentoDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.SinteseRelatorioTrimestralDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.RegistroMonitoramentoService;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.ReportsService;
/*    */ import java.time.LocalDate;
/*    */ import java.util.List;
/*    */ import net.sf.jasperreports.engine.JRException;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.format.annotation.DateTimeFormat;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
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
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"/relatorios"})
/*    */ public class RelatorioMonitoramentoController
/*    */ {
/*    */   @Autowired
/*    */   private RegistroMonitoramentoService registroMonitoramentoService;
/*    */   @Autowired
/*    */   private ReportsService reportsService;
/*    */   
/*    */   @GetMapping({"/filter"})
/*    */   public ResponseEntity<List<ListaMonitoramentoDTO>> getFuncionariosByDemandante(@RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy") LocalDate dataInicio, @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy") LocalDate dataFim, @RequestParam("unidade") String unidadeLotacao, @RequestParam("municipio") Long municipio, @RequestParam("demandante") Long demandante) {
/*    */     try {
/* 43 */       return new ResponseEntity(this.registroMonitoramentoService.filterBy(dataInicio, dataFim, unidadeLotacao, municipio, demandante), HttpStatus.OK);
/* 44 */     } catch (MonitoramentoException|java.io.UnsupportedEncodingException ex) {
/* 45 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   @GetMapping({"/unidadesPorDemandantesMunicipios"})
/*    */   public ResponseEntity<List<String>> getUnidadesByDemandantes(@RequestParam("demandantes") List<Long> demandantes, @RequestParam("municipios") List<Long> municipios) {
/*    */     try {
/* 52 */       return new ResponseEntity(this.registroMonitoramentoService.obterUnidadeLotacaoByDemandantesAndMunicipios(demandantes, municipios), HttpStatus.OK);
/* 53 */     } catch (MonitoramentoException ex) {
/* 54 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   @GetMapping({"/porPeriodo"})
/*    */   public ResponseEntity<byte[]> getRelatorioTrimetral(@RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy") LocalDate dataInicio, @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy") LocalDate dataFim, @RequestParam("demandante") Long demandante) {
/*    */     try {
/* 61 */       return new ResponseEntity(this.registroMonitoramentoService.getRelatorioTrimetral(dataInicio, dataFim, demandante), HttpStatus.OK);
/* 62 */     } catch (MonitoramentoException|JRException|java.io.IOException ex) {
/* 63 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   @GetMapping({"/porMonitoramento/{idMonitoramento}"})
/*    */   public ResponseEntity<byte[]> getRelatorioIndividual(@PathVariable("idMonitoramento") Long idMonitoramento) {
/*    */     try {
/* 70 */       return new ResponseEntity(this.reportsService.printRegistroMonitoramento(idMonitoramento), HttpStatus.OK);
/* 71 */     } catch (JRException|java.io.IOException ex) {
/* 72 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   @GetMapping({"/sintesePorPeriodo/"})
/*    */   public ResponseEntity<byte[]> getRelatorioSintesePorPeriodo(@RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy") LocalDate dataInicio, @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy") LocalDate dataFim) {
/*    */     try {
/* 79 */       //return new ResponseEntity(this.registroMonitoramentoService.getRelatorioSintesePorPeriodo(dataInicio, dataFim), HttpStatus.OK);
				return new ResponseEntity(this.registroMonitoramentoService.getRelatorioSintesePorPeriodo2(dataInicio, dataFim), HttpStatus.OK);
/* 80 */     } catch (JRException|java.io.IOException ex) {
/* 81 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */   
/*    */   @GetMapping({"/sintesePorPeriodoXls/"})
/*    */   public ResponseEntity<List<SinteseRelatorioTrimestralDTO>> getRelatorioSintese(@RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy") LocalDate dataInicio, @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy") LocalDate dataFim) {
/*    */     try {
/* 88 */       //return new ResponseEntity(this.registroMonitoramentoService.getRelatorioSintese(dataInicio, dataFim), HttpStatus.OK);
				return new ResponseEntity(this.registroMonitoramentoService.getRelatorioSintese2(dataInicio, dataFim), HttpStatus.OK);
/* 89 */     } catch (MonitoramentoException ex) {
/* 90 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\controller\RelatorioMonitoramentoController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */