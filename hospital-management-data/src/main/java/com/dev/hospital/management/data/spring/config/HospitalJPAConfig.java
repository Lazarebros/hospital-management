/**
 * 
 */
package com.dev.hospital.management.data.spring.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author dayanlazare
 *
 */
@Configuration
@PropertySource("classpath:hospital-db.properties")
@EnableJpaRepositories(
		basePackages = "com.dev.hospital.management.data.dao", 
		entityManagerFactoryRef = "hospitalEntityManager", 
		transactionManagerRef = "hospitalTransactionManager")
@ComponentScans(value = { @ComponentScan("com.dev.hospital.management.data.service") })
public class HospitalJPAConfig {

	@Autowired
	private Environment environment;

	@Bean
	public LocalContainerEntityManagerFactoryBean hospitalEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setPackagesToScan(new String[] { "com.dev.hospital.management.data.bean" });
		em.setPersistenceUnitName("hospitalPersistenceUnit");
		em.setDataSource(hospitalDataSource());

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.batch.size", environment.getRequiredProperty("hibernate.batch.size"));
		em.setJpaPropertyMap(properties);

		return em;
	}

	@Bean
	public DataSource hospitalDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("hospital.db.driver"));
		dataSource.setUrl(environment.getRequiredProperty("hospital.db.url"));
		dataSource.setUsername(environment.getRequiredProperty("hospital.db.username"));
		dataSource.setPassword(environment.getRequiredProperty("hospital.db.password"));
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager hospitalTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(hospitalEntityManager().getObject());
		return transactionManager;
	}

}
