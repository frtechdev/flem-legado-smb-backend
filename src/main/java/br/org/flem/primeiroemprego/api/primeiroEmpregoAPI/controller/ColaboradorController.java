package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.ColaboradorDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.DemandanteDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.DemandanteMunicipioDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.FuncionarioDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.MunicipioDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.exception.MonitoramentoException;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.ColaboradorService;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tscortes
 */
@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {
    
    @Autowired
    private ColaboradorService service;
    
    @GetMapping
    public ResponseEntity<List<ColaboradorDTO>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/byEscritorio/{idEscritorio}")
    public ResponseEntity<List<ColaboradorDTO>> findByEscritorioRegional(@PathVariable(value="idEscritorio") Long idEscritorio) {
        return new ResponseEntity<>(service.findByEscritorioRegional(idEscritorio), HttpStatus.OK);
    }
    
    @GetMapping("/{idMonitor}/beneficiarios")
    public ResponseEntity<List<FuncionarioDTO>> getFuncionariosByDemandante(@PathVariable(required = false, value="idMonitor") Long idMonitor, @RequestParam(required = false, name="idDemandantes") List<Long> idDemandantes, @RequestParam(required = false, name="idMunicipios") List<Long> idMunicipios) {
        try {
            return new ResponseEntity<>(service.findByDemandanteAndMunicipio(idMonitor, idDemandantes, idMunicipios), HttpStatus.OK);
        } catch (MonitoramentoException ex) {
            throw new MonitoramentoException(ex.getMessage());
        }
    }
    	
    @GetMapping("/funcionariosByUnidadeAndMunAndDem")
    public ResponseEntity<List<FuncionarioDTO>> getFuncionariosByUnidadeMunAndDem(@RequestParam("unidadeDeLotacao") String unidadeDeLotacao, @RequestParam("idMunicipio")Long idMunicipio, @RequestParam("idDemandante")Long idDemandante) {
        try {
            return new ResponseEntity<>(service.obterFuncionarioPorUnidade(null, unidadeDeLotacao, idMunicipio, idDemandante), HttpStatus.OK);
        } catch (MonitoramentoException | UnsupportedEncodingException ex) {
            throw new MonitoramentoException(ex.getMessage());
        }
    }
    
    @GetMapping("/{idMonitor}/demandantes")
    public ResponseEntity<List<DemandanteDTO>> getDemandantes(@PathVariable("idMonitor") Long idMonitor, @RequestParam("idMunicipios") List<Long> idMunicipios) {
        try {
            return new ResponseEntity<>(service.getDemandantes(idMonitor, idMunicipios), HttpStatus.OK);
        } catch (MonitoramentoException ex) {
            throw new MonitoramentoException(ex.getMessage());
        }
    }
    
    @GetMapping("/{idMonitor}/municipios")
    public ResponseEntity<List<MunicipioDTO>> getMunicipios(@PathVariable("idMonitor") Long idMonitor) {
        try {
            return new ResponseEntity<>(service.getMunicipios(idMonitor), HttpStatus.OK);
        } catch (MonitoramentoException ex) {
            throw new MonitoramentoException(ex.getMessage());
        }

    }
    
    @GetMapping("/{idMonitor}/associacoes")
    public ResponseEntity<List<DemandanteMunicipioDTO>> getAssociacoes(@PathVariable("idMonitor") Long idMonitor, @RequestParam("idMunicipios") List<Long> idMunicipios) {
        try {
            return new ResponseEntity<>(service.obterAssociacoes(idMonitor, idMunicipios), HttpStatus.OK);
        } catch (MonitoramentoException ex) {
            throw new MonitoramentoException(ex.getMessage());
        }

    }
    
}
