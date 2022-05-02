package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author tscortes
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BeneficiarioTest {


//    @Autowired
//    private BeneficiarioService service;

    @Test
    public void findMonitoramentoLast() throws Exception {
        System.out.println("testando: 203202");
        Character categoria = "203202".charAt(5);
        System.out.println("Categoria: "+categoria);
//        String contentType = "pdf";
//        String fileName = "Nome do Arquivo.jpg";
//        if ( fileName == null){
//            throw new MonitoramentoException("Arquivo com formato inválido");
//        }
//        String[] arrayFileName = fileName.split("\\.");
//        String resultFileName = null;
//        String resultContentType = contentType;
//        if (arrayFileName.length == 0) {
//            if (resultContentType == null) {
//                throw new MonitoramentoException("Arquivo com formato inválido");
//            }
//            resultFileName = Normalizer.normalize(fileName, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "") + "." + resultContentType;
//        } else if (arrayFileName.length > 1) {
//            if (resultContentType == null) {
//                resultContentType = arrayFileName[arrayFileName.length - 1];
//            }
//            resultFileName = arrayFileName[arrayFileName.length - 2] + "." + resultContentType;
//        }
//
////        return resultFileName;
//        System.out.println(resultFileName);
        
//        String[] fileName = "Nome do Arquivo".split(".");
//        System.out.println(fileName.length);
//        Assert.assertTrue(service.findMonitoramentoLast(514l) != null);
    }

}
