/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum RespostaTecnica
/*    */ {
/* 14 */   BOA("BOA", "Boa"),
/* 15 */   REGULAR("REGULAR", "Regular"),
/* 16 */   RUIM("RUIM", "Ruim");
/*    */   
/*    */   private String descricao;
/*    */   private String codigo;
/*    */   
/*    */   RespostaTecnica(String codigo, String descricao) {
/* 22 */     this.descricao = descricao;
/* 23 */     this.codigo = codigo;
/*    */   }
/*    */   
/*    */   public static RespostaTecnica get(String codigoOuDescricao) {
/* 27 */     if (StringUtils.isBlank(codigoOuDescricao)) {
/* 28 */       throw new MonitoramentoException("Todas as Impressões da Equipe Técnica devem ser informadas!");
/*    */     }
/* 30 */     if (codigoOuDescricao.equalsIgnoreCase("Boa"))
/* 31 */       return BOA; 
/* 32 */     if (codigoOuDescricao.equalsIgnoreCase("Regular"))
/* 33 */       return REGULAR; 
/* 34 */     if (codigoOuDescricao.equalsIgnoreCase("Ruim")) {
/* 35 */       return RUIM;
/*    */     }
/* 37 */     throw new MonitoramentoException("Impressões da Equipe Técnica");
/*    */   }
/*    */   
/*    */   public static Map<String, String> getRespostaTecnica() {
/* 41 */     Map<String, String> respostas = new HashMap<>();
/* 42 */     respostas.put("BOA", "Boa");
/* 43 */     respostas.put("REGULAR", "Regular");
/* 44 */     respostas.put("RUIM", "Ruim");
/* 45 */     return respostas;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 49 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 53 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public String getCodigo() {
/* 57 */     return this.codigo;
/*    */   }
/*    */   
/*    */   public void setCodigo(String codigo) {
/* 61 */     this.codigo = codigo;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\enums\RespostaTecnica.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */