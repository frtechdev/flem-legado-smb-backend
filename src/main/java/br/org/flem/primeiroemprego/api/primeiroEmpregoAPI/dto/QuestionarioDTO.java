/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*     */ 
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QuestionarioDTO
/*     */ {
/*     */   private Long id;
/*     */   private String observacao;
/*     */   private String desvioDeFuncao;
/*     */   private String tipoDesvioDeFuncao;
/*     */   private String descricaoDesvioDeFuncao;
/*     */   private Long idRegistroMonitoramento;
/*     */   private List<Long> avaliacoes;
/*     */   private String conhecimento;
/*     */   private String habilidade;
/*     */   private String autonomia;
/*     */   private String pontualidade;
/*     */   private String motivacao;
/*     */   private String experienciaProfissional;
/*     */   private Boolean gravida;
/*  25 */   private Boolean acidenteDeTrabalho = Boolean.FALSE;
/*     */   private String descricaoAcidenteDeTrabalho;
/*     */   
/*     */   public Long getId() {
/*  29 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  33 */     this.id = id;
/*     */   }
/*     */   
/*     */   public String getObservacao() {
/*  37 */     return this.observacao;
/*     */   }
/*     */   
/*     */   public void setObservacao(String observacao) {
/*  41 */     this.observacao = observacao;
/*     */   }
/*     */   
/*     */   public String getDesvioDeFuncao() {
/*  45 */     return this.desvioDeFuncao;
/*     */   }
/*     */   
/*     */   public void setDesvioDeFuncao(String desvioDeFuncao) {
/*  49 */     this.desvioDeFuncao = desvioDeFuncao;
/*     */   }
/*     */   
/*     */   public String getTipoDesvioDeFuncao() {
/*  53 */     return this.tipoDesvioDeFuncao;
/*     */   }
/*     */   
/*     */   public void setTipoDesvioDeFuncao(String tipoDesvioDeFuncao) {
/*  57 */     this.tipoDesvioDeFuncao = tipoDesvioDeFuncao;
/*     */   }
/*     */   
/*     */   public Long getIdRegistroMonitoramento() {
/*  61 */     return this.idRegistroMonitoramento;
/*     */   }
/*     */   
/*     */   public void setIdRegistroMonitoramento(Long idRegistroMonitoramento) {
/*  65 */     this.idRegistroMonitoramento = idRegistroMonitoramento;
/*     */   }
/*     */   
/*     */   public String getConhecimento() {
/*  69 */     return this.conhecimento;
/*     */   }
/*     */   
/*     */   public void setConhecimento(String conhecimento) {
/*  73 */     this.conhecimento = conhecimento;
/*     */   }
/*     */   
/*     */   public String getHabilidade() {
/*  77 */     return this.habilidade;
/*     */   }
/*     */   
/*     */   public void setHabilidade(String habilidade) {
/*  81 */     this.habilidade = habilidade;
/*     */   }
/*     */   
/*     */   public String getAutonomia() {
/*  85 */     return this.autonomia;
/*     */   }
/*     */   
/*     */   public void setAutonomia(String autonomia) {
/*  89 */     this.autonomia = autonomia;
/*     */   }
/*     */   
/*     */   public String getPontualidade() {
/*  93 */     return this.pontualidade;
/*     */   }
/*     */   
/*     */   public void setPontualidade(String pontualidade) {
/*  97 */     this.pontualidade = pontualidade;
/*     */   }
/*     */   
/*     */   public String getMotivacao() {
/* 101 */     return this.motivacao;
/*     */   }
/*     */   
/*     */   public void setMotivacao(String motivacao) {
/* 105 */     this.motivacao = motivacao;
/*     */   }
/*     */   
/*     */   public String getExperienciaProfissional() {
/* 109 */     return this.experienciaProfissional;
/*     */   }
/*     */   
/*     */   public void setExperienciaProfissional(String experienciaProfissional) {
/* 113 */     this.experienciaProfissional = experienciaProfissional;
/*     */   }
/*     */   
/*     */   public List<Long> getAvaliacoes() {
/* 117 */     return this.avaliacoes;
/*     */   }
/*     */   
/*     */   public void setAvaliacoes(List<Long> avaliacoes) {
/* 121 */     this.avaliacoes = avaliacoes;
/*     */   }
/*     */   
/*     */   public String getDescricaoDesvioDeFuncao() {
/* 125 */     return this.descricaoDesvioDeFuncao;
/*     */   }
/*     */   
/*     */   public void setDescricaoDesvioDeFuncao(String descricaoDesvioDeFuncao) {
/* 129 */     this.descricaoDesvioDeFuncao = descricaoDesvioDeFuncao;
/*     */   }
/*     */   
/*     */   public Boolean getGravida() {
/* 133 */     return this.gravida;
/*     */   }
/*     */   
/*     */   public void setGravida(Boolean gravida) {
/* 137 */     this.gravida = gravida;
/*     */   }
/*     */   
/*     */   public Boolean getAcidenteDeTrabalho() {
/* 141 */     return this.acidenteDeTrabalho;
/*     */   }
/*     */   
/*     */   public void setAcidenteDeTrabalho(Boolean acidenteDeTrabalho) {
/* 145 */     this.acidenteDeTrabalho = acidenteDeTrabalho;
/*     */   }
/*     */   
/*     */   public String getDescricaoAcidenteDeTrabalho() {
/* 149 */     return this.descricaoAcidenteDeTrabalho;
/*     */   }
/*     */   
/*     */   public void setDescricaoAcidenteDeTrabalho(String descricaoAcidenteDeTrabalho) {
/* 153 */     this.descricaoAcidenteDeTrabalho = descricaoAcidenteDeTrabalho;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\QuestionarioDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */