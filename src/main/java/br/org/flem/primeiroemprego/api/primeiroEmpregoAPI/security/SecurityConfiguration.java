/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.security;
/*    */ 
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.http.HttpMethod;
/*    */ import org.springframework.security.config.annotation.web.builders.HttpSecurity;
/*    */ import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
/*    */ import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
/*    */ import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
/*    */ import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
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
/*    */ @Configuration
/*    */ @EnableResourceServer
/*    */ public class SecurityConfiguration
/*    */   extends ResourceServerConfigurerAdapter
/*    */ {
/*    */   private static final String RESOURCE_ID = "resources";
/*    */   private static final String WRITE = "#oauth2.hasScope('write')";
/*    */   private static final String READ = "#oauth2.hasScope('read')";
/*    */   
/*    */   public void configure(HttpSecurity http) throws Exception {
/* 30 */     ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((HttpSecurity.RequestMatcherConfigurer)((HttpSecurity)http.cors().and()).requestMatchers()
/* 31 */       .antMatchers(new String[] { "/**"
/* 32 */         })).and()
/* 33 */       .authorizeRequests()
/* 34 */       .anyRequest())
/* 35 */       .authenticated()
/* 36 */       .antMatchers(HttpMethod.GET, new String[] { "/**" })).access("#oauth2.hasScope('read')")
/* 37 */       .antMatchers(HttpMethod.OPTIONS, new String[] { "/**" })).access("#oauth2.hasScope('read')")
/* 38 */       .antMatchers(HttpMethod.POST, new String[] { "/**" })).access("#oauth2.hasScope('write')")
/* 39 */       .antMatchers(HttpMethod.PUT, new String[] { "/**" })).access("#oauth2.hasScope('write')")
/* 40 */       .antMatchers(HttpMethod.PATCH, new String[] { "/**" })).access("#oauth2.hasScope('write')")
/* 41 */       .antMatchers(HttpMethod.DELETE, new String[] { "/**" })).access("#oauth2.hasScope('write')");
/*    */   }
/*    */ 
/*    */   
/*    */   public void configure(ResourceServerSecurityConfigurer resources) {
/* 46 */     resources.resourceId("resources");
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\security\SecurityConfiguration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */