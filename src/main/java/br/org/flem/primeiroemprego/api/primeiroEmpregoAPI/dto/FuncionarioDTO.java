/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;

/*     */ import java.io.Serializable;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FuncionarioDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -7344542697978898995L;
/*     */   private Long idFuncionario;
/*     */   private String nomeFuncionario;
/*     */   private Long idDemandante;
/*     */   private String nomeDemandante;
/*     */   private String siglaDemandante;
/*     */   private Long idMunicipio;
/*     */   private String nomeMunicipio;
/*     */   private String cpf;
/*     */   @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
/*     */   private LocalDateTime dataMonitoramento;
/*     */   @JsonFormat(pattern = "dd/MM/yyyy")
/*     */   private Date dataAdmissao;
/*     */   @JsonFormat(pattern = "dd/MM/yyyy")
/*     */   private Date dataDesligamento;
/*     */   private String matricula;
/*     */   private String unidadeLotacao;
/*     */   private String pontoFocalNaUnidade;
/*     */   private String emailPontoFocal;
/*     */   private String formacao;
/*     */   private String sexo;
/*     */   private String sexoDescricao;
/*     */   private String status;
/*     */   private Long idStatus;
/*  41 */   private String aptoParaMonitoramento = "Não";
/*  42 */   private String aptoParaAvaliacao = "Não";
/*     */   
/*     */   private String statusVisitaBeneficiario;
/*     */ 
/*     */   
/*     */   public FuncionarioDTO() {}
/*     */   
/*     */   public FuncionarioDTO(Long idFuncionario, String nomeFuncionario, String formacao) {
/*  50 */     this.idFuncionario = idFuncionario;
/*  51 */     this.nomeFuncionario = nomeFuncionario;
/*  52 */     this.formacao = formacao;
/*     */   }
/*     */ 
/*     */   
/*     */   public FuncionarioDTO(Long idFuncionario, String nomeFuncionario, String formacao, Date dataAdmissao, String matricula, String cpf, String sexo, Long idDemandante, String nomeDemandante, String siglaDemandante, Long idMunicipio, String nomeMunicipio, String unidadeLotacao, String status, String pontoFocalNaUnidade, String emailPontoFocal) {
/*  57 */     this.idFuncionario = idFuncionario;
/*  58 */     this.nomeFuncionario = nomeFuncionario;
/*  59 */     this.idDemandante = idDemandante;
/*  60 */     this.nomeDemandante = nomeDemandante;
/*  61 */     this.siglaDemandante = siglaDemandante;
/*  62 */     this.idMunicipio = idMunicipio;
/*  63 */     this.nomeMunicipio = nomeMunicipio;
/*  64 */     this.cpf = cpf;
/*  65 */     this.dataAdmissao = dataAdmissao;
/*  66 */     this.matricula = matricula;
/*  67 */     this.unidadeLotacao = unidadeLotacao;
/*  68 */     this.formacao = formacao;
/*  69 */     this.sexo = sexo;
/*  70 */     this.status = status;
/*  71 */     this.pontoFocalNaUnidade = pontoFocalNaUnidade;
/*  72 */     this.emailPontoFocal = emailPontoFocal;
/*     */   }
/*     */   
/*     */   public Long getIdFuncionario() {
/*  76 */     return this.idFuncionario;
/*     */   }
/*     */   
/*     */   public void setIdFuncionario(Long idFuncionario) {
/*  80 */     this.idFuncionario = idFuncionario;
/*     */   }
/*     */   
/*     */   public String getNomeFuncionario() {
/*  84 */     return this.nomeFuncionario;
/*     */   }
/*     */   
/*     */   public void setNomeFuncionario(String nomeFuncionario) {
/*  88 */     
			this.nomeFuncionario = nomeFuncionario;
/*     */   }
/*     */   
/*     */   public Long getIdDemandante() {
/*  92 */     return this.idDemandante;
/*     */   }
/*     */   
/*     */   public void setIdDemandante(Long idDemandante) {
/*  96 */     this.idDemandante = idDemandante;
/*     */   }
/*     */   
/*     */   public String getNomeDemandante() {
/* 100 */     return this.nomeDemandante;
/*     */   }
/*     */   
/*     */   public void setNomeDemandante(String nomeDemandante) {
/* 104 */     this.nomeDemandante = nomeDemandante;
/*     */   }
/*     */   
/*     */   public String getSiglaDemandante() {
/* 108 */     return this.siglaDemandante;
/*     */   }
/*     */   
/*     */   public void setSiglaDemandante(String siglaDemandante) {
/* 112 */     this.siglaDemandante = siglaDemandante;
/*     */   }
/*     */   
/*     */   public Long getIdMunicipio() {
/* 116 */     return this.idMunicipio;
/*     */   }
/*     */   
/*     */   public void setIdMunicipio(Long idMunicipio) {
/* 120 */     this.idMunicipio = idMunicipio;
/*     */   }
/*     */   
/*     */   public String getNomeMunicipio() {
/* 124 */     return this.nomeMunicipio;
/*     */   }
/*     */   
/*     */   public void setNomeMunicipio(String nomeMunicipio) {
/* 128 */     this.nomeMunicipio = nomeMunicipio;
/*     */   }
/*     */   
/*     */   public String getCpf() {
/* 132 */     return this.cpf;
/*     */   }
/*     */   
/*     */   public void setCpf(String cpf) {
/* 136 */     this.cpf = cpf;
/*     */   }
/*     */   
/*     */   public LocalDateTime getDataMonitoramento() {
/* 140 */     return this.dataMonitoramento;
/*     */   }
/*     */   
/*     */   public void setDataMonitoramento(LocalDateTime dataMonitoramento) {
/* 144 */     this.dataMonitoramento = dataMonitoramento;
/*     */   }
/*     */   
/*     */   public Date getDataAdmissao() {
/* 148 */     return this.dataAdmissao;
/*     */   }
/*     */   
/*     */   public void setDataAdmissao(Date dataAdmissao) {
/* 152 */     this.dataAdmissao = dataAdmissao;
/*     */   }
/*     */   
/*     */   public String getMatricula() {
/* 156 */     return this.matricula;
/*     */   }
/*     */   
/*     */   public void setMatricula(String matricula) {
/* 160 */     this.matricula = matricula;
/*     */   }
/*     */   
/*     */   public String getUnidadeLotacao() {
/* 164 */     return this.unidadeLotacao;
/*     */   }
/*     */   
/*     */   public void setUnidadeLotacao(String unidadeLotacao) {
/* 168 */     this.unidadeLotacao = unidadeLotacao;
/*     */   }
/*     */   
/*     */   public String getFormacao() {
/* 172 */     return this.formacao;
/*     */   }
/*     */   
/*     */   public void setFormacao(String formacao) {
/* 176 */     this.formacao = formacao;
/*     */   }
/*     */   
/*     */   public String getSexo() {
/* 180 */     return this.sexo;
/*     */   }
/*     */   
/*     */   public void setSexo(String sexo) {
/* 184 */     this.sexo = sexo;
/*     */   }
/*     */   
/*     */   public String getStatus() {
/* 188 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status) {
/* 192 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getSexoDescricao() {
/* 196 */     return this.sexoDescricao;
/*     */   }
/*     */   
/*     */   public void setSexoDescricao(String sexoDescricao) {
/* 200 */     this.sexoDescricao = sexoDescricao;
/*     */   }
/*     */   
/*     */   public String getAptoParaMonitoramento() {
/* 204 */     return this.aptoParaMonitoramento;
/*     */   }
/*     */   
/*     */   public void setAptoParaMonitoramento(String aptoParaMonitoramento) {
/* 208 */     this.aptoParaMonitoramento = aptoParaMonitoramento;
/*     */   }
/*     */   
/*     */   public String getAptoParaAvaliacao() {
/* 212 */     return this.aptoParaAvaliacao;
/*     */   }
/*     */   
/*     */   public void setAptoParaAvaliacao(String aptoParaAvaliacao) {
/* 216 */     this.aptoParaAvaliacao = aptoParaAvaliacao;
/*     */   }
/*     */   
/*     */   public Date getDataDesligamento() {
/* 220 */     return this.dataDesligamento;
/*     */   }
/*     */   
/*     */   public void setDataDesligamento(Date dataDesligamento) {
/* 224 */     this.dataDesligamento = dataDesligamento;
/*     */   }
/*     */   
/*     */   public String getPontoFocalNaUnidade() {
/* 228 */     return this.pontoFocalNaUnidade;
/*     */   }
/*     */   
/*     */   public void setPontoFocalNaUnidade(String pontoFocalNaUnidade) {
/* 232 */     this.pontoFocalNaUnidade = pontoFocalNaUnidade;
/*     */   }
/*     */   
/*     */   public String getEmailPontoFocal() {
/* 236 */     return this.emailPontoFocal;
/*     */   }
/*     */   
/*     */   public void setEmailPontoFocal(String emailPontoFocal) {
/* 240 */     this.emailPontoFocal = emailPontoFocal;
/*     */   }
/*     */   
/*     */   public Long getIdStatus() {
/* 244 */     return this.idStatus;
/*     */   }
/*     */   
/*     */   public void setIdStatus(Long idStatus) {
/* 248 */     this.idStatus = idStatus;
/*     */   }
/*     */   
/*     */   public String getStatusVisitaBeneficiario() {
/* 252 */     return this.statusVisitaBeneficiario;
/*     */   }
/*     */   
/*     */   public void setStatusVisitaBeneficiario(String statusVisitaBeneficiario) {
/* 256 */     this.statusVisitaBeneficiario = statusVisitaBeneficiario;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\dto\FuncionarioDTO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */