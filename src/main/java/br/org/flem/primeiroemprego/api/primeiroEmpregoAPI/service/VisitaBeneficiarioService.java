/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.AbstractHelper;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseEntityAudited;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.VisitaBeneficiarioDAO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.StatusVisitaEnum;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Beneficiario;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.VisitaBeneficiario;
/*     */ import java.util.Date;
/*     */ import javax.transaction.Transactional;
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
/*     */ public class VisitaBeneficiarioService
/*     */   extends AbstractHelper
/*     */ {
/*     */   private static final long serialVersionUID = -1625843021277574983L;
/*     */   @Autowired
/*     */   private VisitaBeneficiarioDAO dao;
/*     */   @Autowired
/*     */   private ColaboradorService colaboradorService;
/*     */   @Autowired
/*     */   private BeneficiarioService beneficiarioService;
/*     */   @Autowired
/*     */   private PeriodoService periodoService;
/*     */   
/*     */   public VisitaBeneficiario findByEgresso(Long idBeneficiario) {
/*  50 */     Beneficiario beneficiario = this.beneficiarioService.findById(idBeneficiario);
/*  51 */     return this.dao.findFirstByEgressoAndExcluidoOrderByDataVisitaDesc(beneficiario, Boolean.FALSE);
/*     */   }
/*     */   
/*     */   public VisitaBeneficiario findByEgressoAndStatus(Long idBeneficiario, StatusVisitaEnum status) {
/*  55 */     Beneficiario beneficiario = this.beneficiarioService.findById(idBeneficiario);
/*  56 */     return this.dao.findFirstByEgressoAndStatusAndExcluidoOrderByDataVisitaDesc(beneficiario, status, Boolean.FALSE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VisitaBeneficiario saveVisitaBeneficiario(Long idMonitor, Long idBeneficiario) {
/*  66 */     VisitaBeneficiario visita = findByEgressoAndStatus(idBeneficiario, StatusVisitaEnum.VISITADO);
/*  67 */     if (visita == null || !this.periodoService.validarDataDentroDoPeriodo(visita.getDataAtualizacao().toLocalDate())) {
/*  68 */       visita = new VisitaBeneficiario();
/*  69 */       visita.setColaborador(this.colaboradorService.findById(idMonitor));
/*  70 */       visita.setEgresso(this.beneficiarioService.findById(idBeneficiario));
/*  71 */       visita.setDataVisita(new Date());
/*  72 */       visita.setStatus(StatusVisitaEnum.VISITADO);
/*  73 */       preSave((BaseEntityAudited)visita);
/*  74 */       return (VisitaBeneficiario)this.dao.save(visita);
/*     */     } 
/*  76 */     return visita;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VisitaBeneficiario saveDesfazerVisitaBeneficiario(Long idBeneficiario) {
/*  86 */     return saveExcluir(idBeneficiario, StatusVisitaEnum.VISITADO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VisitaBeneficiario saveExcluir(Long idBeneficiario, StatusVisitaEnum status) {
/*  96 */     VisitaBeneficiario visita = findByEgressoAndStatus(idBeneficiario, status);
/*  97 */     if (visita != null) {
/*  98 */       visita.setExcluido(Boolean.valueOf(true));
/*  99 */       preUpdate((BaseEntityAudited)visita);
/* 100 */       return (VisitaBeneficiario)this.dao.save(visita);
/*     */     } 
/* 102 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional
/*     */   public void updateVisitaBeneficiario(Long idMonitor, Long idBeneficiario) {
/* 112 */     VisitaBeneficiario visita = findByEgresso(idBeneficiario);
/* 113 */     if (visita != null) {
/* 114 */       visita.setStatus(StatusVisitaEnum.MONITORADO);
/* 115 */       preUpdate((BaseEntityAudited)visita);
/*     */     } else {
/* 117 */       visita = new VisitaBeneficiario();
/* 118 */       visita.setColaborador(this.colaboradorService.findById(idMonitor));
/* 119 */       visita.setEgresso(this.beneficiarioService.findById(idBeneficiario));
/* 120 */       visita.setDataVisita(new Date());
/* 121 */       visita.setStatus(StatusVisitaEnum.MONITORADO);
/* 122 */       preSave((BaseEntityAudited)visita);
/*     */     } 
/* 124 */     this.dao.save(visita);
/*     */   }
/*     */   
/*     */   public VisitaBeneficiario carregarVisitaBeneficiarioMonitoradoOuVisitadoNoPeriodo(Long id) {
/* 128 */     VisitaBeneficiario visitado = findByEgresso(id);
/* 129 */     if (visitado != null && this.periodoService.validarDataDentroDoPeriodo(visitado.getDataAtualizacao().toLocalDate())) {
/* 130 */       return visitado;
/*     */     }
/* 132 */     return new VisitaBeneficiario(StatusVisitaEnum.NAO_MONITORADO);
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\VisitaBeneficiarioService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */