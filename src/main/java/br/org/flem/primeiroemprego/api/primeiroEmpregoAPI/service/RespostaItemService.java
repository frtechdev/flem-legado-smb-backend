/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseService;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.convert.CustomMultipartFile;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.RespostaItemDAO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.EmailDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.MonitoramentoQuestionarioDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.PerguntaDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RelPerguntaDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RelQuestionarioDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RelRespostaDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RespostaDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.RespostaItemDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.ParameterEnum;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.TipoResposta;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Beneficiario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Colaborador;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Comprovacao;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.OpcaoResposta;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Pergunta;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.RegistroMonitoramento;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Resposta;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.RespostaItem;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.RespostaItemId;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.report.QuestionarioReportInput;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.util.SMBUtil;
import br.org.flem.util.helper.CoreUtil;
import br.org.flem.util.helper.DateUtil;
import net.sf.jasperreports.engine.JRException;

/**
 * @author tscortes
 */
@Service
public class RespostaItemService extends BaseService<RespostaItem, RespostaItemId> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8405968871122425671L;

	@Autowired
	private PerguntaService perguntaService;
	@Autowired
	private RespostaService respostaService;
	@Autowired
	private RegistroMonitoramentoService registroMonitoramentoService;
	@Autowired
	private OpcaoRespostaService opcaoRespostaService;
	@Autowired
	private BeneficiarioService beneficiarioService;
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private PeriodoService periodoService;
	@Autowired
	private ComprovacaoService comprovacaoService;
	@Autowired
	private ReportsService reportsService;
	@Autowired
	private FileStorageService fileService;
	@Autowired
	private ParameterService parameterService;

	private final RespostaItemDAO dao;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	public RespostaItemService(RespostaItemDAO dao) {
		super(dao);
		this.dao = dao;
	}

	/**
	 *
	 * @param dto
	 * @return
	 * @throws JRException
	 */
	@Transactional
	public void salvar(RespostaItemDTO dto) throws JRException {
		verificarCamposObrigatorios(dto);
		RegistroMonitoramento registroMonitoramento = obterRegistroMonitoramento();
		List<Pergunta> perguntasBD = Lists.newArrayList(perguntaService.findAll());
		SMBUtil.throwException(registroMonitoramento == null,
				"Não foi localizado Monitoramento para este Beneficiário neste Período");
		if (dto.getPerguntas() != null && !dto.getPerguntas().isEmpty()) {

			SMBUtil.throwException(perguntasBD.size() != dto.getPerguntas().size(),
					"Todas as perguntas devem ser respondidas");

			dto.getPerguntas().forEach(per -> {
				SMBUtil.throwException(per.getId() == null, "Pergunta é obrigatório");
				Pergunta pergunta = perguntaService.findById(per.getId());
				verificarRespostas(pergunta, per);
				per.getRespostas().forEach(resp -> {
					Resposta resposta = respostaService.findById(resp.getId());
					OpcaoResposta opcao = opcaoRespostaService.findById(pergunta, resposta);
					SMBUtil.throwException(opcao == null, "Perguntas e respostas não estão associadas");
					RespostaItem item = new RespostaItem(pergunta, resposta, registroMonitoramento);
					if (findById(item.getId()) == null)
						super.salvar(item);
				});
			});
			postSalvar(registroMonitoramento);
		}
	}

	private void postSalvar(RegistroMonitoramento registroMonitoramento) throws JRException {
		gerarComprovacao(registroMonitoramento);
	}

	private void verificarRespostas(Pergunta pergunta, PerguntaDTO dto) {
		boolean condition = pergunta.isObrigatoria() && (dto.getRespostas() == null || dto.getRespostas().isEmpty());
		SMBUtil.throwException(condition, "Pergunta (" + pergunta.getOrdem() + ") é obrigatória");

		condition = TipoResposta.UNICA.equals(pergunta.getTipoResposta())
				&& (dto.getRespostas() != null && dto.getRespostas().size() > 1);
		SMBUtil.throwException(condition, "Pergunta (" + pergunta.getOrdem() + ") de resposta Única");

	}

	private void verificarCamposObrigatorios(RespostaItemDTO dto) {
		SMBUtil.throwException(dto.getIdRegistroMonitoramento() == null, "Monitoramento é obrigatório");
	}

	private void enviarEmailBeneficiario(String filePath, Beneficiario beneficiario) {
		String var = beneficiario.getSexo() != null && beneficiario.getSexo().equalsIgnoreCase("F") ? "a" : "o";
		String email = CoreUtil.isNull(beneficiario.getEmailParticular(), beneficiario.getEmailSecundario());
		SMBUtil.throwException(StringUtils.isEmpty(email), "Beneficiári" + var + " sem E-mail cadastrado");
		EmailDTO dto = new EmailDTO(Arrays.asList(email), "Não Responda", "naoresponda@flem.org.br",
				"Monitoramento remoto", "Obrigado! Seu questionário foi respondido e enviado com sucesso");
		dto.setPaths(Arrays.asList(filePath));
		sendEmail(dto);
	}

	private void enviarEmailMonitor(String filePath, RegistroMonitoramento registro, Beneficiario beneficiario) {
		Colaborador colaborador = registro.getMonitor();
		String var = beneficiario.getSexo() != null && beneficiario.getSexo().equalsIgnoreCase("F") ? "a" : "o";
		if (!StringUtils.isEmpty(colaborador.getEmail())) {
			StringBuilder body = new StringBuilder();
			body.append("Beneficiári").append(var).append(" ").append(beneficiario.getMatriculaFlem()).append(" - ")
					.append(beneficiario.getNome())
					.append(" respondeu ao questionário referente ao monitoramento realizado dia ")
					.append(DateUtil.formatarData(registro.getDataMonitoramento(), "dd/MM/yyy HH:mm"));
			EmailDTO dto = new EmailDTO(Arrays.asList(colaborador.getEmail()), "Não Responda",
					"naoresponda@flem.org.br", "Questionário de Monitoramento Respondido", body.toString());
			dto.setPaths(Arrays.asList(filePath));
			sendEmail(dto);
		}

	}

	private void sendEmail(EmailDTO email) {
		emailSender.send(email);
	}

	private RegistroMonitoramento obterRegistroMonitoramento() {
		Beneficiario beneficiario = beneficiarioService.obterBeneficiarioLogado();
		RegistroMonitoramento registro = registroMonitoramentoService
				.findFirstByBeneficiarioOrderByDataMonitoramentoDesc(beneficiario);
		if (registro == null)
			return null;
		SMBUtil.throwException(!findByIdRegistroMonitoramento(registro).isEmpty(), "Questionário já respondido");
		LocalDate periodoAtual = periodoService.dataReferenciaPeriodo(LocalDate.now(), "TRIMESTRE");
		LocalDate periodoMonitoramento = periodoService
				.dataReferenciaPeriodo(registro.getDataMonitoramento().toLocalDate(), "TRIMESTRE");
		if (DateUtil.isEquals(periodoAtual, periodoMonitoramento))
			return registro;
		return null;
	}

	public MonitoramentoQuestionarioDTO obterRegistroMonitoramentoDTO() {
		RegistroMonitoramento registro = obterRegistroMonitoramento();
		if (registro == null)
			return null;
		return modelMapper.map(registro, MonitoramentoQuestionarioDTO.class);
	}

	public List<RespostaItem> findByIdRegistroMonitoramento(RegistroMonitoramento monitoramento) {
		return dao.findByIdRegistroMonitoramento(monitoramento);
	}

	public void gerarComprovacao(RegistroMonitoramento registroMonitoramento) throws JRException {
		String reportPath = "questionarioRelTrimestral.jasper";
		List<RespostaItem> items = dao.findByIdRegistroMonitoramento(registroMonitoramento);
		QuestionarioReportInput inputReport = new QuestionarioReportInput();
		if (!items.isEmpty()) {
			RelQuestionarioDTO questionarioDTO = new RelQuestionarioDTO();
			questionarioDTO.setBeneficiarioCpf(registroMonitoramento.getBeneficiario().getCpf());
			questionarioDTO.setBeneficiarioNome(registroMonitoramento.getBeneficiario().getNome());
			questionarioDTO.setDemandanteSigla(registroMonitoramento.getDemandante().getSigla());
			questionarioDTO.setUnidadeLotacao(registroMonitoramento.getUnidadeLotacao());
			questionarioDTO.setDataCriacao(DateUtil.formatarData(items.get(0).getDataCriacao(), "dd/MM/yyyy HH:mm"));
			questionarioDTO.setDataMonitoramento(
					DateUtil.formatarData(registroMonitoramento.getDataMonitoramento(), "dd/MM/yyyy HH:mm"));
			for (RespostaItem item : items) {
				Pergunta pergunta = item.getId().getPergunta();
				List<RespostaDTO> respostas = respostaService.findByPergunta(pergunta);
				RelPerguntaDTO perguntaDTO = RelPerguntaDTO.of(pergunta.getId(), pergunta.getOrdem(),
						pergunta.getDescricao());

				if (perguntaDTO.getRespostas() == null)
					perguntaDTO.setRespostas(new ArrayList<>());
				for (RespostaDTO dto : respostas) {
					RelRespostaDTO respostaDTO = RelRespostaDTO.of(dto.getId(), dto.getDescricao(),
							dto.getId().compareTo(item.getId().getResposta().getId()) == 0);
					perguntaDTO.getRespostas().add(respostaDTO);
				}

				if (questionarioDTO.getPerguntas() == null)
					questionarioDTO.setPerguntas(new ArrayList<>());
				questionarioDTO.getPerguntas().add(perguntaDTO);
			}

			inputReport.setLogoFlem(
					loadFile(parameterService.findById(ParameterEnum.LOGO_FLEM_HORIZONTAL.getChave()).getValor()));
			inputReport
					.setLogoGov(loadFile(parameterService.findById(ParameterEnum.PP_GOV_2019.getChave()).getValor()));
			inputReport.setSubReport("br/org/flem/primeiroemprego/api/reports/subQuestionarioRelTrimestral.jasper");

			byte[] byteAray = reportsService.generatePDF(inputReport.getParameters(), reportPath,
					Arrays.asList(questionarioDTO));
			gravarComprovacao(registroMonitoramento,
					new CustomMultipartFile(byteAray,
							"QUESTIONARIO_" + registroMonitoramento.getBeneficiario().getMatriculaFlem() + "_"
									+ registroMonitoramento.getId() + ".pdf",
							"application/pdf"));
		}

	}

	private void gravarComprovacao(RegistroMonitoramento monitoramento, MultipartFile file) {
		Comprovacao comprovacao = comprovacaoService.associarComprovacao(Arrays.asList(monitoramento.getId()), file,
				"QUESTIONARIO");
		if (comprovacao != null) {
			Beneficiario beneficiario = monitoramento.getBeneficiario();
			enviarEmailBeneficiario(comprovacao.getFilePath(), beneficiario);
			enviarEmailMonitor(comprovacao.getFilePath(), monitoramento, beneficiario);
		}
	}

	private InputStream loadFile(String filePath) {
		Resource res = loadFileResource(filePath);
		try {
			return res.getInputStream();
		} catch (IOException e) {
			return null;
		}
	}

	private Resource loadFileResource(String filePath) {
		return fileService.loadFile(filePath);
	}

}
