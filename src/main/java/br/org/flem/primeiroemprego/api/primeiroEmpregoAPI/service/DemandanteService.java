/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.DemandanteDAO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Demandante;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.DemandanteMunicipioProj;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class DemandanteService
/*    */ {
/*    */   @Autowired
/*    */   private DemandanteDAO dao;
/*    */   @Autowired
/*    */   private VagaService vagaService;
/*    */   
/*    */   public Demandante findById(Long id) {
/* 24 */     return (Demandante)this.dao.findOne(id);
/*    */   }
/*    */   
/*    */   public List<Demandante> findByIdIn(List<Long> id) {
/* 28 */     return this.dao.findByIdIn(id);
/*    */   }
/*    */   
/*    */   public List<DemandanteMunicipioProj> findByVagaMunicipioNaoAssociados(List<Municipio> municipios) {
/* 32 */     return this.vagaService.findByVagaMunicipioNaoAssociados(municipios);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<DemandanteMunicipioProj> findByMunicipios(List<Municipio> municipios) {
/* 40 */     return this.vagaService.findByVagaMunicipio(municipios);
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\DemandanteService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */