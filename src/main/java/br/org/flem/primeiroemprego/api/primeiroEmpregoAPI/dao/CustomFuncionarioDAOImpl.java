/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.FuncionarioDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Colaborador;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Demandante;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.MonitorDemandante;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Vaga;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.persistence.EntityManager;
/*     */ import javax.persistence.PersistenceContext;
/*     */ import javax.persistence.criteria.CriteriaBuilder;
/*     */ import javax.persistence.criteria.CriteriaQuery;
/*     */ import javax.persistence.criteria.Expression;
/*     */ import javax.persistence.criteria.Order;
/*     */ import javax.persistence.criteria.Predicate;
/*     */ import javax.persistence.criteria.Root;
/*     */ import javax.persistence.criteria.Selection;
/*     */ import javax.persistence.criteria.Subquery;
/*     */ import org.springframework.stereotype.Repository;
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
/*     */ @Repository
/*     */ public class CustomFuncionarioDAOImpl
/*     */   implements CustomFuncionarioDAO
/*     */ {
/*     */   @PersistenceContext
/*     */   private EntityManager entityManager;
/*     */   
/*     */   public List<FuncionarioDTO> findVagasByUnidadeDeLotacaoInAndMunicipioInAndDemandanteIn(Long monitor, List<String> unidadeDeLotacao, List<Municipio> municipios, List<Demandante> demandantes) {
/*  46 */     CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
/*  47 */     CriteriaQuery<FuncionarioDTO> criteria = cb.createQuery(FuncionarioDTO.class);
/*  48 */     Subquery<MonitorDemandante> subCriteria = criteria.subquery(MonitorDemandante.class);
/*     */     
/*  50 */     Root<Vaga> vaga = criteria.from(Vaga.class);
/*     */     
/*  52 */     criteria.select((Selection)cb.construct(FuncionarioDTO.class, new Selection[] { (Selection)vaga
/*  53 */             .get("egresso").get("id"), (Selection)vaga
/*  54 */             .get("egresso").get("nome"), (Selection)vaga
/*  55 */             .get("egresso").get("formacao").get("nome"), (Selection)vaga
/*  56 */             .get("egresso").get("dataAdmissao"), (Selection)vaga
/*  57 */             .get("egresso").get("matriculaFlem"), (Selection)vaga
/*  58 */             .get("egresso").get("cpf"), (Selection)vaga
/*  59 */             .get("egresso").get("sexo"), (Selection)vaga
/*  60 */             .get("demandante").get("id"), (Selection)vaga
/*  61 */             .get("demandante").get("nome"), (Selection)vaga
/*  62 */             .get("demandante").get("sigla"), (Selection)vaga
/*  63 */             .get("municipio").get("id"), (Selection)vaga
/*  64 */             .get("municipio").get("nome"), (Selection)vaga
/*  65 */             .get("unidadeDeLotacao"), (Selection)vaga
/*  66 */             .get("situacao").get("nome"), (Selection)vaga
/*  67 */             .get("pontoFocalNaUnidade"), (Selection)vaga
/*  68 */             .get("emailPontoFocal") }));
/*     */     
/*  70 */     List<Predicate> predicates = new ArrayList<>();
/*  71 */     if (monitor != null) {
/*  72 */       Root<MonitorDemandante> demandanteVinculado = subCriteria.from(MonitorDemandante.class);
/*  73 */       subCriteria.select((Expression)demandanteVinculado)
/*  74 */         .where(new Predicate[] {
/*  75 */             cb.equal((Expression)demandanteVinculado.get("monitor"), monitor), cb
/*  76 */             .equal((Expression)demandanteVinculado.get("demandante"), (Expression)vaga.get("demandante")), cb
/*  77 */             .equal((Expression)demandanteVinculado.get("municipio"), (Expression)vaga.get("municipio"))
/*     */           });
/*  79 */       predicates.add(cb.exists(subCriteria));
/*     */     } 
/*     */     
/*  82 */     predicates.add(vaga.get("situacao").get("categoria").get("value").in(new Object[] { Long.valueOf(3L), Long.valueOf(6L) }));
/*  83 */     if (municipios != null && !municipios.isEmpty()) {
/*  84 */       predicates.add(vaga.get("municipio").in(municipios));
/*     */     }
/*  86 */     if (demandantes != null && !demandantes.isEmpty()) {
/*  87 */       predicates.add(vaga.get("demandante").in(demandantes));
/*     */     }
/*  89 */     if (unidadeDeLotacao != null && !unidadeDeLotacao.isEmpty()) {
/*  90 */       Expression<String> replacedValue = cb.function("replace", String.class, new Expression[] { (Expression)vaga
/*  91 */             .get("unidadeDeLotacao"), cb.literal("  "), cb
/*  92 */             .literal("") });
/*  93 */       List<String> unidades = new ArrayList<>();
/*  94 */       unidadeDeLotacao.forEach(item -> unidades.add(item.replace("'", "''").replace("  ", "")));
/*     */ 
/*     */       
/*  97 */       if (unidadeDeLotacao.size() == 1) {
/*  98 */         String[] likesIn = ((String)unidades.get(0)).split("'");
/*  99 */         if (likesIn.length > 1) {
/* 100 */           for (String str : likesIn) {
/* 101 */             predicates.add(cb.like(replacedValue, "%" + str + "%"));
/*     */           }
/*     */         } else {
/* 104 */           predicates.add(cb.like(replacedValue, "%" + (String)unidades.get(0) + "%"));
/*     */         } 
/*     */       } else {
/*     */         
/* 108 */         predicates.add(replacedValue.in(unidades));
/*     */       } 
/*     */     } 
/*     */     
/* 112 */     criteria.where(predicates.<Predicate>toArray(new Predicate[0]));
/* 113 */     criteria.orderBy(new Order[] { cb.asc((Expression)vaga.get("egresso").get("nome")) });
/* 114 */     return this.entityManager.createQuery(criteria).getResultList();
/*     */   }
/*     */ 
/*     */   
/*     */   public String value() {
/* 119 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<? extends Annotation> annotationType() {
/* 124 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   public List<FuncionarioDTO> obterFuncionariosVinculados(List<Colaborador> monitores, List<Municipio> municipios, List<Demandante> demandantes) {
/* 129 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dao\CustomFuncionarioDAOImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */