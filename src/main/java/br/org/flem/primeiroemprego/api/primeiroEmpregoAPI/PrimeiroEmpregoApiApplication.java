/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI;
/*    */ 
/*    */ import com.fasterxml.jackson.databind.Module;
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
/*    */ import javax.annotation.PostConstruct;
/*    */ import org.modelmapper.ModelMapper;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.boot.SpringApplication;
/*    */ import org.springframework.boot.autoconfigure.SpringBootApplication;
/*    */ import org.springframework.boot.builder.SpringApplicationBuilder;
/*    */ import org.springframework.boot.web.support.SpringBootServletInitializer;
/*    */ import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
/*    */ import org.springframework.web.client.RestTemplate;
/*    */ 
/*    */ @SpringBootApplication
/*    */ @EnableEurekaClient
/*    */ @EnableJpaAuditing
/*    */ public class PrimeiroEmpregoApiApplication
/*    */   extends SpringBootServletInitializer
/*    */ {
/*    */   @Autowired
/*    */   private ObjectMapper objectMapper;
/*    */   
/*    */   public static void main(String[] args) {
/* 28 */     SpringApplication.run(PrimeiroEmpregoApiApplication.class, args);
/*    */   }
/*    */ 
/*    */   
/*    */   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
/* 33 */     return application.sources(new Class[] { PrimeiroEmpregoApiApplication.class });
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public RestTemplate getRestTemplate() {
/* 38 */     return new RestTemplate();
/*    */   }
/*    */   
/*    */   @Bean
/*    */   public ModelMapper getModelMapper() {
/* 43 */     return new ModelMapper();
/*    */   }
/*    */   
/*    */   @PostConstruct
/*    */   public void setUp() {
/* 48 */     this.objectMapper.registerModule((Module)new JavaTimeModule());
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\PrimeiroEmpregoApiApplication.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */