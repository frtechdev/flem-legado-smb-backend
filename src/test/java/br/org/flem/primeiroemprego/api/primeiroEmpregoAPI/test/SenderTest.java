package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service.EmailSender;

/**
 *
 * @author tscortes
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SenderTest {

    @Autowired
    private EmailSender service;

    @Before
    public void setUp() {
    }

    @Test
    public void senderEmail() throws Exception {
//        EmailDTO dto = new EmailDTO();
//        dto.setRemetente("Eu");	
//        dto.setAssunto("Assunto teste");
//        dto.setMensagem("Mensagem teste");
//        dto.setAliasRemetente("Alias Teste");
//        dto.setDestinatarios(Arrays.asList("tscortes@flem.org.br", "thiagoscortes29@gmail.com"));
//
//        service.send(dto);
    }

}
