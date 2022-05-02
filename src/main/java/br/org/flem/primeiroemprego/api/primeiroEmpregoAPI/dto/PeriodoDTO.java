package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseDTO;

/**
 *
 * @author tscortes
 */
public class PeriodoDTO extends BaseDTO {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 3128941050076294177L;
	
	private Long id;
    private String tipo;
    private Short ordem;
    private String nome;
    private String descricao;
    private Integer mesInicio;
    private Integer mesFim;
    private Integer diaReferencia;
    private String label;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Short getOrdem() {
		return ordem;
	}
	public void setOrdem(Short ordem) {
		this.ordem = ordem;
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
	public Integer getMesInicio() {
		return Math.abs(mesInicio);
	}
	public void setMesInicio(Integer mesInicio) {
		this.mesInicio = mesInicio;
	}
	public Integer getMesFim() {
		return Math.abs(mesFim);
	}
	public void setMesFim(Integer mesFim) {
		this.mesFim = mesFim;
	}
	public Integer getDiaReferencia() {
		return diaReferencia;
	}
	public void setDiaReferencia(Integer diaReferencia) {
		this.diaReferencia = diaReferencia;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}    
    
}
