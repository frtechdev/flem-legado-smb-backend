/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.List;
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
/*     */ public class MonitoramentoComprovacaoDTO
/*     */ {
/*     */   private Long idMonitoramento;
/*     */   private Long idEgresso;
/*     */   private String nomeEgresso;
/*     */   private String cpfEgresso;
/*     */   private Integer matriculaEgresso;
/*     */   @JsonFormat(pattern = "dd/MM/yyyy")
/*     */   private LocalDateTime dataMonitoramento;
/*     */   private String unidadeDeLotacao;
/*     */   private String nomeDemandante;
/*     */   private Long idComprovacao;
/*     */   private String nomeComprovacao;
/*     */   private String nomeMonitor;
/*     */   private String loginMonitor;
/*     */   private List<String> avaliacoesPendentes;
/*     */   private List<String> pathAvaliacoes;
/*     */   private String status;
/*     */   private Long idStatus;
/*     */   
/*     */   public Long getIdMonitoramento() {
/*  37 */     return this.idMonitoramento;
/*     */   }
/*     */   
/*     */   public void setIdMonitoramento(Long idMonitoramento) {
/*  41 */     this.idMonitoramento = idMonitoramento;
/*     */   }
/*     */   
/*     */   public Long getIdEgresso() {
/*  45 */     return this.idEgresso;
/*     */   }
/*     */   
/*     */   public void setIdEgresso(Long idEgresso) {
/*  49 */     this.idEgresso = idEgresso;
/*     */   }
/*     */   
/*     */   public String getNomeEgresso() {
/*  53 */     return this.nomeEgresso;
/*     */   }
/*     */   
/*     */   public void setNomeEgresso(String nomeEgresso) {
/*  57 */     this.nomeEgresso = nomeEgresso;
/*     */   }
/*     */   
/*     */   public String getCpfEgresso() {
/*  61 */     return this.cpfEgresso;
/*     */   }
/*     */   
/*     */   public void setCpfEgresso(String cpfEgresso) {
/*  65 */     this.cpfEgresso = cpfEgresso;
/*     */   }
/*     */   
/*     */   public Integer getMatriculaEgresso() {
/*  69 */     return this.matriculaEgresso;
/*     */   }
/*     */   
/*     */   public void setMatriculaEgresso(Integer matriculaEgresso) {
/*  73 */     this.matriculaEgresso = matriculaEgresso;
/*     */   }
/*     */   
/*     */   public LocalDateTime getDataMonitoramento() {
/*  77 */     return this.dataMonitoramento;
/*     */   }
/*     */   
/*     */   public void setDataMonitoramento(LocalDateTime dataMonitoramento) {
/*  81 */     this.dataMonitoramento = dataMonitoramento;
/*     */   }
/*     */   
/*     */   public String getUnidadeDeLotacao() {
/*  85 */     return this.unidadeDeLotacao;
/*     */   }
/*     */   
/*     */   public void setUnidadeDeLotacao(String unidadeDeLotacao) {
/*  89 */     this.unidadeDeLotacao = unidadeDeLotacao;
/*     */   }
/*     */   
/*     */   public Long getIdComprovacao() {
/*  93 */     return this.idComprovacao;
/*     */   }
/*     */   
/*     */   public void setIdComprovacao(Long idComprovacao) {
/*  97 */     this.idComprovacao = idComprovacao;
/*     */   }
/*     */   
/*     */   public String getNomeMonitor() {
/* 101 */     return this.nomeMonitor;
/*     */   }
/*     */   
/*     */   public void setNomeMonitor(String nomeMonitor) {
/* 105 */     this.nomeMonitor = nomeMonitor;
/*     */   }
/*     */   
/*     */   public List<String> getAvaliacoesPendentes() {
/* 109 */     return this.avaliacoesPendentes;
/*     */   }
/*     */   
/*     */   public void setAvaliacoesPendentes(List<String> avaliacoesPendentes) {
/* 113 */     this.avaliacoesPendentes = avaliacoesPendentes;
/*     */   }
/*     */   
/*     */   public List<String> getPathAvaliacoes() {
/* 117 */     return this.pathAvaliacoes;
/*     */   }
/*     */   
/*     */   public void setPathAvaliacoes(List<String> pathAvaliacoes) {
/* 121 */     this.pathAvaliacoes = pathAvaliacoes;
/*     */   }
/*     */   
/*     */   public String getNomeComprovacao() {
/* 125 */     return this.nomeComprovacao;
/*     */   }
/*     */   
/*     */   public void setNomeComprovacao(String nomeComprovacao) {
/* 129 */     this.nomeComprovacao = nomeComprovacao;
/*     */   }
/*     */   
/*     */   public String getNomeDemandante() {
/* 133 */     return this.nomeDemandante;
/*     */   }
/*     */   
/*     */   public void setNomeDemandante(String nomeDemandante) {
/* 137 */     this.nomeDemandante = nomeDemandante;
/*     */   }
/*     */   
/*     */   public String getLoginMonitor() {
/* 141 */     return this.loginMonitor;
/*     */   }
/*     */   
/*     */   public void setLoginMonitor(String loginMonitor) {
/* 145 */     this.loginMonitor = loginMonitor;
/*     */   }
/*     */   
/*     */   public String getStatus() {
/* 149 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/* 153 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Long getIdStatus() {
/* 157 */     return this.idStatus;
/*     */   }
/*     */   
/*     */   public void setIdStatus(Long idStatus) {
/* 161 */     this.idStatus = idStatus;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\MonitoramentoComprovacaoDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */