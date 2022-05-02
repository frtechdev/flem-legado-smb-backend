/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*     */ 
/*     */ import br.org.flem.util.helper.DateUtil;
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import java.io.InputStream;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
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
/*     */ public class RelatorioMonitoramentoDTO
/*     */ {
/*     */   private String nomeEgresso;
/*     */   private Long idEgresso;
/*     */   @JsonFormat(pattern = "MM/yyyy")
/*     */   private LocalDateTime proxMonitoramento;
/*     */   private String unidadeDeLotacao;
/*     */   private String municipio;
/*     */   private String demandante;
/*     */   @JsonFormat(pattern = "dd/MM/yyyy")
/*     */   private LocalDateTime dataMonitoramento;
/*     */   @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
/*     */   private LocalDateTime dataHrMonitoramento;
/*     */   private String formacao;
/*     */   private String subMeta;
/*     */   private String subMetaKey;
/*     */   private String observacao;
/*     */   private String desvioDeFuncao;
/*     */   private String tipoDesvio;
/*     */   private String autonomia;
/*     */   private String conhecimento;
/*     */   private String habilidade;
/*     */   private String motivacao;
/*     */   private String pontualidade;
/*     */   private String experienciaProfissional;
/*     */   private String avaliacoes;
/*     */   private List<AvaliacaoDTO> avaliacoesDto;
/*     */   private InputStream assinatura;
/*     */   private Long idMonitor;
/*     */   private String monitor;
/*     */   private String links;
/*     */   private String principaisRegistros;
/*     */   private Long idComprovacao;
/*     */   private Boolean presente;
/*     */   private String situacao;
/*     */   private String fileName;
/*     */   private String comprovacaoName;
/*     */   private List<AvaliacaoQuestionarioDTO> avaliacoesQuestionario;
/*     */   
/*     */   public RelatorioMonitoramentoDTO() {}
/*     */   
/*     */   public RelatorioMonitoramentoDTO(String nomeEgresso, LocalDateTime proxMonitoramento, String unidadeDeLotacao, String municipio, String demandante, LocalDateTime dataMonitoramento, String formacao, String subMeta, String observacao, String desvioDeFuncao, String tipoDesvio, String autonomia, String conhecimento, String habilidade, String motivacao, String pontualidade, String experienciaProfissional) {
/*  64 */     this.nomeEgresso = nomeEgresso;
/*  65 */     this.proxMonitoramento = proxMonitoramento;
/*  66 */     this.unidadeDeLotacao = unidadeDeLotacao;
/*  67 */     this.municipio = municipio;
/*  68 */     this.demandante = demandante;
/*  69 */     this.dataMonitoramento = dataMonitoramento;
/*  70 */     this.formacao = formacao;
/*  71 */     this.subMeta = subMeta;
/*  72 */     this.observacao = observacao;
/*  73 */     this.desvioDeFuncao = desvioDeFuncao;
/*  74 */     this.tipoDesvio = tipoDesvio;
/*  75 */     this.autonomia = autonomia;
/*  76 */     this.conhecimento = conhecimento;
/*  77 */     this.habilidade = habilidade;
/*  78 */     this.motivacao = motivacao;
/*  79 */     this.pontualidade = pontualidade;
/*  80 */     this.experienciaProfissional = experienciaProfissional;
/*     */   }
/*     */   
/*     */   public String getNomeEgresso() {
/*  84 */     return this.nomeEgresso;
/*     */   }
/*     */   
/*     */   public void setNomeEgresso(String nomeEgresso) {
/*  88 */     this.nomeEgresso = nomeEgresso;
/*     */   }
/*     */   
/*     */   public LocalDateTime getProxMonitoramento() {
/*  92 */     return this.proxMonitoramento;
/*     */   }
/*     */   
/*     */   public void setProxMonitoramento(LocalDateTime proxMonitoramento) {
/*  96 */     this.proxMonitoramento = proxMonitoramento;
/*     */   }
/*     */   
/*     */   public String getUnidadeDeLotacao() {
/* 100 */     return this.unidadeDeLotacao;
/*     */   }
/*     */   
/*     */   public void setUnidadeDeLotacao(String unidadeDeLotacao) {
/* 104 */     this.unidadeDeLotacao = unidadeDeLotacao;
/*     */   }
/*     */   
/*     */   public String getMunicipio() {
/* 108 */     return this.municipio;
/*     */   }
/*     */   
/*     */   public void setMunicipio(String municipio) {
/* 112 */     this.municipio = municipio;
/*     */   }
/*     */   
/*     */   public String getDemandante() {
/* 116 */     return this.demandante;
/*     */   }
/*     */   
/*     */   public void setDemandante(String demandante) {
/* 120 */     this.demandante = demandante;
/*     */   }
/*     */   
/*     */   public LocalDateTime getDataMonitoramento() {
/* 124 */     return this.dataMonitoramento;
/*     */   }
/*     */   
/*     */   public void setDataMonitoramento(LocalDateTime dataMonitoramento) {
/* 128 */     this.dataMonitoramento = dataMonitoramento;
/*     */   }
/*     */   
/*     */   public String getFormacao() {
/* 132 */     return this.formacao;
/*     */   }
/*     */   
/*     */   public void setFormacao(String formacao) {
/* 136 */     this.formacao = formacao;
/*     */   }
/*     */   
/*     */   public String getSubMeta() {
/* 140 */     return this.subMeta;
/*     */   }
/*     */   
/*     */   public void setSubMeta(String subMeta) {
/* 144 */     this.subMeta = subMeta;
/*     */   }
/*     */   
/*     */   public String getObservacao() {
/* 148 */     return this.observacao;
/*     */   }
/*     */   
/*     */   public void setObservacao(String observacao) {
/* 152 */     this.observacao = observacao;
/*     */   }
/*     */   
/*     */   public String getDesvioDeFuncao() {
/* 156 */     return this.desvioDeFuncao.equalsIgnoreCase("S") ? "Sim" : "Não";
/*     */   }
/*     */   
/*     */   public void setDesvioDeFuncao(String desvioDeFuncao) {
/* 160 */     this.desvioDeFuncao = desvioDeFuncao;
/*     */   }
/*     */   
/*     */   public String getTipoDesvio() {
/* 164 */     return this.tipoDesvio;
/*     */   }
/*     */   
/*     */   public void setTipoDesvio(String tipoDesvio) {
/* 168 */     this.tipoDesvio = tipoDesvio;
/*     */   }
/*     */   
/*     */   public String getAutonomia() {
/* 172 */     return this.autonomia;
/*     */   }
/*     */   
/*     */   public void setAutonomia(String autonomia) {
/* 176 */     this.autonomia = autonomia;
/*     */   }
/*     */   
/*     */   public String getConhecimento() {
/* 180 */     return this.conhecimento;
/*     */   }
/*     */   
/*     */   public void setConhecimento(String conhecimento) {
/* 184 */     this.conhecimento = conhecimento;
/*     */   }
/*     */   
/*     */   public String getHabilidade() {
/* 188 */     return this.habilidade;
/*     */   }
/*     */   
/*     */   public void setHabilidade(String habilidade) {
/* 192 */     this.habilidade = habilidade;
/*     */   }
/*     */   
/*     */   public String getMotivacao() {
/* 196 */     return this.motivacao;
/*     */   }
/*     */   
/*     */   public void setMotivacao(String motivacao) {
/* 200 */     this.motivacao = motivacao;
/*     */   }
/*     */   
/*     */   public String getPontualidade() {
/* 204 */     return this.pontualidade;
/*     */   }
/*     */   
/*     */   public void setPontualidade(String pontualidade) {
/* 208 */     this.pontualidade = pontualidade;
/*     */   }
/*     */   
/*     */   public String getExperienciaProfissional() {
/* 212 */     return this.experienciaProfissional;
/*     */   }
/*     */   
/*     */   public void setExperienciaProfissional(String experienciaProfissional) {
/* 216 */     this.experienciaProfissional = experienciaProfissional;
/*     */   }
/*     */   
/*     */   public String getAvaliacoes() {
/* 220 */     if (this.avaliacoesQuestionario == null || this.avaliacoesQuestionario.isEmpty())
/* 221 */       return this.avaliacoes; 
/* 222 */     String avaliacoesRealizadas = this.avaliacoesQuestionario.stream().map(n -> n.getFileName()).collect(Collectors.joining(", "));
/* 223 */     return avaliacoesRealizadas;
/*     */   }
/*     */   
/*     */   public void setAvaliacoes(String avaliacoes) {
/* 227 */     this.avaliacoes = avaliacoes;
/*     */   }
/*     */   
/*     */   public String getMonitor() {
/* 231 */     return this.monitor;
/*     */   }
/*     */   
/*     */   public void setMonitor(String monitor) {
/* 235 */     this.monitor = monitor;
/*     */   }
/*     */   
/*     */   public String getLinks() {
/* 239 */     return this.links;
/*     */   }
/*     */   
/*     */   public void setLinks(String links) {
/* 243 */     this.links = links;
/*     */   }
/*     */   
/*     */   public String getPrincipaisRegistros() {
/* 247 */     return this.principaisRegistros;
/*     */   }
/*     */   
/*     */   public void setPrincipaisRegistros(String principaisRegistros) {
/* 251 */     this.principaisRegistros = principaisRegistros;
/*     */   }
/*     */   
/*     */   public Long getIdEgresso() {
/* 255 */     return this.idEgresso;
/*     */   }
/*     */   
/*     */   public void setIdEgresso(Long idEgresso) {
/* 259 */     this.idEgresso = idEgresso;
/*     */   }
/*     */   
/*     */   public LocalDateTime getDataHrMonitoramento() {
/* 263 */     return this.dataHrMonitoramento;
/*     */   }
/*     */   
/*     */   public void setDataHrMonitoramento(LocalDateTime dataHrMonitoramento) {
/* 267 */     this.dataHrMonitoramento = dataHrMonitoramento;
/*     */   }
/*     */   
/*     */   public String getSubMetaKey() {
/* 271 */     return this.subMetaKey;
/*     */   }
/*     */   
/*     */   public void setSubMetaKey(String subMetaKey) {
/* 275 */     this.subMetaKey = subMetaKey;
/*     */   }
/*     */   
/*     */   public List<AvaliacaoDTO> getAvaliacoesDto() {
/* 279 */     return this.avaliacoesDto;
/*     */   }
/*     */   
/*     */   public void setAvaliacoesDto(List<AvaliacaoDTO> avaliacoesDto) {
/* 283 */     this.avaliacoesDto = avaliacoesDto;
/*     */   }
/*     */   
/*     */   public Long getIdComprovacao() {
/* 287 */     return this.idComprovacao;
/*     */   }
/*     */   
/*     */   public void setIdComprovacao(Long idComprovacao) {
/* 291 */     this.idComprovacao = idComprovacao;
/*     */   }
/*     */   
/*     */   public Boolean getPresente() {
/* 295 */     return this.presente;
/*     */   }
/*     */   
/*     */   public void setPresente(Boolean presente) {
/* 299 */     this.presente = presente;
/*     */   }
/*     */   
/*     */   public String getSituacao() {
/* 303 */     return this.situacao;
/*     */   }
/*     */   
/*     */   public void setSituacao(String situacao) {
/* 307 */     this.situacao = situacao;
/*     */   }
/*     */   
/*     */   public String getFileName() {
/* 311 */     return this.fileName;
/*     */   }
/*     */   
/*     */   public void setFileName(String fileName) {
/* 315 */     this.fileName = fileName;
/*     */   }
/*     */   
/*     */   public String getDataRegistro() {
/* 319 */     return DateUtil.formatarData(this.dataMonitoramento, "dd/MM/yyyy");
/*     */   }
/*     */   
/*     */   public String getDataProxRegistro() {
/* 323 */     return DateUtil.formatarData(this.proxMonitoramento, "MM/yyyy");
/*     */   }
/*     */   
/*     */   public String getPresenca() {
/* 327 */     if (this.presente == null || this.presente.booleanValue())
/* 328 */       return "Sim"; 
/* 329 */     return "Não";
/*     */   }
/*     */   
/*     */   public String getComprovacaoName() {
/* 333 */     return this.comprovacaoName;
/*     */   }
/*     */   
/*     */   public void setComprovacaoName(String comprovacaoName) {
/* 337 */     this.comprovacaoName = comprovacaoName;
/*     */   }
/*     */   
/*     */   public List<AvaliacaoQuestionarioDTO> getAvaliacoesQuestionario() {
/* 341 */     return this.avaliacoesQuestionario;
/*     */   }
/*     */   
/*     */   public void setAvaliacoesQuestionario(List<AvaliacaoQuestionarioDTO> avaliacoesQuestionario) {
/* 345 */     this.avaliacoesQuestionario = avaliacoesQuestionario;
/*     */   }
/*     */   
/*     */   public Long getIdMonitor() {
/* 349 */     return this.idMonitor;
/*     */   }
/*     */   
/*     */   public void setIdMonitor(Long idMonitor) {
/* 353 */     this.idMonitor = idMonitor;
/*     */   }
/*     */   
/*     */   public InputStream getAssinatura() {
/* 357 */     return this.assinatura;
/*     */   }
/*     */   
/*     */   public void setAssinatura(InputStream assinatura) {
/* 361 */     this.assinatura = assinatura;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\RelatorioMonitoramentoDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */