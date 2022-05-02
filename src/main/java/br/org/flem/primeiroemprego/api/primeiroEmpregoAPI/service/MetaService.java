/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.AbstractHelper;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseEntityAudited;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.MetaDAO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.MetaDTO;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Meta;
/*     */ import java.util.Optional;
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
/*     */ @Service
/*     */ public class MetaService
/*     */   extends AbstractHelper
/*     */ {
/*     */   @Autowired
/*     */   private MetaDAO dao;
/*     */   
/*     */   public Meta save(Meta object) {
/*  29 */     preSave((BaseEntityAudited)object);
/*  30 */     return (Meta)this.dao.save(object);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Meta remover(Meta object) {
/*  40 */     object.setExcluido(Boolean.TRUE);
/*  41 */     return update(object);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Meta update(Meta object) {
/*  51 */     preUpdate((BaseEntityAudited)object);
/*  52 */     return (Meta)this.dao.save(object);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterable<Meta> getList() {
/*  61 */     return this.dao.findAll();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Meta findById(Long id) {
/*  71 */     return (Meta)this.dao.findOne(id);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Meta salvar(MetaDTO dto) {
/*  81 */     Meta meta = new Meta();
/*  82 */     meta.setDescricao(dto.getDescricao());
/*  83 */     meta.setNome(dto.getNome());
/*  84 */     isExist(meta);
/*  85 */     return save(meta);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Meta atualizar(MetaDTO dto) {
/*  95 */     if (dto.getId() == null) {
/*  96 */       throw new MonitoramentoException("Meta a ser editada não foi informada!");
/*     */     }
/*  98 */     Meta meta = (Meta)this.dao.findOne(dto.getId());
/*  99 */     meta.setDescricao(dto.getDescricao());
/* 100 */     meta.setNome(dto.getNome());
/* 101 */     isExist(meta);
/* 102 */     return update(meta);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deletar(Long id) {
/* 111 */     Meta old = (Meta)this.dao.findOne(id);
/* 112 */     if (old != null) {
/* 113 */       remover(old);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void isExist(Meta meta) {
/* 123 */     Optional<Meta> old = this.dao.findByNomeAndExcluidoFalse(meta.getNome());
/* 124 */     if (old.isPresent() && (
/* 125 */       meta.getId() == null || !meta.getId().equals(((Meta)old.get()).getId()))) {
/* 126 */       throw new MonitoramentoException("Já existe uma meta cadastrada com esse nome!");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNomeEDescricaoPorId(Long id) {
/* 136 */     Meta meta = findById(id);
/* 137 */     return getNomeEDescricaoPorId(meta);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNomeEDescricaoPorId(Meta meta) {
/* 146 */     if (meta != null) {
/* 147 */       StringBuilder build = new StringBuilder();
/* 148 */       build.append(meta.getNome()).append(" (").append(meta.getDescricao()).append(")");
/* 149 */       return build.toString();
/*     */     } 
/* 151 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\MetaService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */