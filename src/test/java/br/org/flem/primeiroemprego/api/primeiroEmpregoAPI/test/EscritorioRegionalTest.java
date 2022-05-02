package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.test;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.EscritorioRegionalService;
import org.junit.Assert;
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
public class EscritorioRegionalTest {

    @Autowired
    private EscritorioRegionalService service;

    @Test
    public void existsEscritorios() throws Exception {
        Assert.assertTrue("Lista Carregada", service.findAllActive().iterator().hasNext());
    }
}
