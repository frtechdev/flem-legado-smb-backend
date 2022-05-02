package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.test;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.ColaboradorDTO;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Colaborador;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Demandante;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.ColaboradorService;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.DemandanteService;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.MonitorDemandanteService;
import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author tscortes
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MonitorDemandanteTest {

    @Autowired
    private MonitorDemandanteService service;
    @Autowired
    private DemandanteService demandanteService;
    @Autowired
    private ColaboradorService colaboradorService;
    
    private Municipio municipio;
    private Demandante demandante;
    private Colaborador colaborador;
    
    private List<Municipio> municipios;
    
    @Before
    public void loadObjectos(){
//        municipios = new ArrayList<>();
        
//        List<Municipio> itrMuni = municipioService.();
//        municipio = itrMuni.next();
//        
//        municipios.add(municipio);
//        municipios.add(itrMuni.next());
        
//        demandante = demandanteService.().iterator().next();
        Iterator<ColaboradorDTO> itr = colaboradorService.findAll().iterator();
        colaborador = colaboradorService.findById(itr.next().getId());
    }

    @Test
    public void findAll() throws Exception {
        Assert.assertTrue(service.findAll().iterator().hasNext());
    }
//    
//    @Test
//    public void findByColaborador() {
//        service.findByColaborador(colaborador);
//    }
//
//    @Test
//    public void findByMunicipioAndDemandante() {
//        service.findByMunicipioAndDemandante(municipio, demandante);
//    }
//
//    @Test
//    public void findByMunicipioAndDemandanteAndColaborador() {
//        service.findByMunicipioAndDemandanteAndColaborador(municipio, demandante, colaborador);
//    }
//
//    @Test
//    public void findByMunicipioInAndColaboradorNot() {
//        service.findByMunicipioInAndColaboradorNot(municipios, colaborador);
//    }
//
//    @Test
//    public void findByMunicipioInAndColaborador() {
//        service.findByMunicipioInAndColaborador(municipios, colaborador);
//    }

}
