/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.security;
/*    */ 
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.web.cors.CorsConfiguration;
/*    */ import org.springframework.web.cors.CorsConfigurationSource;
/*    */ import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
/*    */ import org.springframework.web.filter.CorsFilter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ public class RestConfig
/*    */ {
/*    */   @Bean
/*    */   public CorsFilter corsFilter() {
/* 23 */     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
/* 24 */     CorsConfiguration config = new CorsConfiguration();
/* 25 */     config.setAllowCredentials(Boolean.valueOf(true));
/* 26 */     config.addAllowedOrigin("*");
/* 27 */     config.addAllowedHeader("*");
/* 28 */     config.addAllowedMethod("OPTIONS");
/* 29 */     config.addAllowedMethod("GET");
/* 30 */     config.addAllowedMethod("POST");
/* 31 */     config.addAllowedMethod("PUT");
/* 32 */     config.addAllowedMethod("DELETE");
/* 33 */     config.addExposedHeader("Content-Disposition");
/* 34 */     config.addExposedHeader("Access-Control-Allow-Credentials");
/* 35 */     config.addExposedHeader("Access-Control-Allow-Origin");
/* 36 */     source.registerCorsConfiguration("/**", config);
/* 37 */     return new CorsFilter((CorsConfigurationSource)source);
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\security\RestConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */