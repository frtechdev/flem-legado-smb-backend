/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseModel;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseService;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.RespostaDAO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RespostaDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.OpcaoResposta;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Pergunta;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Resposta;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.util.SMBUtil;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
/*     */ import org.modelmapper.ModelMapper;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.data.repository.CrudRepository;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.util.StringUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class RespostaService
/*     */   extends BaseService<Resposta, Long>
/*     */ {
/*     */   private static final long serialVersionUID = 8405968871122425671L;
/*     */   private final RespostaDAO dao;
/*     */   @Autowired
/*     */   private OpcaoRespostaService opcaoRespostaService;
/*     */   @Autowired
/*     */   private ModelMapper modelMapper;
/*     */   
/*     */   @Autowired
/*     */   public RespostaService(RespostaDAO dao) {
/*  48 */     super((CrudRepository)dao);
/*  49 */     this.dao = dao;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Resposta salvar(RespostaDTO dto) {
/*  58 */     Resposta pergunta = new Resposta();
/*  59 */     verificarCamposObrigatorios(dto);
/*  60 */     pergunta.setDescricao(dto.getDescricao().trim().toUpperCase());
/*  61 */     isExists(pergunta);
/*  62 */     return super.salvar(pergunta);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Resposta atualizar(RespostaDTO dto) {
/*  71 */     Resposta pergunta = (Resposta)findById(dto.getId());
/*  72 */     verificarCamposObrigatorios(dto);
/*  73 */     pergunta.setDescricao(dto.getDescricao().trim().toUpperCase());
/*  74 */     isExists(pergunta);
/*  75 */     return super.atualizar(pergunta);
/*     */   }
/*     */   
/*     */   public void delete(Long id) {
/*  79 */     Resposta resposta = (Resposta)findById(id);
/*  80 */     SMBUtil.throwException((resposta == null), "Registro não localizado");
/*  81 */     SMBUtil.throwException(isUsed(resposta), "Registro em uso não pode ser excluido!");
/*  82 */     super.excluir(resposta);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void isExists(Resposta pergunta) {
/*  91 */     verificarDescricaoJaCadastrada(pergunta);
/*     */   }
/*     */   
/*     */   private void verificarCamposObrigatorios(RespostaDTO dto) {
/*  95 */     SMBUtil.throwException(StringUtils.isEmpty(dto.getDescricao().trim()), "Descrição é obrigatório");
/*     */   }
/*     */   
/*     */   private void verificarDescricaoJaCadastrada(Resposta pergunta) {
/*  99 */     Resposta question = findByDescricao(pergunta.getDescricao());
/*     */     
/* 101 */     boolean condition = ((pergunta.getId() == null && question != null) || (question != null && question.getId().compareTo(pergunta.getId()) != 0));
/* 102 */     SMBUtil.throwException(condition, "Já existe uma Resposta Cadastrada com esta Descrição");
/*     */   }
/*     */   
/*     */   private Resposta findByDescricao(String descricao) {
/* 106 */     return this.dao.findByDescricao(descricao);
/*     */   }
/*     */   
/*     */   public List<RespostaDTO> findByPergunta(Pergunta pergunta) {
/* 110 */     List<OpcaoResposta> opcoes = this.opcaoRespostaService.findByPergunta(pergunta);
/* 111 */     return (List<RespostaDTO>)opcoes.stream().map(item -> toDto(item.getId().getResposta()))
/*     */       
/* 113 */       .collect(Collectors.toList());
/*     */   }
/*     */   
/*     */   private boolean isUsed(Resposta resposta) {
/* 117 */     List<OpcaoResposta> opcoes = this.opcaoRespostaService.findByIdResposta(resposta);
/* 118 */     return !opcoes.isEmpty();
/*     */   }
/*     */   
/*     */   public RespostaDTO toDto(Resposta resposta) {
/* 122 */     if (resposta == null)
/* 123 */       return null; 
/* 124 */     return (RespostaDTO)this.modelMapper.map(resposta, RespostaDTO.class);
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\RespostaService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */