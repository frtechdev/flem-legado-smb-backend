/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.TipoResposta;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.serializer.BooleanSerializer;
/*    */ import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
/*    */ 
/*    */ public class PerguntaDTO
/*    */   extends BaseDTO
/*    */ {
/*    */   private static final long serialVersionUID = -285741379863008384L;
/*    */   private Long id;
/*    */   private String descricao;
/*    */   @JsonSerialize(using = BooleanSerializer.class)
/*    */   private boolean obrigatoria = true;
/*    */   private int ordem;
/*    */   private TipoResposta tipoResposta;
/*    */   private List<RespostaDTO> respostas;
/*    */   
/*    */   public PerguntaDTO() {}
/*    */   
/*    */   public PerguntaDTO(Long id, String descricao) {
/* 36 */     this.id = id;
/* 37 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public Long getId() {
/* 41 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 45 */     this.id = id;
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
/*    */   public boolean isObrigatoria() {
/* 57 */     return this.obrigatoria;
/*    */   }
/*    */   
/*    */   public void setObrigatoria(boolean obrigatoria) {
/* 61 */     this.obrigatoria = obrigatoria;
/*    */   }
/*    */   
/*    */   public int getOrdem() {
/* 65 */     return this.ordem;
/*    */   }
/*    */   
/*    */   public void setOrdem(int ordem) {
/* 69 */     this.ordem = ordem;
/*    */   }
/*    */   
/*    */   public TipoResposta getTipoResposta() {
/* 73 */     return this.tipoResposta;
/*    */   }
/*    */   
/*    */   public void setTipoResposta(TipoResposta tipoResposta) {
/* 77 */     this.tipoResposta = tipoResposta;
/*    */   }
/*    */   
/*    */   public List<RespostaDTO> getRespostas() {
/* 81 */     return this.respostas;
/*    */   }
/*    */   
/*    */   public void setRespostas(List<RespostaDTO> respostas) {
/* 85 */     this.respostas = respostas;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\PerguntaDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */