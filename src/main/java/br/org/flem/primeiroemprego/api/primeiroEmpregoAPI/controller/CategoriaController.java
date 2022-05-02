/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Categoria;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.CategoriaService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.http.ResponseEntity;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
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
/*    */ @RestController
/*    */ @RequestMapping({"/categoria"})
/*    */ public class CategoriaController
/*    */ {
/*    */   @Autowired
/*    */   private CategoriaService service;
/*    */   
/*    */   @GetMapping
/*    */   public ResponseEntity<List<Categoria>> findCategoria() {
/* 34 */     return new ResponseEntity(this.service.findAll(), HttpStatus.OK);
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\controller\CategoriaController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */