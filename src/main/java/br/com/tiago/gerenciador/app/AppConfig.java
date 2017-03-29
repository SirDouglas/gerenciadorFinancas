package br.com.tiago.gerenciador.app;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration 
@EnableTransactionManagement
@ComponentScan(basePackages={"br.com.tiago.gerenciador.*"})
public class AppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
	configurer.enable();
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
		
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] {"br.com.tiago.gerenciador.modelo"});
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(addionalProperties());
		return em;
		
	}
	   @Bean
       public Properties addionalProperties() {
		Properties properties = new Properties();
properties.setProperty("hibernate.hbm2ddl.auto", "update");
properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/fj21");
		dataSource.setUsername("root");
		dataSource.setPassword("vertrigo");
		return dataSource;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	 
	   
	   @Bean
	   @Autowired
	   public PlatformTransactionManager transactionManager(EntityManagerFactory entityManager){
	       JpaTransactionManager transactionManager = new JpaTransactionManager();
	       transactionManager.setEntityManagerFactory(entityManager);
	       return transactionManager;
	   }
}
