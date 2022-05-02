/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.StatusAgendaEnum;
/*    */ import java.time.LocalDate;
/*    */ import java.time.LocalDateTime;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AgendamentoDTO
/*    */   extends BaseDTO
/*    */ {
/*    */   private Long id;
/*    */   private Long idBeneficiario;
/*    */   private Long idPeriodo;
/*    */   private String observacao;
/*    */   private StatusAgendaEnum status;
/*    */   private LocalDate dataInicial;
/*    */   private LocalDate dataFinal;
/*    */   private LocalDateTime dataRegistro;
/*    */   
/*    */   public Long getId() {
/* 25 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 29 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Long getIdBeneficiario() {
/* 33 */     return this.idBeneficiario;
/*    */   }
/*    */   
/*    */   public void setIdBeneficiario(Long idBeneficiario) {
/* 37 */     this.idBeneficiario = idBeneficiario;
/*    */   }
/*    */   
/*    */   public Long getIdPeriodo() {
/* 41 */     return this.idPeriodo;
/*    */   }
/*    */   
/*    */   public void setIdPeriodo(Long idPeriodo) {
/* 45 */     this.idPeriodo = idPeriodo;
/*    */   }
/*    */   
/*    */   public String getObservacao() {
/* 49 */     return this.observacao;
/*    */   }
/*    */   
/*    */   public void setObservacao(String observacao) {
/* 53 */     this.observacao = observacao;
/*    */   }
/*    */   
/*    */   public StatusAgendaEnum getStatus() {
/* 57 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(StatusAgendaEnum status) {
/* 61 */     this.status = status;
/*    */   }
/*    */   
/*    */   public LocalDate getDataInicial() {
/* 65 */     return this.dataInicial;
/*    */   }
/*    */   
/*    */   public void setDataInicial(LocalDate dataInicial) {
/* 69 */     this.dataInicial = dataInicial;
/*    */   }
/*    */   
/*    */   public LocalDate getDataFinal() {
/* 73 */     return this.dataFinal;
/*    */   }
/*    */   
/*    */   public void setDataFinal(LocalDate dataFinal) {
/* 77 */     this.dataFinal = dataFinal;
/*    */   }
/*    */   
/*    */   public LocalDateTime getDataRegistro() {
/* 81 */     return this.dataRegistro;
/*    */   }
/*    */   
/*    */   public void setDataRegistro(LocalDateTime dataRegistro) {
/* 85 */     this.dataRegistro = dataRegistro;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 90 */     return "AgendamentoDTO{id=" + this.id + ", idBeneficiario=" + this.idBeneficiario + ", idPeriodo=" + this.idPeriodo + ", observacao=" + this.observacao + ", status=" + this.status + ", dataInicial=" + this.dataInicial + ", dataFinal=" + this.dataFinal + ", dataRegistro=" + this.dataRegistro + '}';
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\AgendamentoDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */