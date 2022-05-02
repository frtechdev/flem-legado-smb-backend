package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.AbstractHelper;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.ComprovacaoDAO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.MonitoramentoComprovacaoDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.integracao.model.RHFuncionario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.integracao.service.RHFuncionarioService;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.AvaliacaoQuestionario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Comprovacao;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Questionario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.RegistroMonitoramento;

/**
 * @author tscortes
 */
@Service
public class ComprovacaoService extends AbstractHelper {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2799851206071997471L;
	@Autowired
    private ComprovacaoDAO dao;
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private RegistroMonitoramentoService registroMonitoramentoService;
    @Autowired
    private AvaliacaoQuestionarioService avaliacaoQuestionarioService;
    @Autowired
    private QuestionarioService questionarioService;
    @Autowired
    private RHFuncionarioService rhFuncionarioService;

    /**
     *
     * @param comprovacao
     * @return
     */
    public Comprovacao save(Comprovacao comprovacao) {
        preSave(comprovacao);
        return dao.save(comprovacao);
    }

    /**
     * @param comprovacao
     * @param file
     * @return
     */
    public Comprovacao save(Comprovacao comprovacao, MultipartFile file) {
        String filePath = saveFileInStorage(file);
        comprovacao.setFilePath(filePath);
        return save(comprovacao);
    }

    /**
     *
     * @param file
     * @return
     */
    @Transactional
    public Comprovacao save(MultipartFile file) {
        Comprovacao comprovacao = new Comprovacao();

        String filePath = saveFileInStorage(file);
        comprovacao.setFilePath(filePath);
        comprovacao.setContentType(file.getContentType());
        comprovacao.setFileName(file.getOriginalFilename());
        comprovacao.setFileSize(file.getSize());
        return save(comprovacao);
    }
    
    @Transactional
    public Comprovacao save(MultipartFile file, String tipoComprovacao) {
        Comprovacao comprovacao = new Comprovacao();

        String filePath = saveFileInStorage(file);
        comprovacao.setFilePath(filePath);
        comprovacao.setContentType(file.getContentType());
        comprovacao.setFileName(file.getOriginalFilename());
        comprovacao.setFileSize(file.getSize());
        comprovacao.setTipoComprovacao(tipoComprovacao);
        return save(comprovacao);
    }

    /**
     *
     * @param id
     * @return
     */
    public Comprovacao findById(Long id) {
        return dao.findOne(id);
    }

    /**
     *
     * @param id
     */
    public void deleteById(Long id) {
        Comprovacao comprovacao = findById(id);
        comprovacao.setExcluido(Boolean.TRUE);
        update(comprovacao);
    }
    /**
     * 
     * @param comprovacao 
     */
    public void update(Comprovacao comprovacao){
        preUpdate(comprovacao);
        dao.save(comprovacao);
    }

    /**
     *
     * @param file
     * @return
     */
    public String saveFileInStorage(MultipartFile file) {
        return fileStorageService.storeComprovacao(file);
    }

    /**
     * @param idsMonitoramentos
     * @param file
     */
    @Transactional
    public Comprovacao associarComprovacao(List<Long> idsMonitoramentos, MultipartFile file, String tipoComprovacao) {
        if (idsMonitoramentos != null) {
            Comprovacao comprovacao = save(file, tipoComprovacao);
            idsMonitoramentos.forEach(id -> {
                RegistroMonitoramento registro = registroMonitoramentoService.findById(id);
                if (registro != null) {
                    registro.setComprovacao(comprovacao);
                    registroMonitoramentoService.update(registro);
                }
            });
            return comprovacao;
        }
        return null;
    }

    /**
     *
     * @param dataInicioParam
     * @param dataFimParam
     * @param unidadeLotacao
     * @param municipio
     * @param demandante
     * @return
     * @throws java.io.UnsupportedEncodingException
     */
    public List<MonitoramentoComprovacaoDTO> filterBy(LocalDate dataInicioParam, LocalDate dataFimParam, String unidadeLotacao, Long municipio, Long demandante) throws UnsupportedEncodingException {
    	String usuarioLogado = null;
    	
    	if(!hasPermissions("adminSmb")) {
    		usuarioLogado = getCurrentUser();
    	}
    	
        List<RegistroMonitoramento> results = registroMonitoramentoService.filterByDataMonitoramentoBetweenAndMunicipioAndDemandandeAndUnidadeDeLotacao(dataInicioParam, dataFimParam, municipio, demandante, unidadeLotacao,usuarioLogado);
        List<MonitoramentoComprovacaoDTO> resultsDTO = new ArrayList<>();
        results.forEach(res -> {
            MonitoramentoComprovacaoDTO dto = new MonitoramentoComprovacaoDTO();
            dto.setIdMonitoramento(res.getId());
            carregarPathAvaliacoes(res, dto);
            dto.setCpfEgresso(res.getBeneficiario().getCpf());
            dto.setDataMonitoramento(res.getDataMonitoramento());
            if (res.getComprovacao() != null) {
                dto.setIdComprovacao(res.getComprovacao().getId());
                Comprovacao comprovacao = findById(res.getComprovacao().getId());
                dto.setNomeComprovacao(comprovacao.getFileName());
            }
            dto.setIdEgresso(res.getBeneficiario().getId());
            
            RHFuncionario rhFuncionario = rhFuncionarioService.findByMatricula(Integer.parseInt(res.getBeneficiario().getMatriculaFlem()));
            if(rhFuncionario != null) {            	
            	dto.setStatus(rhFuncionario.getSituacao());
            	dto.setIdStatus(rhFuncionario.getIdSituacao());
            }
            dto.setMatriculaEgresso(Integer.parseInt(res.getBeneficiario().getMatriculaFlem()));
            dto.setNomeEgresso(res.getBeneficiario().getNome());
            dto.setNomeMonitor(getUser(res.getUsuarioCriacao()).getNome());
            dto.setUnidadeDeLotacao(res.getUnidadeLotacao());
            dto.setLoginMonitor(res.getUsuarioCriacao());
            if (res.getDemandante() != null) {
                dto.setNomeDemandante(res.getDemandante().getNome());
            }
            
            resultsDTO.add(dto);
            
        });
        return resultsDTO;
    }

	public void carregarPathAvaliacoes(RegistroMonitoramento res, MonitoramentoComprovacaoDTO dto) {
		Questionario questionario = questionarioService.findByRegistroMonitoramento(res.getId());
		if (questionario != null) {
		    List<AvaliacaoQuestionario> avaliacoes = avaliacaoQuestionarioService.findByIdQuestionario(questionario);
		    if (avaliacoes != null && !avaliacoes.isEmpty()) {
		        avaliacoes.forEach(eva -> {
		            if (StringUtils.isBlank(eva.getFilePath())) {
		                if (dto.getAvaliacoesPendentes() == null) {
		                    dto.setAvaliacoesPendentes(new ArrayList<>());
		                }
		                dto.getAvaliacoesPendentes().add(eva.getId().getAvaliacao().getNome());
		            } else {
		                if (dto.getPathAvaliacoes() == null) {
		                    dto.setPathAvaliacoes(new ArrayList<>());
		                }
		                dto.getPathAvaliacoes().add(eva.getFilePath());
		            }
		        });
		    }
		}
	}

    /**
     *
     * @param id
     * @return
     */
    public Resource downloadById(Long id) {
        Comprovacao comprovacao = findById(id);
        if (comprovacao == null || StringUtils.isBlank(comprovacao.getFilePath())) {
            throw new MonitoramentoException("Comprovação não localizada ou sem anexo!");
        }

        return fileStorageService.loadFile(comprovacao.getFilePath());
    }

}
