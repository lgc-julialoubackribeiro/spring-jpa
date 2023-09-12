package com.exercicio.crud.configuration;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class AppConfigDB {

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	Logger logger = Logger.getLogger("CrudApplication.java");

	
	@Bean
	public DataSource dataSource() throws Exception {
		HikariConfig config = null;
		try {
		    config = new HikariConfig();
			config.setJdbcUrl(url);
			config.setUsername(username);
			config.setPassword(password);
			if (!driverClassName.isEmpty())
				config.setDriverClassName(driverClassName);

			HikariDataSource hikariDataSource = new HikariDataSource(config);
			logger.info("Database connection valid = " + hikariDataSource.getConnection().isValid(1000));
			
			return hikariDataSource;
		} catch (Exception e) {
			logger.error("Database error, connection valid = false - " + e.getMessage(),e);
			throw e;
		}
	}

	@Bean
	@Lazy
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setFetchSize(20000);
		return jdbcTemplate;
	}
}
