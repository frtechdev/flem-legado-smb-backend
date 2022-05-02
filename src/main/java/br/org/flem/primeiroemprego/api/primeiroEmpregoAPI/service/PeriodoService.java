package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.AbstractHelper;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.PeriodoDAO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.PeriodoDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Periodo;
import br.org.flem.util.helper.DateUtil;

/**
 *
 * @author tscortes
 */
@Service
public class PeriodoService extends AbstractHelper {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2647151103375932472L;

	private String[] months = new String[]{"", "JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO"};

    private static final int MES_12 = 12;
    @Autowired
    private PeriodoDAO dao;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Persiste o objeto no banco de dados
     *
     * @param object
     * @return Periodo
     */
    public Periodo save(Periodo object) {
        this.preSave(object);
        return dao.save(object);
    }

    /**
     * remove o objeto direto do banco
     *
     * @param object
     * @return Periodo
     */
    public Periodo remover(Periodo object) {
        object.setExcluido(Boolean.TRUE);
        return update(object);
    }

    /**
     * Atualiza o Objeto passado
     *
     * @param object
     * @return Periodo
     */
    public Periodo update(Periodo object) {
        this.preUpdate(object);
        return dao.save(object);
    }

    /**
     * Obtem uma lista de Objetos
     *
     * @return Iterable
     */
    public List<Periodo> getList() {
        return dao.obterTodosAtivosOrdemAsc();
    }

    /**
     * Obtem uma lista de Objetos
     *
     * @return Iterable
     */
    public List<PeriodoDTO> getListDTO() {
        List<Periodo> lista = dao.obterTodosAtivosOrdemAsc();
        return lista.stream()
        	.map(this::toDTO)
        	.collect(Collectors.toList());
    }
    
    private PeriodoDTO toDTO(Periodo periodo){
    	if(periodo == null)
    		return null;
    	PeriodoDTO dto = modelMapper.map(periodo, PeriodoDTO.class);
    	dto.setLabel("DE "+months[Math.abs(periodo.getMesInicio())]+" ATÉ "+ months[Math.abs(periodo.getMesFim())]);
    	return dto;
    }

    /**
     * Obtem o objeto pelo id informado
     *
     * @param id
     * @return T
     */
    public Periodo findById(Long id) {
        return dao.findOne(id);
    }

    /**
     * Obtem o objeto pela ordem
     *
     * @param ordem
     * @return Periodo
     */
    public Periodo findByOrdem(Short ordem, String tipo) {
    	System.out.println("PeriodoService - findByOrdem - " + ordem + ", " + tipo);
    	return dao.findByOrdemAndTipo(ordem, tipo);
    }

    /**
     * Metodo salva a periodo
     *
     * @param dto
     * @return
     */
    public Periodo salvar(PeriodoDTO dto) {
        Periodo periodo = modelMapper.map(dto, Periodo.class);
        if( periodo.getMesInicio().compareTo(periodo.getMesFim()) > 0) {
        	periodo.setMesInicio(-periodo.getMesInicio());
        }
        isExist(periodo);
        return save(periodo);
    }

    /**
     * Metodo atualiza o Periodo
     *
     * @param dto
     * @return
     */
    public Periodo atualizar(PeriodoDTO dto) {
        if (dto.getId() == null) {
            throw new MonitoramentoException("Periodo a ser editado não foi informado!");
        }
        Periodo periodo = dao.findOne(dto.getId());
        periodo.setDescricao(dto.getDescricao());
        periodo.setNome(dto.getNome());
        periodo.setTipo(dto.getTipo());
        isExist(periodo);
        return update(periodo);
    }

    /**
     * Metodo Deleta a Periodo
     *
     * @param id
     */
    public void deletar(Long id) {
        Periodo old = dao.findOne(id);
        if (old != null) {
            remover(old);
        }
    }

    /**
     * Verifica se já existe um Periodo com este nome
     *
     * @param Periodo
     */
    private void isExist(Periodo periodo) {
        Periodo old = dao.findByOrdemAndTipo(periodo.getOrdem(), periodo.getTipo());
        if (old != null && 
        		(periodo.getId() == null || !periodo.getId().equals(old.getId()))) {
                throw new MonitoramentoException("Já existe uma periodo cadastrado com esse nome e ordem!");
        }
    }

    /**
     *
     * @param mes
     * @return
     */
    public Periodo obterPeriodoPorMes(Integer mes, String tipo) {
    	if(mes == 12){
    		mes = -12;
    	}
        return dao.obterPeriodoPorMes(mes, tipo);
    }
    
    public LocalDate dataReferenciaPeriodo(LocalDate ldAtual, String tipo) {
		Periodo periodoCurrent = obterPeriodoPorMes(ldAtual.getMonthValue(), tipo);
		if (periodoCurrent.getMesInicio().intValue() == MES_12 && ldAtual.getMonth().getValue() != MES_12) {
			return LocalDate.of(ldAtual.getYear() -1, periodoCurrent.getMesInicio(), periodoCurrent.getDiaReferencia());
		} else {			
			return LocalDate.of(ldAtual.getYear(), Math.abs(periodoCurrent.getMesInicio()), periodoCurrent.getDiaReferencia());
		}
	}

    public boolean validarDataDentroDoPeriodo(LocalDate data, String tipo) {
		LocalDate startDate = obterInicioPeriodo(LocalDate.now(), tipo);
		LocalDate endDate = obterFimPeriodo(LocalDate.now(), tipo);
		return DateUtil.isEqualsAndBefore(data, endDate) && DateUtil.isEqualsAndAfter(data, startDate);
	}
    
    public boolean validarDataDentroDoPeriodo(LocalDate data) {
    	return validarDataDentroDoPeriodo(data, "TRIMESTRE");
	}
    
    public LocalDate obterInicioPeriodo(LocalDate data, String tipo) {
    	Periodo periodoCurrent = obterPeriodoPorMes(data.getMonthValue(), tipo);
		if (periodoCurrent.getMesInicio() < 0 && data.getMonth().getValue() != MES_12) {
			return LocalDate.of(data.getYear() -1, Math.abs(periodoCurrent.getMesInicio()), 1);
		} else {			
			return LocalDate.of(data.getYear(), Math.abs(periodoCurrent.getMesInicio()), 1);
		}
    }
    
    public LocalDate obterFimPeriodo(LocalDate data, String tipo) {
    	Periodo periodoCurrent = obterPeriodoPorMes(data.getMonthValue(), tipo);
		if (periodoCurrent.getMesInicio() < 0 && data.getMonth().getValue() == MES_12) {
			LocalDate lDate = LocalDate.of(data.getYear() + 1, periodoCurrent.getMesFim(), 1);
			return lDate.withDayOfMonth(lDate.lengthOfMonth());
		} else {			
			LocalDate lDate = LocalDate.of(data.getYear(), periodoCurrent.getMesFim(), 1);
			return lDate.withDayOfMonth(lDate.lengthOfMonth());
		}
    }
}


