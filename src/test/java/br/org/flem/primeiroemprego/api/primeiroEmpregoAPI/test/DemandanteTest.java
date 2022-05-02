package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller.DemandanteController;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.Municipio;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.projections.MunicipioProj;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.DemandanteService;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.MunicipioService;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.VagaService;

/**
 *
 * @author tscortes
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DemandanteTest {

    private MockMvc mockMvc;

    @Autowired
    private DemandanteService service;

    @Autowired
    private DemandanteController controller;

    @Autowired
    private MunicipioService municipioService;
    
    @Autowired
    private VagaService vagaService;

    private List<MunicipioProj> municipios;

    @Before
    public void setUp() {
        municipios = vagaService.findAllMunicipiosVaga();
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    public void obterPorMunicipiosController() throws Exception {
        List<Municipio> lista = new ArrayList<>();
        municipios.forEach(proj -> {
            Municipio mun = new Municipio();
            mun.setId(proj.getId());
            mun.setNome(proj.getNome());
            lista.add(mun);
        });
        Assert.assertFalse(service.findByMunicipios(lista).isEmpty());
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/demandantes/byMunicipios")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}
