/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseEntityAudited;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.StatusVisitaEnum;
/*     */ import com.fasterxml.jackson.annotation.JsonIdentityInfo;
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
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
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
/*     */ @Table(name = "Visita_Beneficiario")
/*     */ public class VisitaBeneficiario
/*     */   extends BaseEntityAudited<Long>
/*     */ {
/*     */   private static final long serialVersionUID = -253823680815632042L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Column(name = "id")
/*     */   private Long id;
/*     */   @JsonIgnore
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "id_egresso")
/*     */   private Beneficiario egresso;
/*     */   @JsonIgnore
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "id_colaborador")
/*     */   private Colaborador colaborador;
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   @Column(name = "data_visita")
/*     */   private Date dataVisita;
/*     */   @Enumerated(EnumType.STRING)
/*     */   private StatusVisitaEnum status;
/*     */   
/*     */   public VisitaBeneficiario(StatusVisitaEnum status) {
/*  71 */     this.status = status;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VisitaBeneficiario() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getId() {
/*  81 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  85 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Beneficiario getEgresso() {
/*  89 */     return this.egresso;
/*     */   }
/*     */   
/*     */   public void setEgresso(Beneficiario egresso) {
/*  93 */     this.egresso = egresso;
/*     */   }
/*     */   
/*     */   public Colaborador getColaborador() {
/*  97 */     return this.colaborador;
/*     */   }
/*     */   
/*     */   public void setColaborador(Colaborador colaborador) {
/* 101 */     this.colaborador = colaborador;
/*     */   }
/*     */   
/*     */   public Date getDataVisita() {
/* 105 */     return this.dataVisita;
/*     */   }
/*     */   
/*     */   public void setDataVisita(Date dataVisita) {
/* 109 */     this.dataVisita = dataVisita;
/*     */   }
/*     */   
/*     */   public StatusVisitaEnum getStatus() {
/* 113 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(StatusVisitaEnum status) {
/* 117 */     this.status = status;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\VisitaBeneficiario.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */