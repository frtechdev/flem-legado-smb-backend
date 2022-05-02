/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.report;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/*    */ 
/*    */ 
/*    */ public class QuestionarioReportInput
/*    */ {
/*    */   private JRBeanCollectionDataSource questionarioDataSource;
/*    */   private InputStream logoFlem;
/*    */   private InputStream logoGov;
/*    */   private String subReport;
/*    */   
/*    */   public Map<String, Object> getParameters() {
/* 17 */     Map<String, Object> parameters = new HashMap<>();
/* 18 */     parameters.put("REPORT_TITLE", "Monitoramento");
/* 19 */     parameters.put("LOGO_FLEM", this.logoFlem);
/* 20 */     parameters.put("LOGO_GOV", this.logoGov);
/* 21 */     parameters.put("SUBREPORT_DIR", this.subReport);
/* 22 */     return parameters;
/*    */   }
/*    */   
/*    */   public JRBeanCollectionDataSource getQuestionarioDataSource() {
/* 26 */     return this.questionarioDataSource;
/*    */   }
/*    */   
/*    */   public void setQuestionarioDataSource(JRBeanCollectionDataSource questionarioDataSource) {
/* 30 */     this.questionarioDataSource = questionarioDataSource;
/*    */   }
/*    */   
/*    */   public InputStream getLogoFlem() {
/* 34 */     return this.logoFlem;
/*    */   }
/*    */   
/*    */   public void setLogoFlem(InputStream logoFlem) {
/* 38 */     this.logoFlem = logoFlem;
/*    */   }
/*    */   
/*    */   public InputStream getLogoGov() {
/* 42 */     return this.logoGov;
/*    */   }
/*    */   
/*    */   public void setLogoGov(InputStream logoGov) {
/* 46 */     this.logoGov = logoGov;
/*    */   }
/*    */   
/*    */   public String getSubReport() {
/* 50 */     return this.subReport;
/*    */   }
/*    */   
/*    */   public void setSubReport(String subReport) {
/* 54 */     this.subReport = subReport;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\report\QuestionarioReportInput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */