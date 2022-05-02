/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonIdentityInfo;
/*    */ import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.OneToMany;
/*    */ import javax.persistence.Table;
/*    */ import org.hibernate.annotations.Immutable;
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
/*    */ @Table(name = "escritorioregional")
/*    */ @Immutable
/*    */ @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
/*    */ public class EscritorioRegional
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 7969448961025439185L;
/*    */   @Id
/*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    */   @Column(name = "id_esc_regional")
/*    */   private Long id;
/*    */   private String nome;
/*    */   private Boolean ativo;
/*    */   @OneToMany(mappedBy = "escritorioRegional")
/*    */   private List<Colaborador> colaboradores;
/*    */   
/*    */   public Long getId() {
/* 42 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Long id) {
/* 46 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 50 */     return this.nome;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 54 */     this.nome = nome;
/*    */   }
/*    */   
/*    */   public Boolean getAtivo() {
/* 58 */     return this.ativo;
/*    */   }
/*    */   
/*    */   public void setAtivo(Boolean ativo) {
/* 62 */     this.ativo = ativo;
/*    */   }
/*    */   
/*    */   public List<Colaborador> getColaboradores() {
/* 66 */     return this.colaboradores;
/*    */   }
/*    */   
/*    */   public void setColaboradores(List<Colaborador> colaboradores) {
/* 70 */     this.colaboradores = colaboradores;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\model\EscritorioRegional.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */