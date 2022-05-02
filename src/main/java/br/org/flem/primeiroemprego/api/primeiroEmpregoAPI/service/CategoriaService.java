/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.CategoriaDAO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Categoria;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class CategoriaService
/*    */ {
/*    */   @Autowired
/*    */   private CategoriaDAO dao;
/*    */   
/*    */   public Iterable<Categoria> findAll() {
/* 20 */     return this.dao.findAll();
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\CategoriaService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */