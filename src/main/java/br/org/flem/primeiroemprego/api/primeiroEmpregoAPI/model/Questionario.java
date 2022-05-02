/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseEntityAudited;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.RespostaTecnica;
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.EnumType;
/*     */ import javax.persistence.Enumerated;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.OneToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.validation.constraints.NotNull;
/*     */ import org.hibernate.envers.AuditOverride;
/*     */ import org.hibernate.envers.AuditOverrides;
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
/*     */ @AuditOverrides({@AuditOverride(forClass = Questionario.class), @AuditOverride(forClass = BaseEntityAudited.class)})
/*     */ @Entity
/*     */ @Table(name = "questionarios")
/*     */ public class Questionario
/*     */   extends BaseEntityAudited<Long>
/*     */ {
/*     */   private static final long serialVersionUID = 5451923595892412614L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   private Long id;
/*     */   @Column(columnDefinition = "TEXT")
/*     */   private String observacao;
/*     */   private String desvioDeFuncao;
/*     */   private String tipoDesvioDeFuncao;
/*     */   @Column(columnDefinition = "TEXT")
/*     */   private String descricaoDesvioDeFuncao;
/*     */   @OneToOne
/*     */   @NotNull
/*     */   @JoinColumn(name = "id_registro_monitoramento")
/*     */   private RegistroMonitoramento registroMonitoramento;
/*     */   @Enumerated(EnumType.STRING)
/*     */   private RespostaTecnica conhecimento;
/*     */   @Enumerated(EnumType.STRING)
/*     */   private RespostaTecnica habilidade;
/*     */   @Enumerated(EnumType.STRING)
/*     */   private RespostaTecnica autonomia;
/*     */   @Enumerated(EnumType.STRING)
/*     */   private RespostaTecnica pontualidade;
/*     */   @Enumerated(EnumType.STRING)
/*     */   private RespostaTecnica motivacao;
/*     */   @Enumerated(EnumType.STRING)
/*     */   private RespostaTecnica experienciaProfissional;
/*     */   private Boolean gravida;
/*  62 */   private Boolean acidenteDeTrabalho = Boolean.FALSE;
/*     */   
/*     */   @Column(columnDefinition = "TEXT")
/*     */   private String descricaoAcidenteDeTrabalho;
/*     */   
/*     */   public Long getId() {
/*  68 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  72 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getObservacao() {
/*  76 */     return this.observacao;
/*     */   }
/*     */   
/*     */   public void setObservacao(String observacao) {
/*  80 */     this.observacao = observacao;
/*     */   }
/*     */   
/*     */   public String getDesvioDeFuncao() {
/*  84 */     return this.desvioDeFuncao;
/*     */   }
/*     */   
/*     */   public void setDesvioDeFuncao(String desvioDeFuncao) {
/*  88 */     this.desvioDeFuncao = desvioDeFuncao;
/*     */   }
/*     */   
/*     */   public String getTipoDesvioDeFuncao() {
/*  92 */     return this.tipoDesvioDeFuncao;
/*     */   }
/*     */   
/*     */   public void setTipoDesvioDeFuncao(String tipoDesvioDeFuncao) {
/*  96 */     this.tipoDesvioDeFuncao = tipoDesvioDeFuncao;
/*     */   }
/*     */   
/*     */   public RegistroMonitoramento getRegistroMonitoramento() {
/* 100 */     return this.registroMonitoramento;
/*     */   }
/*     */   
/*     */   public void setRegistroMonitoramento(RegistroMonitoramento registroMonitoramento) {
/* 104 */     this.registroMonitoramento = registroMonitoramento;
/*     */   }
/*     */   
/*     */   public RespostaTecnica getConhecimento() {
/* 108 */     return this.conhecimento;
/*     */   }
/*     */   
/*     */   public void setConhecimento(RespostaTecnica conhecimento) {
/* 112 */     this.conhecimento = conhecimento;
/*     */   }
/*     */   
/*     */   public RespostaTecnica getHabilidade() {
/* 116 */     return this.habilidade;
/*     */   }
/*     */   
/*     */   public void setHabilidade(RespostaTecnica habilidade) {
/* 120 */     this.habilidade = habilidade;
/*     */   }
/*     */   
/*     */   public RespostaTecnica getAutonomia() {
/* 124 */     return this.autonomia;
/*     */   }
/*     */   
/*     */   public void setAutonomia(RespostaTecnica autonomia) {
/* 128 */     this.autonomia = autonomia;
/*     */   }
/*     */   
/*     */   public RespostaTecnica getPontualidade() {
/* 132 */     return this.pontualidade;
/*     */   }
/*     */   
/*     */   public void setPontualidade(RespostaTecnica pontualidade) {
/* 136 */     this.pontualidade = pontualidade;
/*     */   }
/*     */   
/*     */   public RespostaTecnica getMotivacao() {
/* 140 */     return this.motivacao;
/*     */   }
/*     */   
/*     */   public void setMotivacao(RespostaTecnica motivacao) {
/* 144 */     this.motivacao = motivacao;
/*     */   }
/*     */   
/*     */   public RespostaTecnica getExperienciaProfissional() {
/* 148 */     return this.experienciaProfissional;
/*     */   }
/*     */   
/*     */   public void setExperienciaProfissional(RespostaTecnica experienciaProfissional) {
/* 152 */     this.experienciaProfissional = experienciaProfissional;
/*     */   }
/*     */   
/*     */   public String getDescricaoDesvioDeFuncao() {
/* 156 */     return this.descricaoDesvioDeFuncao;
/*     */   }
/*     */   
/*     */   public void setDescricaoDesvioDeFuncao(String descricaoDesvioDeFuncao) {
/* 160 */     this.descricaoDesvioDeFuncao = descricaoDesvioDeFuncao;
/*     */   }
/*     */   
/*     */   public Boolean getGravida() {
/* 164 */     return this.gravida;
/*     */   }
/*     */   
/*     */   public void setGravida(Boolean gravida) {
/* 168 */     this.gravida = gravida;
/*     */   }
/*     */   
/*     */   public Boolean getAcidenteDeTrabalho() {
/* 172 */     return this.acidenteDeTrabalho;
/*     */   }
/*     */   
/*     */   public void setAcidenteDeTrabalho(Boolean acidenteDeTrabalho) {
/* 176 */     this.acidenteDeTrabalho = acidenteDeTrabalho;
/*     */   }
/*     */   
/*     */   public String getDescricaoAcidenteDeTrabalho() {
/* 180 */     return this.descricaoAcidenteDeTrabalho;
/*     */   }
/*     */   
/*     */   public void setDescricaoAcidenteDeTrabalho(String descricaoAcidenteDeTrabalho) {
/* 184 */     this.descricaoAcidenteDeTrabalho = descricaoAcidenteDeTrabalho;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\Questionario.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */