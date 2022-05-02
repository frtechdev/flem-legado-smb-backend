/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.EscritorioRegionalDAO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.EscritorioRegional;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.EscritorioRegionalProj;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class EscritorioRegionalService
/*    */ {
/*    */   @Autowired
/*    */   private EscritorioRegionalDAO dao;
/*    */   
/*    */   public List<EscritorioRegionalProj> findAllActive() {
/* 22 */     return this.dao.findByAtivoTrueOrderByNomeAsc();
/*    */   }
/*    */   
/*    */   public Iterable<EscritorioRegional> listarTodos() {
/* 26 */     return this.dao.findAll();
/*    */   }
/*    */   
/*    */   public EscritorioRegional findById(Long id) {
/* 30 */     return (EscritorioRegional)this.dao.findOne(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\EscritorioRegionalService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */