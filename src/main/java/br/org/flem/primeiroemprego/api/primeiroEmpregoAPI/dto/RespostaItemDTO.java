/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RespostaItemDTO
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -8653329921588125783L;
/*    */   private Long idRegistroMonitoramento;
/*    */   private List<PerguntaDTO> perguntas;
/*    */   
/*    */   public Long getIdRegistroMonitoramento() {
/* 17 */     return this.idRegistroMonitoramento;
/*    */   }
/*    */   public void setIdRegistroMonitoramento(Long idRegistroMonitoramento) {
/* 20 */     this.idRegistroMonitoramento = idRegistroMonitoramento;
/*    */   }
/*    */   public List<PerguntaDTO> getPerguntas() {
/* 23 */     return this.perguntas;
/*    */   }
/*    */   public void setPerguntas(List<PerguntaDTO> perguntas) {
/* 26 */     this.perguntas = perguntas;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\RespostaItemDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */