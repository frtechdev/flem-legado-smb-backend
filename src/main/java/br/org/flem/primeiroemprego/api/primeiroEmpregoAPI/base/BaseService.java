/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.time.LocalDateTime;
/*    */ import java.util.List;
/*    */ import org.springframework.data.repository.CrudRepository;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class BaseService<T extends BaseModel<I>, I extends Serializable>
/*    */   extends AbstractHelper
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -1469703224182593320L;
/*    */   private final CrudRepository<T, I> dao;
/*    */   
/*    */   public BaseService(CrudRepository<T, I> dao) {
/* 23 */     this.dao = dao;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public T findById(I id) {
/* 32 */     return (T)this.dao.findOne(id);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Iterable<T> findAll() {
/* 40 */     return this.dao.findAll();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public T salvar(T t) {
/* 49 */     preSave(t);
/* 50 */     return (T)this.dao.save(t);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public T atualizar(T t) {
/* 58 */     preUpdate(t);
/* 59 */     return (T)this.dao.save(t);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void excluir(T t) {
/* 67 */     this.dao.delete(t);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void excluir(List<T> objects) {
/* 74 */     objects.forEach(this::excluir);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void preSave(T obj) {
/* 82 */     String login = getCurrentUser();
/* 83 */     obj.setDataCriacao(LocalDateTime.now());
/* 84 */     obj.setUsuarioCriacao(login);
/* 85 */     obj.setDataAtualizacao(LocalDateTime.now());
/* 86 */     obj.setUsuarioAtualizacao(login);
/*    */   }
/*    */   
/*    */   private void preUpdate(T obj) {
/* 90 */     String login = getCurrentUser();
/* 91 */     obj.setDataAtualizacao(LocalDateTime.now());
/* 92 */     obj.setUsuarioAtualizacao(login);
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\base\BaseService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */