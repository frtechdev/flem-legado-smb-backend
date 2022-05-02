package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.test;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller.ColaboradorController;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.ColaboradorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author tscortes
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ColaboradorTest {

    private MockMvc mockMvc;

    @Autowired
    private ColaboradorController controller;
    
    @Autowired
    private ColaboradorService service;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void obterColaboradoresPorEscritorio() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/colaboradores/byEscritorio/8")).andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void obterColaboradores() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/colaboradores")).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void findAll() throws Exception {
//        Assert.assertTrue(service.findAll().size() == 18);
    }

}
