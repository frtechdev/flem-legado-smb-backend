/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseEntityAudited;
/*     */ import java.io.Serializable;
/*     */ import java.time.LocalDate;
/*     */ import java.time.LocalDateTime;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @AuditOverrides({@AuditOverride(forClass = RegistroMonitoramento.class), @AuditOverride(forClass = BaseEntityAudited.class)})
/*     */ @Entity
/*     */ @Table(name = "registro_monitoramento")
/*     */ public class RegistroMonitoramento
/*     */   extends BaseEntityAudited<Long>
/*     */ {
/*     */   private static final long serialVersionUID = 3068291955695856753L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @ManyToOne
/*     */   @NotNull
/*     */   @JoinColumn(name = "ID_BENEFICIARIO")
/*     */   @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
/*     */   private Beneficiario beneficiario;
/*     */   @NotNull
/*     */   private LocalDateTime dataMonitoramento;
/*     */   @ManyToOne
/*     */   @NotNull
/*     */   @JoinColumn(name = "ID_MONITOR_ASSOCIADO")
/*     */   @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
/*     */   private Colaborador monitorAssociado;
/*     */   @ManyToOne
/*     */   @NotNull
/*     */   @JoinColumn(name = "ID_MONITOR")
/*     */   @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
/*     */   private Colaborador monitor;
/*     */   private LocalDate dataProxMonitoramento;
/*     */   @Column(columnDefinition = "TEXT")
/*     */   private String observacao;
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "ID_META")
/*     */   @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
/*     */   private Meta meta;
/*     */   private String links;
/*     */   @Column(columnDefinition = "TEXT")
/*     */   private String principaisRegistros;
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "ID_COMPROVACAO")
/*     */   @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
/*     */   private Comprovacao comprovacao;
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "ID_MUNICIPIO")
/*     */   @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
/*     */   private Municipio municipio;
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "ID_DEMANDANTE")
/*     */   @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
/*     */   private Demandante demandante;
/*     */   private String unidadeLotacao;
/*  90 */   private Boolean presente = Boolean.TRUE;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "ID_AGENDAMENTO")
/*     */   @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
/*     */   private Agendamento agendamento;
/*     */ 
/*     */   
/*     */   public Long getId() {
/*  99 */     return this.id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setId(Long id) {
/* 104 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Beneficiario getBeneficiario() {
/* 108 */     return this.beneficiario;
/*     */   }
/*     */   
/*     */   public void setBeneficiario(Beneficiario beneficiario) {
/* 112 */     this.beneficiario = beneficiario;
/*     */   }
/*     */   
/*     */   public LocalDateTime getDataMonitoramento() {
/* 116 */     return this.dataMonitoramento;
/*     */   }
/*     */   
/*     */   public void setDataMonitoramento(LocalDateTime dataMonitoramento) {
/* 120 */     this.dataMonitoramento = dataMonitoramento;
/*     */   }
/*     */   
/*     */   public String getObservacao() {
/* 124 */     return this.observacao;
/*     */   }
/*     */   
/*     */   public void setObservacao(String observacao) {
/* 128 */     this.observacao = observacao;
/*     */   }
/*     */   
/*     */   public Colaborador getMonitorAssociado() {
/* 132 */     return this.monitorAssociado;
/*     */   }
/*     */   
/*     */   public void setMonitorAssociado(Colaborador monitorAssociado) {
/* 136 */     this.monitorAssociado = monitorAssociado;
/*     */   }
/*     */   
/*     */   public Colaborador getMonitor() {
/* 140 */     return this.monitor;
/*     */   }
/*     */   
/*     */   public void setMonitor(Colaborador monitor) {
/* 144 */     this.monitor = monitor;
/*     */   }
/*     */   
/*     */   public LocalDate getDataProxMonitoramento() {
/* 148 */     return this.dataProxMonitoramento;
/*     */   }
/*     */   
/*     */   public void setDataProxMonitoramento(LocalDate dataProxMonitoramento) {
/* 152 */     this.dataProxMonitoramento = dataProxMonitoramento;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLinks() {
/* 164 */     return this.links;
/*     */   }
/*     */   
/*     */   public void setLinks(String links) {
/* 168 */     this.links = links;
/*     */   }
/*     */   
/*     */   public String getPrincipaisRegistros() {
/* 172 */     return this.principaisRegistros;
/*     */   }
/*     */   
/*     */   public void setPrincipaisRegistros(String principaisRegistros) {
/* 176 */     this.principaisRegistros = principaisRegistros;
/*     */   }
/*     */   
/*     */   public Comprovacao getComprovacao() {
/* 180 */     return this.comprovacao;
/*     */   }
/*     */   
/*     */   public void setComprovacao(Comprovacao comprovacao) {
/* 184 */     this.comprovacao = comprovacao;
/*     */   }
/*     */   
/*     */   public Municipio getMunicipio() {
/* 188 */     return this.municipio;
/*     */   }
/*     */   
/*     */   public void setMunicipio(Municipio municipio) {
/* 192 */     this.municipio = municipio;
/*     */   }
/*     */   
/*     */   public Demandante getDemandante() {
/* 196 */     return this.demandante;
/*     */   }
/*     */   
/*     */   public void setDemandante(Demandante demandante) {
/* 200 */     this.demandante = demandante;
/*     */   }
/*     */   
/*     */   public String getUnidadeLotacao() {
/* 204 */     return this.unidadeLotacao;
/*     */   }
/*     */   
/*     */   public void setUnidadeLotacao(String unidadeLotacao) {
/* 208 */     this.unidadeLotacao = unidadeLotacao;
/*     */   }
/*     */   
/*     */   public Boolean getPresente() {
/* 212 */     return this.presente;
/*     */   }
/*     */   
/*     */   public void setPresente(Boolean presente) {
/* 216 */     this.presente = presente;
/*     */   }
/*     */   
/*     */   public Agendamento getAgendamento() {
/* 220 */     return this.agendamento;
/*     */   }
/*     */   
/*     */   public void setAgendamento(Agendamento agendamento) {
/* 224 */     this.agendamento = agendamento;
/*     */   }
/*     */   
/*     */   public Meta getMeta() {
/* 228 */     return this.meta;
/*     */   }
/*     */   
/*     */   public void setMeta(Meta meta) {
/* 232 */     this.meta = meta;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\RegistroMonitoramento.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */