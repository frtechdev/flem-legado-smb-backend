package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.AgendamentoDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.ResponseMessage;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Agendamento;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tscortes
 */
@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @GetMapping
    public ResponseEntity<Iterable<Agendamento>> findAll() {
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> findOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping("/{idbeneficiario}/novo")
    public ResponseEntity<Agendamento> agendarPorIdBeneficiario(@PathVariable("idbeneficiario") Long idbeneficiario) {
        try {
            return new ResponseEntity<>(service.criarAgendamentoPorIdbeneficiario(idbeneficiario, "TRIMESTRE"), HttpStatus.OK);
        } catch (MonitoramentoException ex) {
            throw new MonitoramentoException(ex.getMessage());
        }
    }
    
    @PutMapping
    public ResponseEntity<Agendamento> atualizar(@RequestBody AgendamentoDTO dto) {
        try {
            return new ResponseEntity<>(service.atualizar(dto), HttpStatus.OK);
        } catch (MonitoramentoException ex) {
            throw new MonitoramentoException(ex.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deletar(@PathVariable("id") Long id) {
        try {
            service.deletar(id);
            return new ResponseEntity<>(new ResponseMessage(1, "Excluido com sucesso"), HttpStatus.OK);
        } catch (MonitoramentoException ex) {
            throw new MonitoramentoException(ex.getMessage());
        }
    }

}
