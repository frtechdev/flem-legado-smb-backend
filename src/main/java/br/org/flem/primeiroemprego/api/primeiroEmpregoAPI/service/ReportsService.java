/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RelatorioMonitoramentoDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.ParameterEnum;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*     */ import br.org.flem.util.helper.ReportUtil;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import net.sf.jasperreports.engine.JRException;
/*     */ import net.sf.jasperreports.engine.JRPrintElement;
/*     */ import net.sf.jasperreports.engine.JRPrintPage;
/*     */ import net.sf.jasperreports.engine.JRPrintText;
/*     */ import net.sf.jasperreports.engine.JasperPrint;
/*     */ import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.core.io.Resource;
/*     */ import org.springframework.stereotype.Service;
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
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class ReportsService
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1303135654084541509L;
/*     */   private static final String REPORT_PATH = "br/org/flem/primeiroemprego/api/reports/";
/*     */   @Autowired
/*     */   private ParameterService parameterService;
/*     */   @Autowired
/*     */   private FileStorageService fileStorageService;
/*     */   @Autowired
/*     */   private RegistroMonitoramentoService registroMonitoramentoService;
/*     */   
/*     */   public byte[] generatePDF(Map<String, Object> parameters, String pathReport, Collection<?> collections) throws JRException {
/*  59 */     JasperPrint print = getJasperPrint(parameters, pathReport, collections);
/*  60 */     return exportReportToPdf(print);
/*     */   }
/*     */   
/*     */   public byte[] generatePDF(Map<String, Object> parameters, String pathReport, JRBeanCollectionDataSource dataSource) throws JRException {
/*  64 */     JasperPrint print = getJasperPrint(parameters, pathReport, dataSource);
/*  65 */     return exportReportToPdf(print);
/*     */   }
/*     */   
/*     */   public byte[] exportReportToPdf(JasperPrint print) throws JRException {
/*  69 */     return ReportUtil.exportReportToPdf(print);
/*     */   }
/*     */   
/*     */   public JasperPrint getJasperPrint(Map<String, Object> parameters, String pathReport, Collection<?> collections) {
/*  73 */     return ReportUtil.getJasperPrint(parameters, "br/org/flem/primeiroemprego/api/reports/" + pathReport, collections);
/*     */   }
/*     */   
/*     */   public JasperPrint getJasperPrint(Map<String, Object> parameters, String pathReport, JRBeanCollectionDataSource dataSource) {
/*  77 */     return ReportUtil.getJasperPrint(parameters, "br/org/flem/primeiroemprego/api/reports/" + pathReport, dataSource);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] printRegistroMonitoramento(Long idMonitoramento) throws JRException, IOException {
/*  87 */     RelatorioMonitoramentoDTO dto = this.registroMonitoramentoService.obterRegistroPorId(idMonitoramento);
/*  88 */     dto.setAssinatura(loadSignature(dto.getIdMonitor()));
/*     */     
/*  90 */     List<RelatorioMonitoramentoDTO> lista = new ArrayList<>();
/*  91 */     lista.add(dto);
/*  92 */     JasperPrint printOne = getJasperPrint(getParametros(), "registroMonitoramento.jasper", lista);
/*  93 */     int currentPage = 1;
/*  94 */     int totPageNumber = printOne.getPages().size();
/*  95 */     for (JRPrintPage jp : printOne.getPages()) {
/*  96 */       List<JRPrintElement> elements = jp.getElements();
/*  97 */       for (JRPrintElement jpe : elements) {
/*  98 */         if (jpe instanceof JRPrintText) {
/*  99 */           JRPrintText jpt = (JRPrintText)jpe;
/* 100 */           if ("${CURRENT_PAGE_NUMBER}".equals(jpt.getValue())) {
/* 101 */             jpt.setText("Página " + currentPage + " de");
/*     */             continue;
/*     */           } 
/* 104 */           if ("${TOTAL_PAGE_NUMBER}".equals(jpt.getValue())) {
/* 105 */             jpt.setText(" " + totPageNumber);
/*     */           }
/*     */         } 
/*     */       } 
/* 109 */       currentPage++;
/*     */     } 
/* 111 */     return exportReportToPdf(printOne);
/*     */   }
/*     */   
/*     */   private Map<String, Object> getParametros() throws IOException {
/* 115 */     Map<String, Object> parametros = new HashMap<>();
/* 116 */     if (!parametros.containsKey("LOGO_FLEM")) {
/* 117 */       Resource logoFlem = this.fileStorageService.loadFile(this.parameterService.findById(ParameterEnum.LOGO_FLEM_HORIZONTAL.getChave()).getValor());
/* 118 */       parametros.put("LOGO_FLEM", logoFlem.getInputStream());
/*     */     } 
/* 120 */     if (!parametros.containsKey("LOGO_GOV")) {
/* 121 */       Resource logoGov = this.fileStorageService.loadFile(this.parameterService.findById(ParameterEnum.PP_GOV_2019.getChave()).getValor());
/* 122 */       parametros.put("LOGO_GOV", logoGov.getInputStream());
/*     */     } 
/* 124 */     return parametros;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream loadSignature(Long idMonitor) {
/* 133 */     Resource res = this.fileStorageService.loadSignature(idMonitor);
/* 134 */     if (res != null) {
/* 135 */       try (InputStream inputStream = res.getInputStream()) {
/* 136 */         return inputStream;
/* 137 */       } catch (MonitoramentoException|IOException ex) {
/* 138 */         Logger.getLogger(ReportsService.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */       } 
/*     */     }
/* 141 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\ReportsService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */