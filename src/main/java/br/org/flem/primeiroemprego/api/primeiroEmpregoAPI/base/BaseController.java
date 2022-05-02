/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*    */ import com.google.common.collect.Lists;
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ import java.util.Optional;
/*    */ import java.util.stream.Collectors;
/*    */ import org.modelmapper.ModelMapper;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.DeleteMapping;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class BaseController<T extends BaseModel<I>, I extends Serializable, D extends BaseDTO>
/*    */ {
/*    */   protected static final String NOT_FOUND = "Registro não encontrado";
/*    */   private final BaseService<T, I> service;
/*    */   private Class<D> clazz;
/*    */   @Autowired
/*    */   private ModelMapper modelMapper;
/*    */   
/*    */   protected BaseController(BaseService<T, I> service, Class<D> clazz) {
/* 40 */     this.service = service;
/* 41 */     this.clazz = clazz;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"/{id}"})
/*    */   protected ResponseEntity<D> get(@PathVariable I id) {
/* 50 */     return Optional.<D>ofNullable(toDto((BaseModel<I>)this.service.findById(id)))
/* 51 */       .map(obj -> new ResponseEntity(obj, HttpStatus.OK))
/* 52 */       .orElse(ResponseEntity.notFound().build());
/*    */   }
/*    */ 
/*    */   
/*    */   @GetMapping
/*    */   protected ResponseEntity<List<D>> list() {
/*    */     try {
/* 59 */       List<T> obj = Lists.newArrayList(this.service.findAll());
/* 60 */       if (obj != null) {
/* 61 */         return ResponseEntity.ok().body(obj
/* 62 */             .stream()
/* 63 */             .map(this::toDto)
/* 64 */             .collect(Collectors.toList()));
/*    */       }
/*    */       
/* 67 */       return ResponseEntity.notFound().build();
/*    */     }
/* 69 */     catch (MonitoramentoException ex) {
/* 70 */       throw new MonitoramentoException(ex.getMessage());
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @DeleteMapping({"/{id}"})
/*    */   public ResponseEntity<D> delete(@PathVariable("id") I id) {
/* 77 */     T obj = this.service.findById(id);
/* 78 */     if (obj == null) {
/* 79 */       throw new MonitoramentoException("Registro não encontrado");
/*    */     }
/* 81 */     this.service.excluir(obj);
/* 82 */     return ResponseEntity.ok().build();
/*    */   }
/*    */   
/*    */   public D toDto(BaseModel<I> cargo) {
/* 86 */     if (cargo == null)
/* 87 */       return null; 
/* 88 */     return (D)this.modelMapper.map(cargo, this.clazz);
/*    */   }
/*    */   
/*    */   protected abstract ResponseEntity<D> create(D paramD);
/*    */   
/*    */   protected abstract ResponseEntity<D> update(D paramD);
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\base\BaseController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */