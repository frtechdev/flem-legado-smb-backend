/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.MonitoramentoDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.MonitorarDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RegistroMonitoramentoEditarDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RelatorioMonitoramentoDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.ResponseMessage;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.RespostaTecnica;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.RegistroMonitoramentoService;
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.core.io.Resource;
/*     */ import org.springframework.http.HttpStatus;
/*     */ import org.springframework.http.MediaType;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.web.bind.annotation.DeleteMapping;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ @RequestMapping({"/monitoramentos"})
/*     */ public class MonitoramentoController
/*     */ {
/*     */   @Autowired
/*     */   private RegistroMonitoramentoService monitoramentoService;
/*     */   @Autowired
/*     */   private ObjectMapper objectMapper;
/*     */   
/*     */   @GetMapping({"/byBeneficiario/{id}"})
/*     */   public ResponseEntity<List<MonitoramentoDTO>> historic(@PathVariable("id") Long id) {
/*     */     try {
/*  50 */       return new ResponseEntity(this.monitoramentoService.getHistoric(id), HttpStatus.OK);
/*  51 */     } catch (MonitoramentoException ex) {
/*  52 */       throw new MonitoramentoException(ex.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   @GetMapping({"/{id}"})
/*     */   public ResponseEntity<RelatorioMonitoramentoDTO> obterMonitoramento(@PathVariable("id") Long id) {
/*     */     try {
/*  59 */       return new ResponseEntity(this.monitoramentoService.obterRegistroPorId(id), HttpStatus.OK);
/*  60 */     } catch (MonitoramentoException ex) {
/*  61 */       throw new MonitoramentoException(ex.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   @DeleteMapping({"/{id}"})
/*     */   public ResponseEntity<ResponseMessage> deleteById(@PathVariable("id") Long id) {
/*     */     try {
/*  68 */       this.monitoramentoService.deleteById(id);
/*  69 */       return new ResponseEntity(new ResponseMessage(Integer.valueOf(1), "Registro de Monitoramento excluído com sucesso!"), HttpStatus.OK);
/*  70 */     } catch (MonitoramentoException ex) {
/*  71 */       throw new MonitoramentoException(ex.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   @PostMapping(consumes = {"multipart/form-data"})
/*     */   public ResponseEntity<ResponseMessage> monitorar(@RequestParam("beneficiario") String monitoramento, @RequestParam("avaliacoes") MultipartFile[] avaliacoes) {
/*     */     try {
	
				System.out.println("CONSUMED 1");
				
/*  78 */       MonitorarDTO dto = (MonitorarDTO)this.objectMapper.readValue(monitoramento, MonitorarDTO.class);
				
				System.out.println("CONSUMED 2");

				System.out.println(dto.getDataMonitoramento());
/*  79 */       this.monitoramentoService.registrarMonitoramento(dto, avaliacoes);
				
				System.out.println("CONSUMED 3");
/*  80 */       
				return new ResponseEntity(new ResponseMessage(Integer.valueOf(1), "Beneficiário Monitorado Com Sucesso"), HttpStatus.OK);
/*  81 */     } catch (MonitoramentoException|IOException ex) {
				
				System.out.println("CONSUMED 4");
/*  82 */       
				throw new MonitoramentoException(ex.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   @GetMapping({"/respostasTecnicas"})
/*     */   public ResponseEntity<Map<String, String>> getRespostaTecnica() {
/*     */     try {
/*  89 */       return new ResponseEntity(RespostaTecnica.getRespostaTecnica(), HttpStatus.OK);
/*  90 */     } catch (MonitoramentoException ex) {
/*  91 */       throw new MonitoramentoException(ex.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   @GetMapping(value = {"/{id}/documentos"}, produces = {"application/zip"})
/*     */   public ResponseEntity<Resource> getDocumentos(@PathVariable("id") Long id) throws IOException {
/*     */     try {
/*  98 */       Resource resources = this.monitoramentoService.obterDocumentosPorId(id);
/*     */ 
/*     */ 
/*     */       
/* 102 */       return ((ResponseEntity.BodyBuilder)ResponseEntity.ok().header("Content-Disposition", new String[] { "attachment;filename=avaliacoes.zip" })).contentType(MediaType.parseMediaType("application/zip")).body(resources);
/* 103 */     } catch (MonitoramentoException ex) {
/* 104 */       throw new MonitoramentoException(ex.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   @GetMapping({"/{id}/documento"})
/*     */   public ResponseEntity<Resource> getDocumentoByPath(@RequestParam("path") String path) {
/*     */     try {
/* 111 */       Resource resources = this.monitoramentoService.obterDocumentoPorPath(path);
/* 112 */       String[] fileArray = path.split("/");
/*     */ 
/*     */ 
/*     */       
/* 116 */       return ((ResponseEntity.BodyBuilder)ResponseEntity.ok().header("Content-Disposition", new String[] { "attachment;filename=" + fileArray[fileArray.length - 1] })).contentType(MediaType.parseMediaType("application/pdf")).body(resources);
/* 117 */     } catch (MonitoramentoException ex) {
/* 118 */       throw new MonitoramentoException(ex.getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/{id}/obterMonitoramento"})
/*     */   public ResponseEntity<RegistroMonitoramentoEditarDTO> getRegistroMonitoramento(@PathVariable("id") Long id) {
/*     */     try {
/* 126 */       return new ResponseEntity(this.monitoramentoService.getMonitoramento(id), HttpStatus.OK);
/* 127 */     } catch (MonitoramentoException ex) {
/* 128 */       throw new MonitoramentoException(ex.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   @PostMapping(value = {"/editar"}, consumes = {"multipart/form-data"})
/*     */   public ResponseEntity<ResponseMessage> edtarMonitoramento(@RequestParam("beneficiario") String monitoramento, @RequestParam("avaliacoes") MultipartFile[] avaliacoes) {
/*     */     try {
/* 135 */       MonitorarDTO dto = (MonitorarDTO)this.objectMapper.readValue(monitoramento, MonitorarDTO.class);
/* 136 */       this.monitoramentoService.editarRegistrarMonitoramento(dto, avaliacoes);
/* 137 */       return new ResponseEntity(new ResponseMessage(Integer.valueOf(1), "Beneficiário Monitorado Com Sucesso"), HttpStatus.OK);
/* 138 */     } catch (MonitoramentoException ex) {
/* 139 */       throw new MonitoramentoException(ex.getMessage());
/* 140 */     } catch (IOException ex) {
/* 141 */       Logger.getLogger(MonitoramentoController.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 142 */       throw new MonitoramentoException(ex.getMessage());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\controller\MonitoramentoController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */