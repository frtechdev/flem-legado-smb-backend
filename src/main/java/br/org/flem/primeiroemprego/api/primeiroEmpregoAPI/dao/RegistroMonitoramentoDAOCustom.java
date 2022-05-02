/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Demandante;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.RegistroMonitoramento;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author tscortes
 */
public interface RegistroMonitoramentoDAOCustom{
    List<RegistroMonitoramento> findByDataMonitoramentoBetweenAndMunicipioAndDemandante(LocalDateTime dataInicio, LocalDateTime dataFim, Municipio municipio, Demandante demandante, String unidadeLotacao, String usuarioCriacao) throws UnsupportedEncodingException;
    List<RegistroMonitoramento> obterMonitoramentosSemComprovacao(LocalDateTime dataInicio, LocalDateTime dataFim);
}
