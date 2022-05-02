/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
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
/*    */ 
/*    */ public class RelPerguntaDTO
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -285741379863008384L;
/*    */   private Long id;
/*    */   private int ordem;
/*    */   private String descricao;
/*    */   private List<RelRespostaDTO> respostas;
/*    */   
/*    */   public static RelPerguntaDTO of(Long id, int ordem, String descricao, List<RelRespostaDTO> respostas) {
/* 27 */     RelPerguntaDTO dto = of(id, ordem, descricao);
/* 28 */     dto.setRespostas(respostas);
/* 29 */     return dto;
/*    */   }
/*    */   
/*    */   public static RelPerguntaDTO of(Long id, int ordem, String descricao) {
/* 33 */     RelPerguntaDTO dto = of(id, descricao);
/* 34 */     dto.setOrdem(ordem);
/* 35 */     return dto;
/*    */   }
/*    */   
/*    */   public static RelPerguntaDTO of(Long id, String descricao) {
/* 39 */     RelPerguntaDTO dto = new RelPerguntaDTO();
/* 40 */     dto.setDescricao(descricao);
/* 41 */     dto.setId(id);
/* 42 */     return dto;
/*    */   }
/*    */   
/*    */   public Long getId() {
/* 46 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 50 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 54 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 58 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public List<RelRespostaDTO> getRespostas() {
/* 62 */     return this.respostas;
/*    */   }
/*    */   
/*    */   public void setRespostas(List<RelRespostaDTO> respostas) {
/* 66 */     this.respostas = respostas;
/*    */   }
/*    */   
/*    */   public int getOrdem() {
/* 70 */     return this.ordem;
/*    */   }
/*    */   
/*    */   public void setOrdem(int ordem) {
/* 74 */     this.ordem = ordem;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\RelPerguntaDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */