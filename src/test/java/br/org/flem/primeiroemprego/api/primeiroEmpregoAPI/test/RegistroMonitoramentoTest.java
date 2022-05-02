package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.test;

import java.time.LocalDateTime;
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
import org.springframework.web.client.RestTemplate;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.controller.RelatorioMonitoramentoController;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.RegistroMonitoramento;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.FileStorageService;
import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.RegistroMonitoramentoService;

/**
 *
 * @author tscortes
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RegistroMonitoramentoTest {

    private MockMvc mockMvc;

    @Autowired
    private RegistroMonitoramentoService service;

    @Autowired
    private RelatorioMonitoramentoController reportsController;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private RestTemplate restTemplate;

    private Long idMonitoramento;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(reportsController).build();
        idMonitoramento = 1l;
    }

    @Test
    public void filterByDate() {
//        try {
//            Assert.isTrue(!service.filterBy(LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30), null, null, null).isEmpty(), "filterByDate está vazio");
//        } catch (MonitoramentoException | UnsupportedEncodingException ex) {
//            Logger.getLogger(RegistroMonitoramentoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
//
//    @Test
//    public void filterByDateAndUnidade() {
//        Assert.isTrue(!service.filterByDataMonitoramentoBetweenAndUnidade(LocalDate.of(2019, 7, 1), LocalDate.of(2019, 7, 30), "COLEGIO").isEmpty(), "filterByDateAndUnidade está vazio");
//    }

    @Test
    public void obterRegistroPorId() {
        if (idMonitoramento != null) {
//            Assert.isTrue(!service.obterRegistroPorId(11l).isEmpty(), "obterRegistroPorId está nulo");
        }
    }

    @Test
    public void obterUnidade() {
//        Assert.isTrue(service.obterTodasUnidadeLotacao().size() == 1076, "diferente de 1076");
    }

    @Test
    public void get() throws Exception {
//        String dataInicio = "01/07/2019";
//        String dataFim = "30/07/2019";
//        String unidade = "COLEGIO";
//        this.mockMvc.perform(MockMvcRequestBuilders.get("/relatorios/filter")
//                .param("dataInicio", dataInicio)
//                .param("dataFim", dataFim)
//                .param("unidade", unidade)
//        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

//    @Test
//    public void getRelatorioTrimestral() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/relatorios/periodo/1/relatorioTrimestral")).andExpect(MockMvcResultMatchers.status().isOk());
//
//    }
    
    @Test
    public void getRelatorioTrimestralMunicipios() throws Exception {
//        this.mockMvc.perform(MockMvcRequestBuilders
//                .get("/relatorios/periodo/4/relatorioTrimetralDemamdate/7")).andExpect(MockMvcResultMatchers.status().isOk());
    }
//    @Test
//    public void findByAllStartDateLessThanEqualAndEndDateGreaterThanEqual() {
////        List<RelatorioTrimestralProj> lista = service.findByAllStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDateTime.of(2019, 9, 2, 0, 0), LocalDateTime.of(2019, 9, 3, 23, 59));
////        Assert.isTrue(lista.isEmpty(), "está retornando: "+lista.toString());
//    }
    
    @Test
    public void obterMunitoramentosSemComprovacao() {
//    	List<RegistroMonitoramento> registros = service.obterMonitoramentosSemComprovacao(LocalDateTime.of(2020, 2, 1, 0, 0, 0), LocalDateTime.of(2020, 5, 18, 17, 30, 0));
//    	Assert.assertTrue("Erros nos registros", registros.size() == 622);
    }
}
