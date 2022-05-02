package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.AbstractHelper;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao.AgendamentoDAO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.AgendamentoDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.enums.StatusAgendaEnum;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.integracao.model.RHFuncionario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.integracao.service.RHFuncionarioService;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Agendamento;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Beneficiario;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Periodo;
import br.org.flem.util.helper.DateUtil;

/**
 *
 * @author tscortes
 */
@Service
public class AgendamentoService extends AbstractHelper {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7546815869925465637L;

	@Autowired
    private AgendamentoDAO dao;

    @Autowired
    private BeneficiarioService beneficiarioService;

    @Autowired
    private PeriodoService periodoService;
    
    @Autowired
    private RHFuncionarioService rhFuncionarioService;

    /**
     * Persiste o objeto no banco de dados
     *
     * @param object
     * @return Periodo
     */
    public Agendamento save(Agendamento object) {
        this.preSave(object);
        return dao.save(object);
    }

    /**
     * remove o objeto direto do banco
     *
     * @param object
     * @return Periodo
     */
    public Agendamento remover(Agendamento object) {
        object.setExcluido(Boolean.TRUE);
        return update(object);
    }

    /**
     * Atualiza o Objeto passado
     *
     * @param object
     * @return Periodo
     */
    public Agendamento update(Agendamento object) {
        this.preUpdate(object);
        return dao.save(object);
    }

    /**
     * Obtem uma lista de Objetos
     *
     * @return Iterable
     */
    public Iterable<Agendamento> getList() {
        return dao.findAll();
    }

    /**
     * Obtem o objeto pelo id informado
     *
     * @param id
     * @return T
     */
    public Agendamento findById(Long id) {
        return dao.findOne(id);
    }

    /**
     * Metodo Deleta a Periodo
     *
     * @param id
     */
    public void deletar(Long id) {
        Agendamento old = findById(id);
        if (old != null) {
            remover(old);
        }
    }

    /**
     * Metodo atualiza o Periodo
     *
     * @param dto
     * @return
     */
    public Agendamento atualizar(AgendamentoDTO dto) {
        if (dto.getId() == null) {
            throw new MonitoramentoException("Agendamento a ser editado não foi informado!");
        }
        Agendamento agendamento = findById(dto.getId());
        agendamento.setDataFinal(dto.getDataFinal());
        agendamento.setDataInicial(dto.getDataInicial());
        return update(agendamento);
    }

    /**
     * @param obj
     * @param periodo
     * @return
     */
    public Agendamento criarNovoAgendamento(Beneficiario obj, Periodo periodo, String tipoPeriodo) {
        Beneficiario beneficiario = obterBeneficiario(obj.getId());
        Agendamento agendamento = obterAgendamentoAbertoPorBeneficiario(beneficiario);
        if (agendamento != null) {
            return agendamento;
        }
        agendamento = new Agendamento();
        agendamento.setBeneficiario(beneficiario);
        
        
        if (periodo != null) {
            agendamento.setPeriodo(periodo);
        } else {
            int year = LocalDate.now().getYear();
            
            System.out.println("AgendamentoService.criarNovoAgendamento() - nome e tipoPeriodo: " + beneficiario.getNome() + " - " + tipoPeriodo);
            
            Periodo novoPeriodo = obterProximoPeriodoPorBeneficiario(beneficiario, tipoPeriodo);
           
            System.out.println("/n/n" + novoPeriodo.getTipo());
            
            LocalDate ldInicio = LocalDate.of(year, Math.abs(novoPeriodo.getMesInicio()), 1);
            System.out.println("/n/n" + ldInicio);
            
            if (novoPeriodo.getMesFim().compareTo(Math.abs(novoPeriodo.getMesInicio())) < 0) {
                year++;
            }
            LocalDate dataFimReferencia = LocalDate.of(year, novoPeriodo.getMesFim(), 1);
            LocalDate ldFim = LocalDate.of(year, novoPeriodo.getMesFim(), dataFimReferencia.lengthOfMonth());
            agendamento.setDataInicial(ldInicio);
            agendamento.setDataFinal(ldFim);
            agendamento.setPeriodo(novoPeriodo);
        }

        return agendar(agendamento);
    }

    /**
     * @param object
     * @return
     */
    public Agendamento agendar(Agendamento object) {
        return save(object);
    }

    /**
     *
     * @param obj
     * @param dataRegistro
     * @return
     */
    public Agendamento finalizarAgendamento(Beneficiario obj, LocalDateTime dataRegistro) {
        Beneficiario beneficiario = obterBeneficiario(obj.getId());
        Agendamento agendamento = obterAgendamentoAbertoPorBeneficiario(beneficiario);
        if (agendamento != null) {
            if (DateUtil.isEqualsAndAfter(dataRegistro.toLocalDate(), agendamento.getDataInicial())
                    && DateUtil.isEqualsAndBefore(dataRegistro.toLocalDate(), agendamento.getDataFinal())) {
                agendamento.setDataRegistro(dataRegistro);
                return finalizarAgendamento(agendamento);
            }
        }
        return null;
    }

    /**
     * Finaliza o agendamento passado pro parametro
     *
     * @param agendamento
     * @return
     */
    public Agendamento finalizarAgendamento(Agendamento agendamento) {
        agendamento.setStatus(StatusAgendaEnum.REALIZADO);
        return update(agendamento);
    }

    /**
     * Finaliza o agendamento por id do agendamento
     *
     * @param id
     * @return
     */
    public Agendamento finalizarAgendamento(Long id) {
        Agendamento agendamento = dao.findOne(id);
        if (agendamento == null) {
            throw new MonitoramentoException("Nenhum Agendamento foi localizado!");
        }
        return finalizarAgendamento(agendamento);
    }

    /**
     *
     * @param id
     * @return
     */
    private Beneficiario obterBeneficiario(Long idBeneficiario) {
        Beneficiario beneficiario = beneficiarioService.findById(idBeneficiario);
        if (beneficiario == null) {
            throw new MonitoramentoException("Nenhum Beneficiário localizado!");
        }
        return beneficiario;
    }

    /**
     * @param beneficiario
     * @return
     */
    private Periodo obterProximoPeriodoPorBeneficiario(Beneficiario beneficiario, String tipoPeriodo) {
    	
    	
        System.out.println("1 - AgendamentoService.obterProximoPeriodoPorBeneficiario() - beneficiario: " + beneficiario.getNome());
        System.out.println("2 - AgendamentoService.obterProximoPeriodoPorBeneficiario() - tipoPeriodo: " + tipoPeriodo);
    	
        List<Agendamento> agendamentos = dao.findByBeneficiario(beneficiario);
        
        System.out.println("3 - AgendamentoService.obterProximoPeriodoPorBeneficiario() - agendamentos is Empty?: " + agendamentos.isEmpty());
        
        Periodo periodo = null;
        
        if (!agendamentos.isEmpty()) {
            Agendamento agendamento = Collections.max(agendamentos, Comparator.comparing(s -> s.getPeriodo().getOrdem()));
            
            //COMENTADO EM 24/05/2021 PARA O BUGFIX
            //Short minValue = Short.valueOf("1");
            
            //BUGFIX EM 24/05/2021 PARA SOLUÇÃO DOS BENEFICIÁRIOS QUE NÃO CONSEGUIAM RECEBER MONITORAMENTO
            //INÍCIO
            
            Short minValue = Short.valueOf("0");
            //FIM
            
            Integer ordem = agendamento.getPeriodo().getOrdem() + minValue;
            
            System.out.println("4 - AgendamentoService.obterProximoPeriodoPorBeneficiario() - ordem: " + ordem);
            System.out.println("5 - AgendamentoService.obterProximoPeriodoPorBeneficiario() - tipoPeriodo: " + tipoPeriodo);
            
            periodo = periodoService.findByOrdem(ordem.shortValue(), tipoPeriodo);
        }
        if (periodo == null) 
       	{	
           	RHFuncionario rhFuncionario = rhFuncionarioService.findByMatricula(Integer.parseInt(beneficiario.getMatriculaFlem()));
           	List<Periodo> periodos = periodoService.getList();
           	periodos.forEach((item)->
           	{
           		System.out.println("6 - AgendamentoService.obterProximoPeriodoPorBeneficiario() - periodos: " + item.getNome());
           	});
           	if (rhFuncionario.getAdmissao() == null) {
               throw new MonitoramentoException("Beneficiário sem data de Admissão Informada!");
           	}
           	LocalDate dataAdmissao = DateUtil.convertToLocalDate(rhFuncionario.getAdmissao());
           	for (Periodo per : periodos) {
               MonthDay mdAdmissao = MonthDay.of(dataAdmissao.getMonth(), dataAdmissao.getDayOfMonth());
               MonthDay mdPeriodo = MonthDay.of(Math.abs(per.getMesInicio()), per.getDiaReferencia());
               System.out.println(mdAdmissao);
               System.out.println(mdPeriodo);
              /**
               if(mdAdmissao.isBefore(mdPeriodo))
               {
                   return per;
               }
               */
               if(dentroDoPeriodo(dataAdmissao, per))
               {
            	   return per;
               }
           	}
       	}
        return periodo;
    }
    
    
    public boolean dentroDoPeriodo(LocalDate dataAdmissao, Periodo per)
    {
    	int anoAdmissao = dataAdmissao.getYear();
    	int anoAtual = LocalDate.now().getYear();
    	int incremento = 0;
    	boolean result = false;
    	if (anoAdmissao < anoAtual)
    	{
    		incremento = 10;
    	}
    	int mesPeriodoInicio = per.getMesInicio()+incremento;
    	System.out.println("mesPeriodoInicio= " + mesPeriodoInicio);
    	int mesPeriodoFim = per.getMesFim()+incremento;
    	System.out.println("mesPeriodoFim= " + mesPeriodoFim);
    	if ( (dataAdmissao.getMonthValue() >= mesPeriodoInicio) && (dataAdmissao.getMonthValue() <= mesPeriodoFim) )
    	{
    		result = true;
    	}
    	return result;
    }
    
    

    /**
     *
     * @param beneficiario
     * @return
     */
    public Agendamento obterAgendamentoAbertoPorBeneficiario(Beneficiario beneficiario) {
        List<Agendamento> agendamentos = dao.findByBeneficiarioAndStatus(beneficiario, StatusAgendaEnum.AGENDADA);
        
        System.out.println(beneficiario.getNome());
        System.out.println(StatusAgendaEnum.AGENDADA);
        
        System.out.println("AgendamentoService.obterAgendamentoAbertoPorBeneficiario() - agendamentos:" + agendamentos.toString());

        if (!agendamentos.isEmpty()) {
            return agendamentos.get(0);
        }
        return null;
    }

    /**
     * Agendar por id Beneficiario
     *
     * @param idBeneficiario
     * @return
     * @throws MonitoramentoException
     */
    public Agendamento criarAgendamentoPorIdbeneficiario(Long idBeneficiario, String tipoPeriodo) {
        Beneficiario beneficiario = obterBeneficiario(idBeneficiario);
        return criarNovoAgendamento(beneficiario, null, tipoPeriodo);
    }

}
