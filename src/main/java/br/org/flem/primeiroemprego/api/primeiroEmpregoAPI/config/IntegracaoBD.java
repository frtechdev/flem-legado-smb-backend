/*    */ package br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.config;
/*    */ 
/*    */ import javax.persistence.EntityManagerFactory;
/*    */ import javax.sql.DataSource;
/*    */ import org.springframework.beans.factory.annotation.Qualifier;
/*    */ import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
/*    */ import org.springframework.boot.context.properties.ConfigurationProperties;
/*    */ import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
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
/*    */ @EnableJpaRepositories(entityManagerFactoryRef = "integracaoEntityManagerFactory", basePackages = {"br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.integracao.dao"})
/*    */ public class IntegracaoBD
/*    */ {
/*    */   @Bean(name = {"integracaoDataSource"})
/*    */   @ConfigurationProperties(prefix = "integracao.datasource")
/*    */   public DataSource dataSource() {
/* 31 */     return DataSourceBuilder.create().build();
/*    */   }
/*    */   
/*    */   @Bean(name = {"integracaoEntityManagerFactory"})
/*    */   public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("integracaoDataSource") DataSource dataSource) {
/* 36 */     return builder.dataSource(dataSource).packages(new String[] { "br.org.flem.primeiroemprego.api.primeiroEmpregoAPI.integracao.model" }).persistenceUnit("integracao").build();
/*    */   }
/*    */   
/*    */   @Bean(name = {"integracaoTransactionManager"})
/*    */   public PlatformTransactionManager transactionManager(@Qualifier("integracaoEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
/* 41 */     return (PlatformTransactionManager)new JpaTransactionManager(entityManagerFactory);
/*    */   }
/*    */ }


/* Location:              C:\Users\rlima\Desktop\ROOT\WEB-INF\classes\!\br\org\flem\primeiroemprego\api\primeiroEmpregoAPI\config\IntegracaoBD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */