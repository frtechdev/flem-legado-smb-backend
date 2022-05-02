/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.message;
/*    */ 
/*    */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base.BaseDTO;
/*    */ import java.io.Serializable;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.jms.core.JmsTemplate;
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
/*    */ @Service
/*    */ public class Sender
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 7379771831785307345L;
/*    */   @Autowired
/*    */   private JmsTemplate template;
/*    */   
/*    */   public void send(String destination, BaseDTO message) {
/* 29 */     this.template.convertAndSend(destination, message);
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\message\Sender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */