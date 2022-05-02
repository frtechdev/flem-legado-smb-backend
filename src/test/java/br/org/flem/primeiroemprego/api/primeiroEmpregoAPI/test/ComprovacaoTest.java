/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.test;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller.ComprovacaoController;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.ComprovacaoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author tscortes
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ComprovacaoTest {
    
    private MockMvc mockMvc;
    
    @Autowired
    private ComprovacaoService service;
    
    @Autowired
    private ComprovacaoController comprovacaoController;
    
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(comprovacaoController).build();
    }
    
    @Test
    public void filter() throws Exception {
//        String dataInicio = "01/08/2019";
//        String dataFim = "30/08/2019";
//        String unidade = "";
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/comprovacoes/filter")
//                .param("dataInicio", dataInicio)
//                .param("dataFim", dataFim)
//                .param("unidade", unidade)
//        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
    
}
