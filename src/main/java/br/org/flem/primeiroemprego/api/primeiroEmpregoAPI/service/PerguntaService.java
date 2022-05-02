/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseModel;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseService;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.PerguntaDAO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.PerguntaDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RespostaDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.OpcaoResposta;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Pergunta;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.util.SMBUtil;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
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
/*     */ @Service
/*     */ public class PerguntaService
/*     */   extends BaseService<Pergunta, Long>
/*     */ {
/*     */   private static final long serialVersionUID = 8405968871122425671L;
/*     */   private final PerguntaDAO dao;
/*     */   @Autowired
/*     */   private OpcaoRespostaService opcaoRespostaService;
/*     */   @Autowired
/*     */   private RespostaService respostaService;
/*     */   @Autowired
/*     */   private ModelMapper modelMapper;
/*     */   
/*     */   @Autowired
/*     */   public PerguntaService(PerguntaDAO dao) {
/*  51 */     super((CrudRepository)dao);
/*  52 */     this.dao = dao;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Pergunta salvar(PerguntaDTO dto) {
/*  61 */     Pergunta pergunta = toPergunta(dto);
/*  62 */     verificarCamposObrigatorios(dto);
/*  63 */     isExists(pergunta);
/*  64 */     pergunta.setDescricao(pergunta.getDescricao().trim().toUpperCase());
/*  65 */     super.salvar(pergunta);
/*  66 */     postSalvar(pergunta, dto.getRespostas());
/*  67 */     return pergunta;
/*     */   }
/*     */   
/*     */   public List<PerguntaDTO> obterPerguntasComRespostas() {
/*  71 */     Iterable<Pergunta> perguntasIt = findAll();
/*  72 */     List<Pergunta> perguntas = Lists.newArrayList(perguntasIt);
/*  73 */     return (List<PerguntaDTO>)perguntas.stream()
/*  74 */       .map(this::toDto)
/*  75 */       .collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Pergunta atualizar(PerguntaDTO dto) {
/*  84 */     Pergunta pergunta = (Pergunta)findById(dto.getId());
/*  85 */     verificarCamposObrigatorios(dto);
/*  86 */     pergunta.setDescricao(dto.getDescricao().trim().toUpperCase());
/*  87 */     pergunta.setObrigatoria(dto.isObrigatoria());
/*  88 */     pergunta.setOrdem(dto.getOrdem());
/*  89 */     pergunta.setTipoResposta(dto.getTipoResposta());
/*  90 */     isExists(pergunta);
/*  91 */     super.atualizar(pergunta);
/*  92 */     postAtualizar(pergunta, dto.getRespostas());
/*  93 */     return pergunta;
/*     */   }
/*     */   
/*     */   public void delete(Long id) {
/*  97 */     Pergunta pergunta = (Pergunta)findById(id);
/*  98 */     SMBUtil.throwException((pergunta == null), "Registro não localizado");
/*  99 */     super.excluir(pergunta);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void isExists(Pergunta pergunta) {
/* 108 */     verificarDescricaoJaCadastrada(pergunta);
/* 109 */     verificarOrdemJaCadastrada(pergunta);
/*     */   }
/*     */   
/*     */   private void verificarCamposObrigatorios(PerguntaDTO dto) {
/* 113 */     SMBUtil.throwException(StringUtils.isEmpty(dto.getDescricao().trim()), "Descrição é obrigatório");
/* 114 */     SMBUtil.throwException((dto.getTipoResposta() == null), "Tipo de Resposta é obrigatório");
/* 115 */     SMBUtil.throwException((dto.getOrdem() <= 0), "Ordem tem que ter valor maior do que Zero (0)");
/*     */   }
/*     */   
/*     */   private void verificarDescricaoJaCadastrada(Pergunta pergunta) {
/* 119 */     Pergunta question = findByDescricao(pergunta.getDescricao());
/*     */     
/* 121 */     boolean condition = ((pergunta.getId() == null && question != null) || (question != null && question.getId().compareTo(pergunta.getId()) != 0));
/* 122 */     SMBUtil.throwException(condition, "Já existe uma Pergunta Cadastrada com esta Descrição");
/*     */   }
/*     */   
/*     */   private void verificarOrdemJaCadastrada(Pergunta pergunta) {
/* 126 */     Pergunta question = findByOrdem(pergunta.getOrdem());
/* 127 */     boolean condition = (pergunta.getId() == null && question != null);
/* 128 */     SMBUtil.throwException(condition, "Já existe uma Pergunta cadastrada com esta Ordem");
/*     */   }
/*     */   
/*     */   private void associarRespostas(Pergunta pergunta, List<RespostaDTO> respostas) {
/*     */	postSalvar(pergunta, respostas);
/*     */	List<OpcaoResposta> opcoes = opcaoRespostaService.findByPergunta(pergunta);
/*     */	if (!opcoes.isEmpty()) {
/*     */		opcoes.forEach(item -> {
/*     */			if (respostas != null) {
/*     */				Optional<RespostaDTO> op = respostas.stream()
/*     */						.filter(res -> item.getId().getPergunta().equals(pergunta)
/*     */								&& item.getId().getResposta().getId().equals(res.getId()))
/*     */						.findAny();
/*     */				if (!op.isPresent())
/*     */					opcaoRespostaService.excluir(item);
/*     */			}
/*     */		});
/*     */	}
/*     */}
/*     */ 
/*     */ 
/*     */   
/*     */private void postSalvar(Pergunta pergunta, List<RespostaDTO> respostas) {
/*     */	if (respostas != null && !respostas.isEmpty()) {
/*     */		respostas.forEach(item -> associarResposta(pergunta.getId(), item.getId()));
/*     */	}
/*     */}
/*     */   
/*     */   private void postAtualizar(Pergunta pergunta, List<RespostaDTO> respostas) {
/* 155 */     associarRespostas(pergunta, respostas);
/*     */   }
/*     */   
/*     */   private void associarResposta(Long idPergunta, Long idResposta) {
/* 159 */     this.opcaoRespostaService.salvar(idPergunta, idResposta);
/*     */   }
/*     */   
/*     */   public PerguntaDTO obterPerguntaPorId(Long id) {
/* 163 */     Pergunta pergunta = (Pergunta)findById(id);
/* 164 */     PerguntaDTO dto = toDto(pergunta);
/* 165 */     return dto;
/*     */   }
/*     */   
/*     */   private Pergunta findByDescricao(String descricao) {
/* 169 */     return this.dao.findByDescricao(descricao);
/*     */   }
/*     */   
/*     */   private Pergunta findByOrdem(int ordem) {
/* 173 */     return this.dao.findByOrdem(ordem);
/*     */   }
/*     */   
/*     */   public List<RespostaDTO> obterRespostas(Long id) {
/* 177 */     Pergunta pergunta = (Pergunta)findById(id);
/* 178 */     return this.respostaService.findByPergunta(pergunta);
/*     */   }
/*     */   
/*     */   public PerguntaDTO toDto(Pergunta resposta) {
/* 182 */     if (resposta == null)
/* 183 */       return null; 
/* 184 */     PerguntaDTO dto = (PerguntaDTO)this.modelMapper.map(resposta, PerguntaDTO.class);
/* 185 */     dto.setRespostas(obterRespostas(dto.getId()));
/* 186 */     return dto;
/*     */   }
/*     */   
/*     */   public Pergunta toPergunta(PerguntaDTO dto) {
/* 190 */     if (dto == null)
/* 191 */       return null; 
/* 192 */     return (Pergunta)this.modelMapper.map(dto, Pergunta.class);
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\PerguntaService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */