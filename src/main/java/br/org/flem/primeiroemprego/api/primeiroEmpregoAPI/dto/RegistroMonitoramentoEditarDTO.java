/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.RespostaTecnica;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Agendamento;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Colaborador;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Comprovacao;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Demandante;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Meta;
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import java.io.Serializable;
/*     */ import java.time.LocalDate;
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
/*     */ public class RegistroMonitoramentoEditarDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1284655151046620199L;
/*     */   private Long id;
/*     */   private String beneficiario;
/*     */   private Long idBeneficiario;
/*     */   @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
/*     */   private LocalDateTime dataMonitoramento;
/*     */   private Colaborador monitorAssociado;
/*     */   private Colaborador monitor;
/*     */   private LocalDate dataProxMonitoramento;
/*     */   private String observacao;
/*     */   private Meta meta;
/*     */   private String links;
/*     */   private String principaisRegistros;
/*     */   private Comprovacao comprovacao;
/*     */   private Municipio municipio;
/*     */   private Demandante demandante;
/*     */   private String unidadeLotacao;
/*     */   private Boolean presente;
/*     */   private Agendamento agendamento;
/*     */   private Long idMunicipio;
/*     */   private String nomeMuniciopio;
/*     */   private Long idDamandante;
/*     */   private String nomeDemandante;
/*     */   private String formacao;
/*     */   private Long idFormacao;
/*     */   private String desvioDeFuncao;
/*     */   private Boolean gravida;
/*     */   private Boolean acidenteDeTrabalho;
/*     */   private RespostaTecnica conhecimento;
/*     */   private RespostaTecnica habilidade;
/*     */   private RespostaTecnica autonomia;
/*     */   private RespostaTecnica pontualidade;
/*     */   private RespostaTecnica motivacao;
/*     */   private RespostaTecnica experienciaProfissional;
/*     */   private String tipoDesvioDeFuncao;
/*     */   private String descricaoDesvioDeFuncao;
/*     */   private String descricaoAcidenteDeTrabalho;
/*     */   private Long idQuestionario;
/*     */   private List<String> pathAvaliacoes;
/*     */   
/*     */   public Long getId() {
/*  68 */     return this.id;
/*     */   }
/*     */   public void setId(Long id) {
/*  71 */     this.id = id;
/*     */   }
/*     */   public String getBeneficiario() {
/*  74 */     return this.beneficiario;
/*     */   }
/*     */   public void setBeneficiario(String beneficiario) {
/*  77 */     this.beneficiario = beneficiario;
/*     */   }
/*     */   public LocalDateTime getDataMonitoramento() {
/*  80 */     return this.dataMonitoramento;
/*     */   }
/*     */   public void setDataMonitoramento(LocalDateTime dataMonitoramento) {
/*  83 */     this.dataMonitoramento = dataMonitoramento;
/*     */   }
/*     */   public Colaborador getMonitorAssociado() {
/*  86 */     return this.monitorAssociado;
/*     */   }
/*     */   public void setMonitorAssociado(Colaborador monitorAssociado) {
/*  89 */     this.monitorAssociado = monitorAssociado;
/*     */   }
/*     */   public Colaborador getMonitor() {
/*  92 */     return this.monitor;
/*     */   }
/*     */   public void setMonitor(Colaborador monitor) {
/*  95 */     this.monitor = monitor;
/*     */   }
/*     */   public LocalDate getDataProxMonitoramento() {
/*  98 */     return this.dataProxMonitoramento;
/*     */   }
/*     */   public void setDataProxMonitoramento(LocalDate dataProxMonitoramento) {
/* 101 */     this.dataProxMonitoramento = dataProxMonitoramento;
/*     */   }
/*     */   public String getObservacao() {
/* 104 */     return this.observacao;
/*     */   }
/*     */   public void setObservacao(String observacao) {
/* 107 */     this.observacao = observacao;
/*     */   }
/*     */   public Meta getMeta() {
/* 110 */     return this.meta;
/*     */   }
/*     */   public void setMeta(Meta meta) {
/* 113 */     this.meta = meta;
/*     */   }
/*     */   public String getLinks() {
/* 116 */     return this.links;
/*     */   }
/*     */   public void setLinks(String links) {
/* 119 */     this.links = links;
/*     */   }
/*     */   public String getPrincipaisRegistros() {
/* 122 */     return this.principaisRegistros;
/*     */   }
/*     */   public void setPrincipaisRegistros(String principaisRegistros) {
/* 125 */     this.principaisRegistros = principaisRegistros;
/*     */   }
/*     */   public Comprovacao getComprovacao() {
/* 128 */     return this.comprovacao;
/*     */   }
/*     */   public void setComprovacao(Comprovacao comprovacao) {
/* 131 */     this.comprovacao = comprovacao;
/*     */   }
/*     */   public Municipio getMunicipio() {
/* 134 */     return this.municipio;
/*     */   }
/*     */   public void setMunicipio(Municipio municipio) {
/* 137 */     this.municipio = municipio;
/*     */   }
/*     */   public Demandante getDemandante() {
/* 140 */     return this.demandante;
/*     */   }
/*     */   public void setDemandante(Demandante demandante) {
/* 143 */     this.demandante = demandante;
/*     */   }
/*     */   public String getUnidadeLotacao() {
/* 146 */     return this.unidadeLotacao;
/*     */   }
/*     */   public void setUnidadeLotacao(String unidadeLotacao) {
/* 149 */     this.unidadeLotacao = unidadeLotacao;
/*     */   }
/*     */   public Boolean getPresente() {
/* 152 */     return this.presente;
/*     */   }
/*     */   public void setPresente(Boolean presente) {
/* 155 */     this.presente = presente;
/*     */   }
/*     */   public Agendamento getAgendamento() {
/* 158 */     return this.agendamento;
/*     */   }
/*     */   public void setAgendamento(Agendamento agendamento) {
/* 161 */     this.agendamento = agendamento;
/*     */   }
/*     */   public Long getIdMunicipio() {
/* 164 */     return this.idMunicipio;
/*     */   }
/*     */   public void setIdMunicipio(Long idMunicipio) {
/* 167 */     this.idMunicipio = idMunicipio;
/*     */   }
/*     */   public String getNomeMuniciopio() {
/* 170 */     return this.nomeMuniciopio;
/*     */   }
/*     */   public void setNomeMuniciopio(String nomeMuniciopio) {
/* 173 */     this.nomeMuniciopio = nomeMuniciopio;
/*     */   }
/*     */   public Long getIdDamandante() {
/* 176 */     return this.idDamandante;
/*     */   }
/*     */   public void setIdDamandante(Long idDamandante) {
/* 179 */     this.idDamandante = idDamandante;
/*     */   }
/*     */   public String getNomeDemandante() {
/* 182 */     return this.nomeDemandante;
/*     */   }
/*     */   public void setNomeDemandante(String nomeDemandante) {
/* 185 */     this.nomeDemandante = nomeDemandante;
/*     */   }
/*     */   public Long getIdBeneficiario() {
/* 188 */     return this.idBeneficiario;
/*     */   }
/*     */   public void setIdBeneficiario(Long idBeneficiario) {
/* 191 */     this.idBeneficiario = idBeneficiario;
/*     */   }
/*     */   public String getFormacao() {
/* 194 */     return this.formacao;
/*     */   }
/*     */   public void setFormacao(String formacao) {
/* 197 */     this.formacao = formacao;
/*     */   }
/*     */   public Long getIdFormacao() {
/* 200 */     return this.idFormacao;
/*     */   }
/*     */   public void setIdFormacao(Long idFormacao) {
/* 203 */     this.idFormacao = idFormacao;
/*     */   }
/*     */   public String getDesvioDeFuncao() {
/* 206 */     return this.desvioDeFuncao;
/*     */   }
/*     */   public void setDesvioDeFuncao(String desvioDeFuncao) {
/* 209 */     this.desvioDeFuncao = desvioDeFuncao;
/*     */   }
/*     */   public Boolean getGravida() {
/* 212 */     return this.gravida;
/*     */   }
/*     */   public void setGravida(Boolean gravida) {
/* 215 */     this.gravida = gravida;
/*     */   }
/*     */   public Boolean getAcidenteDeTrabalho() {
/* 218 */     return this.acidenteDeTrabalho;
/*     */   }
/*     */   public void setAcidenteDeTrabalho(Boolean acidenteDeTrabalho) {
/* 221 */     this.acidenteDeTrabalho = acidenteDeTrabalho;
/*     */   }
/*     */   public RespostaTecnica getConhecimento() {
/* 224 */     return this.conhecimento;
/*     */   }
/*     */   public void setConhecimento(RespostaTecnica conhecimento) {
/* 227 */     this.conhecimento = conhecimento;
/*     */   }
/*     */   public RespostaTecnica getHabilidade() {
/* 230 */     return this.habilidade;
/*     */   }
/*     */   public void setHabilidade(RespostaTecnica habilidade) {
/* 233 */     this.habilidade = habilidade;
/*     */   }
/*     */   public RespostaTecnica getAutonomia() {
/* 236 */     return this.autonomia;
/*     */   }
/*     */   public void setAutonomia(RespostaTecnica autonomia) {
/* 239 */     this.autonomia = autonomia;
/*     */   }
/*     */   public RespostaTecnica getPontualidade() {
/* 242 */     return this.pontualidade;
/*     */   }
/*     */   public void setPontualidade(RespostaTecnica pontualidade) {
/* 245 */     this.pontualidade = pontualidade;
/*     */   }
/*     */   public RespostaTecnica getMotivacao() {
/* 248 */     return this.motivacao;
/*     */   }
/*     */   public void setMotivacao(RespostaTecnica motivacao) {
/* 251 */     this.motivacao = motivacao;
/*     */   }
/*     */   public RespostaTecnica getExperienciaProfissional() {
/* 254 */     return this.experienciaProfissional;
/*     */   }
/*     */   public void setExperienciaProfissional(RespostaTecnica experienciaProfissional) {
/* 257 */     this.experienciaProfissional = experienciaProfissional;
/*     */   }
/*     */   public String getTipoDesvioDeFuncao() {
/* 260 */     return this.tipoDesvioDeFuncao;
/*     */   }
/*     */   public void setTipoDesvioDeFuncao(String tipoDesvioDeFuncao) {
/* 263 */     this.tipoDesvioDeFuncao = tipoDesvioDeFuncao;
/*     */   }
/*     */   public String getDescricaoDesvioDeFuncao() {
/* 266 */     return this.descricaoDesvioDeFuncao;
/*     */   }
/*     */   public void setDescricaoDesvioDeFuncao(String descricaoDesvioDeFuncao) {
/* 269 */     this.descricaoDesvioDeFuncao = descricaoDesvioDeFuncao;
/*     */   }
/*     */   public String getDescricaoAcidenteDeTrabalho() {
/* 272 */     return this.descricaoAcidenteDeTrabalho;
/*     */   }
/*     */   public void setDescricaoAcidenteDeTrabalho(String descricaoAcidenteDeTrabalho) {
/* 275 */     this.descricaoAcidenteDeTrabalho = descricaoAcidenteDeTrabalho;
/*     */   }
/*     */   public Long getIdQuestionario() {
/* 278 */     return this.idQuestionario;
/*     */   }
/*     */   public void setIdQuestionario(Long idQuestionario) {
/* 281 */     this.idQuestionario = idQuestionario;
/*     */   }
/*     */   public List<String> getPathAvaliacoes() {
/* 284 */     return this.pathAvaliacoes;
/*     */   }
/*     */   public void setPathAvaliacoes(List<String> pathAvaliacoes) {
/* 287 */     this.pathAvaliacoes = pathAvaliacoes;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\RegistroMonitoramentoEditarDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */