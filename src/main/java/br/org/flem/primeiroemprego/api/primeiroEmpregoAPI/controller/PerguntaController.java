/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseController;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseModel;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseService;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.PerguntaDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RespostaDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.TipoResposta;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Pergunta;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.PerguntaService;
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.http.HttpStatus;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.web.bind.annotation.DeleteMapping;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.PutMapping;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ @RequestMapping({"/perguntas"})
/*     */ public class PerguntaController
/*     */   extends BaseController<Pergunta, Long, PerguntaDTO>
/*     */ {
/*     */   private final PerguntaService service;
/*     */   
/*     */   @Autowired
/*     */   public PerguntaController(PerguntaService service) {
/*  45 */     super((BaseService)service, PerguntaDTO.class);
/*  46 */     this.service = service;
/*     */   }
/*     */ 
/*     */   
/*     */   @PutMapping
/*     */   public ResponseEntity<PerguntaDTO> update(@RequestBody PerguntaDTO dto) {
/*  52 */     return (ResponseEntity<PerguntaDTO>)Optional.<BaseDTO>ofNullable(toDto((BaseModel)this.service.atualizar(dto))).map(obj -> new ResponseEntity(obj, HttpStatus.OK))
/*  53 */       .orElseThrow(() -> new MonitoramentoException("Erro salvar pergunta"));
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping
/*     */   public ResponseEntity<PerguntaDTO> create(@RequestBody PerguntaDTO dto) {
/*     */     try {
/*  60 */       return (ResponseEntity<PerguntaDTO>)Optional.<BaseDTO>ofNullable(toDto((BaseModel)this.service.salvar(dto))).map(obj -> new ResponseEntity(obj, HttpStatus.OK))
/*  61 */         .orElseThrow(() -> new MonitoramentoException("Erro salvar pergunta"));
/*  62 */     } catch (MonitoramentoException ex) {
/*  63 */       throw new MonitoramentoException(ex.getMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/{id}"})
/*     */   protected ResponseEntity<PerguntaDTO> get(@PathVariable Long id) {
/*  70 */     return Optional.<PerguntaDTO>ofNullable(this.service.obterPerguntaPorId(id)).map(obj -> new ResponseEntity(obj, HttpStatus.OK))
/*  71 */       .orElse(ResponseEntity.notFound().build());
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping
/*     */   protected ResponseEntity<List<PerguntaDTO>> list() {
/*  77 */     return Optional.<List>ofNullable(this.service.obterPerguntasComRespostas())
/*  78 */       .map(obj -> new ResponseEntity(obj, HttpStatus.OK))
/*  79 */       .orElse(ResponseEntity.notFound().build());
/*     */   }
/*     */ 
/*     */   
/*     */   @DeleteMapping({"/{id}"})
/*     */   public ResponseEntity<PerguntaDTO> delete(@PathVariable("id") Long id) {
/*     */     try {
/*  86 */       this.service.delete(id);
/*  87 */       return ResponseEntity.ok().build();
/*  88 */     } catch (MonitoramentoException ex) {
/*  89 */       throw new MonitoramentoException(ex.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   @GetMapping({"/tiposDeRespostas"})
/*     */   public ResponseEntity<Map<TipoResposta, String>> tiposDeRespostas() {
/*  95 */     return new ResponseEntity(TipoResposta.getValues(), HttpStatus.OK);
/*     */   }
/*     */   
/*     */   @GetMapping({"/{id}/respostas"})
/*     */   public ResponseEntity<List<RespostaDTO>> getRespostas(@PathVariable Long id) {
/* 100 */     return Optional.<List>ofNullable(this.service.obterRespostas(id)).map(obj -> new ResponseEntity(obj, HttpStatus.OK))
/* 101 */       .orElse(ResponseEntity.notFound().build());
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\controller\PerguntaController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */