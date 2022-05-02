package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;

import java.util.List;

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

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.PeriodoDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.ResponseMessage;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Periodo;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.PeriodoService;

/**
 *
 * @author tscortes
 */
@RestController
@RequestMapping("/periodos")
public class PeriodoController {

    @Autowired
    private PeriodoService service;

    @GetMapping
    public ResponseEntity<List<PeriodoDTO>> findAll() {
        return new ResponseEntity<>(service.getListDTO(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Periodo> findOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Periodo> gravar(@RequestBody PeriodoDTO dto) {
        try {
            return new ResponseEntity<>(service.salvar(dto), HttpStatus.OK);
        } catch (MonitoramentoException ex) {
            throw new MonitoramentoException(ex.getMessage());
        }
    }
    
    @PutMapping
    public ResponseEntity<Periodo> atualizar(@RequestBody PeriodoDTO dto) {
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
