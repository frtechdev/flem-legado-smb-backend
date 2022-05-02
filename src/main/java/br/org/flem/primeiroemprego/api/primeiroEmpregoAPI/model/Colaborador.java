/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIdentityInfo;
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/*     */ import java.io.Serializable;
/*     */ import java.util.Set;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToMany;
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
/*     */ @Entity
/*     */ @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
/*     */ @Immutable
/*     */ public class Colaborador
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 5991683242756044212L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Column(name = "id_colaborador")
/*     */   private Long id;
/*     */   private String nome;
/*     */   private String cargo;
/*     */   private Long celular;
/*     */   private Long telefone;
/*  45 */   private Boolean ativo = Boolean.TRUE;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "ID_ESC_REGIONAL")
/*     */   @JsonIgnore
/*     */   private EscritorioRegional escritorioRegional;
/*     */   
/*     */   private String email;
/*     */   
/*     */   @OneToMany(mappedBy = "monitor")
/*     */   private Set<MonitorDemandante> associacoes;
/*     */   
/*     */   @OneToMany(mappedBy = "monitor")
/*     */   private Set<RegistroMonitoramento> registros;
/*     */   
/*     */   @OneToMany(mappedBy = "monitorAssociado")
/*     */   private Set<RegistroMonitoramento> registrosNaoAssociados;
/*     */   
/*     */   public Long getId() {
/*  64 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  68 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getNome() {
/*  72 */     return this.nome;
/*     */   }
/*     */   
/*     */   public void setNome(String nome) {
/*  76 */     this.nome = nome;
/*     */   }
/*     */   
/*     */   public String getCargo() {
/*  80 */     return this.cargo;
/*     */   }
/*     */   
/*     */   public void setCargo(String cargo) {
/*  84 */     this.cargo = cargo;
/*     */   }
/*     */   
/*     */   public Long getCelular() {
/*  88 */     return this.celular;
/*     */   }
/*     */   
/*     */   public void setCelular(Long celular) {
/*  92 */     this.celular = celular;
/*     */   }
/*     */   
/*     */   public Long getTelefone() {
/*  96 */     return this.telefone;
/*     */   }
/*     */   
/*     */   public void setTelefone(Long telefone) {
/* 100 */     this.telefone = telefone;
/*     */   }
/*     */   
/*     */   public Boolean getAtivo() {
/* 104 */     return this.ativo;
/*     */   }
/*     */   
/*     */   public void setAtivo(Boolean ativo) {
/* 108 */     this.ativo = ativo;
/*     */   }
/*     */   
/*     */   public EscritorioRegional getEscritorioRegional() {
/* 112 */     return this.escritorioRegional;
/*     */   }
/*     */   
/*     */   public void setEscritorioRegional(EscritorioRegional escritorioRegional) {
/* 116 */     this.escritorioRegional = escritorioRegional;
/*     */   }
/*     */   
/*     */   public String getEmail() {
/* 120 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/* 124 */     this.email = email;
/*     */   }
/*     */   
/*     */   public Set<MonitorDemandante> getAssociacoes() {
/* 128 */     return this.associacoes;
/*     */   }
/*     */   
/*     */   public void setAssociacoes(Set<MonitorDemandante> associacoes) {
/* 132 */     this.associacoes = associacoes;
/*     */   }
/*     */   
/*     */   public Set<RegistroMonitoramento> getRegistros() {
/* 136 */     return this.registros;
/*     */   }
/*     */   
/*     */   public void setRegistros(Set<RegistroMonitoramento> registros) {
/* 140 */     this.registros = registros;
/*     */   }
/*     */   
/*     */   public Set<RegistroMonitoramento> getRegistrosNaoAssociados() {
/* 144 */     return this.registrosNaoAssociados;
/*     */   }
/*     */   
/*     */   public void setRegistrosNaoAssociados(Set<RegistroMonitoramento> registrosNaoAssociados) {
/* 148 */     this.registrosNaoAssociados = registrosNaoAssociados;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\Colaborador.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */