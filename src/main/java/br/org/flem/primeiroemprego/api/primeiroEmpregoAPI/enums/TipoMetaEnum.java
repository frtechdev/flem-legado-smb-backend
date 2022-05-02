package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tscortes
 */
public enum TipoMetaEnum {
    
    TRIMESTRAL("TRIMESTRAL", "Trimestral", "TRIMESTRE"),
    SEMESTRAL("SEMESTRAL", "Semestral", "SEMESTRE");
    
    private String descricao;
    private String periodo;
    private String codigo;

    private TipoMetaEnum(String codigo, String descricao, String periodo) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.periodo = periodo;
    }
        
    public static Map<String, String> getStatusAgendaEnum(){
        Map<String, String> respostas = new HashMap<>();
        respostas.put("TRIMESTRAL", "Trimestral");
        respostas.put("SEMESTRAL", "Semestral");
        return respostas;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public String getPeriodo() {
    	return periodo;
    }
    
}
