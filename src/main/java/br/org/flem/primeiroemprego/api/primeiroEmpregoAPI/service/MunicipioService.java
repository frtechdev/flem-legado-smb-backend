/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.MunicipioDAO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.EscritorioRegional;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.MunicipioProj;
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
/*    */ public class MunicipioService
/*    */ {
/*    */   @Autowired
/*    */   private MunicipioDAO dao;
/*    */   @Autowired
/*    */   private EscritorioRegionalService escritorioRegionalService;
/*    */   
/*    */   public List<MunicipioProj> findByEscritorioRegional(EscritorioRegional escritorio) {
/* 25 */     return this.dao.findByEscritorioRegional(escritorio);
/*    */   }
/*    */   
/*    */   public List<MunicipioProj> findByEscritorioRegional(Long idEscritorio) {
/* 29 */     EscritorioRegional escritorio = this.escritorioRegionalService.findById(idEscritorio);
/* 30 */     return findByEscritorioRegional(escritorio);
/*    */   }
/*    */   
/*    */   public List<Municipio> findByIdIn(List<Long> ids) {
/* 34 */     return this.dao.findByIdIn(ids);
/*    */   }
/*    */   
/*    */   public Municipio findById(Long id) {
/* 38 */     return (Municipio)this.dao.findOne(id);
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\MunicipioService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */