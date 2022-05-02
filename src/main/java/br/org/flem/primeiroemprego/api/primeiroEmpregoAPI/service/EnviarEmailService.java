/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.EmailDTO;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class EnviarEmailService
/*    */ {
/*    */   @Autowired
/*    */   private EmailSender emailSender;
/*    */   
/*    */   public void send(List<String> destinatarios, String aliasRemetente, String remetente, String assunto, String mensagem) {
/* 33 */     this.emailSender.send(new EmailDTO(destinatarios, aliasRemetente, remetente, assunto, mensagem));
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\EnviarEmailService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */