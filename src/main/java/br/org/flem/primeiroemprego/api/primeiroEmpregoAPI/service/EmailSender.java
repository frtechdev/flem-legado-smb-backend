/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.service;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dto.EmailDTO;
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.message.Sender;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class EmailSender
/*    */   extends Sender
/*    */ {
/*    */   private static final long serialVersionUID = 4132993477261964123L;
/*    */   
/*    */   public void send(EmailDTO message) {
/* 22 */     send("see.send", (BaseDTO)message);
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\service\EmailSender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */