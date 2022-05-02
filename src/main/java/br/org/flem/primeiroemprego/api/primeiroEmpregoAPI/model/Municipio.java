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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
/*     */ @Immutable
/*     */ public class Municipio
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -1717045913460420413L;
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*     */   @Column(name = "id_municipio")
/*     */   private Long id;
/*     */   private String nome;
/*     */   private String uf;
/*     */   @JsonIgnore
/*     */   @OneToMany(mappedBy = "municipio")
/*  51 */   private Set<Vaga> vagas = new HashSet<>(0);
/*     */ 
/*     */   
/*     */   @JsonIgnore
/*     */   @ManyToOne
/*     */   @JoinColumn(name = "ID_ESC_REGIONAL")
/*     */   private EscritorioRegional escritorioRegional;
/*     */   
/*     */   @JsonIgnore
/*     */   @OneToMany(mappedBy = "municipio")
/*     */   private Set<MonitorDemandante> associacoes;
/*     */ 
/*     */   
/*     */   public Long getId() {
/*  65 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  69 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getNome() {
/*  73 */     return this.nome;
/*     */   }
/*     */   
/*     */   public void setNome(String nome) {
/*  77 */     this.nome = nome;
/*     */   }
/*     */   
/*     */   public String getUf() {
/*  81 */     return this.uf;
/*     */   }
/*     */   
/*     */   public void setUf(String uf) {
/*  85 */     this.uf = uf;
/*     */   }
/*     */   
/*     */   public EscritorioRegional getEscritorioRegional() {
/*  89 */     return this.escritorioRegional;
/*     */   }
/*     */   
/*     */   public void setEscritorioRegional(EscritorioRegional escritorioRegional) {
/*  93 */     this.escritorioRegional = escritorioRegional;
/*     */   }
/*     */   
/*     */   public Set<MonitorDemandante> getAssociacoes() {
/*  97 */     return this.associacoes;
/*     */   }
/*     */   
/*     */   public void setAssociacoes(Set<MonitorDemandante> associacoes) {
/* 101 */     this.associacoes = associacoes;
/*     */   }
/*     */   
/*     */   public Set<Vaga> getVagas() {
/* 105 */     return this.vagas;
/*     */   }
/*     */   
/*     */   public void setVagas(Set<Vaga> vagas) {
/* 109 */     this.vagas = vagas;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 114 */     int hash = 7;
/* 115 */     hash = 37 * hash + Objects.hashCode(this.id);
/* 116 */     return hash;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 121 */     if (this == obj) {
/* 122 */       return true;
/*     */     }
/* 124 */     if (obj == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (getClass() != obj.getClass()) {
/* 128 */       return false;
/*     */     }
/* 130 */     Municipio other = (Municipio)obj;
/* 131 */     if (!Objects.equals(this.id, other.id)) {
/* 132 */       return false;
/*     */     }
/* 134 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\Municipio.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */