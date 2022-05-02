/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import java.io.Serializable;
/*     */ import java.time.LocalDateTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ListaMonitoramentoDTO
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   private Long idEgresso;
/*     */   private String nomeEgresso;
/*     */   private String cpfEgresso;
/*     */   private String admissaoEgresso;
/*     */   private Integer matriculaEgresso;
/*     */   @JsonFormat(pattern = "MM/yyyy")
/*     */   private LocalDateTime proxMonitoramento;
/*     */   private String unidadeDeLotacao;
/*     */   private Long idComprovacao;
/*     */   @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
/*     */   private LocalDateTime dataMonitoramento;
/*     */   private String loginMonitor;
/*     */   private String fileName;
/*     */   private String nomeDemandante;
/*     */   private String nomeMunicipio;
/*     */   
/*     */   public Long getId() {
/*  36 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  40 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Long getIdEgresso() {
/*  44 */     return this.idEgresso;
/*     */   }
/*     */   
/*     */   public void setIdEgresso(Long idEgresso) {
/*  48 */     this.idEgresso = idEgresso;
/*     */   }
/*     */   
/*     */   public String getNomeEgresso() {
/*  52 */     return this.nomeEgresso;
/*     */   }
/*     */   
/*     */   public void setNomeEgresso(String nomeEgresso) {
/*  56 */     this.nomeEgresso = nomeEgresso;
/*     */   }
/*     */   
/*     */   public String getCpfEgresso() {
/*  60 */     return this.cpfEgresso;
/*     */   }
/*     */   
/*     */   public void setCpfEgresso(String cpfEgresso) {
/*  64 */     this.cpfEgresso = cpfEgresso;
/*     */   }
/*     */   
/*     */   public String getAdmissaoEgresso() {
/*  68 */     return this.admissaoEgresso;
/*     */   }
/*     */   
/*     */   public void setAdmissaoEgresso(String admissaoEgresso) {
/*  72 */     this.admissaoEgresso = admissaoEgresso;
/*     */   }
/*     */   
/*     */   public Integer getMatriculaEgresso() {
/*  76 */     return this.matriculaEgresso;
/*     */   }
/*     */   
/*     */   public void setMatriculaEgresso(Integer matriculaEgresso) {
/*  80 */     this.matriculaEgresso = matriculaEgresso;
/*     */   }
/*     */   
/*     */   public LocalDateTime getProxMonitoramento() {
/*  84 */     return this.proxMonitoramento;
/*     */   }
/*     */   
/*     */   public void setProxMonitoramento(LocalDateTime proxMonitoramento) {
/*  88 */     this.proxMonitoramento = proxMonitoramento;
/*     */   }
/*     */   
/*     */   public String getUnidadeDeLotacao() {
/*  92 */     return this.unidadeDeLotacao;
/*     */   }
/*     */   
/*     */   public void setUnidadeDeLotacao(String unidadeDeLotacao) {
/*  96 */     this.unidadeDeLotacao = unidadeDeLotacao;
/*     */   }
/*     */   
/*     */   public Long getIdComprovacao() {
/* 100 */     return this.idComprovacao;
/*     */   }
/*     */   
/*     */   public void setIdComprovacao(Long idComprovacao) {
/* 104 */     this.idComprovacao = idComprovacao;
/*     */   }
/*     */   
/*     */   public LocalDateTime getDataMonitoramento() {
/* 108 */     return this.dataMonitoramento;
/*     */   }
/*     */   
/*     */   public void setDataMonitoramento(LocalDateTime dataMonitoramento) {
/* 112 */     this.dataMonitoramento = dataMonitoramento;
/*     */   }
/*     */   
/*     */   public String getLoginMonitor() {
/* 116 */     return this.loginMonitor;
/*     */   }
/*     */   
/*     */   public void setLoginMonitor(String loginMonitor) {
/* 120 */     this.loginMonitor = loginMonitor;
/*     */   }
/*     */   
/*     */   public String getFileName() {
/* 124 */     return this.fileName;
/*     */   }
/*     */   
/*     */   public void setFileName(String fileName) {
/* 128 */     this.fileName = fileName;
/*     */   }
/*     */   
/*     */   public String getNomeDemandante() {
/* 132 */     return this.nomeDemandante;
/*     */   }
/*     */   
/*     */   public void setNomeDemandante(String nomeDemandante) {
/* 136 */     this.nomeDemandante = nomeDemandante;
/*     */   }
/*     */   
/*     */   public String getNomeMunicipio() {
/* 140 */     return this.nomeMunicipio;
/*     */   }
/*     */   
/*     */   public void setNomeMunicipio(String nomeMunicipio) {
/* 144 */     this.nomeMunicipio = nomeMunicipio;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\ListaMonitoramentoDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */