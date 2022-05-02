/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.SinteseRelatorioTrimestralProj;
/*     */ import java.time.LocalDateTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SinteseRelatorioTrimestralDTO
/*     */   implements SinteseRelatorioTrimestralProj
/*     */ {
/*     */   private Long id;
/*     */   private Long idEgresso;
/*     */   private Long idComprovacao;
/*     */   private String cpfEgresso;
/*     */   private String nomeEgresso;
/*     */   private String matriculaEgresso;
/*     */   private String municipio;
/*     */   private LocalDateTime dataMonitoramento;
/*     */   private String dataVisita;
/*     */   private String demandante;
/*     */   private String siglaDemandante;
/*     */   private String unidadeDeLotacao;
/*     */   private String monitor;
/*     */   private String avaliacoes;
/*     */   private String dataAdmissao;
/*     */   private LocalDateTime admissao;
/*     */   private String usuarioCriacao;
/*     */   
/*     */   public Long getId() {
/*  32 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  36 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Long getIdEgresso() {
/*  40 */     return this.idEgresso;
/*     */   }
/*     */   
/*     */   public void setIdEgresso(Long idEgresso) {
/*  44 */     this.idEgresso = idEgresso;
/*     */   }
/*     */   
/*     */   public String getCpfEgresso() {
/*  48 */     return this.cpfEgresso;
/*     */   }
/*     */   
/*     */   public void setCpfEgresso(String cpfEgresso) {
/*  52 */     this.cpfEgresso = cpfEgresso;
/*     */   }
/*     */   
/*     */   public String getNomeEgresso() {
/*  56 */     return this.nomeEgresso;
/*     */   }
/*     */   
/*     */   public void setNomeEgresso(String nomeEgresso) {
/*  60 */     this.nomeEgresso = nomeEgresso;
/*     */   }
/*     */   
/*     */   public String getMatriculaEgresso() {
/*  64 */     return this.matriculaEgresso;
/*     */   }
/*     */   
/*     */   public void setMatriculaEgresso(String matriculaEgresso) {
/*  68 */     this.matriculaEgresso = matriculaEgresso;
/*     */   }
/*     */   
/*     */   public String getMunicipio() {
/*  72 */     return this.municipio;
/*     */   }
/*     */   
/*     */   public void setMunicipio(String municipio) {
/*  76 */     this.municipio = municipio;
/*     */   }
/*     */   
/*     */   public LocalDateTime getDataMonitoramento() {
/*  80 */     return this.dataMonitoramento;
/*     */   }
/*     */   
/*     */   public void setDataMonitoramento(LocalDateTime dataMonitoramento) {
/*  84 */     this.dataMonitoramento = dataMonitoramento;
/*     */   }
/*     */   
/*     */   public String getDemandante() {
/*  88 */     return this.demandante;
/*     */   }
/*     */   
/*     */   public void setDemandante(String demandante) {
/*  92 */     this.demandante = demandante;
/*     */   }
/*     */   
/*     */   public String getUnidadeDeLotacao() {
/*  96 */     return this.unidadeDeLotacao;
/*     */   }
/*     */   
/*     */   public void setUnidadeDeLotacao(String unidadeDeLotacao) {
/* 100 */     this.unidadeDeLotacao = unidadeDeLotacao;
/*     */   }
/*     */   
/*     */   public String getMonitor() {
/* 104 */     return this.monitor;
/*     */   }
/*     */   
/*     */   public void setMonitor(String monitor) {
/* 108 */     this.monitor = monitor;
/*     */   }
/*     */   
/*     */   public String getDataVisita() {
/* 112 */     return this.dataVisita;
/*     */   }
/*     */   
/*     */   public void setDataVisita(String dataVisita) {
/* 116 */     this.dataVisita = dataVisita;
/*     */   }
/*     */   
/*     */   public String getAvaliacoes() {
/* 120 */     return this.avaliacoes;
/*     */   }
/*     */   
/*     */   public void setAvaliacoes(String avaliacoes) {
/* 124 */     this.avaliacoes = avaliacoes;
/*     */   }
/*     */   
/*     */   public Long getIdComprovacao() {
/* 128 */     return this.idComprovacao;
/*     */   }
/*     */   
/*     */   public void setIdComprovacao(Long idComprovacao) {
/* 132 */     this.idComprovacao = idComprovacao;
/*     */   }
/*     */   
/*     */   public String getSiglaDemandante() {
/* 136 */     return this.siglaDemandante;
/*     */   }
/*     */   
/*     */   public void setSiglaDemandante(String siglaDemandante) {
/* 140 */     this.siglaDemandante = siglaDemandante;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDataAdmissao() {
/* 145 */     return this.dataAdmissao;
/*     */   }
/*     */   
/*     */   public void setDataAdmissao(String dataAdmissao) {
/* 149 */     this.dataAdmissao = dataAdmissao;
/*     */   }
/*     */   
/*     */   public LocalDateTime getAdmissao() {
/* 153 */     return this.admissao;
/*     */   }
/*     */   
/*     */   public void setAdmissao(LocalDateTime admissao) {
/* 157 */     this.admissao = admissao;
/*     */   }
/*     */   
/*     */   public String getUsuarioCriacao() {
/* 161 */     return this.usuarioCriacao;
/*     */   }
/*     */   
/*     */   public void setUsuarioCriacao(String usuarioCriacao) {
/* 165 */     this.usuarioCriacao = usuarioCriacao;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\SinteseRelatorioTrimestralDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */