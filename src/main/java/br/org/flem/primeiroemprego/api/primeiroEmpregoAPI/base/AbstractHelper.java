/*     */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.base;
/*     */ 
/*     */ import br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model.User;
/*     */ import java.io.Serializable;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.Collection;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.http.HttpEntity;
/*     */ import org.springframework.http.HttpHeaders;
/*     */ import org.springframework.http.HttpMethod;
/*     */ import org.springframework.http.MediaType;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.security.core.GrantedAuthority;
/*     */ import org.springframework.security.core.authority.SimpleGrantedAuthority;
/*     */ import org.springframework.security.core.context.SecurityContextHolder;
/*     */ import org.springframework.security.core.userdetails.UserDetails;
/*     */ import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
/*     */ import org.springframework.util.MultiValueMap;
/*     */ import org.springframework.web.client.RestTemplate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractHelper
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 680387602822646576L;
/*     */   @Autowired
/*     */   private RestTemplate restTemplate;
/*     */   @Value("${authserver.hostname}")
/*     */   private String authhostname;
/*     */   
/*     */   protected String getCurrentUser() {
/*     */     String username;
/*  47 */     Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
/*     */     
/*  49 */     if (principal instanceof UserDetails) {
/*  50 */       username = ((UserDetails)principal).getUsername();
/*     */     } else {
/*  52 */       username = principal.toString();
/*     */     } 
/*  54 */     return username;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected User getUser(String login) {
/*  63 */     HttpEntity<String> entity = getHttpEntity();
/*  64 */     ResponseEntity<User> response = this.restTemplate.exchange(this.authhostname + "/users/byUsername/" + login, HttpMethod.GET, entity, User.class, new Object[0]);
/*  65 */     return (User)response.getBody();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected User getUser(Long id) {
/*  74 */     HttpEntity<String> entity = getHttpEntity();
/*  75 */     ResponseEntity<User> response = this.restTemplate.exchange(this.authhostname + "/users/byId/" + id, HttpMethod.GET, entity, User.class, new Object[0]);
/*  76 */     return (User)response.getBody();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private HttpEntity<String> getHttpEntity() {
/*  84 */     HttpHeaders headers = getHttpHeaders();
/*  85 */     return new HttpEntity((MultiValueMap)headers);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpHeaders getHttpHeaders() {
/*  92 */     HttpHeaders headers = new HttpHeaders();
/*  93 */     OAuth2AuthenticationDetails principal = (OAuth2AuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
/*  94 */     headers.setContentType(MediaType.APPLICATION_JSON);
/*  95 */     headers.set("Authorization", "Bearer " + principal.getTokenValue());
/*  96 */     return headers;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean hasPermissions(String... permissions) {
/* 105 */     Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
/* 106 */     for (String role : permissions) {
/* 107 */       boolean authorized = authorities.contains(new SimpleGrantedAuthority(role));
/* 108 */       if (authorized) {
/* 109 */         return true;
/*     */       }
/*     */     } 
/* 112 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected User getUserLogged() {
/* 120 */     return getUser(getCurrentUser());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preSave(BaseEntityAudited obj) {
/* 128 */     String login = getCurrentUser();
/* 129 */     obj.setDataCriacao(LocalDateTime.now());
/* 130 */     obj.setUsuarioCriacao(login);
/* 131 */     obj.setDataAtualizacao(LocalDateTime.now());
/* 132 */     obj.setUsuarioAtualizacao(login);
/*     */   }
/*     */   
/*     */   protected void preUpdate(BaseEntityAudited obj) {
/* 136 */     String login = getCurrentUser();
/* 137 */     obj.setDataAtualizacao(LocalDateTime.now());
/* 138 */     obj.setUsuarioAtualizacao(login);
/*     */   }
/*     */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\base\AbstractHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */