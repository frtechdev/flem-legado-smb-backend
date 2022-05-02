/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.AbstractHelper;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseEntityAudited;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.ParameterDAO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Parameter;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class ParameterService
/*    */   extends AbstractHelper
/*    */ {
/*    */   @Autowired
/*    */   private ParameterDAO dao;
/*    */   
/*    */   public Parameter save(Parameter object) {
/* 25 */     preSave((BaseEntityAudited)object);
/* 26 */     return (Parameter)this.dao.save(object);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Parameter remover(Parameter object) {
/* 36 */     object.setExcluido(Boolean.TRUE);
/* 37 */     return update(object);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Parameter update(Parameter object) {
/* 47 */     preUpdate((BaseEntityAudited)object);
/* 48 */     return (Parameter)this.dao.save(object);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Iterable<Parameter> getList() {
/* 56 */     return this.dao.findAll();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Parameter findById(String id) {
/* 66 */     return (Parameter)this.dao.findOne(id);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void deletar(String id) {
/* 74 */     Parameter old = (Parameter)this.dao.findOne(id);
/* 75 */     if (old != null)
/* 76 */       remover(old); 
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\ParameterService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */