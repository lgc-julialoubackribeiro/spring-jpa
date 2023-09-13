package com.exercicio.crud;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.exercicio.crud")
@ComponentScan(basePackages = {"com.exercicio.crud"})
@EntityScan("com.exercicio.crud.model")  
public class CrudApplication {
	
	Logger logger = Logger.getLogger("CrudApplication.java");

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
}
