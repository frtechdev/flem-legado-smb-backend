/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
/*     */ import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/*     */ import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
/*     */ import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
/*     */ import java.io.Serializable;
/*     */ import java.time.LocalDateTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MonitorarDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -434538718745889009L;
/*     */   private Long id;
/*     */   private Long idBeneficiario;
/*     */   @JsonSerialize(using = LocalDateTimeSerializer.class)
/*     */   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
/*     */   @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
/*     */   private LocalDateTime dataMonitoramento;
/*     */   private String observacao;
/*     */   private String principaisRegistros;
/*     */   private QuestionarioDTO questionario;
/*     */   private String subMetaSelecionada;
/*     */   private Long idMeta;
/*     */   private Long idQuestionario;
/*     */   private String links;
/*  34 */   private Boolean presente = Boolean.TRUE;
/*     */ 
/*     */   
/*     */   public Long getIdBeneficiario() {
/*  38 */     return this.idBeneficiario;
/*     */   }
/*     */   
/*     */   public void setIdBeneficiario(Long idBeneficiario) {
/*  42 */     this.idBeneficiario = idBeneficiario;
/*     */   }
/*     */   
/*     */   public LocalDateTime getDataMonitoramento() {
/*  46 */     return this.dataMonitoramento;
/*     */   }
/*     */   
/*     */   public void setDataMonitoramento(LocalDateTime dataMonitoramento) {
/*  50 */     this.dataMonitoramento = dataMonitoramento;
/*     */   }
/*     */   
/*     */   public String getObservacao() {
/*  54 */     return this.observacao;
/*     */   }
/*     */   
/*     */   public void setObservacao(String observacao) {
/*  58 */     this.observacao = observacao;
/*     */   }
/*     */   
/*     */   public QuestionarioDTO getQuestionario() {
/*  62 */     return this.questionario;
/*     */   }
/*     */   
/*     */   public void setQuestionario(QuestionarioDTO questionario) {
/*  66 */     this.questionario = questionario;
/*     */   }
/*     */   
/*     */   public String getSubMetaSelecionada() {
/*  70 */     return this.subMetaSelecionada;
/*     */   }
/*     */   
/*     */   public void setSubMetaSelecionada(String subMetaSelecionada) {
/*  74 */     this.subMetaSelecionada = subMetaSelecionada;
/*     */   }
/*     */   
/*     */   public String getLinks() {
/*  78 */     return this.links;
/*     */   }
/*     */   
/*     */   public void setLinks(String links) {
/*  82 */     this.links = links;
/*     */   }
/*     */   
/*     */   public String getPrincipaisRegistros() {
/*  86 */     return this.principaisRegistros;
/*     */   }
/*     */   
/*     */   public void setPrincipaisRegistros(String principaisRegistros) {
/*  90 */     this.principaisRegistros = principaisRegistros;
/*     */   }
/*     */   
/*     */   public Boolean getPresente() {
/*  94 */     return this.presente;
/*     */   }
/*     */   
/*     */   public void setPresente(Boolean presente) {
/*  98 */     this.presente = presente;
/*     */   }
/*     */   
/*     */   public Long getIdMeta() {
/* 102 */     return this.idMeta;
/*     */   }
/*     */   
/*     */   public void setIdMeta(Long idMeta) {
/* 106 */     this.idMeta = idMeta;
/*     */   }
/*     */   
/*     */   public Long getId() {
/* 110 */     return this.id;
/*     */   }
/*     */   
/*     */   public void setId(Long id) {
/* 114 */     this.id = id;
/*     */   }
/*     */   
/*     */   public Long getIdQuestionario() {
/* 118 */     return this.idQuestionario;
/*     */   }
/*     */   
/*     */   public void setIdQuestionario(Long idQuestionario) {
/* 122 */     this.idQuestionario = idQuestionario;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\MonitorarDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */