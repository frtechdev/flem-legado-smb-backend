/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.config;
/*    */ 
/*    */ import javax.jms.ConnectionFactory;
/*    */ import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.jms.annotation.EnableJms;
/*    */ import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
/*    */ import org.springframework.jms.config.JmsListenerContainerFactory;
/*    */ import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
/*    */ import org.springframework.jms.support.converter.MessageConverter;
/*    */ import org.springframework.jms.support.converter.MessageType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @EnableJms
/*    */ @Configuration
/*    */ public class MensageriaConfig
/*    */ {
/*    */   public static final String FLEM_QUEUE = "flem-queue";
/*    */   
/*    */   @Bean
/*    */   public MessageConverter messageConverter() {
/* 28 */     MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
/* 29 */     converter.setTargetType(MessageType.TEXT);
/* 30 */     converter.setTypeIdPropertyName("_type");
/* 31 */     return (MessageConverter)converter;
/*    */   }
/*    */ 
/*    */   
/*    */   @Bean
/*    */   public JmsListenerContainerFactory<?> connectionFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
/* 37 */     DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
/* 38 */     configurer.configure(factory, connectionFactory);
/* 39 */     return (JmsListenerContainerFactory<?>)factory;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\config\MensageriaConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */