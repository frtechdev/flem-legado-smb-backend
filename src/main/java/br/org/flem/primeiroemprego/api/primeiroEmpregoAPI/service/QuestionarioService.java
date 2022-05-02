/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.AbstractHelper;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.QuestionarioDAO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Questionario;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.RegistroMonitoramento;
/*     */ import java.time.LocalDateTime;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class QuestionarioService
/*     */   extends AbstractHelper
/*     */ {
/*     */   @Autowired
/*     */   private QuestionarioDAO dao;
/*     */   @Autowired
/*     */   private RegistroMonitoramentoService registroMonitoramentoService;
/*     */   @Autowired
/*     */   private AvaliacaoQuestionarioService avaliacaoQuestionarioService;
/*     */   
/*     */   public Questionario registrarMonitoramento(Questionario questionario) {
/*  29 */     return save(questionario);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Questionario save(Questionario questionario) {
/*  38 */     verificarRegras(questionario);
/*  39 */     String login = getCurrentUser();
/*  40 */     questionario.setUsuarioCriacao(login);
/*  41 */     questionario.setUsuarioAtualizacao(login);
/*  42 */     questionario.setDataAtualizacao(LocalDateTime.now());
/*  43 */     questionario.setDataCriacao(LocalDateTime.now());
/*  44 */     return (Questionario)this.dao.save(questionario);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Questionario update(Questionario questionario) {
/*  54 */     verificarRegras(questionario);
/*  55 */     String login = getCurrentUser();
/*  56 */     questionario.setUsuarioAtualizacao(login);
/*  57 */     questionario.setDataAtualizacao(LocalDateTime.now());
/*  58 */     return (Questionario)this.dao.save(questionario);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void verificarRegras(Questionario questionario) {
/*  67 */     if (questionario.getDesvioDeFuncao().equalsIgnoreCase("S") && 
/*  68 */       StringUtils.isBlank(questionario.getTipoDesvioDeFuncao())) {
/*  69 */       throw new MonitoramentoException("Tipo de Desvio de Função deve ser informado!");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Questionario findById(Long id) {
/*  80 */     return (Questionario)this.dao.findOne(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deleteById(Long id) {
/*  88 */     Questionario questionario = findById(id);
/*  89 */     if (questionario == null) {
/*  90 */       throw new MonitoramentoException("Questionário não localizado!");
/*     */     }
/*  92 */     this.avaliacaoQuestionarioService.deleteByQuestionario(questionario);
/*  93 */     delete(questionario);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Questionario findByRegistroMonitoramento(RegistroMonitoramento registroMonitoramento) {
/* 101 */     return this.dao.findByRegistroMonitoramento(registroMonitoramento);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Questionario findByRegistroMonitoramento(Long idRegistroMonitoramento) {
/* 110 */     RegistroMonitoramento registroMonitoramento = this.registroMonitoramentoService.findById(idRegistroMonitoramento);
/* 111 */     return findByRegistroMonitoramento(registroMonitoramento);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void delete(Questionario questionario) {
/* 118 */     questionario.setExcluido(Boolean.TRUE);
/* 119 */     update(questionario);
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\QuestionarioService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */