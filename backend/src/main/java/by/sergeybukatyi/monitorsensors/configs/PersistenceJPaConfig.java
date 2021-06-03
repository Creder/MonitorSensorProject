package by.sergeybukatyi.monitorsensors.configs;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScans(value = {@ComponentScan("by.sergeybukatyi.monitorsensors.services"),
                          @ComponentScan("by.sergeybukatyi.monitorsensors.persistence")})
public class PersistenceJPaConfig {

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
    LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
    bean.setDataSource(dataSource());
    bean.setPackagesToScan("by.sergeybukatyi.monitorsensors.entities");

    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
    bean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
    bean.setJpaProperties(additionalProperties());
    return bean;
  }

  @Bean
  public DataSource dataSource(){
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://localhost/monitorsensorsdb");
    dataSource.setUsername("postgres");
    dataSource.setPassword("12345");
    return dataSource;
  }


  @Bean
  public PlatformTransactionManager transactionManager(){
    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
    jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return jpaTransactionManager;
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
    return new PersistenceExceptionTranslationPostProcessor();
  }

  private Properties additionalProperties(){
    Properties properties = new Properties();
    properties.setProperty("hibernate.hbm2ddl.auto", "update");
    properties.setProperty("hibernate.show_sql", "true");
    properties.setProperty("hibernate.pool_size", "1");
    properties.setProperty("hibername.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    return properties;
  }
}
