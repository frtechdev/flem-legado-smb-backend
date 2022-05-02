package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Demandante;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.RegistroMonitoramento;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.RespostaItem;

/**
 *
 * @author tscortes
 */
@Repository
public class RegistroMonitoramentoDAOCustomImpl implements RegistroMonitoramentoDAOCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RegistroMonitoramento> findByDataMonitoramentoBetweenAndMunicipioAndDemandante(LocalDateTime dataInicio, LocalDateTime dataFim, Municipio municipio, Demandante demandante, String unidadeLotacao, String usuarioCriacao) throws UnsupportedEncodingException {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RegistroMonitoramento> criteria = cb.createQuery(RegistroMonitoramento.class);

        Root<RegistroMonitoramento> vaga = criteria.from(RegistroMonitoramento.class);
        List<Predicate> predicates = new ArrayList<>();
        
        if (municipio != null) {
            predicates.add(cb.equal(vaga.get("municipio"), municipio));
        }
        if (demandante != null) {
            predicates.add(cb.equal(vaga.get("demandante"), demandante));
        }
        if( dataInicio != null ){
            predicates.add(cb.greaterThanOrEqualTo(vaga.get("dataMonitoramento"), dataInicio));
        }
        if( dataFim != null ){
            predicates.add(cb.lessThanOrEqualTo(vaga.get("dataMonitoramento"), dataFim));
        }
        if( StringUtils.isNotBlank(unidadeLotacao)){
            predicates.add(cb.like(vaga.get("unidadeLotacao"), "%"+URLDecoder.decode(unidadeLotacao.trim(), "UTF-8")+"%"));
        }
        if(usuarioCriacao != null) {
        	predicates.add(cb.equal(vaga.get("usuarioCriacao"), usuarioCriacao));
        }
        predicates.add(cb.equal(vaga.get("excluido"), Boolean.FALSE));
        criteria.where(predicates.toArray(new Predicate[0]));
        
        return entityManager.createQuery(criteria).getResultList();
    }
    
    @Override
    public List<RegistroMonitoramento> obterMonitoramentosSemComprovacao(LocalDateTime dataInicio, LocalDateTime dataFim){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RegistroMonitoramento> criteria = cb.createQuery(RegistroMonitoramento.class);
        Root<RegistroMonitoramento> vaga = criteria.from(RegistroMonitoramento.class);
        
        Subquery<RespostaItem> subquery = criteria.subquery(RespostaItem.class);
        Root<RespostaItem> respostaItemCb = subquery.from(RespostaItem.class);
        subquery
        	.select(respostaItemCb.get("id").get("registroMonitoramento").get("id"))
        	.where(cb.lessThan(respostaItemCb.get("dataCriacao"), LocalDateTime.of(2020, 5, 18, 17, 34)));
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(vaga.get("excluido"), Boolean.FALSE));    
        predicates.add(cb.between(vaga.get("dataMonitoramento"), dataInicio, dataFim));
        predicates.add(cb.in(vaga.get("id")).value(subquery));

        criteria.where(predicates.toArray(new Predicate[0]));
        
        return entityManager.createQuery(criteria).getResultList();
    }
}
