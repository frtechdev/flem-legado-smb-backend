/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.convert;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.File;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CustomMultipartFile
/*    */   implements MultipartFile
/*    */ {
/*    */   private final byte[] fileContent;
/*    */   private String fileName;
/*    */   private String contentType;
/*    */   private File file;
/* 21 */   private String destPath = System.getProperty("java.io.tmpdir");
/*    */   
/*    */   private FileOutputStream fileOutputStream;
/*    */   
/*    */   public CustomMultipartFile(byte[] fileData, String name, String contentType) {
/* 26 */     this.fileContent = fileData;
/* 27 */     this.fileName = name;
/* 28 */     this.contentType = contentType;
/* 29 */     this.file = new File(this.destPath + this.fileName);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void transferTo(File dest) throws IOException, IllegalStateException {
/* 35 */     this.fileOutputStream = new FileOutputStream(dest);
/* 36 */     this.fileOutputStream.write(this.fileContent);
/*    */   }
/*    */   
/*    */   public void clearOutStreams() throws IOException {
/* 40 */     if (null != this.fileOutputStream) {
/* 41 */       this.fileOutputStream.flush();
/* 42 */       this.fileOutputStream.close();
/* 43 */       this.file.deleteOnExit();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public byte[] getBytes() throws IOException {
/* 49 */     return this.fileContent;
/*    */   }
/*    */ 
/*    */   
/*    */   public InputStream getInputStream() throws IOException {
/* 54 */     return new ByteArrayInputStream(this.fileContent);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 59 */     return this.fileName;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getOriginalFilename() {
/* 64 */     return this.fileName;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getContentType() {
/* 69 */     return this.contentType;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEmpty() {
/* 74 */     return (this.fileContent.length == 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public long getSize() {
/* 79 */     return this.fileContent.length;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\convert\CustomMultipartFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */