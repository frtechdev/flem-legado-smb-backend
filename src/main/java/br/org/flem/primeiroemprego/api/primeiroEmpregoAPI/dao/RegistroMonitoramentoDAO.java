package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.MunicipioDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Beneficiario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.RegistroMonitoramento;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.MonitoramentoProj;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.RelatorioRegistroVisitaProj;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.SinteseRelatorioTrimestralProj;

/**
 * @author tscortes
 */
public interface RegistroMonitoramentoDAO extends CrudRepository<RegistroMonitoramento, Long>, JpaSpecificationExecutor<RegistroMonitoramento> {

    List<MonitoramentoProj> findByBeneficiarioAndExcluidoFalse(Beneficiario beneficiario);

    RegistroMonitoramento findFirstByBeneficiarioAndExcluidoFalseOrderByDataMonitoramentoDesc(Beneficiario beneficiario);
    /**
     * @param id
     * @return
     */
    @Query(value = "select que.autonomia as autonomia, que.conhecimento as conhecimento, rm.data_monitoramento as dataMonitoramento "
            + " , de.nome as demandante, que.desvio_de_funcao as desvioDeFuncao "
            + "	, que.experiencia_profissional as experienciaProfissional, comp.file_name as fileName, fo.nome as formacao, que.habilidade as habilidade "
            + " , rm.id as id, rm.id_comprovacao as idComprovacao, eg.id_egresso as idEgresso, rm.links as links, rm.id_monitor as monitor, que.motivacao as motivacao, mu.nome as municipio "
            + " , eg.nome as nomeEgresso, que.observacao as observacao, que.pontualidade as pontualidade, rm.presente as presente, rm.principais_registros as principaisRegistros, rm.data_prox_monitoramento as proxMonitoramento, rm.id_meta as subMeta "
            + " , que.tipo_desvio_de_funcao as tipoDesvioDeFuncao, rm.unidade_lotacao as unidadeDeLotacao "
            + "   from registro_monitoramento rm "
            + "   inner join Egresso eg on (rm.id_beneficiario = eg.id_egresso) "
            + "   left join Municipio mu on (mu.id_municipio = rm.id_municipio) "
            + "   left join Comprovacao comp on (comp.id = rm.id_comprovacao) "
            + "   left join Demandante de on (de.id_demandante = rm.id_demandante) "
            + "   left join Formacao fo on (fo.id_formacao = eg.id_formacao) "
            + "   inner join questionarios que on(rm.id = que.id_registro_monitoramento) "
            + "   where rm.id = :id and rm.excluido = 0", nativeQuery = true)
    List<RelatorioRegistroVisitaProj> obterRegistroPorId(@Param("id") Long id);
    
    /**
     * 
     * @param startDate
     * @param endDate
     * @param idDemandante
     * @return 
     */
    @Query(value = "select rm.beneficiario.cpf as cpfEgresso, rm.dataMonitoramento as dataMonitoramento "
            + " , rm.demandante.nome as demandante, rm.demandante.sigla as siglaDemandante, rm.id as id, rm.comprovacao.id as idComprovacao, rm.beneficiario.id as idEgresso, rm.beneficiario.matriculaFlem as matriculaEgresso "
            + " , rm.monitor.nome as monitor, rm.municipio.nome as municipio, rm.usuarioCriacao as usuarioCriacao"
            + " , rm.beneficiario.nome as nomeEgresso, rm.unidadeLotacao as unidadeDeLotacao, emp.dataAdmissao as admissao"
            + "   from RegistroMonitoramento rm,  FoEmpregadosView emp"
            + " where (emp.id = rm.beneficiario.matriculaFlem) and rm.dataMonitoramento BETWEEN :startDate AND :endDate and rm.demandante.id = :idDemandante and rm.excluido = false order by rm.demandante.nome,rm.municipio.nome, rm.beneficiario.nome")
    List<SinteseRelatorioTrimestralProj> findByAllStartDateLessThanEqualAndEndDateGreaterThanEqual(@Param("startDate")LocalDateTime startDate, @Param("endDate")LocalDateTime endDate, @Param("idDemandante")Long idDemandante);
    
    /**
     * 
     * @param startDate
     * @param endDate
     * @return 
     */
    @Query(value = "select rm.beneficiario.cpf as cpfEgresso, rm.dataMonitoramento as dataMonitoramento "
            + " , rm.demandante.nome as demandante, rm.demandante.sigla as siglaDemandante, rm.id as id, rm.comprovacao.id as idComprovacao, rm.beneficiario.id as idEgresso, rm.beneficiario.matriculaFlem as matriculaEgresso "
            + " , rm.monitor.nome as monitor, rm.municipio.nome as municipio, rm.usuarioCriacao as usuarioCriacao"
            + " , rm.beneficiario.nome as nomeEgresso, rm.unidadeLotacao as unidadeDeLotacao, emp.dataAdmissao as admissao"
            + "   from RegistroMonitoramento rm,  FoEmpregadosView emp"
            + " where (emp.id = rm.beneficiario.matriculaFlem) and rm.dataMonitoramento BETWEEN :startDate AND :endDate and rm.excluido = false order by rm.demandante.nome,rm.municipio.nome, rm.beneficiario.nome")
    List<SinteseRelatorioTrimestralProj> findByAllStartDateLessThanEqualAndEndDateGreaterThanEqual(@Param("startDate")LocalDateTime startDate, @Param("endDate")LocalDateTime endDate);
    
    
    /**
     * 
     * @param startDate
     * @param endDate
     * @param idDemandante
     * @return 
     */
    @Query(value = "select distinct new br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.MunicipioDTO(rm.municipio.id, rm.municipio.nome) "
            + "   from RegistroMonitoramento rm where rm.dataMonitoramento BETWEEN :startDate AND :endDate and rm.demandante.id = :idDemandante order by rm.municipio.nome")
    List<MunicipioDTO> findMunicipios(@Param("startDate")LocalDateTime startDate, @Param("endDate")LocalDateTime endDate, @Param("idDemandante")Long idDemandante);
    
    /**
     * 
     * @param startDate
     * @param endDate
     * @param idDemandante
     * @return 
     */
    @Query(value = "select rm.id from RegistroMonitoramento rm where rm.dataMonitoramento BETWEEN :startDate AND :endDate and rm.demandante.id = :idDemandante and rm.municipio.id = :idMunicipio and rm.excluido = false")
    List<Long> findIdMonitoramentosByMunicipio(@Param("startDate")LocalDateTime startDate, @Param("endDate")LocalDateTime endDate, @Param("idDemandante")Long idDemandante, @Param("idMunicipio")Long idMunicipio);

    
    List<RegistroMonitoramento> findByBeneficiarioAndDataMonitoramentoBetweenAndExcluidoFalse(Beneficiario beneficiario, LocalDateTime startDate, LocalDateTime endDate);

}
