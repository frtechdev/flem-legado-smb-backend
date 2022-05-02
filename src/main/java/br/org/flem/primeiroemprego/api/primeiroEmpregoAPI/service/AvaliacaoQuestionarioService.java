/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.AbstractHelper;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseEntityAudited;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.AvaliacaoQuestionarioDAO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.AvaliacaoQuestionarioDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.AvaliacaoMonitoramento;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.AvaliacaoQuestionario;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.AvaliacaoQuestionarioId;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Questionario;
/*     */ import java.io.Serializable;
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
/*     */ @Service
/*     */ public class AvaliacaoQuestionarioService
/*     */   extends AbstractHelper
/*     */ {
/*     */   @Autowired
/*     */   private AvaliacaoQuestionarioDAO dao;
/*     */   @Autowired
/*     */   private QuestionarioService questionarioService;
/*     */   @Autowired
/*     */   private AvaliacaoMonitoramentoService avaliacaoService;
/*     */   
/*     */   public AvaliacaoQuestionario save(AvaliacaoQuestionario obj) throws MonitoramentoException {
/*  37 */     preSave((BaseEntityAudited)obj);
/*  38 */     return (AvaliacaoQuestionario)this.dao.save(obj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deleteById(AvaliacaoQuestionarioId id) {
/*  47 */     AvaliacaoQuestionario avaliacao = findOne(id);
/*  48 */     delete(avaliacao);
/*     */   }
/*     */   
/*     */   public AvaliacaoQuestionario findOne(AvaliacaoQuestionarioId id) {
/*  52 */     return (AvaliacaoQuestionario)this.dao.findOne(id);
/*     */   }
/*     */   
/*     */   public void delete(AvaliacaoQuestionario obj) {
/*  56 */     obj.setExcluido(Boolean.TRUE);
/*  57 */     update(obj);
/*     */   }
/*     */   
/*     */   public AvaliacaoQuestionario update(AvaliacaoQuestionario obj) {
/*  61 */     preUpdate((BaseEntityAudited)obj);
/*  62 */     return (AvaliacaoQuestionario)this.dao.save(obj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<AvaliacaoQuestionario> findByIdQuestionario(Questionario questionario) {
/*  70 */     return this.dao.findByIdQuestionarioAndExcluidoFalse(questionario);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deleteByQuestionario(Questionario questionario) {
/*  78 */     if (questionario != null) {
/*  79 */       List<AvaliacaoQuestionario> avaliacoes = findByIdQuestionario(questionario);
/*  80 */       avaliacoes.forEach(evaluation -> deleteById(evaluation.getId()));
/*     */     } 
/*     */   }
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
/*     */   public AvaliacaoQuestionario salvar(AvaliacaoQuestionarioDTO dto) throws MonitoramentoException {
/*  94 */     AvaliacaoQuestionario obj = new AvaliacaoQuestionario();
/*  95 */     AvaliacaoMonitoramento avaliacao = this.avaliacaoService.findById(dto.getIdAvaliacao());
/*  96 */     Questionario questionario = this.questionarioService.findById(dto.getIdQuestionario());
/*     */     
/*  98 */     obj.getId().setAvaliacao(avaliacao);
/*  99 */     obj.getId().setQuestionario(questionario);
/* 100 */     obj.setFilePath(dto.getFilePath());
/*     */     
/* 102 */     return save(obj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AvaliacaoQuestionario update(AvaliacaoQuestionarioDTO dto) throws MonitoramentoException {
/* 112 */     AvaliacaoMonitoramento avaliacao = this.avaliacaoService.findById(dto.getIdAvaliacao());
/* 113 */     Questionario questionario = this.questionarioService.findById(dto.getIdQuestionario());
/* 114 */     AvaliacaoQuestionarioId id = new AvaliacaoQuestionarioId(questionario, avaliacao);
/* 115 */     AvaliacaoQuestionario obj = (AvaliacaoQuestionario)this.dao.findOne(id);
/* 116 */     if (obj != null) {
/* 117 */       obj.getId().setAvaliacao(avaliacao);
/* 118 */       obj.getId().setQuestionario(questionario);
/* 119 */       obj.setFilePath(dto.getFilePath());
/*     */       
/* 121 */       return update(obj);
/*     */     } 
/* 123 */     return salvar(dto);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<AvaliacaoQuestionarioDTO> findByIdRegistroMonitoramento(Long id) {
/* 132 */     Questionario questionario = this.questionarioService.findByRegistroMonitoramento(id);
/* 133 */     List<AvaliacaoQuestionarioDTO> dtos = new ArrayList<>();
/* 134 */     if (questionario == null) {
/* 135 */       throw new MonitoramentoException("Avaliação não Localizada");
/*     */     }
/* 137 */     List<AvaliacaoQuestionario> lista = findByIdQuestionario(questionario);
/* 138 */     lista.forEach(item -> {
/*     */           AvaliacaoQuestionarioDTO dto = new AvaliacaoQuestionarioDTO();
/*     */           
/*     */           dto.setIdAvaliacao(item.getId().getAvaliacao().getId());
/*     */           dto.setIdQuestionario(item.getId().getQuestionario().getId());
/*     */           dto.setFilePath(item.getFilePath());
/*     */           dto.setFileName(item.getId().getAvaliacao().getNome());
/*     */           dtos.add(dto);
/*     */         });
/* 147 */     return dtos;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\AvaliacaoQuestionarioService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */