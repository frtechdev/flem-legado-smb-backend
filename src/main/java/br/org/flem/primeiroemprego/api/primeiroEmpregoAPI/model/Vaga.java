/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIdentityInfo;
/*     */ import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToOne;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import org.hibernate.annotations.Immutable;
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
/*     */ 
/*     */ @Entity
/*     */ @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
/*     */ @Immutable
/*     */ public class Vaga
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 3805212806634844073L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Column(name = "id_vaga")
/*     */   private Long id;
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "id_demandante")
/*     */   private Demandante demandante;
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "id_municipiodavaga")
/*     */   private Municipio municipio;
/*     */   @Column(name = "datainicioatividades")
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dataInicioAtividades;
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "id_situacao")
/*     */   private Situacao situacao;
/*     */   @OneToOne
/*     */   @JoinColumn(name = "id_egresso")
/*     */   private Beneficiario egresso;
/*     */   @Column(name = "unidadedelotacao")
/*     */   private String unidadeDeLotacao;
/*     */   @Column(name = "pontofocalnaunidade")
/*     */   private String pontoFocalNaUnidade;
/*     */   @Column(name = "emailpontofocal")
/*     */   private String emailPontoFocal;
/*     */   
/*     */   public Long getId() {
/*  76 */     return this.id;
/*     */   }
/*     */   public void setId(Long id) {
/*  79 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Demandante getDemandante() {
/*  83 */     return this.demandante;
/*     */   }
/*     */   
/*     */   public void setDemandante(Demandante demandante) {
/*  87 */     this.demandante = demandante;
/*     */   }
/*     */   
/*     */   public Municipio getMunicipio() {
/*  91 */     return this.municipio;
/*     */   }
/*     */   
/*     */   public void setMunicipio(Municipio municipio) {
/*  95 */     this.municipio = municipio;
/*     */   }
/*     */   
/*     */   public Date getDataInicioAtividades() {
/*  99 */     return this.dataInicioAtividades;
/*     */   }
/*     */   
/*     */   public void setDataInicioAtividades(Date dataInicioAtividades) {
/* 103 */     this.dataInicioAtividades = dataInicioAtividades;
/*     */   }
/*     */   
/*     */   public Situacao getSituacao() {
/* 107 */     return this.situacao;
/*     */   }
/*     */   
/*     */   public void setSituacao(Situacao situacao) {
/* 111 */     this.situacao = situacao;
/*     */   }
/*     */   
/*     */   public Beneficiario getEgresso() {
/* 115 */     return this.egresso;
/*     */   }
/*     */   
/*     */   public void setEgresso(Beneficiario egresso) {
/* 119 */     this.egresso = egresso;
/*     */   }
/*     */   
/*     */   public String getUnidadeDeLotacao() {
/* 123 */     return this.unidadeDeLotacao;
/*     */   }
/*     */   
/*     */   public void setUnidadeDeLotacao(String unidadeDeLotacao) {
/* 127 */     this.unidadeDeLotacao = unidadeDeLotacao;
/*     */   }
/*     */   
/*     */   public String getPontoFocalNaUnidade() {
/* 131 */     return this.pontoFocalNaUnidade;
/*     */   }
/*     */   
/*     */   public void setPontoFocalNaUnidade(String pontoFocalNaUnidade) {
/* 135 */     this.pontoFocalNaUnidade = pontoFocalNaUnidade;
/*     */   }
/*     */   
/*     */   public String getEmailPontoFocal() {
/* 139 */     return this.emailPontoFocal;
/*     */   }
/*     */   
/*     */   public void setEmailPontoFocal(String emailPontoFocal) {
/* 143 */     this.emailPontoFocal = emailPontoFocal;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\Vaga.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */