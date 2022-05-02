/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import java.io.InputStream;
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
/*    */ public class ComprovacaoRelDTO
/*    */ {
/*    */   private InputStream listaPresenca;
/*    */   
/*    */   public ComprovacaoRelDTO() {}
/*    */   
/*    */   public ComprovacaoRelDTO(InputStream listaPresenca) {
/* 21 */     this.listaPresenca = listaPresenca;
/*    */   }
/*    */   public InputStream getListaPresenca() {
/* 24 */     return this.listaPresenca;
/*    */   }
/*    */   
/*    */   public void setListaPresenca(InputStream listaPresenca) {
/* 28 */     this.listaPresenca = listaPresenca;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\ComprovacaoRelDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */