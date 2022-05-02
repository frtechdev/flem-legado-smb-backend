/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseModel;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseService;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.OpcaoRespostaDAO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.OpcaoResposta;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.OpcaoRespostaId;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Pergunta;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Resposta;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.util.SMBUtil;
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.repository.CrudRepository;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class OpcaoRespostaService
/*     */   extends BaseService<OpcaoResposta, OpcaoRespostaId>
/*     */ {
/*     */   private static final long serialVersionUID = 8405968871122425671L;
/*     */   private final OpcaoRespostaDAO dao;
/*     */   @Autowired
/*     */   private PerguntaService perguntaService;
/*     */   @Autowired
/*     */   private RespostaService respostaService;
/*     */   
/*     */   @Autowired
/*     */   public OpcaoRespostaService(OpcaoRespostaDAO dao) {
/*  41 */     super((CrudRepository)dao);
/*  42 */     this.dao = dao;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */public OpcaoResposta salvar(Pergunta pergunta, Resposta resposta) {
/*     */	OpcaoResposta opcao = findById(new OpcaoRespostaId(pergunta, resposta));
/*     */	if( opcao != null )
/*     */		return opcao;
/*     */	opcao = new OpcaoResposta(pergunta, resposta);
/*     */	return super.salvar(opcao);
/*     */}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OpcaoResposta salvar(Long idPergunta, Long idResposta) {
/*  66 */     Pergunta pergunta = (Pergunta)this.perguntaService.findById(idPergunta);
/*  67 */     Resposta resposta = (Resposta)this.respostaService.findById(idResposta);
/*  68 */     return salvar(pergunta, resposta);
/*     */   }
/*     */   
/*     */   public OpcaoResposta findById(Long idPergunta, Long idResposta) {
/*  72 */     Pergunta pergunta = (Pergunta)this.perguntaService.findById(idPergunta);
/*  73 */     Resposta resposta = (Resposta)this.respostaService.findById(idResposta);
/*  74 */     return findById(pergunta, resposta);
/*     */   }
/*     */   
/*     */   public OpcaoResposta findById(Pergunta pergunta, Resposta resposta) {
/*  78 */     return (OpcaoResposta)findById(new OpcaoRespostaId(pergunta, resposta));
/*     */   }
/*     */   
/*     */   public void delete(OpcaoRespostaId id) {
/*  82 */     OpcaoResposta opcao = (OpcaoResposta)findById(id);
/*  83 */     SMBUtil.throwException((opcao == null), "Registro não localizado");
/*  84 */     excluir(opcao);
/*     */   }
/*     */   
/*     */   public void delete(Pergunta pergunta, Resposta resposta) {
/*  88 */     delete(new OpcaoRespostaId(pergunta, resposta));
/*     */   }
/*     */   
/*     */   public void delete(Long idPergunta, Long idResposta) {
/*  92 */     Pergunta pergunta = (Pergunta)this.perguntaService.findById(idPergunta);
/*  93 */     Resposta resposta = (Resposta)this.respostaService.findById(idResposta);
/*  94 */     SMBUtil.throwException((pergunta == null || resposta == null), "Registro não localizado");
/*  95 */     delete(pergunta, resposta);
/*     */   }
/*     */   
/*     */   public List<OpcaoResposta> findByPergunta(Pergunta pergunta) {
/*  99 */     return this.dao.findByIdPergunta(pergunta);
/*     */   }
/*     */   
/*     */   public List<OpcaoResposta> findByIdResposta(Resposta resposta) {
/* 103 */     return this.dao.findByIdResposta(resposta);
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\OpcaoRespostaService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */