/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.config;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.persistence.EntityManagerFactory;
/*    */ import javax.sql.DataSource;
/*    */ import org.springframework.beans.factory.annotation.Qualifier;
/*    */ import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
/*    */ import org.springframework.boot.context.properties.ConfigurationProperties;
/*    */ import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
/*    */ import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
/*    */ import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.context.annotation.Primary;
/*    */ import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/*    */ import org.springframework.orm.jpa.JpaTransactionManager;
/*    */ import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
/*    */ import org.springframework.transaction.PlatformTransactionManager;
/*    */ import org.springframework.transaction.annotation.EnableTransactionManagement;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Configuration
/*    */ @EnableTransactionManagement
/*    */ @EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = {"br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.dao"})
/*    */ public class SMBBD
/*    */ {
/*    */   @Primary
/*    */   @Bean(name = {"dataSource"})
/*    */   @ConfigurationProperties(prefix = "spring.datasource")
/*    */   public DataSource dataSource() {
/* 37 */     return DataSourceBuilder.create().build();
/*    */   }
/*    */   
/*    */   @Primary
/*    */   @Bean(name = {"entityManagerFactory"})
/*    */   public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("dataSource") DataSource dataSource) {
/* 43 */     return builder.dataSource(dataSource).packages(new String[] { "br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.model", "org.springframework.data.jpa.convert.threeten" }).persistenceUnit("foo").properties(jpaProperties()).build();
/*    */   }
/*    */   
/*    */   @Primary
/*    */   @Bean(name = {"transactionManager"})
/*    */   public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
/* 49 */     return (PlatformTransactionManager)new JpaTransactionManager(entityManagerFactory);
/*    */   }
/*    */   
/*    */   protected Map<String, Object> jpaProperties() {
/* 53 */     Map<String, Object> props = new HashMap<>();
/* 54 */     props.put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
/* 55 */     props.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
/* 56 */     return props;
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\config\SMBBD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */