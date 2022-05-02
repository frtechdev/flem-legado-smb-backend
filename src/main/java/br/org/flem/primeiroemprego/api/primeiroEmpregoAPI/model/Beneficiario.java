package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Type;

/**
 *
 * @author tscortes
 */
@Entity
@Table(name = "Egresso")
public class Beneficiario implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3397765279960663181L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_egresso")
    private Long id;

    private String nome;
    @Column(name = "matriculaflem")
    private String matriculaFlem;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datanascimento")
    private Date dataNascimento;
    private String cpf;
    private String ctps;
    private String pis;

    @Column(name = "dddtelefone1")
    private String dddTelefone1;
    private String telefone1;
    @Column(name = "dddtelefone2")
    private String dddTelefone2;
    private String telefone2;
    private String dddCelular;
    private String celular;
    @Column(name = "dddcontato")
    private String dddContato;
    private String contato;
    @Column(name = "emailparticular")
    private String emailParticular;
    @Column(name = "emailsecundario")
    private String emailSecundario;
    private String sexo;

    @Type(type = "text")
    private String observacao;

    @OneToMany(mappedBy = "beneficiario")
    private Set<RegistroMonitoramento> monitoramento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataadmissao")
    private Date dataAdmissao;

    @ManyToOne
    @JoinColumn(name = "id_formacao")
    private Formacao formacao;
    @OneToOne(mappedBy = "egresso")
    private Vaga vaga;

    @OneToMany(mappedBy = "beneficiario")
    private Set<Agendamento> agendamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatriculaFlem() {
        return matriculaFlem;
    }

    public void setMatriculaFlem(String matriculaFlem) {
        this.matriculaFlem = matriculaFlem;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getDddTelefone1() {
        return dddTelefone1;
    }

    public void setDddTelefone1(String dddTelefone1) {
        this.dddTelefone1 = dddTelefone1;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getDddTelefone2() {
        return dddTelefone2;
    }

    public void setDddTelefone2(String dddTelefone2) {
        this.dddTelefone2 = dddTelefone2;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getDddCelular() {
        return dddCelular;
    }

    public void setDddCelular(String dddCelular) {
        this.dddCelular = dddCelular;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDddContato() {
        return dddContato;
    }

    public void setDddContato(String dddContato) {
        this.dddContato = dddContato;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmailParticular() {
        return emailParticular;
    }

    public void setEmailParticular(String emailParticular) {
        this.emailParticular = emailParticular;
    }

    public String getEmailSecundario() {
        return emailSecundario;
    }

    public void setEmailSecundario(String emailSecundario) {
        this.emailSecundario = emailSecundario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Set<RegistroMonitoramento> getMonitoramento() {
        return monitoramento;
    }

    public void setMonitoramento(Set<RegistroMonitoramento> monitoramento) {
        this.monitoramento = monitoramento;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Formacao getFormacao() {
        return formacao;
    }

    public void setFormacao(Formacao formacao) {
        this.formacao = formacao;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Set<Agendamento> getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Set<Agendamento> agendamento) {
        this.agendamento = agendamento;
    }

}
