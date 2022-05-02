/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.AbstractHelper;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.AvaliacaoMonitoramentoDAO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.AvaliacaoMonitoramentoDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.AvaliacaoMonitoramento;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Questionario;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
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
/*     */ @Service
/*     */ public class AvaliacaoMonitoramentoService
/*     */   extends AbstractHelper
/*     */ {
/*     */   @Autowired
/*     */   private AvaliacaoMonitoramentoDAO dao;
/*     */   
/*     */   public AvaliacaoMonitoramento save(AvaliacaoMonitoramento obj) throws MonitoramentoException {
/*  32 */     verificarRegras(obj);
/*  33 */     String login = getCurrentUser();
/*  34 */     obj.setDataCriacao(LocalDateTime.now());
/*  35 */     obj.setUsuarioCriacao(login);
/*  36 */     obj.setDataAtualizacao(LocalDateTime.now());
/*  37 */     obj.setUsuarioAtualizacao(login);
/*  38 */     return (AvaliacaoMonitoramento)this.dao.save(obj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AvaliacaoMonitoramento update(AvaliacaoMonitoramento obj) throws MonitoramentoException {
/*  48 */     verificarRegras(obj);
/*  49 */     obj.setDataAtualizacao(LocalDateTime.now());
/*  50 */     obj.setUsuarioAtualizacao(getCurrentUser());
/*  51 */     return (AvaliacaoMonitoramento)this.dao.save(obj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void verificarRegras(AvaliacaoMonitoramento obj) throws MonitoramentoException {
/*  59 */     if (obj.getNome() == null) {
/*  60 */       throw new MonitoramentoException("Nome da avaliação deve ser informado");
/*     */     }
/*  62 */     AvaliacaoMonitoramento old = this.dao.findByNomeAndAtivoTrue(obj.getNome());
/*  63 */     if (old != null && (
/*  64 */       obj.getId() == null || old.getId().compareTo(obj.getId()) != 0)) {
/*  65 */       throw new MonitoramentoException("Avaliação Já Cadastrada");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void delete(AvaliacaoMonitoramento obj) throws MonitoramentoException {
/*  75 */     if (obj != null) {
/*  76 */       delete(obj.getId());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void delete(Long id) throws MonitoramentoException {
/*  84 */     if (id != null) {
/*  85 */       AvaliacaoMonitoramento obj = (AvaliacaoMonitoramento)this.dao.findOne(id);
/*  86 */       if (obj.getQuestionario() != null && !obj.getQuestionario().isEmpty()) {
/*  87 */         throw new MonitoramentoException("Avaliação não Pode ser Excluída. Existem Registros Associados a ela.");
/*     */       }
/*  89 */       this.dao.delete(obj);
/*     */     } 
/*     */ 
/*     */     
/*  93 */     throw new MonitoramentoException("Avaliação Não Localizada");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AvaliacaoMonitoramentoDTO salvar(AvaliacaoMonitoramentoDTO dto) throws MonitoramentoException {
/* 102 */     AvaliacaoMonitoramento obj = new AvaliacaoMonitoramento();
/*     */     
/* 104 */     obj.setDescricao(dto.getDescricao());
/* 105 */     obj.setNome(dto.getNome());
/*     */     
/* 107 */     AvaliacaoMonitoramento salvo = save(obj);
/* 108 */     dto.setId(salvo.getId());

			
/* 109 */     return dto;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AvaliacaoMonitoramentoDTO atualizar(AvaliacaoMonitoramentoDTO dto) throws MonitoramentoException {
/* 118 */     AvaliacaoMonitoramento obj = findById(dto.getId());
/*     */     
/* 120 */     obj.setDescricao(dto.getDescricao());
/* 121 */     obj.setNome(dto.getNome());
/*     */     
/* 123 */     update(obj);
/* 124 */     dto.setId(obj.getId());
/* 125 */     return dto;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AvaliacaoMonitoramento findById(Long id) {
/* 133 */     AvaliacaoMonitoramento obj = (AvaliacaoMonitoramento)this.dao.findOne(id);
/* 134 */     if (obj == null) {
/* 135 */       throw new MonitoramentoException("Avaliação não Localizada");
/*     */     }
/* 137 */     return obj;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AvaliacaoMonitoramentoDTO findDTOById(Long id) {
/* 145 */     AvaliacaoMonitoramento obj = findById(id);
/* 146 */     AvaliacaoMonitoramentoDTO dto = new AvaliacaoMonitoramentoDTO();
/* 147 */     dto.setNome(obj.getNome());
/* 148 */     dto.setDescricao(obj.getDescricao());
/* 149 */     return dto;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<AvaliacaoMonitoramentoDTO> findDTOAll() {
/* 156 */     List<AvaliacaoMonitoramentoDTO> retorno = new ArrayList<>();
/* 157 */     List<AvaliacaoMonitoramento> objs = this.dao.findByAtivoTrue();
/* 158 */     if (objs != null) {
/* 159 */       objs.forEach(item -> {
/*     */             AvaliacaoMonitoramentoDTO dto = new AvaliacaoMonitoramentoDTO();
/*     */             dto.setNome(item.getNome());
/*     */             dto.setId(item.getId());
/*     */             dto.setDescricao(item.getDescricao());
/*     */             retorno.add(dto);
/*     */           });
/*     */     }
/* 167 */     return retorno;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<AvaliacaoMonitoramento> findByQuestionario(Questionario questionario) {
/* 175 */     return this.dao.findByQuestionario(questionario);
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\AvaliacaoMonitoramentoService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */