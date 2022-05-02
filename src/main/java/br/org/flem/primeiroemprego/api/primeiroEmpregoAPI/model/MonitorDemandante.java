/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseEntityAudited;
/*    */ import com.fasterxml.jackson.annotation.JsonIdentityInfo;
/*    */ import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name = "monitordemandante")
/*    */ @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
/*    */ public class MonitorDemandante
/*    */   extends BaseEntityAudited<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 4783353764287782078L;
/*    */   @Id
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   @Column(name = "id")
/*    */   private Long id;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_demandante")
/*    */   private Demandante demandante;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_colaborador")
/*    */   private Colaborador monitor;
/*    */   @ManyToOne
/*    */   @JoinColumn(name = "id_municipio")
/*    */   private Municipio municipio;
/*    */   
/*    */   public Long getId() {
/* 48 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 52 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Demandante getDemandante() {
/* 56 */     return this.demandante;
/*    */   }
/*    */   
/*    */   public void setDemandante(Demandante demandante) {
/* 60 */     this.demandante = demandante;
/*    */   }
/*    */   
/*    */   public Colaborador getMonitor() {
/* 64 */     return this.monitor;
/*    */   }
/*    */   
/*    */   public void setMonitor(Colaborador monitor) {
/* 68 */     this.monitor = monitor;
/*    */   }
/*    */   
/*    */   public Municipio getMunicipio() {
/* 72 */     return this.municipio;
/*    */   }
/*    */   
/*    */   public void setMunicipio(Municipio municipio) {
/* 76 */     this.municipio = municipio;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\MonitorDemandante.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */