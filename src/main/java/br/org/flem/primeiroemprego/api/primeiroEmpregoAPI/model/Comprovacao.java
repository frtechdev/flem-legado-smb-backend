/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseEntityAudited;
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import org.hibernate.envers.AuditOverride;
/*    */ import org.hibernate.envers.AuditOverrides;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @AuditOverrides({@AuditOverride(forClass = Comprovacao.class), @AuditOverride(forClass = BaseEntityAudited.class)})
/*    */ @Entity
/*    */ public class Comprovacao
/*    */   extends BaseEntityAudited<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -7654906507524425816L;
/*    */   @Id
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Long id;
/*    */   private String filePath;
/*    */   private String fileName;
/*    */   private Long fileSize;
/*    */   private String contentType;
/*    */   private String tipoComprovacao;
/*    */   
/*    */   public Long getId() {
/* 36 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 40 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getFilePath() {
/* 44 */     return this.filePath;
/*    */   }
/*    */   
/*    */   public void setFilePath(String filePath) {
/* 48 */     this.filePath = filePath;
/*    */   }
/*    */   
/*    */   public String getFileName() {
/* 52 */     return this.fileName;
/*    */   }
/*    */   
/*    */   public void setFileName(String fileName) {
/* 56 */     this.fileName = fileName;
/*    */   }
/*    */   
/*    */   public Long getFileSize() {
/* 60 */     return this.fileSize;
/*    */   }
/*    */   
/*    */   public void setFileSize(Long fileSize) {
/* 64 */     this.fileSize = fileSize;
/*    */   }
/*    */   
/*    */   public String getContentType() {
/* 68 */     return this.contentType;
/*    */   }
/*    */   
/*    */   public void setContentType(String contentType) {
/* 72 */     this.contentType = contentType;
/*    */   }
/*    */   
/*    */   public String getTipoComprovacao() {
/* 76 */     return this.tipoComprovacao;
/*    */   }
/*    */   
/*    */   public void setTipoComprovacao(String tipoComprovacao) {
/* 80 */     this.tipoComprovacao = tipoComprovacao;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\Comprovacao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */