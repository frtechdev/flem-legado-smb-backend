/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.security;
/*    */ 
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.web.servlet.config.annotation.CorsRegistry;
/*    */ import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/*    */ import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*    */ 
/*    */ @Configuration
/*    */ @EnableWebMvc
/*    */ public class WebConfig
/*    */   extends WebMvcConfigurerAdapter
/*    */ {
/*    */   public void addCorsMappings(CorsRegistry registry) {
/* 14 */     registry.addMapping("/**");
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\security\WebConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */