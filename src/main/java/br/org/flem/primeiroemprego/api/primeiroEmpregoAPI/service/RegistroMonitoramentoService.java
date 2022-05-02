package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.AbstractHelper;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.RegistroMonitoramentoDAO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.RegistroMonitoramentoDAOCustom;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.AvaliacaoQuestionarioDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.ComprovacaoRelDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.ListaMonitoramentoDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.MonitoramentoComprovacaoDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.MonitoramentoDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.MonitorarDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.MunicipioDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.QuestionarioDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RegistroMonitoramentoEditarDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RelatorioMonitoramentoDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RelatorioTrimestralDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.SinteseRelatorioTrimestralDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.ParameterEnum;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.RespostaTecnica;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.StatusVisitaEnum;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.TipoMetaEnum;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.integracao.model.RHFuncionario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.integracao.service.RHFuncionarioService;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.AvaliacaoQuestionario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Beneficiario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Colaborador;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Comprovacao;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Demandante;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Meta;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.MonitorDemandante;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Periodo;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Questionario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.RegistroMonitoramento;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.User;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Vaga;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.MonitoramentoProj;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.RelatorioRegistroVisitaProj;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.SinteseRelatorioTrimestralProj;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.util.SMBUtil;
import br.org.flem.util.helper.CoreUtil;
import br.org.flem.util.helper.DateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JRPrintText;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

/**
 *
 * @author tscortes
 */
@Service
public class RegistroMonitoramentoService extends AbstractHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8808543253648205409L;
	private static final String CURRENT_PAGE_NUMBER = "${CURRENT_PAGE_NUMBER}";
	private static final String TOTAL_PAGE_NUMBER = "${TOTAL_PAGE_NUMBER}";
	private static final int MES_12 = 12;

	@Autowired
	private RegistroMonitoramentoDAO dao;
	@Autowired
	private RegistroMonitoramentoDAOCustom customRegistroMonitoramentoDAO;
	@Autowired
	private BeneficiarioService beneficiarioService;
	@Autowired
	private QuestionarioService questionarioService;
	@Autowired
	private ColaboradorService colaboradorService;
	@Autowired
	private AvaliacaoQuestionarioService avaliacaoQuestionarioService;
	@Autowired
	private MonitorDemandanteService monitorDemandanteService;
	@Autowired
	private VagaService vagaService;
	@Autowired
	private MunicipioService municipioService;
	@Autowired
	private DemandanteService demandanteService;
	@Autowired
	private FileStorageService fileStorageService;
	@Autowired
	private EnviarEmailService enviarEmailService;
	@Autowired
	private AgendamentoService agendamentoService;
	@Autowired
	private MetaService metaService;
	@Autowired
	private RHFuncionarioService rhFuncionarioService;
	@Autowired
	private PeriodoService periodoService;
	@Autowired
	private ReportsService reportsService;
	@Autowired
	private ComprovacaoService comprovacaoService;
	@Autowired
	private ParameterService parameterService;
	@Autowired
	private VisitaBeneficiarioService visitaBeneficiarioService;	

	/**
	 * @param beneficiario
	 * @return
	 */
	public List<MonitoramentoProj> findByBeneficiario(Beneficiario beneficiario) {
		return dao.findByBeneficiarioAndExcluidoFalse(beneficiario);
	}

	public RegistroMonitoramento findById(Long id) {
		return dao.findOne(id);
	}

	/**
	 * @param id
	 * @return
	 */
	public RelatorioMonitoramentoDTO obterRegistroPorId(Long id) {
		List<RelatorioRegistroVisitaProj> listaProj = dao.obterRegistroPorId(id);
		List<RelatorioMonitoramentoDTO> listaDTO = new ArrayList<>();
		listaProj.forEach(item -> {
			Meta meta = metaService.findById(item.getSubMeta());
			String nomeMeta = metaService.getNomeEDescricaoPorId(meta);
			RelatorioMonitoramentoDTO dto = new RelatorioMonitoramentoDTO(item.getNomeEgresso(),
					item.getProxMonitoramento(), item.getUnidadeDeLotacao(), item.getMunicipio(), item.getDemandante(),
					item.getDataMonitoramento(), item.getFormacao(), nomeMeta, item.getObservacao(),
					item.getDesvioDeFuncao(), item.getTipoDesvio(), item.getAutonomia(), item.getConhecimento(),
					item.getHabilidade(), item.getMotivacao(), item.getPontualidade(),
					item.getExperienciaProfissional());
			Colaborador colaborador = colaboradorService.findById(item.getMonitor());
			if (colaborador == null) {
				throw new MonitoramentoException(
						"RelatÃ³rio nÃ£o pode ser gerado: Monitor que realizou o monitoramento nÃ£o foi localizado!");
			}
			if (item.getIdComprovacao() != null) {
				dto.setComprovacaoName("Lista de PresenÃ§a");
			}
			dto.setIdComprovacao(item.getIdComprovacao());
			dto.setPresente(item.getPresente());
			dto.setIdEgresso(item.getIdEgresso());
			dto.setDataHrMonitoramento(item.getDataMonitoramento());
			dto.setMonitor(colaborador.getNome());
			dto.setIdMonitor(colaborador.getId());
			dto.setPrincipaisRegistros(item.getPrincipaisRegistros());
			dto.setLinks(item.getLinks());
			dto.setSubMetaKey(meta.getTipo().getCodigo());
			dto.setFileName(item.getFileName());
			dto.setAvaliacoesQuestionario(avaliacaoQuestionarioService.findByIdRegistroMonitoramento(item.getId()));
			listaDTO.add(dto);
		});
		if (!listaDTO.isEmpty()) {
			return listaDTO.get(0);
		}
		return null;
	}

	/**
	 * @param idBeneficiario
	 * @return
	 */
	public List<MonitoramentoProj> findByBeneficiario(Long idBeneficiario) {
		Beneficiario beneficiario = beneficiarioService.findById(idBeneficiario);
		return findByBeneficiario(beneficiario);
	}

	/**
	 *
	 * @param idBeneficiario
	 * @return
	 */
	public List<MonitoramentoDTO> getHistoric(Long idBeneficiario) {
		List<MonitoramentoProj> lista = findByBeneficiario(idBeneficiario);
		List<MonitoramentoDTO> retorno = new ArrayList<>();
		if (lista != null && !lista.isEmpty()) {
			lista.forEach((item -> {
				MonitoramentoDTO dto = new MonitoramentoDTO();
				User user = getUser(item.getUsuarioCriacao());
				dto.setDataMonitoramento(item.getDataMonitoramento());
				dto.setUsuarioCriacao(user.getNome());
				dto.setId(item.getId());
				dto.setUnidadeLotacao(item.getUnidadeLotacao());
				if (item.getDemandante() != null) {
					dto.setDemandante(item.getDemandante().getNome());
				}
				if (item.getMunicipio() != null) {
					dto.setMunicipio(item.getMunicipio().getNome());
				}
				retorno.add(dto);
			}));
		}
		return retorno;
	}

	/**
	 *
	 * @param id
	 */
	@Transactional
	public void deleteById(Long id) {
		RegistroMonitoramento monitoramento = findById(id);
		validarRegrasDeDelecao(monitoramento);
		Questionario questionario = questionarioService.findByRegistroMonitoramento(monitoramento);
		visitaBeneficiarioService.saveExcluir(monitoramento.getBeneficiario().getId(), StatusVisitaEnum.MONITORADO);
		if (questionario != null) {
			questionarioService.delete(questionario);
		}
		delete(monitoramento);
	}

	/**
	 *
	 * @param monitoramento
	 * @throws MonitoramentoException
	 */
	private void validarRegrasDeDelecao(RegistroMonitoramento monitoramento) {
		SMBUtil.throwException(monitoramento == null, "Esse monitoramento nÃ£o pode ser excluído: Registro de Monitoramento nÃ£o localizado!");
		String currentUser = getCurrentUser();
		if (!currentUser.equalsIgnoreCase(monitoramento.getUsuarioCriacao()) && 
				!hasPermissions("smbRemoverMonitoramento")) {
			throw new MonitoramentoException(
					"Esse monitoramento nÃ£o pode ser excluÃ­do: Somente o monitor que registrou o monitoramento pode excluir este registro!");
			
		}
 	
		if (!periodoService.validarDataDentroDoPeriodo(LocalDate.now(), monitoramento.getMeta().getTipo().getPeriodo())) {
			throw new MonitoramentoException(
					"Esse monitoramento não pode ser excluído: Ele está fora do prazo permitido para exclusão!");
		}
	}


	/**
	 * @param dto
	 * @param files
	 */
	@Transactional
	public void registrarMonitoramento(MonitorarDTO dto, MultipartFile[] files) {
		Beneficiario beneficiario = beneficiarioService.findById(dto.getIdBeneficiario());
		String login = getCurrentUser();
		verificarRegras(dto, beneficiario, null, login);


		Colaborador monitor = colaboradorService.findByEmail(login + "@flem.org.br");
		Vaga vaga = getVaga(dto);
		if (monitor == null) {
			throw new MonitoramentoException("Usuário logado não estão habilitado para fazer monitoramento!");
		}
		MonitorDemandante associacao = getAssociacao(vaga);
		RegistroMonitoramento monitoramento = new RegistroMonitoramento();
		monitoramento.setBeneficiario(beneficiario);
		monitoramento.setDataMonitoramento(dto.getDataMonitoramento());
		monitoramento.setObservacao(dto.getObservacao());
		monitoramento.setMonitor(monitor);
		monitoramento.setMonitorAssociado(associacao.getMonitor());
		monitoramento.setDemandante(associacao.getDemandante());
		monitoramento.setMunicipio(associacao.getMunicipio());

		if (dto.getIdMeta() != null) {
			monitoramento.setMeta(metaService.findById(dto.getIdMeta()));
		}
		monitoramento.setLinks(dto.getLinks());
		monitoramento.setUnidadeLotacao(vaga.getUnidadeDeLotacao());
		monitoramento.setPrincipaisRegistros(dto.getPrincipaisRegistros());
		monitoramento.setPresente(dto.getPresente());
		monitoramento.setAgendamento(agendamentoService.obterAgendamentoAbertoPorBeneficiario(beneficiario));
		
		inserirProximoMonitoramento(monitoramento);

		RegistroMonitoramento registroSalvo = save(monitoramento);
		gravarQuestionario(dto.getQuestionario(), registroSalvo, files);
		if(registroSalvo != null) {			
			visitaBeneficiarioService.updateVisitaBeneficiario( monitor.getId(), beneficiario.getId());
		}
		enviarEmail(dto, monitoramento);

	}

	/**
	 *
	 * @param dto
	 * @param registro
	 */
	public void enviarEmail(MonitorarDTO dto, RegistroMonitoramento registro) {
		if (Objects.nonNull(dto.getQuestionario())) {
			if (dto.getQuestionario().getGravida()) {
				this.enviarEmailGravidez(registro);
			}
			if (dto.getQuestionario().getAcidenteDeTrabalho()) {
				this.enviarEmailAcidenteTrabalho(dto, registro);
			}
		}
	}

	/**
	 *
	 * @param registro
	 */
	public void enviarEmailGravidez(RegistroMonitoramento registro) {
		List<String> destinatarios = Arrays.asList("atestadoflem@flem.org.br", "mpmachado@flem.org.br");
		// List<String> destinatarios = Arrays.asList("irqueiroz@flem.org.br",
		// "mscosta@flem.org.br", "tscortes@flem.org.br");
		String aliasRemetente = "SMB - Sistema de Monitoramento de BeneficiÃ¡rios.";
		String remetente = "naoresponda@flem.org.br";
		String assunto = "Informe de Gravidez de FuncionÃ¡rio - SMB";

		String mensagem = " <html><body><p><b>FOI CADASTRADO MONITORAMENTO DE BENEFICIÃ�RIO COM SINALIZAÃ‡ÃƒO DE GRAVIDEZ.</b></p></br> "
				+ " <p><b>DADOS DO MONITOR</b></p> " + " <p><b>Nome: </b> " + registro.getMonitor().getNome() + " </p> "
				+ " <p><b>E-mail: </b> " + registro.getMonitor().getEmail() + " </p> "
				+ " <p><b>EscritÃ³rio Regional: </b> " + registro.getMonitor().getEscritorioRegional().getNome()
				+ " </p></br> " + " <p><b>DADOS DO BENEFICIÃ�RIO</b></p> " + " <p><b>Nome: </b> "
				+ registro.getBeneficiario().getNome() + " </p> " + " <p><b>MatrÃ­cula: </b> "
				+ registro.getBeneficiario().getMatriculaFlem() + " </p></body></html> ";

		enviarEmailService.send(destinatarios, aliasRemetente, remetente, assunto, mensagem);
	}

	/**
	 *
	 * @param dto
	 * @param registro
	 */
	public void enviarEmailAcidenteTrabalho(MonitorarDTO dto, RegistroMonitoramento registro) {

		List<String> destinatarios = Arrays.asList("mpmachado@flem.org.br");
		// List<String> destinatarios = Arrays.asList("irqueiroz@flem.org.br",
		// "mscosta@flem.org.br", "tscortes@flem.org.br");
		String aliasRemetente = "SMB - Sistema de Monitoramento de BeneficiÃ¡rios.";
		String remetente = "naoresponda@flem.org.br";
		String assunto = "Informe de Acidente de Trabalho - SMB";

		String mensagem = " <html><body><p><b>FOI CADASTRADO MONITORAMENTO DE BENEFICIÃ�RIO COM SINALIZAÃ‡ÃƒO DE ACIDENTE DE TRABALHO.</b></p></br> "
				+ " <p><b>DADOS DO MONITOR</b></p> " + " <p><b>Nome: </b> " + registro.getMonitor().getNome() + " </p> "
				+ " <p><b>E-mail: </b> " + registro.getMonitor().getEmail() + " </p> "
				+ " <p><b>EscritÃ³rio Regional: </b> " + registro.getMonitor().getEscritorioRegional().getNome()
				+ " </p></br> " + " <p><b>DADOS DO BENEFICIÃ�RIO</b></p> " + " <p><b>Nome: </b> "
				+ registro.getBeneficiario().getNome() + " </p> " + " <p><b>MatrÃ­cula: </b> "
				+ registro.getBeneficiario().getMatriculaFlem() + " </p></br>" + " <p><b>ACIDENTE DE TRABALHO</b></p> "
				+ " <p><b>DescriÃ§Ã£o: </b> " + dto.getQuestionario().getDescricaoAcidenteDeTrabalho()
				+ " </p></body></html> ";

		enviarEmailService.send(destinatarios, aliasRemetente, remetente, assunto, mensagem);
	}

	/**
	 *
	 * @param monitoramento
	 * @return
	 */
	public RegistroMonitoramento save(RegistroMonitoramento monitoramento) {
		preSave(monitoramento);
		return dao.save(monitoramento);
	}

	/**
	 *
	 * @param vaga
	 * @return
	 */
	private MonitorDemandante getAssociacao(Vaga vaga) {
		MonitorDemandante associacao = monitorDemandanteService.findByMunicipioAndDemandante(vaga.getMunicipio(),
				vaga.getDemandante());
		if (associacao == null) {
			throw new MonitoramentoException("BeneficiÃ¡rio nÃ£o encontrado");
		}
		return associacao;
	}

	/**
	 *
	 * @param dto
	 * @return
	 */
	private Vaga getVaga(MonitorarDTO dto) {
		Vaga vaga = vagaService.findByBeneficiario(dto.getIdBeneficiario());
		if (vaga == null) {
			throw new MonitoramentoException("BeneficiÃ¡rio nÃ£o encontrado");
		}
		return vaga;
	}

	/**
	 *
	 * @param dto
	 * @param registroMonitoramento
	 * @param files
	 */
	public void gravarQuestionario(QuestionarioDTO dto, RegistroMonitoramento registroMonitoramento,
			MultipartFile[] files) {
		if (dto != null) {

			Questionario questionario = new Questionario();
			questionario.setRegistroMonitoramento(registroMonitoramento);
			preencherQuestionario(registroMonitoramento, dto, questionario);

			questionarioService.registrarMonitoramento(questionario);

			AvaliacaoQuestionarioDTO avaDto = new AvaliacaoQuestionarioDTO();
			avaDto.setIdQuestionario(questionario.getId());

			if (registroMonitoramento.getMeta().getTipo().equals(TipoMetaEnum.SEMESTRAL)) {
				gravarAvaliacoesRealizadas(registroMonitoramento, avaDto, files, dto.getAvaliacoes());
			}
		}
	}

	/**
	 * Para funcionar, deve-se incluir no nome do arquivo o prefixo com o id da
	 * avaliaÃ§Ã£o ex.: 2_nome_do_arquivo
	 *
	 * @param dto
	 * @param files
	 * @param avaliacoes
	 */
	private void gravarAvaliacoesRealizadas(RegistroMonitoramento registroMonitoramento, AvaliacaoQuestionarioDTO dto,
			MultipartFile[] files, List<Long> avaliacoes) {

		if (avaliacoes != null && !avaliacoes.isEmpty()) {
			avaliacoes.forEach(evaluation -> {
				if (files.length > 0) {
					for (MultipartFile file : files) {
						String[] fileName = file.getOriginalFilename().split("_");
						Long idEvaluation = Long.parseLong(fileName[0]);
						if (evaluation.compareTo(idEvaluation) == 0) {
							dto.setIdAvaliacao(evaluation);
							String path = registroMonitoramento.getBeneficiario().getMatriculaFlem() + "/"
									+ registroMonitoramento.getId();
							String filePath = fileStorageService.storeAvaliacao(path, file);
							dto.setFilePath(filePath);
						}
					}
				}
				avaliacaoQuestionarioService.salvar(dto);
			});
		}
	}

	/**
	 * @param dto
	 * @param questionario
	 */
	private void preencherQuestionario(RegistroMonitoramento registro, QuestionarioDTO dto, Questionario questionario) {
		if (StringUtils.isNotBlank(dto.getDesvioDeFuncao()) && dto.getDesvioDeFuncao().equalsIgnoreCase("S")) {
			if (StringUtils.isBlank(dto.getTipoDesvioDeFuncao())) {
				throw new MonitoramentoException("O Tipo de Desvio de FunÃ§Ã£o deve ser informado!");
			}
			if (StringUtils.isBlank(dto.getDescricaoDesvioDeFuncao())) {
				throw new MonitoramentoException(
						"VocÃª deve descrever algo sobre o Desvio de FunÃ§Ã£o no campo de DescriÃ§Ã£o do Desvio de FunÃ§Ã£o!");
			}
		}
		if (StringUtils.isBlank(dto.getObservacao())) {
			throw new MonitoramentoException("O campo ObservaÃ§Ã£o deve ser Informado!");
		}
		questionario.setDesvioDeFuncao(dto.getDesvioDeFuncao());
		questionario.setTipoDesvioDeFuncao(dto.getTipoDesvioDeFuncao());
		questionario.setDescricaoDesvioDeFuncao(dto.getDescricaoDesvioDeFuncao());
		questionario.setObservacao(dto.getObservacao());
		if (registro.getBeneficiario().getSexo() != null
				&& registro.getBeneficiario().getSexo().equalsIgnoreCase("F")) {
			questionario.setGravida(dto.getGravida());
		} else {
			dto.setGravida(Boolean.FALSE);
		}
		questionario.setAcidenteDeTrabalho(dto.getAcidenteDeTrabalho());
		questionario.setDescricaoAcidenteDeTrabalho(dto.getDescricaoAcidenteDeTrabalho());
		preencherImpressoesDaEquipe(registro.getPresente(), dto, questionario);
	}

	/**
	 * @param dto
	 * @param questionario
	 */
	private void preencherImpressoesDaEquipe(boolean presente, QuestionarioDTO dto, Questionario questionario) {
		if (presente) {
			boolean isNull = CoreUtil.isAnyNull(dto.getConhecimento(), dto.getHabilidade(), dto.getAutonomia(),
					dto.getPontualidade(), dto.getMotivacao(), dto.getExperienciaProfissional());
			SMBUtil.throwException(isNull, "Todas as ImpressÃµes da Equipe TÃ©cnica devem ser Informadas!");
			questionario.setConhecimento(RespostaTecnica.get(dto.getConhecimento()));
			questionario.setHabilidade(RespostaTecnica.get(dto.getHabilidade()));
			questionario.setAutonomia(RespostaTecnica.get(dto.getAutonomia()));
			questionario.setPontualidade(RespostaTecnica.get(dto.getPontualidade()));
			questionario.setMotivacao(RespostaTecnica.get(dto.getMotivacao()));
			questionario.setExperienciaProfissional(RespostaTecnica.get(dto.getExperienciaProfissional()));
		}
	}

	/**
	 * @param dto
	 * @throws MonitoramentoException
	 */
	private void verificarRegras(MonitorarDTO dto, Beneficiario beneficiario, RegistroMonitoramento monitoramento, String usuarioLogado) throws MonitoramentoException {
		verificarCamposObrigatorio(dto);
		Meta meta = metaService.findById(dto.getIdMeta());
		verificarBeneficiarioDemitido(beneficiario, dto.getDataMonitoramento(), meta.getTipo().getPeriodo());
		if ( monitoramento != null) {
			if(!monitoramento.getUsuarioCriacao().equals(usuarioLogado)) {
				throw new MonitoramentoException("Somente o monitor que criou o Monitoramento pode edita-lo");
			}
			
			if (!periodoService.validarDataDentroDoPeriodo(monitoramento.getDataMonitoramento().toLocalDate(), meta.getTipo().getPeriodo())) {
				throw new MonitoramentoException(
						"Esse monitoramento não pode ser editado: Ele está fora do prazo permitido para edição!");
			}
		}
		
		
	}

	/**
	 *
	 * @param beneficiario
	 * @param dataMonitoramento
	 */
	private void verificarBeneficiarioDemitido(Beneficiario beneficiario, LocalDateTime dataMonitoramento, String tipoPeriodo) {

		RHFuncionario rhFuncionario = rhFuncionarioService
				.findByMatricula(Integer.parseInt(beneficiario.getMatriculaFlem()));
		LocalDate dataInicioTrimestre;
	    LocalDate ldAtual = LocalDate.now();

		if (rhFuncionario.getDesligamento() != null) {
			Periodo periodo = periodoService.obterPeriodoPorMes(dataMonitoramento.getMonthValue(), tipoPeriodo);
			if (periodo.getMesInicio() < 0 && ldAtual.getMonth().getValue() != MES_12) {				
				 dataInicioTrimestre = LocalDate.of(ldAtual.getYear()-1, Math.abs(periodo.getMesInicio()), 1);
			} else {
				 dataInicioTrimestre = LocalDate.of(dataMonitoramento.getYear(), Math.abs(periodo.getMesInicio()), 1);
			}
			LocalDate dataDesligamento = DateUtil.convertToLocalDate(rhFuncionario.getDesligamento());
			if (!DateUtil.isLessThan(dataInicioTrimestre, dataDesligamento)) {
				throw new MonitoramentoException(
						"Monitoramento nÃ£o pode ser realizado: BeneficiÃ¡rio foi demitido antes do Ã­nicio do trimestre!");
			}
		}
	}

	/**
	 * Valida campos obrigatÃ³rios nÃ£o preenchidos
	 *
	 * @param dto
	 */
	private void verificarCamposObrigatorio(MonitorarDTO dto) {
		if (dto.getIdBeneficiario() == null) {
			throw new MonitoramentoException("FuncionÃ¡rio nÃ£o foi informado");
		}

		if (dto.getDataMonitoramento() == null) {
			throw new MonitoramentoException("Data do monitoramento nÃ£o informada");
		}

		if (DateUtil.isAfter(dto.getDataMonitoramento(), LocalDateTime.now())) {
			throw new MonitoramentoException("Data do monitoramento nÃ£o pode ser maior que a Data Atual");
		}

		if (dto.getIdMeta() == null) {
			throw new MonitoramentoException("A Submeta nÃ£o foi informada");
		}

		if (StringUtils.isBlank(dto.getPrincipaisRegistros())) {
			throw new MonitoramentoException("Principais Registros da VisitaÃ§Ã£o Ã© uma informaÃ§Ã£o obrigatÃ³ria!");
		}
	}

	/**
	 * Obtem ultimo monitoramento do beneficiario
	 *
	 * @param beneficiario
	 * @return
	 */
	public RegistroMonitoramento findFirstByBeneficiarioOrderByDataMonitoramentoDesc(Beneficiario beneficiario) {
		return dao.findFirstByBeneficiarioAndExcluidoFalseOrderByDataMonitoramentoDesc(beneficiario);
	}

	/**
	 * @param idBeneficiario
	 * @return
	 */
	public RegistroMonitoramento findFirstByBeneficiarioOrderByDataMonitoramentoDesc(Long idBeneficiario) {
		Beneficiario beneficiario = beneficiarioService.findById(idBeneficiario);
		return dao.findFirstByBeneficiarioAndExcluidoFalseOrderByDataMonitoramentoDesc(beneficiario);
	}

	/**
	 * Preencher a data do proximo monitoramento
	 *
	 * @param monitoramento
	 */
	private void inserirProximoMonitoramento(RegistroMonitoramento monitoramento) {
		agendamentoService.finalizarAgendamento(monitoramento.getBeneficiario(), monitoramento.getDataMonitoramento());
		LocalDate dataMonitoramento = monitoramento.getDataMonitoramento().toLocalDate();
		String tipoPeriodo = monitoramento.getMeta().getTipo().getPeriodo().equalsIgnoreCase("TRIMESTRE") ? "SEMESTRE":"TRIMESTRE";
		
		//System.out.println("Tipo Periodo : " + tipoPeriodo);
		
		agendamentoService.criarNovoAgendamento(monitoramento.getBeneficiario(), null, tipoPeriodo);
		monitoramento.setDataProxMonitoramento(dataMonitoramento.plusMonths(3l));
	}

	/**
	 *
	 * @param dataInicioParam
	 * @param dataFimParam
	 * @param unidadeLotacao
	 * @param idMunicipio
	 * @param idDemandante
	 * @return
	 * @throws MonitoramentoException
	 * @throws java.io.UnsupportedEncodingException
	 */
	public List<ListaMonitoramentoDTO> filterBy(LocalDate dataInicioParam, LocalDate dataFimParam,
			String unidadeLotacao, Long idMunicipio, Long idDemandante)
			throws UnsupportedEncodingException {
		List<ListaMonitoramentoDTO> dtoList = new ArrayList<>();
		List<RegistroMonitoramento> monitoramentos = filterByDataMonitoramentoBetweenAndMunicipioAndDemandandeAndUnidadeDeLotacao(
				dataInicioParam, dataFimParam, idMunicipio, idDemandante, unidadeLotacao, null);
		if (monitoramentos == null || monitoramentos.isEmpty()) {
			throw new MonitoramentoException("Nenhum Registro localizado!");
		}
		monitoramentos.forEach(item -> {
			ListaMonitoramentoDTO dto = new ListaMonitoramentoDTO();
			Beneficiario beneficiario = item.getBeneficiario();

			Demandante demandante = item.getDemandante();
			Municipio municipio = item.getMunicipio();
			dto.setId(item.getId());
			dto.setDataMonitoramento(item.getDataMonitoramento());
			if (demandante != null) {
				dto.setNomeDemandante(demandante.getNome());
			}
			dto.setIdEgresso(beneficiario.getId());
			dto.setNomeEgresso(beneficiario.getNome());
			dto.setCpfEgresso(beneficiario.getCpf());
			if (beneficiario.getMatriculaFlem() != null) {
				dto.setMatriculaEgresso(Integer.parseInt(beneficiario.getMatriculaFlem()));
			}
			dto.setAdmissaoEgresso(DateUtil.formatarData(beneficiario.getDataAdmissao(), "dd/MM/yyyy"));
			if (municipio != null) {
				dto.setNomeMunicipio(municipio.getNome());
			}
			dto.setProxMonitoramento(item.getDataProxMonitoramento().atTime(0, 0));
			dto.setUnidadeDeLotacao(item.getUnidadeLotacao());
			dtoList.add(dto);
		});
		return dtoList;
	}

	public List<RegistroMonitoramento> filterByDataMonitoramentoBetweenAndMunicipioAndDemandandeAndUnidadeDeLotacao(
			LocalDate dataInicio, LocalDate dataFim, Long idMunicipio, Long idDemandante, String unidadeLotacao,String usuarioCriacao)
			throws UnsupportedEncodingException {
		LocalDateTime dataInicioTime = dataInicio != null ? dataInicio.atTime(0, 0) : null;
		LocalDateTime dataFimTime = dataFim != null ? dataFim.atTime(23, 59) : null;
		Municipio municipio = null;
		Demandante demandante = null;
		if (!DateUtil.isLessThan(dataInicio, dataFim) && !dataInicio.isEqual(dataFim)) {
			throw new MonitoramentoException("Data Final nÃ£o pode ser maior que a data Inicial!");
		}
		if (idMunicipio != null) {
			municipio = municipioService.findById(idMunicipio);
		}
		if (idDemandante != null) {
			demandante = demandanteService.findById(idDemandante);
		}
		return customRegistroMonitoramentoDAO.findByDataMonitoramentoBetweenAndMunicipioAndDemandante(dataInicioTime,
				dataFimTime, municipio, demandante, unidadeLotacao, usuarioCriacao);
	}

	/**
	 * @param demandantes
	 * @param municipios
	 * @return
	 */
	public List<String> obterUnidadeLotacaoByDemandantesAndMunicipios(List<Long> demandantes, List<Long> municipios) {
		return vagaService.obterUnidadeLotacaoByDemandantesAndMunicipios(demandantes, municipios);
	}

	/**
	 *
	 * @param registro
	 * @return
	 */
	public RegistroMonitoramento update(RegistroMonitoramento registro) {
		preUpdate(registro);
		return dao.save(registro);
	}

	/**
	 * @param registro
	 * @return
	 */
	public RegistroMonitoramento delete(RegistroMonitoramento registro) {
		registro.setExcluido(Boolean.TRUE);
		return update(registro);
	}

	/**
	 * Carrega todos os
	 *
	 * @param id
	 * @return
	 * @throws java.io.IOException
	 */
	public Resource obterDocumentosPorId(Long id) throws IOException {
		Questionario questionario = questionarioService.findByRegistroMonitoramento(id);
		if (questionario == null) {
			throw new MonitoramentoException("Monitoramento nÃ£o tem nenhum questionÃ¡rio associado!");
		}
		List<AvaliacaoQuestionario> avaliacoes = avaliacaoQuestionarioService.findByIdQuestionario(questionario);
		if (avaliacoes == null || avaliacoes.isEmpty()) {
			throw new MonitoramentoException("Monitoramento nÃ£o possui nenhuma avaliaÃ§Ã£o anexada!");
		}
		avaliacoes.forEach(eva -> {
			fileStorageService.loadFile(eva.getFilePath());
		});
		return new ClassPathResource(File.separator + "temp" + File.separator + "avaliacoes.zip");
	}

	/**
	 * @param path
	 * @return
	 */
	public Resource obterDocumentoPorPath(String path) {
		return fileStorageService.loadFile(path);
	}

	/**
	 * @param startDate
	 * @param idDemandante
	 * @param endDate
	 * @return
	 */
	public List<SinteseRelatorioTrimestralProj> findByPeriodoAndDemandante(LocalDate startDate, LocalDate endDate,
			Long idDemandante) {
		return findByAllStartDateLessThanEqualAndEndDateGreaterThanEqual(startDate.atTime(0, 0), endDate.atTime(23, 59),
				idDemandante);
	}

	/**
	 * @param startDate
	 * @param endDate
	 * @param idDemandante
	 * @return
	 */
	public List<SinteseRelatorioTrimestralProj> findByAllStartDateLessThanEqualAndEndDateGreaterThanEqual(
			LocalDateTime startDate, LocalDateTime endDate, Long idDemandante) {
		return dao.findByAllStartDateLessThanEqualAndEndDateGreaterThanEqual(startDate, endDate, idDemandante);
	}
	
	/**
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<SinteseRelatorioTrimestralProj> findByAllStartDateLessThanEqualAndEndDateGreaterThanEqual(
			LocalDateTime startDate, LocalDateTime endDate) {
		return dao.findByAllStartDateLessThanEqualAndEndDateGreaterThanEqual(startDate, endDate);
	}
	
	/**
	 * @param monitoramentos
	 * @param meta - 0 para (todas), 1 para meta 1, 2 para meta 2
	 * @return
	 */
	public List<MunicipioDTO> getMunicipios(List<SinteseRelatorioTrimestralProj> monitoramentos, int meta) {
		List<MunicipioDTO> stream = new ArrayList<>();
		List<String> metaStr = new ArrayList<>();
		final int numMeta = meta;
		if (!monitoramentos.isEmpty()) {
			monitoramentos.forEach(moni -> {
				MunicipioDTO dto = new MunicipioDTO(null, moni.getMunicipio());
				if (stream.isEmpty()) {
					dto.setMonitoramentos(new HashSet<>());
					RelatorioMonitoramentoDTO obj = obterRegistroPorId(moni.getId());
					if (obj != null) {
						
						
						
						
						metaStr.add(obj.getSubMeta());
	
						switch(numMeta)
						{
						case 1:
							if (metaStr.get(0).contains("4.1"))
							{
								dto.getMonitoramentos().add(obj);
								System.out.println("nome: " + obj.getNomeEgresso());
								System.out.println("meta: " + metaStr.get(0));
								
								stream.add(dto);
							}
							break;
						case 2:
							if (metaStr.get(0).contains("4.2"))
							{
								dto.getMonitoramentos().add(obj);
								System.out.println("nome: " + obj.getNomeEgresso());
								System.out.println("meta: " + metaStr.get(0));
								
								stream.add(dto);
							}
							break;
						default:
							dto.getMonitoramentos().add(obj);
							stream.add(dto);
							break;
						}
						
						
					}
				} else if (stream.stream().filter(item -> item.getNome().equalsIgnoreCase(moni.getMunicipio()))
						.findAny().isPresent()) {
					stream.forEach(st -> {
						if (st.getNome().equalsIgnoreCase(moni.getMunicipio())) {
							RelatorioMonitoramentoDTO obj = obterRegistroPorId(moni.getId());
							metaStr.add(obj.getSubMeta());
							switch(numMeta)
							{
							case 1:
								if (metaStr.get(0).contains("4.1"))
								{
									st.getMonitoramentos().add(obterRegistroPorId(moni.getId()));
								}
								break;
							case 2:
								if (metaStr.get(0).contains("4.2"))
								{
									st.getMonitoramentos().add(obterRegistroPorId(moni.getId()));
								}
								break;
							default:
								st.getMonitoramentos().add(obterRegistroPorId(moni.getId()));
							}
						}
					});
				} else {
					dto.setMonitoramentos(new HashSet<>());
					RelatorioMonitoramentoDTO obj = obterRegistroPorId(moni.getId());
					if (obj != null) {
						
						
						
						
						
						metaStr.add(obj.getSubMeta());
						
						switch(numMeta)
						{
						case 1:
							if (metaStr.get(0).contains("4.1"))
							{
								dto.getMonitoramentos().add(obj);
								System.out.println("nome: " + obj.getNomeEgresso());
								System.out.println("meta: " + metaStr.get(0));
								
								stream.add(dto);
							}
							break;
						case 2:
							if (metaStr.get(0).contains("4.2"))
							{
								dto.getMonitoramentos().add(obj);
								System.out.println("nome: " + obj.getNomeEgresso());
								System.out.println("meta: " + metaStr.get(0));
								
								stream.add(dto);
							}
							break;
						default:
							dto.getMonitoramentos().add(obj);
							stream.add(dto);
							break;
						}
						
					}
				}
				metaStr.clear();
			});
			stream.sort((p1, p2) -> p1.getNome().compareTo(p2.getNome()));
		}
		return stream;
	}

	/**
	 * @param monitoramentos
	 * @param meta - 0 para (todas), 1 para meta 1, 2 para meta 2
	 * @return
	 */
	public List<SinteseRelatorioTrimestralDTO> getRelatorioTrimestralDTO(
			List<SinteseRelatorioTrimestralProj> monitoramentos, int meta) {
		List<SinteseRelatorioTrimestralDTO> stream = new ArrayList<>();
////////////Código ABAIXO Adicionado por Daniel Augusto Almeida em 10/02/2022
		
		List<String> metaStr = new ArrayList<>();
		
		System.out.println("Iniciando getRelatorioTrimestralDTO, meta " + meta);
		
////////////Código ACIMA Adicionado por Daniel Augusto Almeida em 10/02/2022
		
			if (!monitoramentos.isEmpty()) {
			monitoramentos.forEach(item -> {
				
	////////////Código ABAIXO Adicionado por Daniel Augusto Almeida em 10/02/2022
				
				RelatorioMonitoramentoDTO obj = obterRegistroPorId(item.getId());
				metaStr.add(obj.getSubMeta());
				
		
	////////////Código ACIMA Adicionado por Daniel Augusto Almeida em 10/02/2022
				
				SinteseRelatorioTrimestralDTO dto = new SinteseRelatorioTrimestralDTO();
				dto.setCpfEgresso(item.getCpfEgresso());
				dto.setDataMonitoramento(item.getDataMonitoramento());
				dto.setDataVisita(DateUtil.formatarData(item.getDataMonitoramento(), "dd/MM/yyyy"));
				dto.setDemandante(item.getDemandante());
				dto.setMatriculaEgresso(item.getMatriculaEgresso());
				dto.setMonitor(getUser(item.getUsuarioCriacao()).getNome());
				dto.setMunicipio(item.getMunicipio());
				dto.setNomeEgresso(item.getNomeEgresso());
				dto.setUnidadeDeLotacao(item.getUnidadeDeLotacao());
				dto.setSiglaDemandante(item.getSiglaDemandante());
				
	////////////Código ABAIXO Adicionado por Daniel Augusto Almeida em 13/08/2020
				
				dto.setIdComprovacao(item.getIdComprovacao());
				
	////////////Código ACIMA Adicionado por Daniel Augusto Almeida em 13/08/2020
				
				dto.setDataAdmissao(DateUtil.formatarData(item.getAdmissao(), "dd/MM/yyyy"));
				List<AvaliacaoQuestionarioDTO> avaliacoes = avaliacaoQuestionarioService
						.findByIdRegistroMonitoramento(item.getId());
				if ( (!avaliacoes.isEmpty()) && (metaStr.get(0).contains("4.2")) )
                {
                    String avaliacoesRealizadas = avaliacoes.stream().map(n -> n.getFileName()).collect(Collectors.joining(", "));
                    dto.setAvaliacoes(avaliacoesRealizadas);
                }
				//stream.add(dto);
				
	////////////Código ABAIXO Adicionado por Daniel Augusto Almeida em 10/02/2022
				
				switch(meta)
				{
				case 1:
					if (metaStr.get(0).contains("4.1"))
					{
						System.out.println("nome: " + dto.getNomeEgresso());
						System.out.println("meta: " + metaStr.get(0));
						stream.add(dto);
					}
					break;
				case 2:
					if (metaStr.get(0).contains("4.2"))
					{
						System.out.println("nome: " + dto.getNomeEgresso());
						System.out.println("meta: " + metaStr.get(0));
						stream.add(dto);
					}
					break;
				default:
					stream.add(dto);
					break;
				}
				metaStr.clear();
				
	////////////Código ACIMA Adicionado por Daniel Augusto Almeida em 10/02/2022
				
			});
		}
			System.out.println("FINALIZADO getRelatorioTrimestralDTO, meta " + meta);
		return stream;
	}

	/**
	 * @param dataInicio
	 * @param dataFim
	 * @param idDemandante
	 * @return
	 * @throws JRException
	 * @throws IOException
	 */
	public byte[] getRelatorioTrimetral(LocalDate dataInicio, LocalDate dataFim, Long idDemandante)
			throws JRException, IOException {
		/**
		if (CoreUtil.isAnyNull(dataInicio, dataFim, idDemandante)) {
			throw new MonitoramentoException("ParÃ¢metros: Data de Inicio, Data Final e Demandante sÃ£o obrigatÃ³rios");
		}
		*/
		
		List<JasperPrint> listJasperPrint = new ArrayList<>();

		List<SinteseRelatorioTrimestralProj> monitoramentos = findByPeriodoAndDemandante(dataInicio, dataFim,
				idDemandante);
		if (monitoramentos == null || monitoramentos.isEmpty()) {
			throw new MonitoramentoException("Nenhum Monitoramento Localizado para este PerÃ­odo");
		}
		List<SinteseRelatorioTrimestralDTO> sinteses = getRelatorioTrimestralDTO(monitoramentos, 1);
		
		
		List<MunicipioDTO> municipios = getMunicipios(monitoramentos, 1);
		
		System.out.println("Municipios OK");

		String reportNameOne = "demandanteRelTrimestral3.jasper";
		String reportNameTwo = "sinteseVisitasRelTrimestral.jasper";
		String reportNameThree = "listaDeMunicipiosRelTrimestral.jasper";
		
		String demandante = monitoramentos.get(0).getDemandante();

		listJasperPrint.add(
				reportsService.getJasperPrint(getParameters(dataInicio, dataFim, demandante), reportNameTwo, sinteses));
		
		System.out.println("Report Sinteses");
		
		listJasperPrint.add(reportsService.getJasperPrint(getParameters(dataInicio, dataFim, demandante),
				reportNameThree, municipios));
		
		System.out.println("Report Municipios");

		RelatorioTrimestralDTO reports = new RelatorioTrimestralDTO(demandante, sinteses, new ArrayList<>());
		List<RelatorioTrimestralDTO> lista = new ArrayList<>();
		lista.add(reports);		
		
		JasperPrint printOne = reportsService.getJasperPrint(getParameters(dataInicio, dataFim, demandante),
				reportNameOne, lista);
		
		System.out.println("Parameters ok");
		
		
		addMunicipios(listJasperPrint, municipios, dataInicio, dataFim, 1);
		System.out.println("addMunicipios OK");

		listJasperPrint.stream().map(JasperPrint::getPages).forEach(pages -> {
			for (int i = 0; i < pages.size(); i++) {
				JRPrintPage object = (JRPrintPage) pages.get(i);
				printOne.addPage(object);
			}
		});
		
		
		
		
		
		
		List<JasperPrint> listJasperPrint2 = new ArrayList<>();
		String reportName4 = "demandanteRelTrimestral2.jasper";
		String reportName5 = "sinteseVisitasRelTrimestral2.jasper";
		String reportName6 = "listaDeMunicipiosRelTrimestral2.jasper";
		List<SinteseRelatorioTrimestralDTO> sinteses2 = getRelatorioTrimestralDTO(monitoramentos, 2);
		RelatorioTrimestralDTO reports2 = new RelatorioTrimestralDTO(demandante, sinteses2, new ArrayList<>());
		List<RelatorioTrimestralDTO> lista2 = new ArrayList<>();
		lista2.add(reports2);
		List<MunicipioDTO> municipios2 = getMunicipios(monitoramentos, 2);
		listJasperPrint2.add(
				reportsService.getJasperPrint(getParameters(dataInicio, dataFim, demandante), reportName4, lista2));
		System.out.println("Report Capa2");
		listJasperPrint2.add(
				reportsService.getJasperPrint(getParameters(dataInicio, dataFim, demandante), reportName5, sinteses2));
		
		System.out.println("Report Sinteses2");
		listJasperPrint2.add(reportsService.getJasperPrint(getParameters(dataInicio, dataFim, demandante),
				reportName6, municipios2));
		
		System.out.println("Report Municipios2");
		addMunicipios(listJasperPrint2, municipios2, dataInicio, dataFim, 2);
		System.out.println("addMunicipios2 OK");
		
		
		listJasperPrint2.stream().map(JasperPrint::getPages).forEach(pages -> {
			for (int i = 0; i < pages.size(); i++) {
				JRPrintPage object = (JRPrintPage) pages.get(i);
				printOne.addPage(object);
			}
		});
		
		
		
		
		
		
		System.out.println("FINALIZADO");
		return countAndGenerateReport(printOne);
	}
	
	/**
	private byte[] reportTwoAtOnce(JasperPrint printOne, JasperPrint printTwo)
	{
	  List<JasperPrint> output = new ArrayList<>();
	  output.add(printOne);
	  output.add(printTwo);
	  
	  output.forEach((item) ->{
		  
	  });
	}
*/
	
	private byte[] countAndGenerateReport(JasperPrint printOne) throws JRException, IOException {
		int currentPage = 1;
		int totPageNumber = printOne.getPages().size();
		for (JRPrintPage jp : printOne.getPages()) {
			List<JRPrintElement> elements = jp.getElements();
			for (JRPrintElement jpe : elements) {
				if (jpe instanceof JRPrintText) {
					JRPrintText jpt = (JRPrintText) jpe;
					if (CURRENT_PAGE_NUMBER.equals(jpt.getValue())) {
						jpt.setText("Página " + currentPage + " de");
						continue;
					}
					
					if (TOTAL_PAGE_NUMBER.equals(jpt.getValue())) {
						jpt.setText(" " + totPageNumber);
					}
				}
			}
			currentPage++;
		}
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setExporterInput(new SimpleExporterInput(printOne));
		final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		SimpleOutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(outputStream);
		exporter.setExporterOutput(exporterOutput);

		SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
		reportConfig.setSizePageToContent(true);
		reportConfig.setForceLineBreakPolicy(false);

		SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
		exportConfig.setCompressed(Boolean.FALSE);
		exporter.setConfiguration(reportConfig);
		exporter.setConfiguration(exportConfig);

		exporter.exportReport();
		deleteAll();
		return outputStream.toByteArray();
	}

	private void addRegistros(List<JasperPrint> listJasperPrint, RelatorioMonitoramentoDTO registro) {
		Set<RelatorioMonitoramentoDTO> listaM = new HashSet<>();
		if (registro != null) {
			listaM.add(registro);
			registro.setAssinatura(reportsService.loadSignature(registro.getIdMonitor()));
		}
		String reportRegistroMonitoramento = "registroMonitoramento.jasper";
		listJasperPrint.add(reportsService.getJasperPrint(new HashMap<>(), reportRegistroMonitoramento, listaM));
		if (registro != null && registro.getAvaliacoesQuestionario() != null
				&& !registro.getAvaliacoesQuestionario().isEmpty()) {
			registro.getAvaliacoesQuestionario().forEach(ava -> {
				String[] filename = ava.getFilePath().split("/");
				addListaOrAvaliacao(listJasperPrint, ava.getFilePath(), ava.getFilePath(),
						filename[filename.length - 1]);
			});
		}
	}

	private void addProofs(List<JasperPrint> listJasperPrint, Set<RelatorioMonitoramentoDTO> monitoramentos) {
		List<Long> idsComprovacoes = monitoramentos.stream().map(RelatorioMonitoramentoDTO::getIdComprovacao).distinct()
				.collect(Collectors.toList());
		if (idsComprovacoes != null && !idsComprovacoes.isEmpty()) {
			idsComprovacoes.forEach(proof -> {
				if (proof != null) {
					Comprovacao comprovacao = comprovacaoService.findById(proof);
					addListaOrAvaliacao(listJasperPrint, comprovacao.getFilePath(), comprovacao.getContentType(),
							comprovacao.getFileName());
				}
			});
		}
	}

	private void addListaOrAvaliacao(List<JasperPrint> listJasperPrint, String filePath, String contentType,
			String filename) {
		try {
			List<ComprovacaoRelDTO> inputs = new ArrayList<>();
			Resource res = fileStorageService.loadFile(filePath);
			try (InputStream inputStream = res.getInputStream()) {
				String reportListaPresenca = "listaPresencaRelTrimestral.jasper";
				if (contentType.contains("image") || contentType.contains("jpg") || contentType.contains("jpeg")) {
					inputs.add(new ComprovacaoRelDTO(inputStream));
					listJasperPrint.add(reportsService.getJasperPrint(new HashMap<>(), reportListaPresenca, inputs));
				} else if (contentType.contains("pdf")) {

					List<String> paths = fromPdfToImage(inputStream, filename);
					if (!paths.isEmpty()) {
						for (String path : paths) {
							inputs = new ArrayList<>();
							File file = new File(path);
							inputs.add(new ComprovacaoRelDTO(new FileInputStream(file)));
							listJasperPrint
									.add(reportsService.getJasperPrint(new HashMap<>(), reportListaPresenca, inputs));
						}
					}
				}
			}
		} catch (IOException ex) {
			Logger.getLogger(RegistroMonitoramentoService.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void addMunicipios(List<JasperPrint> listJasperPrint, List<MunicipioDTO> municipios, LocalDate dataInicio,
			LocalDate dataFim, int meta) {
		String reportMunicipio = "";
		switch(meta)
		{
		case 1:
			reportMunicipio = "municipioRelTrimestral.jasper";
			break;
		case 2:
			reportMunicipio = "municipioRelTrimestral2.jasper";
			break;
		default:
			reportMunicipio = "municipioRelTrimestral.jasper";
			break;
		}
		String reportMun = reportMunicipio;
		municipios.forEach(item -> {
			listJasperPrint.add(reportsService.getJasperPrint(getParameters(dataInicio, dataFim, item.getNome()),
					reportMun, new ArrayList<>()));
			if (item.getMonitoramentos() != null && !item.getMonitoramentos().isEmpty()) {
				addProofs(listJasperPrint, item.getMonitoramentos());
				item.getMonitoramentos().forEach(id ->
					addRegistros(listJasperPrint, id)
				);
			}
		});
	}

	private List<String> fromPdfToImage(InputStream input, String filename) throws IOException {
		List<String> paths = new ArrayList<>();
		String[] filenameOld = filename.split("\\.");
		try (PDDocument document = PDDocument.load(input)) {
			PDFRenderer pdfRenderer = new PDFRenderer(document);
			for (int page = 0; page < document.getNumberOfPages(); ++page) {
				BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
				String path = "/tmp/" + filenameOld[0] + "-" + page + ".jpg";
				File outputfile = new File(path);
				if (!outputfile.exists()) {
					outputfile.mkdirs();
				}
				ImageIO.write(bim, "jpg", outputfile);
				paths.add(path);
			}
		}
		return paths;
	}

	private void deleteAll() throws IOException {
		File outputfile = new File("/tmp/");
		for (File file : outputfile.listFiles()) {
			file.delete();
		}
	}

	private Map<String, Object> getParameters(LocalDate startDate, LocalDate endDate, String demandante) {
		Map<String, Object> params = new HashMap<>();
		params = getParameters(startDate, endDate);
		params.put("DEMANDANTE", demandante);
		params.put("MUNICIPIO", demandante);
		return params;
	}
	
	private Map<String, Object> getParameters(LocalDate startDate, LocalDate endDate) {
		Map<String, Object> params = new HashMap<>();
		if( startDate != null )
			params.put("START_DATE", DateUtil.formatarData(startDate, "MM/yyyy"));
		if( endDate != null )
			params.put("END_DATE", DateUtil.formatarData(endDate, "MM/yyyy"));
		if (!params.containsKey("LOGO_FLEM")) 
			params.put("LOGO_FLEM", loadFile(parameterService.findById(ParameterEnum.LOGO_FLEM_HORIZONTAL.getChave()).getValor()));
		
		if (!params.containsKey("LOGO_GOV")) 
			params.put("LOGO_GOV", loadFile(parameterService.findById(ParameterEnum.PP_GOV_2019.getChave()).getValor()));
		return params;
	}

	/**
	 *
	 * @param parameters
	 * @param pathReport
	 * @param collections
	 * @return
	 * @throws JRException
	 * @throws java.io.IOException
	 */
	public byte[] generatePDF(Map<String, Object> parameters, String pathReport, Collection<?> collections)
			throws JRException {
		return reportsService.generatePDF(parameters, pathReport, collections);
	}
		
    /**
	 * 
	 * @param filePath
	 * @return
	 */
	private InputStream loadFile(String filePath) {
		Resource res = loadFileResource(filePath);
		try {
			return res.getInputStream();
		} catch (IOException e) {
			return null;
		}
	}
	
	private Resource loadFileResource(String filePath) {
		return fileStorageService.loadFile(filePath);
	}
	
	/**
	 * metodo que retorna um registro de monitoramento
	 * 
	 * @param id
	 * @return
	 */
	public RegistroMonitoramentoEditarDTO getMonitoramento(Long id) {
		RegistroMonitoramento monitoramento = this.findById(id);
		if (monitoramento != null) {
			return getDTO(monitoramento);
		}
		return null;

	}

	/**
	 * metodo que preenche RelatorioMonitoramentoDTO
	 * 
	 * @param monitoramento
	 * @return
	 */
	public RegistroMonitoramentoEditarDTO getDTO(RegistroMonitoramento monitoramento) {
		RegistroMonitoramentoEditarDTO dto = new RegistroMonitoramentoEditarDTO();
		dto.setId(monitoramento.getId());
		MonitoramentoComprovacaoDTO comp = new MonitoramentoComprovacaoDTO();
		comprovacaoService.carregarPathAvaliacoes(monitoramento, comp);
		dto.setPathAvaliacoes(comp.getPathAvaliacoes());
		dto.setDataMonitoramento(monitoramento.getDataMonitoramento());
		
////////////Código ABAIXO Adicionado por Daniel Augusto Almeida em 09/07/2020
		
		dto.setObservacao(monitoramento.getObservacao());
		
////////////Código ACIMA Adicionado por Daniel Augusto Almeida em 09/07/2020
		
		dto.setPresente(monitoramento.getPresente());
		dto.setPrincipaisRegistros(monitoramento.getPrincipaisRegistros());
		dto.setUnidadeLotacao(monitoramento.getUnidadeLotacao());
		dto.setPresente(monitoramento.getPresente());
		dto.setMeta(monitoramento.getMeta());
		dto.setPrincipaisRegistros(monitoramento.getPrincipaisRegistros());

		if (monitoramento.getMunicipio() != null) {
			dto.setIdMunicipio(monitoramento.getMunicipio().getId());
			dto.setNomeMuniciopio(monitoramento.getMunicipio().getNome());
		}
		if (monitoramento.getDemandante() != null) {
			dto.setIdDamandante(monitoramento.getDemandante().getId());
			dto.setNomeDemandante(monitoramento.getDemandante().getNome());
		}
		if (monitoramento.getBeneficiario() != null) {
			dto.setIdBeneficiario(monitoramento.getBeneficiario().getId());
			dto.setBeneficiario(monitoramento.getBeneficiario().getNome());
			if (monitoramento.getBeneficiario().getFormacao() != null) {
				dto.setIdFormacao(monitoramento.getBeneficiario().getFormacao().getId());
				dto.setFormacao(monitoramento.getBeneficiario().getFormacao().getNome());
			}

		}
		Questionario questionario = questionarioService.findByRegistroMonitoramento(monitoramento.getId());
		if (questionario != null) {
			dto.setDesvioDeFuncao(questionario.getDesvioDeFuncao());
			dto.setTipoDesvioDeFuncao(questionario.getTipoDesvioDeFuncao());
			dto.setDescricaoDesvioDeFuncao(questionario.getDescricaoDesvioDeFuncao());
			dto.setGravida(questionario.getGravida());
			dto.setAcidenteDeTrabalho(questionario.getAcidenteDeTrabalho());
			dto.setDescricaoAcidenteDeTrabalho(questionario.getDescricaoAcidenteDeTrabalho());
			dto.setConhecimento(questionario.getConhecimento());
			dto.setHabilidade(questionario.getHabilidade());
			dto.setAutonomia(questionario.getAutonomia());
			dto.setPontualidade(questionario.getPontualidade());
			dto.setMotivacao(questionario.getMotivacao());
			dto.setExperienciaProfissional(questionario.getExperienciaProfissional());
			dto.setIdQuestionario(questionario.getId());
			dto.setObservacao(questionario.getObservacao());
		}
		return dto;
	}
	
	/**
	 * @param dto
	 * @param files
	 * @throws MonitoramentoException
	 */
	@Transactional
	public void editarRegistrarMonitoramento(MonitorarDTO dto, MultipartFile[] files) {
		RegistroMonitoramento monitoramento = this.findById(dto.getId());
		if (monitoramento != null) {
			Beneficiario beneficiario = beneficiarioService.findById(dto.getIdBeneficiario());
			String login = getCurrentUser();
			verificarRegras(dto, beneficiario, monitoramento, login);


			Colaborador monitor = colaboradorService.findByEmail(login + "@flem.org.br");
			Vaga vaga = getVaga(dto);
			if (monitor == null) {
				throw new MonitoramentoException("UsuÃ¡rio logado nÃ£o estÃ¡ habilitado para fazer monitoramento!");
			}
			MonitorDemandante associacao = getAssociacao(vaga);

			monitoramento.setBeneficiario(beneficiario);
			monitoramento.setDataMonitoramento(dto.getDataMonitoramento());
			monitoramento.setObservacao(dto.getObservacao());
			monitoramento.setMonitor(monitor);
			monitoramento.setMonitorAssociado(associacao.getMonitor());
			monitoramento.setDemandante(associacao.getDemandante());
			monitoramento.setMunicipio(associacao.getMunicipio());

			if (dto.getIdMeta() != null) {
				monitoramento.setMeta(metaService.findById(dto.getIdMeta()));
			}
			monitoramento.setLinks(dto.getLinks());
			monitoramento.setUnidadeLotacao(vaga.getUnidadeDeLotacao());
			monitoramento.setPrincipaisRegistros(dto.getPrincipaisRegistros());
			monitoramento.setPresente(dto.getPresente());
			monitoramento.setAgendamento(agendamentoService.obterAgendamentoAbertoPorBeneficiario(beneficiario));
			
			// inserirProximoMonitoramento(monitoramento);

			RegistroMonitoramento registroSalvo = update(monitoramento);
			editarQuestionario(dto.getQuestionario(), registroSalvo, files);
			
			// enviarEmail(dto, monitoramento);
		}

	}

	/**
	 *
	 * @param dto
	 * @param registroMonitoramento
	 * @param files
	 */
	public void editarQuestionario(QuestionarioDTO dto, RegistroMonitoramento registroMonitoramento,
			MultipartFile[] files) {
		if (dto != null) {
			Questionario questionario = questionarioService.findById(dto.getId());
			questionario.setRegistroMonitoramento(registroMonitoramento);
			preencherQuestionario(registroMonitoramento, dto, questionario);

			questionarioService.update(questionario);

			AvaliacaoQuestionarioDTO avaDto = new AvaliacaoQuestionarioDTO();
			avaDto.setIdQuestionario(questionario.getId());

			if (registroMonitoramento.getMeta().getTipo().equals(TipoMetaEnum.SEMESTRAL)) {
				editarAvaliacoesRealizadas(registroMonitoramento, avaDto, files, dto.getAvaliacoes());
			}
		}
	}

	/**
	 * Para funcionar, deve-se incluir no nome do arquivo o prefixo com o id da
	 * avaliaÃ§Ã£o ex.: 2_nome_do_arquivo
	 *
	 * @param dto
	 * @param files
	 * @param avaliacoes
	 */
	private void editarAvaliacoesRealizadas(RegistroMonitoramento registroMonitoramento, AvaliacaoQuestionarioDTO dto,
			MultipartFile[] files, List<Long> avaliacoes) {

		if (avaliacoes != null && !avaliacoes.isEmpty()) {
			avaliacoes.forEach(evaluation -> {
				if (files.length > 0) {
					for (MultipartFile file : files) {
						String[] fileName = file.getOriginalFilename().split("_");
						Long idEvaluation = Long.parseLong(fileName[0]);
						if (evaluation.compareTo(idEvaluation) == 0) {
							dto.setIdAvaliacao(evaluation);
							String path = registroMonitoramento.getBeneficiario().getMatriculaFlem() + "/"
									+ registroMonitoramento.getId();
							String filePath = fileStorageService.storeAvaliacao(path, file);
							dto.setFilePath(filePath);
						}
					}
				}
				avaliacaoQuestionarioService.update(dto);
			});
		}
	}
	
	public byte[] getRelatorioSintesePorPeriodo(LocalDate dataInicio, LocalDate dataFim) throws IOException, JRException {
		
		List<SinteseRelatorioTrimestralDTO> sinteses = getRelatorioSintese(dataInicio, dataFim);
		String reportNameTwo = "sinteseVisitasRelTrimestral.jasper";		
		
		JasperPrint printOne = reportsService.getJasperPrint(getParameters(dataInicio, dataFim), reportNameTwo, sinteses);
		
		return countAndGenerateReport(printOne);	
	}
	
	public byte[] getRelatorioSintesePorPeriodo2(LocalDate dataInicio, LocalDate dataFim) throws IOException, JRException {
		
		
		List<SinteseRelatorioTrimestralProj> monitoramentos = findByAllStartDateLessThanEqualAndEndDateGreaterThanEqual(dataInicio.atTime(0, 0),dataFim.atTime(23, 59));
		
		
		List<SinteseRelatorioTrimestralDTO> sinteses = getRelatorioTrimestralDTO(monitoramentos, 1);
		List<SinteseRelatorioTrimestralDTO> sinteses2 = getRelatorioTrimestralDTO(monitoramentos, 2);
		String reportNameTwo = "sinteseVisitasRelTrimestral.jasper";	
		String reportNameThree = "sinteseVisitasRelTrimestral2.jasper";
		
		List<JasperPrint> listJasperPrint = new ArrayList<>();
		listJasperPrint.add(
				reportsService.getJasperPrint(getParameters(dataInicio, dataFim), reportNameThree, sinteses2));
		
		JasperPrint printOne = reportsService.getJasperPrint(getParameters(dataInicio, dataFim), reportNameTwo, sinteses);
		listJasperPrint.stream().map(JasperPrint::getPages).forEach(pages -> {
			for (int i = 0; i < pages.size(); i++) {
				JRPrintPage object = (JRPrintPage) pages.get(i);
				printOne.addPage(object);
			}
		});
		
		
		
		return countAndGenerateReport(printOne);	
	}
	
	public List<SinteseRelatorioTrimestralDTO> getRelatorioSintese(LocalDate dataInicio, LocalDate dataFim){
		if (CoreUtil.isAnyNull(dataInicio, dataFim)) {
			throw new MonitoramentoException("ParÃ¢metros: Data de Inicio, Data Final e Demandante sÃ£o obrigatÃ³rios");
		}

		List<SinteseRelatorioTrimestralProj> monitoramentos = findByAllStartDateLessThanEqualAndEndDateGreaterThanEqual(dataInicio.atTime(0, 0),dataFim.atTime(23, 59));
		
		if (monitoramentos == null || monitoramentos.isEmpty()) {
			throw new MonitoramentoException("Nenhum Monitoramento Localizado para este PerÃ­odo");
		}
		return getRelatorioTrimestralDTO(monitoramentos, 0);
	}
	
	public List<SinteseRelatorioTrimestralDTO> getRelatorioSintese2(LocalDate dataInicio, LocalDate dataFim){
		List<SinteseRelatorioTrimestralProj> monitoramentos = findByAllStartDateLessThanEqualAndEndDateGreaterThanEqual(dataInicio.atTime(0, 0),dataFim.atTime(23, 59));
		
		if (monitoramentos == null || monitoramentos.isEmpty()) {
			throw new MonitoramentoException("Nenhum Monitoramento Localizado para este PerÃ­odo");
		}
		List<SinteseRelatorioTrimestralDTO> sinteses = getRelatorioTrimestralDTO(monitoramentos, 1);
		List<SinteseRelatorioTrimestralDTO> sinteses2 = getRelatorioTrimestralDTO(monitoramentos, 2);
		sinteses2.forEach((item) ->
		{
			sinteses.add(item);
		});
		return sinteses;
	}
	
	public List<RegistroMonitoramento> obterMonitoramentosSemComprovacao(LocalDateTime dataInicio, LocalDateTime dataFim) {
		return customRegistroMonitoramentoDAO.obterMonitoramentosSemComprovacao(dataInicio, dataFim);
	}
	
	public List<RegistroMonitoramento> findByBeneficiarioAndDataMonitoramentoBetween(Beneficiario beneficiario, LocalDateTime startDate, LocalDateTime endDate){
		return dao.findByBeneficiarioAndDataMonitoramentoBetweenAndExcluidoFalse(beneficiario, startDate, endDate);
	}
}
