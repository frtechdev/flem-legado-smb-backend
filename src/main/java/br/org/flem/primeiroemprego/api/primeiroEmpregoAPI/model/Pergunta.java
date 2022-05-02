/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseModel;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.TipoResposta;
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.EnumType;
/*    */ import javax.persistence.Enumerated;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ import org.hibernate.envers.AuditOverride;
/*    */ import org.hibernate.envers.AuditOverrides;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @AuditOverrides({@AuditOverride(forClass = Pergunta.class), @AuditOverride(forClass = BaseModel.class)})
/*    */ @Entity
/*    */ @Table(name = "perguntas")
/*    */ public class Pergunta
/*    */   extends BaseModel<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 1375689861963794082L;
/*    */   @Id
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   private Long id;
/*    */   private String descricao;
/*    */   private boolean obrigatoria = true;
/*    */   private int ordem;
/*    */   @Enumerated(EnumType.STRING)
/*    */   private TipoResposta tipoResposta;
/*    */   
/*    */   public Long getId() {
/* 39 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 43 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getDescricao() {
/* 47 */     return this.descricao;
/*    */   }
/*    */   
/*    */   public void setDescricao(String descricao) {
/* 51 */     this.descricao = descricao;
/*    */   }
/*    */   
/*    */   public boolean isObrigatoria() {
/* 55 */     return this.obrigatoria;
/*    */   }
/*    */   
/*    */   public void setObrigatoria(boolean obrigatoria) {
/* 59 */     this.obrigatoria = obrigatoria;
/*    */   }
/*    */   
/*    */   public int getOrdem() {
/* 63 */     return this.ordem;
/*    */   }
/*    */   
/*    */   public void setOrdem(int ordem) {
/* 67 */     this.ordem = ordem;
/*    */   }
/*    */   
/*    */   public TipoResposta getTipoResposta() {
/* 71 */     return this.tipoResposta;
/*    */   }
/*    */   
/*    */   public void setTipoResposta(TipoResposta tipoResposta) {
/* 75 */     this.tipoResposta = tipoResposta;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\Pergunta.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */