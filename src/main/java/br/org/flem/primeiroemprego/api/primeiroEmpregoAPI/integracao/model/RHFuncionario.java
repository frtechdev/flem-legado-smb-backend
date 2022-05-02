/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.integracao.model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import org.hibernate.annotations.Immutable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Immutable
/*     */ @Table(name = "rh_funcionario")
/*     */ public class RHFuncionario
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name = "func_matricula")
/*     */   private Integer matricula;
/*     */   @Column(name = "func_nome")
/*     */   private String nome;
/*     */   @Column(name = "func_cpf")
/*     */   private String cpf;
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   @Column(name = "func_nascimento", columnDefinition = "date")
/*     */   private Date dtNascimento;
/*     */   @Column(name = "func_sexo")
/*     */   private String sexo;
/*     */   @Column(name = "func_id_municipio_residencia")
/*     */   private Long idMunicipioResidencia;
/*     */   @Column(name = "func_municipio_residencia")
/*     */   private String municipioResidencia;
/*     */   @Column(name = "func_uf")
/*     */   private String uf;
/*     */   @Column(name = "func_endereco")
/*     */   private String endereco;
/*     */   @Column(name = "func_identidade")
/*     */   private String identidade;
/*     */   @Column(name = "func_escolaridade")
/*     */   private String escolaridade;
/*     */   @Column(name = "func_estado_civil")
/*     */   private String estadoCivil;
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   @Column(name = "func_admissao", columnDefinition = "date")
/*     */   private Date admissao;
/*     */   @Column(name = "func_cargo")
/*     */   private String cargo;
/*     */   @Column(name = "func_departamento")
/*     */   private String departamento;
/*     */   @Column(name = "func_id_departamento")
/*     */   private Integer idDepartamento;
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   @Column(name = "func_desligamento", columnDefinition = "date")
/*     */   private Date desligamento;
/*     */   @Column(name = "func_email")
/*     */   private String email;
/*     */   @Column(name = "func_email_alternativo")
/*     */   private String emailAlternativo;
/*     */   @Column(name = "func_situacao")
/*     */   private String situacao;
/*     */   @Column(name = "func_id_situacao")
/*     */   private Long idSituacao;
/*     */   
/*     */   public Integer getMatricula() {
/*  71 */     return this.matricula;
/*     */   }
/*     */   
/*     */   public void setMatricula(Integer matricula) {
/*  75 */     this.matricula = matricula;
/*     */   }
/*     */   
/*     */   public String getNome() {
/*  79 */     return this.nome;
/*     */   }
/*     */   
/*     */   public void setNome(String nome) {
/*  83 */     this.nome = nome;
/*     */   }
/*     */   
/*     */   public String getCpf() {
/*  87 */     return this.cpf;
/*     */   }
/*     */   
/*     */   public void setCpf(String cpf) {
/*  91 */     this.cpf = cpf;
/*     */   }
/*     */   
/*     */   public Date getDtNascimento() {
/*  95 */     return this.dtNascimento;
/*     */   }
/*     */   
/*     */   public void setDtNascimento(Date dtNascimento) {
/*  99 */     this.dtNascimento = dtNascimento;
/*     */   }
/*     */   
/*     */   public String getSexo() {
/* 103 */     return this.sexo;
/*     */   }
/*     */   
/*     */   public void setSexo(String sexo) {
/* 107 */     this.sexo = sexo;
/*     */   }
/*     */   
/*     */   public Long getIdMunicipioResidencia() {
/* 111 */     return this.idMunicipioResidencia;
/*     */   }
/*     */   
/*     */   public void setIdMunicipioResidencia(Long idMunicipioResidencia) {
/* 115 */     this.idMunicipioResidencia = idMunicipioResidencia;
/*     */   }
/*     */   
/*     */   public String getMunicipioResidencia() {
/* 119 */     return this.municipioResidencia;
/*     */   }
/*     */   
/*     */   public void setMunicipioResidencia(String municipioResidencia) {
/* 123 */     this.municipioResidencia = municipioResidencia;
/*     */   }
/*     */   
/*     */   public String getUf() {
/* 127 */     return this.uf;
/*     */   }
/*     */   
/*     */   public void setUf(String uf) {
/* 131 */     this.uf = uf;
/*     */   }
/*     */   
/*     */   public String getEndereco() {
/* 135 */     return this.endereco;
/*     */   }
/*     */   
/*     */   public void setEndereco(String endereco) {
/* 139 */     this.endereco = endereco;
/*     */   }
/*     */   
/*     */   public String getIdentidade() {
/* 143 */     return this.identidade;
/*     */   }
/*     */   
/*     */   public void setIdentidade(String identidade) {
/* 147 */     this.identidade = identidade;
/*     */   }
/*     */   
/*     */   public String getEscolaridade() {
/* 151 */     return this.escolaridade;
/*     */   }
/*     */   
/*     */   public void setEscolaridade(String escolaridade) {
/* 155 */     this.escolaridade = escolaridade;
/*     */   }
/*     */   
/*     */   public String getEstadoCivil() {
/* 159 */     return this.estadoCivil;
/*     */   }
/*     */   
/*     */   public void setEstadoCivil(String estadoCivil) {
/* 163 */     this.estadoCivil = estadoCivil;
/*     */   }
/*     */   
/*     */   public Date getAdmissao() {
/* 167 */     return this.admissao;
/*     */   }
/*     */   
/*     */   public void setAdmissao(Date admissao) {
/* 171 */     this.admissao = admissao;
/*     */   }
/*     */   
/*     */   public String getCargo() {
/* 175 */     return this.cargo;
/*     */   }
/*     */   
/*     */   public void setCargo(String cargo) {
/* 179 */     this.cargo = cargo;
/*     */   }
/*     */   
/*     */   public String getDepartamento() {
/* 183 */     return this.departamento;
/*     */   }
/*     */   
/*     */   public void setDepartamento(String departamento) {
/* 187 */     this.departamento = departamento;
/*     */   }
/*     */   
/*     */   public Date getDesligamento() {
/* 191 */     return this.desligamento;
/*     */   }
/*     */   
/*     */   public void setDesligamento(Date desligamento) {
/* 195 */     this.desligamento = desligamento;
/*     */   }
/*     */   
/*     */   public String getEmail() {
/* 199 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/* 203 */     this.email = email;
/*     */   }
/*     */   
/*     */   public String getEmailAlternativo() {
/* 207 */     return this.emailAlternativo;
/*     */   }
/*     */   
/*     */   public void setEmailAlternativo(String emailAlternativo) {
/* 211 */     this.emailAlternativo = emailAlternativo;
/*     */   }
/*     */   
/*     */   public String getSituacao() {
/* 215 */     return this.situacao;
/*     */   }
/*     */   
/*     */   public void setSituacao(String situacao) {
/* 219 */     this.situacao = situacao;
/*     */   }
/*     */   
/*     */   public Integer getIdDepartamento() {
/* 223 */     return this.idDepartamento;
/*     */   }
/*     */   
/*     */   public void setIdDepartamento(Integer idDepartamento) {
/* 227 */     this.idDepartamento = idDepartamento;
/*     */   }
/*     */   
/*     */   public Long getIdSituacao() {
/* 231 */     return this.idSituacao;
/*     */   }
/*     */   
/*     */   public void setIdSituacao(Long idSituacao) {
/* 235 */     this.idSituacao = idSituacao;
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\integracao\model\RHFuncionario.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */