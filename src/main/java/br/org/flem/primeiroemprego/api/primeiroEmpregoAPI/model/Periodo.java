package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.AuditOverrides;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseEntityAudited;

/**
 *
 * @author tscortes
 */
@AuditOverrides({ @AuditOverride(forClass = Periodo.class), @AuditOverride(forClass = BaseEntityAudited.class) })
@Entity
@Table(name = "periodos")
public class Periodo extends BaseEntityAudited<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6102382241446809700L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo = "TRIMESTRE";
	private Short ordem;
	private String nome;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	private Integer mesInicio;
	private Integer mesFim;
	private Integer diaReferencia;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Short getOrdem() 
	{
		return ordem;
	}

	public void setOrdem(Short ordem) {
		this.ordem = ordem;
	}

	public Integer getMesInicio() {
		return mesInicio;
	}

	public void setMesInicio(Integer mesInicio) {
		this.mesInicio = mesInicio;
	}

	public Integer getMesFim() {
		return mesFim;
	}

	public void setMesFim(Integer mesFim) {
		this.mesFim = mesFim;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getDiaReferencia() {
		return diaReferencia;
	}

	public void setDiaReferencia(Integer diaReferencia) {
		this.diaReferencia = diaReferencia;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 59 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Periodo other = (Periodo) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

}
