/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.AbstractHelper;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.AvaliacaoMonitoramento;
/*     */ import br.org.flem.util.helper.DateUtil;
/*     */ import java.io.IOException;
/*     */ import java.text.Normalizer;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.core.io.ByteArrayResource;
/*     */ import org.springframework.core.io.Resource;
/*     */ import org.springframework.http.HttpEntity;
/*     */ import org.springframework.http.HttpHeaders;
/*     */ import org.springframework.http.HttpMethod;
/*     */ import org.springframework.http.MediaType;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.util.LinkedMultiValueMap;
/*     */ import org.springframework.util.MultiValueMap;
/*     */ import org.springframework.web.client.RestClientException;
/*     */ import org.springframework.web.client.RestTemplate;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class FileStorageService
/*     */   extends AbstractHelper
/*     */ {
/*     */   private static final long serialVersionUID = 5674604313288537990L;
/*     */   @Autowired
/*     */   private RestTemplate restTemplate;
/*     */   @Value("${upload.path.avaliacoes}")
/*     */   private String pathAvaliacao;
/*     */   @Value("${upload.path.comprovacoes}")
/*     */   private String pathComprovacoes;
/*     */   @Value("${upload.path.monitores}")
/*     */   private String pathMonitores;
/*     */   @Value("${file.server.url}")
/*     */   private String fileServerURL;
/*     */   private static final String SIGNATURE = "assinatura.png";
/*     */   @Autowired
/*     */   private AvaliacaoMonitoramentoService avaliacaoService;
/*     */   
/*     */   public String storeAvaliacao(String path, MultipartFile file) {
/*     */     try {
/*  66 */       String[] array = file.getOriginalFilename().split("_");
/*  67 */       Long idEvaluation = Long.valueOf(Long.parseLong(array[0]));
/*  68 */       AvaliacaoMonitoramento avaliacao = this.avaliacaoService.findById(idEvaluation);
/*  69 */       String fileName = this.pathAvaliacao + path + "/";
/*  70 */       if (avaliacao != null) {
/*  71 */         String[] arrayFileName = file.getOriginalFilename().split("\\.");
/*  72 */         fileName = fileName + Normalizer.normalize(avaliacao.getNome(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "") + "." + arrayFileName[arrayFileName.length - 1];
/*     */       } 
/*  74 */       return store(fileName, file);
/*  75 */     } catch (MonitoramentoException|IOException ex) {
/*  76 */       Logger.getLogger(FileStorageService.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */       
/*  78 */       throw new MonitoramentoException("Erro ao anexar arquivo");
/*     */     } 
/*     */   }
/*     */   public String storeComprovacao(MultipartFile file) {
/*     */     try {
/*  83 */       String fileName = this.pathComprovacoes + DateUtil.formatarData(LocalDateTime.now(), "ddMMyyyy_HHmmss") + "/" + Normalizer.normalize(file.getOriginalFilename(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
/*  84 */       return store(fileName, file);
/*  85 */     } catch (IOException ex) {
/*  86 */       Logger.getLogger(FileStorageService.class.getName()).log(Level.SEVERE, (String)null, ex);
/*  87 */       throw new MonitoramentoException(ex.getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String store(String pathFileName, MultipartFile file) throws IOException {
/* 100 */     verificarInconsistencia(pathFileName, file);
/*     */     
/* 102 */     HttpHeaders headers = new HttpHeaders();
/* 103 */     headers.setContentType(MediaType.MULTIPART_FORM_DATA);
/*     */     
/* 105 */     LinkedMultiValueMap linkedMultiValueMap = new LinkedMultiValueMap();
/* 106 */     linkedMultiValueMap.add("file", getFileResource(file));
/*     */     
/* 108 */     HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity(linkedMultiValueMap, (MultiValueMap)headers);
/*     */     
/* 110 */     return post(pathFileName, requestEntity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void verificarInconsistencia(String path, MultipartFile file) {
/* 119 */     if (file.isEmpty()) {
/* 120 */       throw new MonitoramentoException("Arquivo não anexado");
/*     */     }
/* 122 */     if (StringUtils.isBlank(path)) {
/* 123 */       throw new MonitoramentoException("Você deve informar um caminho para salvar o arquivo!");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String post(String filePath, HttpEntity<MultiValueMap<String, Object>> requestEntity) {
/* 135 */     String serverUrl = this.fileServerURL + filePath;
/*     */     try {
/* 137 */       ResponseEntity<String> response = this.restTemplate.exchange(serverUrl, HttpMethod.POST, requestEntity, String.class, new Object[0]);
/* 138 */       return (String)response.getBody();
/* 139 */     } catch (RestClientException ex) {
/* 140 */       Logger.getLogger(FileStorageService.class.getName()).log(Level.SEVERE, serverUrl, (Throwable)ex);
/* 141 */       throw new MonitoramentoException(ex.getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Resource getFileResource(final MultipartFile filePart) throws IOException {
/* 153 */     return (Resource)new ByteArrayResource(filePart.getBytes())
/*     */       {
/*     */         public String getFilename()
/*     */         {
/* 157 */           return filePart.getOriginalFilename();
/*     */         }
/*     */ 
/*     */         
/*     */         public long contentLength() {
/* 162 */           return filePart.getSize();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Resource loadFile(String url) {
/* 174 */     HttpHeaders headers = new HttpHeaders();
/* 175 */     headers.set("Accept", "application/json");
/* 176 */     String serverUrl = this.fileServerURL + url;
/* 177 */     HttpEntity<?> entity = new HttpEntity((MultiValueMap)headers);
/*     */     try {
/* 179 */       ResponseEntity<Resource> response = this.restTemplate.exchange(serverUrl, HttpMethod.GET, entity, Resource.class, new Object[0]);
/* 180 */       return (Resource)response.getBody();
/* 181 */     } catch (RestClientException ex) {
/* 182 */       Logger.getLogger(FileStorageService.class.getName()).log(Level.SEVERE, serverUrl, (Throwable)ex);
/* 183 */       throw new MonitoramentoException(ex.getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Resource loadSignature(Long idMonitor) {
/* 193 */     return loadFile(this.pathMonitores.concat(idMonitor.toString()).concat("/").concat("assinatura.png"));
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\FileStorageService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */