/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseEntityAudited;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.StatusAgendaEnum;
/*     */ import java.io.Serializable;
/*     */ import java.time.LocalDate;
/*     */ import java.time.LocalDateTime;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.EnumType;
/*     */ import javax.persistence.Enumerated;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.hibernate.envers.AuditOverride;
/*     */ import org.hibernate.envers.AuditOverrides;
/*     */ import org.hibernate.envers.Audited;
/*     */ import org.hibernate.envers.RelationTargetAuditMode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @AuditOverrides({@AuditOverride(forClass = Agendamento.class), @AuditOverride(forClass = BaseEntityAudited.class)})
/*     */ @Entity
/*     */ @Table(name = "agendamentos")
/*     */ public class Agendamento
/*     */   extends BaseEntityAudited<Long>
/*     */ {
/*     */   private static final long serialVersionUID = 3216362690233193216L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @ManyToOne
/*     */   @NotNull
/*     */   @JoinColumn(name = "ID_BENEFICIARIO")
/*     */   @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
/*     */   private Beneficiario beneficiario;
/*     */   @ManyToOne
/*     */   @NotNull
/*     */   @JoinColumn(name = "ID_PERIODO")
/*     */   @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
/*     */   private Periodo periodo;
/*     */   @Column(columnDefinition = "TEXT")
/*     */   private String observacao;
/*     */   @Enumerated(EnumType.STRING)
/*  57 */   private StatusAgendaEnum status = StatusAgendaEnum.AGENDADA;
/*     */   
/*     */   private LocalDate dataInicial;
/*     */   
/*     */   private LocalDate dataFinal;
/*     */   
/*     */   private LocalDateTime dataRegistro;
/*     */   
/*     */   public Long getId() {
/*  66 */     return this.id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setId(Long id) {
/*  71 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Beneficiario getBeneficiario() {
/*  75 */     return this.beneficiario;
/*     */   }
/*     */   
/*     */   public void setBeneficiario(Beneficiario beneficiario) {
/*  79 */     this.beneficiario = beneficiario;
/*     */   }
/*     */   
/*     */   public Periodo getPeriodo() {
/*  83 */     return this.periodo;
/*     */   }
/*     */   
/*     */   public void setPeriodo(Periodo periodo) {
/*  87 */     this.periodo = periodo;
/*     */   }
/*     */   
/*     */   public String getObservacao() {
/*  91 */     return this.observacao;
/*     */   }
/*     */   
/*     */   public void setObservacao(String observacao) {
/*  95 */     this.observacao = observacao;
/*     */   }
/*     */   
/*     */   public StatusAgendaEnum getStatus() {
/*  99 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(StatusAgendaEnum status) {
/* 103 */     this.status = status;
/*     */   }
/*     */   
/*     */   public LocalDate getDataInicial() {
/* 107 */     return this.dataInicial;
/*     */   }
/*     */   
/*     */   public void setDataInicial(LocalDate dataInicial) {
/* 111 */     this.dataInicial = dataInicial;
/*     */   }
/*     */   
/*     */   public LocalDate getDataFinal() {
/* 115 */     return this.dataFinal;
/*     */   }
/*     */   
/*     */   public void setDataFinal(LocalDate dataFinal) {
/* 119 */     this.dataFinal = dataFinal;
/*     */   }
/*     */   
/*     */   public LocalDateTime getDataRegistro() {
/* 123 */     return this.dataRegistro;
/*     */   }
/*     */   
/*     */   public void setDataRegistro(LocalDateTime dataRegistro) {
/* 127 */     this.dataRegistro = dataRegistro;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\Agendamento.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */