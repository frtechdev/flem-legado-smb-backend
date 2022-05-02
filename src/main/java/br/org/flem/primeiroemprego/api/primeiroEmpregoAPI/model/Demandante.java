/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIdentityInfo;
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/*     */ import java.io.Serializable;
/*     */ import java.util.HashSet;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
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
/*     */ @Entity
/*     */ @Immutable
/*     */ @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
/*     */ public class Demandante
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -7947298317014935032L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Column(name = "id_demandante")
/*     */   private Long id;
/*     */   private String sigla;
/*     */   private String nome;
/*     */   @OneToMany(mappedBy = "demandante")
/*     */   @JsonIgnore
/*     */   private Set<MonitorDemandante> associacoes;
/*     */   @OneToMany(mappedBy = "demandante")
/*     */   @JsonIgnore
/*  47 */   private Set<Vaga> vagas = new HashSet<>(0);
/*     */ 
/*     */ 
/*     */   
/*     */   public Demandante(Long id, String nome) {
/*  52 */     this.id = id;
/*  53 */     this.nome = nome;
/*     */   }
/*     */ 
/*     */   
/*     */   public Demandante() {}
/*     */ 
/*     */   
/*     */   public Long getId() {
/*  61 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  65 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getSigla() {
/*  69 */     return this.sigla;
/*     */   }
/*     */   
/*     */   public void setSigla(String sigla) {
/*  73 */     this.sigla = sigla;
/*     */   }
/*     */   
/*     */   public String getNome() {
/*  77 */     return this.nome;
/*     */   }
/*     */   
/*     */   public void setNome(String nome) {
/*  81 */     this.nome = nome;
/*     */   }
/*     */   
/*     */   public Set<MonitorDemandante> getAssociacoes() {
/*  85 */     return this.associacoes;
/*     */   }
/*     */   
/*     */   public void setAssociacoes(Set<MonitorDemandante> associacoes) {
/*  89 */     this.associacoes = associacoes;
/*     */   }
/*     */   
/*     */   public Set<Vaga> getVagas() {
/*  93 */     return this.vagas;
/*     */   }
/*     */   
/*     */   public void setVagas(Set<Vaga> vagas) {
/*  97 */     this.vagas = vagas;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 102 */     int hash = 5;
/* 103 */     hash = 13 * hash + Objects.hashCode(this.id);
/* 104 */     return hash;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 109 */     if (this == obj) {
/* 110 */       return true;
/*     */     }
/* 112 */     if (obj == null) {
/* 113 */       return false;
/*     */     }
/* 115 */     if (getClass() != obj.getClass()) {
/* 116 */       return false;
/*     */     }
/* 118 */     Demandante other = (Demandante)obj;
/* 119 */     if (!Objects.equals(this.id, other.id)) {
/* 120 */       return false;
/*     */     }
/* 122 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\Demandante.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */