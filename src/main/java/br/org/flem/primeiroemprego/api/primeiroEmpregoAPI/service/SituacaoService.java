/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.SituacaoDAO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Situacao;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class SituacaoService
/*    */ {
/*    */   @Autowired
/*    */   private SituacaoDAO dao;
/*    */   
/*    */   public Iterable<Situacao> findAll() {
/* 20 */     return this.dao.findAll();
/*    */   }
/*    */   
/*    */   public List<Situacao> findByCategoriaValueIn(List<Long> values) {
/* 24 */     return this.dao.findByCategoriaValueIn(values);
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\SituacaoService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */