/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.persistence.criteria.CriteriaBuilder;
/*    */ import javax.persistence.criteria.CriteriaQuery;
/*    */ import javax.persistence.criteria.Expression;
/*    */ import javax.persistence.criteria.Path;
/*    */ import javax.persistence.criteria.Predicate;
/*    */ import javax.persistence.criteria.Root;
/*    */ import org.springframework.data.jpa.domain.Specification;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BaseSpecification<T extends BaseModel, I extends Serializable>
/*    */   implements Specification<T>
/*    */ {
/*    */   private final SearchCriteria criteria;
/*    */   
/*    */   public BaseSpecification(SearchCriteria criteria) {
/* 23 */     this.criteria = criteria;
/*    */   } public Predicate toPredicate(Root<T> root, CriteriaQuery<?> cq, CriteriaBuilder builder) {
/*    */     List<Object> lista;
/*    */     Path path;
/*    */     Predicate predicate;
/* 28 */     if (this.criteria.getValue() == null) {
/* 29 */       return null;
/*    */     }
/*    */     
/* 32 */     switch (this.criteria.getOperation()) {
/*    */       case GT:
/* 34 */         return builder.greaterThan((Expression)root.get(this.criteria.getKey()), (Comparable)this.criteria.getValue());
/*    */       case LT:
/* 36 */         return builder.lessThan((Expression)root.get(this.criteria.getKey()), (Comparable)this.criteria.getValue());
/*    */       case GE:
/* 38 */         return builder.greaterThanOrEqualTo((Expression)root.get(this.criteria.getKey()), (Comparable)this.criteria.getValue());
/*    */       case LE:
/* 40 */         return builder.lessThanOrEqualTo((Expression)root.get(this.criteria.getKey()), (Comparable)this.criteria.getValue());
/*    */       case NE:
/* 42 */         return builder.notEqual((Expression)root.get(this.criteria.getKey()), this.criteria.getValue());
/*    */       case LIKE:
/* 44 */         return builder.like((Expression)root.get(this.criteria.getKey()), "%" + this.criteria.getValue() + "%");
/*    */       case EQ:
/* 46 */         return builder.equal((Expression)root.get(this.criteria.getKey()), this.criteria.getValue());
/*    */       case IN:
/* 48 */         lista = (ArrayList)this.criteria.getValue();
/* 49 */         if (lista == null || lista.isEmpty())
/* 50 */           return null; 
/* 51 */         path = root.get(this.criteria.getKey());
/* 52 */         predicate = path.in(lista);
/*    */         
/* 54 */         return predicate;
/*    */     } 
/*    */ 
/*    */     
/* 58 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\base\BaseSpecification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */