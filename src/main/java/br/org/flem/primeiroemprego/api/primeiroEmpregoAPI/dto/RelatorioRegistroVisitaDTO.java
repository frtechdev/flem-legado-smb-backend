/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.RespostaTecnica;
/*     */ import java.time.LocalDate;
/*     */ import java.time.LocalDateTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RelatorioRegistroVisitaDTO
/*     */ {
/*     */   private Long id;
/*     */   private Long idEgresso;
/*     */   private String municipio;
/*     */   private LocalDateTime dataMonitoramento;
/*     */   private LocalDate proxMonitoramento;
/*     */   private String demandante;
/*     */   private String unidadeDeLotacao;
/*     */   private String nomeEgresso;
/*     */   private String formacao;
/*     */   private Long subMeta;
/*     */   private String observacao;
/*     */   private String desvioDeFuncao;
/*     */   private String tipoDesvio;
/*     */   private RespostaTecnica autonomia;
/*     */   private RespostaTecnica conhecimento;
/*     */   private RespostaTecnica habilidade;
/*     */   private RespostaTecnica motivacao;
/*     */   private RespostaTecnica pontualidade;
/*     */   private RespostaTecnica experienciaProfissional;
/*     */   private String links;
/*     */   private String principaisRegistros;
/*     */   private Long monitor;
/*     */   private Boolean presente;
/*     */   private Long idComprovacao;
/*     */   private String fileName;
/*     */   private String autonomiaStr;
/*     */   private String conhecimentoStr;
/*     */   private String habilidadeStr;
/*     */   private String motivacaoStr;
/*     */   private String pontualidadeStr;
/*     */   private String experienciaProfissionalStr;
/*     */   
/*     */   public RelatorioRegistroVisitaDTO(Long id, Long idEgresso, String municipio, LocalDateTime dataMonitoramento, LocalDate proxMonitoramento, String demandante, String unidadeDeLotacao, String nomeEgresso, String formacao, Long subMeta, String observacao, String desvioDeFuncao, String tipoDesvio, RespostaTecnica autonomia, RespostaTecnica conhecimento, RespostaTecnica habilidade, RespostaTecnica motivacao, RespostaTecnica pontualidade, RespostaTecnica experienciaProfissional, String links, String principaisRegistros, Long monitor, Boolean presente, Long idComprovacao, String fileName) {
/*  47 */     this.id = id;
/*  48 */     this.idEgresso = idEgresso;
/*  49 */     this.municipio = municipio;
/*  50 */     this.dataMonitoramento = dataMonitoramento;
/*  51 */     this.proxMonitoramento = proxMonitoramento;
/*  52 */     this.demandante = demandante;
/*  53 */     this.unidadeDeLotacao = unidadeDeLotacao;
/*  54 */     this.nomeEgresso = nomeEgresso;
/*  55 */     this.formacao = formacao;
/*  56 */     this.subMeta = subMeta;
/*  57 */     this.observacao = observacao;
/*  58 */     this.desvioDeFuncao = desvioDeFuncao;
/*  59 */     this.tipoDesvio = tipoDesvio;
/*  60 */     this.autonomia = autonomia;
/*  61 */     this.conhecimento = conhecimento;
/*  62 */     this.habilidade = habilidade;
/*  63 */     this.motivacao = motivacao;
/*  64 */     this.pontualidade = pontualidade;
/*  65 */     this.experienciaProfissional = experienciaProfissional;
/*  66 */     this.links = links;
/*  67 */     this.principaisRegistros = principaisRegistros;
/*  68 */     this.monitor = monitor;
/*  69 */     this.presente = presente;
/*  70 */     this.idComprovacao = idComprovacao;
/*  71 */     this.fileName = fileName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RelatorioRegistroVisitaDTO() {}
/*     */ 
/*     */   
/*     */   public Long getId() {
/*  80 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/*  84 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Long getIdEgresso() {
/*  88 */     return this.idEgresso;
/*     */   }
/*     */   
/*     */   public void setIdEgresso(Long idEgresso) {
/*  92 */     this.idEgresso = idEgresso;
/*     */   }
/*     */   
/*     */   public String getMunicipio() {
/*  96 */     return this.municipio;
/*     */   }
/*     */   
/*     */   public void setMunicipio(String municipio) {
/* 100 */     this.municipio = municipio;
/*     */   }
/*     */   
/*     */   public LocalDateTime getDataMonitoramento() {
/* 104 */     return this.dataMonitoramento;
/*     */   }
/*     */   
/*     */   public void setDataMonitoramento(LocalDateTime dataMonitoramento) {
/* 108 */     this.dataMonitoramento = dataMonitoramento;
/*     */   }
/*     */   
/*     */   public LocalDate getProxMonitoramento() {
/* 112 */     return this.proxMonitoramento;
/*     */   }
/*     */   
/*     */   public void setProxMonitoramento(LocalDate proxMonitoramento) {
/* 116 */     this.proxMonitoramento = proxMonitoramento;
/*     */   }
/*     */   
/*     */   public String getDemandante() {
/* 120 */     return this.demandante;
/*     */   }
/*     */   
/*     */   public void setDemandante(String demandante) {
/* 124 */     this.demandante = demandante;
/*     */   }
/*     */   
/*     */   public String getUnidadeDeLotacao() {
/* 128 */     return this.unidadeDeLotacao;
/*     */   }
/*     */   
/*     */   public void setUnidadeDeLotacao(String unidadeDeLotacao) {
/* 132 */     this.unidadeDeLotacao = unidadeDeLotacao;
/*     */   }
/*     */   
/*     */   public String getNomeEgresso() {
/* 136 */     return this.nomeEgresso;
/*     */   }
/*     */   
/*     */   public void setNomeEgresso(String nomeEgresso) {
/* 140 */     this.nomeEgresso = nomeEgresso;
/*     */   }
/*     */   
/*     */   public String getFormacao() {
/* 144 */     return this.formacao;
/*     */   }
/*     */   
/*     */   public void setFormacao(String formacao) {
/* 148 */     this.formacao = formacao;
/*     */   }
/*     */   
/*     */   public Long getSubMeta() {
/* 152 */     return this.subMeta;
/*     */   }
/*     */   
/*     */   public void setSubMeta(Long subMeta) {
/* 156 */     this.subMeta = subMeta;
/*     */   }
/*     */   
/*     */   public String getObservacao() {
/* 160 */     return this.observacao;
/*     */   }
/*     */   
/*     */   public void setObservacao(String observacao) {
/* 164 */     this.observacao = observacao;
/*     */   }
/*     */   
/*     */   public String getDesvioDeFuncao() {
/* 168 */     return this.desvioDeFuncao;
/*     */   }
/*     */   
/*     */   public void setDesvioDeFuncao(String desvioDeFuncao) {
/* 172 */     this.desvioDeFuncao = desvioDeFuncao;
/*     */   }
/*     */   
/*     */   public String getTipoDesvio() {
/* 176 */     return this.tipoDesvio;
/*     */   }
/*     */   
/*     */   public void setTipoDesvio(String tipoDesvio) {
/* 180 */     this.tipoDesvio = tipoDesvio;
/*     */   }
/*     */   
/*     */   public RespostaTecnica getAutonomia() {
/* 184 */     return this.autonomia;
/*     */   }
/*     */   
/*     */   public void setAutonomia(RespostaTecnica autonomia) {
/* 188 */     this.autonomia = autonomia;
/*     */   }
/*     */   
/*     */   public RespostaTecnica getConhecimento() {
/* 192 */     return this.conhecimento;
/*     */   }
/*     */   
/*     */   public void setConhecimento(RespostaTecnica conhecimento) {
/* 196 */     this.conhecimento = conhecimento;
/*     */   }
/*     */   
/*     */   public RespostaTecnica getHabilidade() {
/* 200 */     return this.habilidade;
/*     */   }
/*     */   
/*     */   public void setHabilidade(RespostaTecnica habilidade) {
/* 204 */     this.habilidade = habilidade;
/*     */   }
/*     */   
/*     */   public RespostaTecnica getMotivacao() {
/* 208 */     return this.motivacao;
/*     */   }
/*     */   
/*     */   public void setMotivacao(RespostaTecnica motivacao) {
/* 212 */     this.motivacao = motivacao;
/*     */   }
/*     */   
/*     */   public RespostaTecnica getPontualidade() {
/* 216 */     return this.pontualidade;
/*     */   }
/*     */   
/*     */   public void setPontualidade(RespostaTecnica pontualidade) {
/* 220 */     this.pontualidade = pontualidade;
/*     */   }
/*     */   
/*     */   public String getExperienciaProfissional() {
/* 224 */     return this.experienciaProfissional.toString();
/*     */   }
/*     */   
/*     */   public void setExperienciaProfissional(RespostaTecnica experienciaProfissional) {
/* 228 */     this.experienciaProfissional = experienciaProfissional;
/*     */   }
/*     */   
/*     */   public String getLinks() {
/* 232 */     return this.links;
/*     */   }
/*     */   
/*     */   public void setLinks(String links) {
/* 236 */     this.links = links;
/*     */   }
/*     */   
/*     */   public String getPrincipaisRegistros() {
/* 240 */     return this.principaisRegistros;
/*     */   }
/*     */   
/*     */   public void setPrincipaisRegistros(String principaisRegistros) {
/* 244 */     this.principaisRegistros = principaisRegistros;
/*     */   }
/*     */   
/*     */   public Long getMonitor() {
/* 248 */     return this.monitor;
/*     */   }
/*     */   
/*     */   public void setMonitor(Long monitor) {
/* 252 */     this.monitor = monitor;
/*     */   }
/*     */   
/*     */   public Boolean getPresente() {
/* 256 */     return this.presente;
/*     */   }
/*     */   
/*     */   public void setPresente(Boolean presente) {
/* 260 */     this.presente = presente;
/*     */   }
/*     */   
/*     */   public Long getIdComprovacao() {
/* 264 */     return this.idComprovacao;
/*     */   }
/*     */   
/*     */   public void setIdComprovacao(Long idComprovacao) {
/* 268 */     this.idComprovacao = idComprovacao;
/*     */   }
/*     */   
/*     */   public String getFileName() {
/* 272 */     return this.fileName;
/*     */   }
/*     */   
/*     */   public void setFileName(String fileName) {
/* 276 */     this.fileName = fileName;
/*     */   }
/*     */   
/*     */   public String getAutonomiaStr() {
/* 280 */     return getString(this.autonomia);
/*     */   }
/*     */   
/*     */   public String getConhecimentoStr() {
/* 284 */     return getString(this.conhecimento);
/*     */   }
/*     */   
/*     */   public String getExperienciaProfissionalStr() {
/* 288 */     return getString(this.experienciaProfissional);
/*     */   }
/*     */   
/*     */   public String getHabilidadeStr() {
/* 292 */     return getString(this.habilidade);
/*     */   }
/*     */   
/*     */   public String getMotivacaoStr() {
/* 296 */     return getString(this.motivacao);
/*     */   }
/*     */   
/*     */   public String getPontualidadeStr() {
/* 300 */     return getString(this.pontualidade);
/*     */   }
/*     */ 
/*     */   
/*     */   private String getString(RespostaTecnica resposta) {
/* 305 */     if (resposta == null)
/* 306 */       return ""; 
/* 307 */     return resposta.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\RelatorioRegistroVisitaDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */