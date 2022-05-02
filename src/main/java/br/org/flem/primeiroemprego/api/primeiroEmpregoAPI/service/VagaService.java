package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.CustomFuncionarioDAO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.VagaDAO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.FuncionarioDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.StatusVisitaEnum;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.TipoMetaEnum;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.integracao.model.RHFuncionario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.integracao.service.RHFuncionarioService;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Beneficiario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Demandante;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Periodo;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.RegistroMonitoramento;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Vaga;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.DemandanteMunicipioProj;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.DemandanteProj;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.MunicipioProj;
import br.org.flem.util.helper.DateUtil;

/**
 *
 * @author tscortes
 */
@Service
public class VagaService {

	@Autowired
	private VagaDAO dao;
	@Autowired
	private CustomFuncionarioDAO customFuncionarioDAO;
	@Autowired
	private MunicipioService municipioService;
	@Autowired
	private DemandanteService demandanteService;
	@Autowired
	private RegistroMonitoramentoService registroMonitoramentoService;
	@Autowired
	private BeneficiarioService beneficiarioService;
	@Autowired
	private PeriodoService periodoService;
	@Autowired
	private RHFuncionarioService rhFuncionarioService;
	@Autowired
	private VisitaBeneficiarioService visitaBeneficiarioService;

	private static final String MENSAGEM_PONTO_FOCAL = "Registrar Ponto Focal e seus dados com urgência";
	private static final String MENSAGEM_JA_MONITORADO_TRIMESTRE = "Já monitorado neste trimestre";
	private static final String MENSAGEM_JA_AVALIADO_SEMESTRE = "Já avaliado neste semestre";

	/**
	 *
	 * @param idMunicipio
	 * @return
	 */
	public List<FuncionarioDTO> findByMunicipio(List<Long> idMunicipio) {
		return obterBeneficiariosPorUnidadesDeLotacaoAndMunsAndDems(null, null, idMunicipio, null);
	}

	/**
	 *
	 * @param idDemandante
	 * @return
	 */
	public List<FuncionarioDTO> findByDemandante(List<Long> idDemandante) {
		return obterBeneficiariosPorUnidadesDeLotacaoAndMunsAndDems(null, null, null, idDemandante);
	}

	/**
	 *
	 * @param idMonitor
	 * @param idDemandante
	 * @param idMunicipio
	 * @return
	 */
	public List<FuncionarioDTO> findByDemandanteAndMunicipio(Long idMonitor, List<Long> idDemandante,
			List<Long> idMunicipio) {
		return obterBeneficiariosPorUnidadesDeLotacaoAndMunsAndDems(idMonitor, null, idMunicipio, idDemandante);
	}

	/**
	 *
	 * @param monitor
	 * @param unidadeDeLotacao
	 * @param idMunicipios
	 * @param idDemandantes
	 * @return
	 */
	public List<FuncionarioDTO> obterBeneficiariosPorUnidadesDeLotacaoAndMunsAndDems(Long monitor,
			List<String> unidadeDeLotacao, List<Long> idMunicipios, List<Long> idDemandantes)
			throws MonitoramentoException {
		
		List<Demandante> demandantes = new ArrayList<>();
		List<Municipio> municipios = new ArrayList<>();
		List<String> unidades = new ArrayList<>();
		if (idDemandantes != null && !idDemandantes.isEmpty()) {
			demandantes = demandanteService.findByIdIn(idDemandantes);
		}
		if (idMunicipios != null && !idMunicipios.isEmpty()) {
			municipios = municipioService.findByIdIn(idMunicipios);
		}
		if (unidadeDeLotacao != null && !unidadeDeLotacao.isEmpty()) {
			unidadeDeLotacao.forEach(item -> {
				try {
					unidades.add(URLDecoder.decode(item, "UTF-8"));
				} catch (UnsupportedEncodingException ex) {
					Logger.getLogger(VagaService.class.getName()).log(Level.SEVERE, null, ex.getMessage());
				}
			});
		}

		List<FuncionarioDTO> vagas = customFuncionarioDAO
				.findVagasByUnidadeDeLotacaoInAndMunicipioInAndDemandanteIn(monitor, unidades, municipios, demandantes);

		if (vagas == null || vagas.isEmpty()) {
			throw new MonitoramentoException("Funcionários não localizados");
		}
		
		
////////////Código ABAIXO Adicionado por Daniel Augusto Almeida em 23/03/2021
		
		vagas.forEach(item -> 
		{
			RHFuncionario rhFuncionario = rhFuncionarioService.findByMatricula(Integer.parseInt(item.getMatricula()));
			item.setDataDesligamento(rhFuncionario.getDesligamento());
			int dataAtualMonthValue = LocalDate.now().getMonthValue();
			if (item.getDataDesligamento() != null)
			{
			//	System.out.println(rhFuncionario.getNome());
			//	System.out.println(rhFuncionario.getDesligamento());
				
				Integer dataDesligamentoYearValue = item.getDataDesligamento().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().getYear();
				Integer dataDesligamentoMonthValue = item.getDataDesligamento().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().getMonthValue();
				if (dataDesligamentoYearValue < LocalDate.now().getYear()-1) //Ano de desligamento anterior ao ano atual -1 (ex.: menor que 2019 em ano 2020) //
				{
				//	System.out.println("ELIMINADO 1");
					
					item.setMatricula(null);
				}
				else
				{
					int firstMonth = 0;
					firstMonth = dataAtualMonthValue + 7;
					if (firstMonth > 12)
					{
						firstMonth = firstMonth - 12;
					}
					if (firstMonth > dataAtualMonthValue)
					{
						if ( (dataDesligamentoMonthValue < firstMonth) && (dataDesligamentoYearValue != LocalDate.now().getYear()) )
						{
						//	System.out.println("ELIMINADO 2");
							item.setMatricula(null);
						}
					}
					else
					{
						if ( (dataDesligamentoMonthValue < firstMonth) || (dataDesligamentoMonthValue > dataAtualMonthValue) )
						{
						//	System.out.println("ELIMINADO 3");
							item.setMatricula(null);
						}
					}
				}
			}
		});
		
		
////////////Código ACIMA Adicionado por Daniel Augusto Almeida em 23/03/2021
		
////////////Código ABAIXO Comentado por Daniel Augusto Almeida em 23/03/2021
		//////////// Código ABAIXO Adicionado por Daniel Augusto Almeida em 06/07/2020
		/**
		vagas.forEach(item -> 
		{
			
			RHFuncionario rhFuncionario = rhFuncionarioService.findByMatricula(Integer.parseInt(item.getMatricula()));
			
			item.setDataDesligamento(rhFuncionario.getDesligamento());
			int dataAtualMonthValue = LocalDate.now().getMonthValue();
			if (item.getDataDesligamento() != null)
			{
				Integer dataDesligamentoYearValue = item.getDataDesligamento().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().getYear();
				Integer dataDesligamentoMonthValue = item.getDataDesligamento().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().getMonthValue();
				if (dataDesligamentoYearValue < LocalDate.now().getYear()-1) //Ano de desligamento anterior ao ano atual -1 (ex.: menor que 2019 em ano 2020) //
				{
					item.setMatricula(null);
				}
				else if (dataDesligamentoYearValue == LocalDate.now().getYear()) //Ano de desligamento = Ano atual (pesquisa de trimestre) //
				{
					if (((dataDesligamentoMonthValue > 2 && dataDesligamentoMonthValue < 6) != ( dataAtualMonthValue > 2 &&  dataAtualMonthValue < 6))
						||
						((dataDesligamentoMonthValue > 5 && dataDesligamentoMonthValue < 9) != ( dataAtualMonthValue > 5 &&  dataAtualMonthValue < 9))
						||
						((dataDesligamentoMonthValue > 8 && dataDesligamentoMonthValue < 12) != ( dataAtualMonthValue > 8 &&  dataAtualMonthValue < 12))
						||
						((dataDesligamentoMonthValue == 12 || dataDesligamentoMonthValue < 3) != ( dataAtualMonthValue == 12 ||  dataAtualMonthValue < 3)))
					{
						item.setMatricula(null);
					}
				}
				// Ano de desligamento anterior ao atual (ex. 2019 em ano 2020) / Se a data de desligamento não for em trimestre de transição de ano ou o mês atual não for o fim de ano //
				else if ((dataDesligamentoMonthValue != 12 && dataDesligamentoMonthValue >= 3) || ( dataAtualMonthValue != 12 &&  dataAtualMonthValue >= 3))
				{
					item.setMatricula(null);
				}	
			}
		});
		*/
		////////////Código ACIMA Adicionado por Daniel Augusto Almeida em 06/07/2020
////////////Código ACIMA Comentado por Daniel Augusto Almeida em 23/03/2021

		vagas = vagas.stream().filter(item -> item.getMatricula() != null).collect(Collectors.toList());
		vagas.forEach(item -> {
			
			RHFuncionario rhFuncionario = rhFuncionarioService.findByMatricula(Integer.parseInt(item.getMatricula()));
			item.setStatus(rhFuncionario.getSituacao());
			item.setIdStatus(rhFuncionario.getIdSituacao());
			item.setDataAdmissao(rhFuncionario.getAdmissao());
			
			item.setDataDesligamento(rhFuncionario.getDesligamento());
			RegistroMonitoramento monitoramento = registroMonitoramentoService
					.findFirstByBeneficiarioOrderByDataMonitoramentoDesc(item.getIdFuncionario());

			if (Strings.isNullOrEmpty(item.getPontoFocalNaUnidade())) {
				item.setPontoFocalNaUnidade(MENSAGEM_PONTO_FOCAL);
			}
			if (Strings.isNullOrEmpty(item.getEmailPontoFocal())) {
				item.setEmailPontoFocal(MENSAGEM_PONTO_FOCAL);
			}

			aptoParaMonitoramento(item, monitoramento);
			
		});
		return vagas;
	}

	/**
	 *
	 * @param dto
	 * @param monitoramento
	 */
	private void aptoParaMonitoramento(FuncionarioDTO dto, RegistroMonitoramento monitoramento) {
		dto.setStatusVisitaBeneficiario(visitaBeneficiarioService
				.carregarVisitaBeneficiarioMonitoradoOuVisitadoNoPeriodo(dto.getIdFuncionario()).getStatus()
				.getDescricao());

		LocalDate ldAtual = LocalDate.now();
		if (monitoramento == null) {
			LocalDate dataAdmissao = DateUtil.convertToLocalDate(dto.getDataAdmissao());
			LocalDate ldReferencia = periodoService.dataReferenciaPeriodo(ldAtual, "TRIMESTRE");
			if( !DateUtil.isEqualsAndBefore(dataAdmissao, ldReferencia) ) {
				dto.setAptoParaMonitoramento("Não - Beneficiário admitido em "+DateUtil.formatarData(dataAdmissao, "dd/MM/yyyy"));
			} else if (!demitidoIsAptoParaMonitoramento(dto.getDataDesligamento(), "TRIMESTRE")) {
				dto.setAptoParaMonitoramento("Não - Beneficiário demitido em "+DateUtil.formatarData(dto.getDataDesligamento(), "dd/MM/yyyy"));
			}else {
				dto.setAptoParaMonitoramento("Sim");

			}
		} else {
			Periodo periodo = periodoService.obterPeriodoPorMes(monitoramento.getDataMonitoramento().getMonthValue(),
					"TRIMESTRE");
			Periodo periodoCurrent = periodoService.obterPeriodoPorMes(ldAtual.getMonthValue(), "TRIMESTRE");
			if (periodo.equals(periodoCurrent)) {
				dto.setDataMonitoramento(monitoramento.getDataMonitoramento());
				dto.setAptoParaMonitoramento(MENSAGEM_JA_MONITORADO_TRIMESTRE);
			} else if (demitidoIsAptoParaMonitoramento(dto.getDataDesligamento(), "TRIMESTRE")) {
				dto.setAptoParaMonitoramento("Sim");
				dto.setStatusVisitaBeneficiario(StatusVisitaEnum.NAO_MONITORADO.getDescricao());
			}
		}
		aptoParaAvaliacao(dto, monitoramento);

	}

	/**
	 *
	 * @param dto
	 * @param monitoramento
	 */
	private void aptoParaAvaliacao(FuncionarioDTO dto, RegistroMonitoramento registro) {
		LocalDate ldAtual = LocalDate.now();

		LocalDate startDate = periodoService.obterInicioPeriodo(ldAtual, "SEMESTRE");
		LocalDate endDate = periodoService.obterFimPeriodo(ldAtual, "SEMESTRE");
		
		if(registro != null) {
			List<RegistroMonitoramento> registros = registroMonitoramentoService
					.findByBeneficiarioAndDataMonitoramentoBetween(registro.getBeneficiario(), startDate.atTime(0, 0),
							endDate.atTime(23, 59));
			Optional<RegistroMonitoramento> opt = registros.stream().filter(item-> item.getMeta().getTipo().equals(TipoMetaEnum.SEMESTRAL)).findFirst();
			if(opt.isPresent()) {
				dto.setAptoParaAvaliacao(MENSAGEM_JA_AVALIADO_SEMESTRE);
				dto.setDataMonitoramento(registro.getDataMonitoramento());
			}else if( demitidoIsAptoParaMonitoramento(dto.getDataDesligamento(), "SEMESTRE") ) {
				dto.setAptoParaAvaliacao("Sim");
			}
		}else {
			LocalDate dataAdmissao = DateUtil.convertToLocalDate(dto.getDataAdmissao());
			LocalDate ldReferencia = periodoService.dataReferenciaPeriodo(ldAtual, "SEMESTRE");
			if( !DateUtil.isEqualsAndBefore(dataAdmissao, ldReferencia) ) {
				dto.setAptoParaAvaliacao("Não - Beneficiário admitido em "+DateUtil.formatarData(dataAdmissao, "dd/MM/yyyy"));
			} else if (!demitidoIsAptoParaMonitoramento(dto.getDataDesligamento(), "SEMESTRE")) {
				dto.setAptoParaAvaliacao("Não - Beneficiário demitido em "+DateUtil.formatarData(dto.getDataDesligamento(), "dd/MM/yyyy"));
			}else {
				dto.setAptoParaAvaliacao("Sim");
			}
		}
	}

	private boolean demitidoIsAptoParaMonitoramento(Date dataDesligamento, String tipo) {
		
		
		
		
////////////Código ABAIXO Adicionado por Daniel Augusto Almeida em 07/07/2020
////////////Código ABAIXO tratado por COMENTÁRIO por Daniel Augusto Almeida em 13/08/2020
		
		/*
		boolean valor = false;
		if (dataDesligamento == null)
		{
			valor = true;
		}
		return valor;*/
		
		
////////////Código ACIMA Adicionado por Daniel Augusto Almeida em 07/07/2020
////////////Código ACIMA tratado como COMENTÁRIO por Daniel Augusto Almeida em 13/08/2020
		
////////////Código ABAIXO tratado como COMENTÁRIO por Daniel Augusto Almeida em 07/07/2020
////////////Código ABAIXO DESCOMENTADO por Daniel Augusto Almeida em 13/08/2020
		
		if (dataDesligamento == null)
			return true;
		LocalDate desligamento = DateUtil.convertToLocalDate(dataDesligamento);
		LocalDate ldReferencia = periodoService.obterInicioPeriodo(LocalDate.now(), tipo);

		return DateUtil.isEqualsAndAfter(desligamento, ldReferencia);
		
////////////Código ACIMA tratado como COMENTÁRIO por Daniel Augusto Almeida em 07/07/2020
////////////Código ACIMA DESCOMENTADO por Daniel Augusto Almeida em 13/08/2020
		
	}

	/**
	 *
	 * @param beneficiario
	 * @return
	 */
	public Vaga findByBeneficiario(Beneficiario beneficiario) {
		return dao.findByEgresso(beneficiario);
	}

	
	/**
	 *
	 * @param idBeneficiario
	 * @return
	 */
	public Vaga findByBeneficiario(Long idBeneficiario) {
		Beneficiario beneficiario = beneficiarioService.findById(idBeneficiario);
		return findByBeneficiario(beneficiario);
	}

	/**
	 *
	 * @param demandantes
	 * @param municipios
	 * @return
	 */
	public List<String> obterUnidadeLotacaoByDemandantesAndMunicipios(List<Long> demandantes, List<Long> municipios) {
		return dao.obterUnidadeLotacaoByDemandantesAndMunicipios(demandantes, municipios);
	}

	public List<MunicipioProj> findAllMunicipiosVaga() {
		return dao.findAllMunicipiosVaga();
	}

	public List<DemandanteProj> findAllDemandatesVaga() {
		return dao.findAllDemandatesVaga();
	}

	/**
	 *
	 * @param municipios
	 * @return
	 */
	public List<DemandanteMunicipioProj> findByVagaMunicipioNaoAssociados(List<Municipio> municipios) {
		return dao.findByVagaMunicipioNaoAssociados(municipios);
	}

	/**
	 *
	 * @param municipios
	 * @return
	 */
	public List<DemandanteMunicipioProj> findByVagaMunicipio(List<Municipio> municipios) {
		return dao.findByVagaMunicipio(municipios);
	}

}
